package com.flare.rap.message.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.flare.rap.code.model.CommonCodeResponseVO;
import com.flare.rap.code.repository.CommonCodeRepository;
import com.flare.rap.common.constant.CrudConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.message.model.MessageConditionVO;
import com.flare.rap.message.model.MessageSimpleVO;
import com.flare.rap.message.model.MessageVO;
import com.flare.rap.message.repository.MessageRepository;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Value("${i18n.message-file-path}")
    private String messageFilePath;

    @Value("${i18n.upload-cache-on-start}")
    private boolean isUploadCacheOnStart;

    private final MessageRepository messageRepository;
    private final CommonCodeRepository commonCodeRepository;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Map<String, String> readTranslatedMessageFile(String langCd) {

        String filePath = messageFilePath + "/message_" + langCd + ".json";

        Path jsonFilePath = Path.of(filePath);
        Map<String, String> translatedMessages = null;

        try {
            byte[]  fileBytes = Files.readAllBytes(jsonFilePath);
            String  jsonString = new String(fileBytes, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            translatedMessages = gson.fromJson(jsonString, Map.class);

        } catch (IOException e) {
            throw new BusinessException("message read failed", StatusCodeConstants.MESSAGE_READ_FAILED);
        }

        return translatedMessages;
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public boolean deployTranslatedMessages(String LanguageCode) {

        List<String> languageCodes = new ArrayList<>();
        if(LanguageCode == null){
            languageCodes = findValidLanguageCode();
        }else{
            validateLanguageCode(LanguageCode);
            languageCodes.add(LanguageCode);
        }

        for(String langCd : languageCodes){
            List<MessageVO> messageList = messageRepository.selectTransaltedMessages(langCd);

            for (MessageVO message : messageList) {
                message.setMsgTxtCtn(ValidateUtil.charUnescape(message.getMsgTxtCtn()));
            }
            Map<String, String> messageMap = messageList.stream()
            .collect(Collectors.toMap(MessageVO::getMsgCtn, MessageVO::getMsgTxtCtn));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonData = gson.toJson(messageMap);

            String filePath = messageFilePath + "/message_" + langCd + ".json";
            FileWriter writer;
            try {
                writer = new FileWriter(filePath, Charset.forName("UTF-8"));
                writer.write(jsonData);
                writer.close();
            } catch (IOException e) {
                throw new BusinessException("message deploy failed", StatusCodeConstants.MESSAGE_DEPLOY_FAILED);
            }
        }
        return true;
    }


    @Override
    @Transactional(rollbackFor = { Exception.class })
    public boolean deployTranslatedMessagesAll() {

        List<String> languageCodes = findValidLanguageCodeNoLangCd();

        if(!ValidateUtil.isEmpty(languageCodes)) {

            for(String langCd : languageCodes) {
                List<MessageVO> messageList = messageRepository.selectTransaltedMessages(langCd);

                for (MessageVO message : messageList) {
                    message.setMsgTxtCtn(ValidateUtil.charUnescape(message.getMsgTxtCtn()));
                }
                Map<String, String> messageMap = messageList.stream()
                        .collect(Collectors.toMap(MessageVO::getMsgCtn, MessageVO::getMsgTxtCtn));

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonData = gson.toJson(messageMap);

                String filePath = messageFilePath + "/message_" + langCd + ".json";
                FileWriter writer;
                try {
                    writer = new FileWriter(filePath, Charset.forName("UTF-8"));
                    writer.write(jsonData);
                    writer.close();
                } catch (IOException e) {
                    throw new BusinessException("message deploy failed", StatusCodeConstants.MESSAGE_DEPLOY_FAILED);
                }
            }
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageVO> findMessages(MessageConditionVO messageCondition) {
        List<MessageVO> messages = messageRepository.selectMessages(messageCondition);
        for (MessageVO message:messages) {
            message.setMsgTxtCtn(ValidateUtil.charUnescape(message.getMsgTxtCtn()));
        }

        return messages;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageVO> findMessagesMsgCtn(MessageConditionVO messageCondition) {
        List<MessageVO> messages = messageRepository.selectMessagesMsgCtn(messageCondition);
        for (MessageVO message:messages) {
            message.setMsgTxtCtn(ValidateUtil.charUnescape(message.getMsgTxtCtn()));
        }

        return messages;
    }


    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "i18nCache", key = "#msgCtn + #langCd")
    public MessageSimpleVO findMessageCache(String msgCtn, String langCd) {
        MessageSimpleVO rtn = messageRepository.selectMessageCache(msgCtn, langCd);
        if(rtn == null) {
            rtn = MessageSimpleVO.builder()
                    .msgCtn(msgCtn)
                    .msgTxtCtn(msgCtn)
                    .langCd(langCd)
                    .build();
        }
        return rtn;
    }

    @Override
    @Transactional(readOnly = true)
    @EventListener(ApplicationReadyEvent.class)
    public int refreshMessageAll() {
        if(!isUploadCacheOnStart) return 0;

        log.info("i18n Message Loading...");
        List<MessageSimpleVO> messages = messageRepository.selectMessagesAllCache();
        if(ValidateUtil.isEmpty(messages)) {
            return 0;
        }
        log.info("i18n Select all message from DB table : {} rows", messages.size());

        Cache i18nCache = cacheManager.getCache("i18nCache");

        log.info("i18n Cache Clear");
        i18nCache.removeAll();

        for (MessageSimpleVO message : messages) {
            i18nCache.put(message.getMsgCtn() + message.getLangCd() , message);
        }
        log.info("i18n Cache reload completed.");

        return messages.size();
    }


    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int createMessage(MessageVO messageVO) {
        MessageVO existMessages = messageRepository.selectMessage(
            MessageConditionVO.builder().msgCtn(messageVO.getMsgCtn()).langCd(messageVO.getLangCd()).build());

        if (existMessages != null) {
            throw new BusinessException("duplicate message", StatusCodeConstants.DUPLICATED_VALUE_ERROR);
        }

        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        return messageRepository.insertMessage(messageVO, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int modifyMessage(MessageVO messageVO) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        return messageRepository.updateMessage(messageVO, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int removeMessage(String msgCtn, String langCd) {
        return messageRepository.deleteMessage(MessageVO.builder().msgCtn(msgCtn).langCd(langCd).build());
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public DmlResponseVO saveMessages(List<MessageVO> messages) {
        int insertedRows = 0, updatedRows = 0, deletedRows = 0;
        List<MessageVO> insertMessages = new ArrayList<>();
        List<MessageVO> updateMessages = new ArrayList<>();
        List<MessageVO> deleteMessages = new ArrayList<>();

        for (MessageVO message : messages) {
            String crudKey = message.getCrudKey();

            if (CrudConstants.CREATE.equalsIgnoreCase(crudKey)) {
                insertMessages.add(message);
            } else if (CrudConstants.UPDATE.equalsIgnoreCase(crudKey)) {
                updateMessages.add(message);
            } else if (CrudConstants.DELETE.equalsIgnoreCase(crudKey)) {
                deleteMessages.add(message);
            }
        }

        for (MessageVO deleteMessage : deleteMessages) {
            deletedRows += removeMessage(deleteMessage.getMsgCtn(), deleteMessage.getLangCd());
        }

        for (MessageVO updateMessage : updateMessages) {
            updatedRows += modifyMessage(updateMessage);
        }

        for (MessageVO insertMessage : insertMessages) {
            insertedRows += createMessage(insertMessage);
        }

        return DmlResponseVO.builder().insertedRows(insertedRows).updatedRows(updatedRows).deletedRows(deletedRows).build();
    }


    private void validateLanguageCode(String languageCode) {
        List<String> validLanguageCodes = findValidLanguageCode();
        if (validLanguageCodes.stream().noneMatch(validLanguageCode -> validLanguageCode.equalsIgnoreCase(languageCode))) {
            throw new BusinessException("invalid languageCode", StatusCodeConstants.PARAMETER_VALUE_ERROR);
        }
    }

    private List<String> findValidLanguageCode() {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return commonCodeRepository.selectCommonCodes("LANG_CD", userSession.getLangCd()).stream()
            .map(CommonCodeResponseVO::getCmnCd).collect(Collectors.toList());
    }

    private List<String> findValidLanguageCodeNoLangCd() {
        return commonCodeRepository.selectCommonCodesNoLangCd("LANG_CD").stream()
                .map(CommonCodeResponseVO::getCmnCd).collect(Collectors.toList());
    }

}