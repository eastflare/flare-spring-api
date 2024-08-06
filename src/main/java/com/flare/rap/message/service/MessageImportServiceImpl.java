package com.flare.rap.message.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.message.model.MessageImportCheckVO;
import com.flare.rap.message.model.MessageVO;
import com.flare.rap.message.repository.MessageImportRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageImportServiceImpl implements MessageImportService {

    public final MessageImportRepository messageImportRepository;

    @Override
    public DmlResponseVO importMessage(String allUpdateYn) {
        DmlResponseVO dmlResponseVO = DmlResponseVO.builder()
                .insertedRows(0)
                .updatedRows(0)
                .deletedRows(0)
                .build();

        if("Y".equals(allUpdateYn)) {
            messageImportRepository.updateMessageFeBeUseYn();
        }

        List<MessageVO> srcMessages = messageImportRepository.selectSourceMessages();

        for(MessageVO srcMessage: srcMessages) {
            // code/lang 으로 메시지 있는지 체크, 체크할때 번역이 완료된것인지 확인한다. 메시지내용 마지막에 (언어코드) 가 없으면 번역완료로 판단함.
            MessageImportCheckVO messageCheck = messageImportRepository.selectMessageExistCheck(srcMessage.getMsgCtn(), srcMessage.getLangCd());

            //기존 등록된 Message 없으면 Insert
            if(ValidateUtil.isEmpty(messageCheck )) {
                messageImportRepository.insertMessage(srcMessage);
                dmlResponseVO.setInsertedRows(dmlResponseVO.getInsertedRows() + 1);
                continue;
            }

            // 번역이 안돼있으면-- 메시지내용 마지막에 (언어코드)가 있으면, 소스에서 추출된 기본값으로 Update
            if("N".equals(messageCheck.getTransYn()) ) {
                messageImportRepository.updateMessageText(srcMessage);
                dmlResponseVO.setUpdatedRows(dmlResponseVO.getUpdatedRows() + 1);
            }

            // 번역여부와 관계없이 USE_YN은 Update
            messageImportRepository.updateMessageToUse(srcMessage.getMsgCtn(), srcMessage.getLangCd());

        }

        return dmlResponseVO;
    }
}