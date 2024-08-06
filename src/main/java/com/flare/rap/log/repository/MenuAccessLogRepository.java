package com.flare.rap.log.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface MenuAccessLogRepository {

    int insertMenuAccessLog(@Param("mnuId") String mnuId, @Param("session") UserSessionVO session);

}