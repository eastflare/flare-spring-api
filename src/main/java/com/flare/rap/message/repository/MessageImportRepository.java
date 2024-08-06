package com.flare.rap.message.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.message.model.MessageImportCheckVO;
import com.flare.rap.message.model.MessageVO;

@Mapper
public interface MessageImportRepository {

    List<MessageVO> selectSourceMessages();

    MessageImportCheckVO selectMessageExistCheck(String msgCtn, String langCd);

    int updateMessageFeBeUseYn();

    int insertMessage(@Param("message") MessageVO messageVO);

    int updateMessageToUse(String msgCtn, String langCd);

    int updateMessageText(@Param("message") MessageVO messageVO);


}