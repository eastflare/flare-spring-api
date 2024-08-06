package com.flare.rap.menu.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.menu.model.MenuRequestVO;
import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.role.model.RoleEmployeeResponseVO;
import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface MenuRepository {

    List<MenuResponseVO> selectAllMenus();

    MenuResponseVO selectMenu(@Param("mnuId") String mnuId);

    List<MenuResponseVO> selectChildMenus(@Param("mnuId") String mnuId);

    int updateMenuSortOrd(@Param("mnuId") String mnuId, @Param("sortOrd") int sortOrd, @Param("session") UserSessionVO session);

    int insertMenu(@Param("menu") MenuRequestVO menuRequestVO, @Param("session")UserSessionVO session);

    int updateMenu(@Param("menu") MenuRequestVO menuRequestVO, @Param("session")UserSessionVO session);

    int deleteMenus(@Param("mnuId") String mnuId);

    List<RoleResponseVO> selectRolesByMenuId(@Param("mnuId") String mnuId);

    List<RoleEmployeeResponseVO> selectEmployeesByMenuId(@Param("mnuId") String mnuId);

    List<DepartmentVO> selectDepartmentsByMenuId(@Param("mnuId") String mnuId);

}