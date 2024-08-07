package com.flare.rap.mail.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.log.model.EmailLogResponseVO;
import com.flare.rap.log.model.EmailSendLogVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface EmailSendQueRepository {

    int insertEmailSendQue(@Param("email") EmailSendLogVO email, @Param("session") UserSessionVO session);

    long selectEmlSndoQueSeq();

    List<EmailLogResponseVO> selectEmailQueList();

    int updateEmailQue(@Param("email") EmailSendLogVO email);
}