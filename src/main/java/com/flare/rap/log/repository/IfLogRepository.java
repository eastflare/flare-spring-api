package com.flare.rap.log.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.log.model.IfLogRequestVO;
import com.flare.rap.log.model.IfLogResponseVO;
import com.flare.rap.log.model.IfLogVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface IfLogRepository {


    int insertIfLog(@Param("iflog") IfLogVO ifLogVO, @Param("session") UserSessionVO session);


    long selectIfLogSeq();

    int insertIfLogSend(@Param("iflog") IfLogVO ifLogVO, @Param("session") UserSessionVO session);

    int updateIfLogReceive(@Param("iflog") IfLogVO ifLogVO, @Param("session") UserSessionVO session);

    int selectIfLogListCount(@Param("condition") IfLogRequestVO condiiton);

    List<IfLogResponseVO> selectIfLogList(@Param("condition") IfLogRequestVO condition);
}