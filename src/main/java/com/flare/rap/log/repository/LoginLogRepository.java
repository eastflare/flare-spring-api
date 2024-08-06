package com.flare.rap.log.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.log.model.LoginLogRequestVO;
import com.flare.rap.log.model.LoginLogResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface LoginLogRepository {

    int insertLoginLog( @Param("session") UserSessionVO userSessionVO);
    List<LoginLogResponseVO> selectLoginLogList(@Param("condition")LoginLogRequestVO condition);
    int selectLoginLogListCount(@Param("condition")LoginLogRequestVO condition);

}