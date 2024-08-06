package com.flare.rap.message.service;

import java.util.List;
import java.util.Map;

import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.message.model.MessageConditionVO;
import com.flare.rap.message.model.MessageSimpleVO;
import com.flare.rap.message.model.MessageVO;

public interface MessageService {

    Map<String, String> readTranslatedMessageFile(String langCd);

    boolean deployTranslatedMessages(String langCd);

    boolean deployTranslatedMessagesAll();

    List<MessageVO> findMessages(MessageConditionVO messageCondition);

    List<MessageVO> findMessagesMsgCtn(MessageConditionVO messageCondition);

    MessageSimpleVO findMessageCache(String msgCtn, String langCd);

    public int refreshMessageAll();

    int createMessage(MessageVO messageVO);

    int modifyMessage(MessageVO messageVO);

    int removeMessage(String msgCtn, String langCd);

    DmlResponseVO saveMessages(List<MessageVO> messages);

}