package com.flare.rap.role.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface RoleMenuRepository {

    List<MenuResponseVO> selectMenusByRoleCd(@Param("roleCd") String roleCd);

    int deleteRoleMenuByRoleCd(@Param("roleCd") String roleCd);

    int insertRoleMenusByRoleCd(@Param("roleCd") String roleCd, @Param("mnuIdList") List<String> mnuIdList, @Param("session") UserSessionVO session);

    List<MenuResponseVO> selectMenusByRoleCds(@Param("roleCds") List<String> roleCds);

}