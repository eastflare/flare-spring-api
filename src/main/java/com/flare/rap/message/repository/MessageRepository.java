package com.flare.rap.message.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.message.model.MessageConditionVO;
import com.flare.rap.message.model.MessageSimpleVO;
import com.flare.rap.message.model.MessageVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface MessageRepository {

    List<MessageVO> selectMessages(@Param("messageCondition") MessageConditionVO messageCondition);

    List<MessageVO> selectMessagesMsgCtn(MessageConditionVO messageCondition);

    List<MessageVO> selectTransaltedMessages(String langCd);

    MessageVO selectMessage(MessageConditionVO messageCondition);

    MessageSimpleVO selectMessageCache(@Param("msgCtn") String msgCtn, @Param("langCd") String langCd);

    List<MessageSimpleVO> selectMessagesAllCache();

    int insertMessage(@Param("message") MessageVO messageVO, @Param("session") UserSessionVO userSessionVO);

    int updateMessage(@Param("message") MessageVO messageVO, @Param("session") UserSessionVO userSessionVO);

    int deleteMessage(MessageVO messageVO);

}