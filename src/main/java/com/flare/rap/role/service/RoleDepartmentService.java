package com.flare.rap.role.service;
import java.util.List;

import com.flare.rap.department.model.DepartmentVO;

public interface RoleDepartmentService {
    List<String> findRolesByDepartment(String deptCd);

    List<DepartmentVO> findDepartmentsByRoleCd(String roleCd);

    int createRoleDepartments(String roleCd, List<String> deptCdList);

    int removeRoleDepartments(String roleCd, List<String> deptCdList);
}