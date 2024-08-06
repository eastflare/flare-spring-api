package com.flare.rap.log.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.log.model.MenuLogRequestVO;
import com.flare.rap.log.model.MenuLogResponseVO;

@Mapper
public interface MenuLogRepository {
    int selectMenuLogListCount(@Param("condition") MenuLogRequestVO condition);
    List<MenuLogResponseVO> selectMenuLogList(@Param("condition") MenuLogRequestVO condition);
}