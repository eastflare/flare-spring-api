package com.flare.rap.role.service;

import java.util.List;

import com.flare.rap.role.model.RoleResponseVO;

public interface RoleEmployeeService {

    List<RoleResponseVO> findRoleEmployees(String roleCd);

    int createRoleEmployees(String roleCd, List<String> userIdList);

    int removeRoleEmployees(String roleCd, List<String> userIdList);

    List<String> findRoleCodesByUserId(String userId);

}