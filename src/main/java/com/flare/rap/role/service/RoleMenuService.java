package com.flare.rap.role.service;

import java.util.ArrayList;
import java.util.List;

import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.session.model.EmployeeVO;

public interface RoleMenuService {

    List<MenuResponseVO> findMenusByRole(String roleCd);

    int saveMenusByRole(String roleCd, List<String> mnuIdList);

    List<MenuResponseVO> findMenusByRoleCodes(List<String> roleCodes);
}