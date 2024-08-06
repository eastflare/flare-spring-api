package com.flare.rap.log.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.log.model.EmailLogRequestVO;
import com.flare.rap.log.model.EmailLogResponseVO;

@Mapper
public interface EmailLogRepository {
    int selectEmailLogListCount(@Param("condition")EmailLogRequestVO condition);
    List<EmailLogResponseVO> selectEmailLogList(@Param("condition")EmailLogRequestVO condition);
}