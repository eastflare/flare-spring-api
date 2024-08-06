package com.flare.rap.menu.service;

import java.util.ArrayList;
import java.util.List;

import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.menu.model.MenuRequestVO;
import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.role.model.RoleEmployeeResponseVO;
import com.flare.rap.role.model.RoleResponseVO;

public interface MenuService {

    List<MenuResponseVO> findAllMenus();

    MenuResponseVO findMenu(String mnuId);

    int saveMenu(MenuRequestVO menuRequestVO);

    int removeMenus(String mnuId);

    List<RoleResponseVO> findRolesByMenuId(String mnuId);

    List<RoleEmployeeResponseVO> findEmployeesByMenu(String mnuId);

    List<DepartmentVO> findDepartmentsByMenu(String mnuId);
}