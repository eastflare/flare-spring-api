package com.flare.rap.log.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.log.model.EmailSendLogVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface EmailSendLogRepository {

    int insertEmailSendLog(@Param("email") EmailSendLogVO emailSendLogVO, @Param("session") UserSessionVO session);

    long selectEmlLogSeq();


}