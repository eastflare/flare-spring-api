package com.flare.rap.department.service;

import java.util.List;

import com.flare.rap.department.model.DepartmentRequestVO;
import com.flare.rap.department.model.DepartmentResponseVO;
import com.flare.rap.department.model.DepartmentVO;

public interface DepartmentService {

    List<DepartmentVO> findDepartments(DepartmentRequestVO departmentRequestVo);

    DepartmentResponseVO findDepartmentsAddingUserDeptCode(DepartmentRequestVO departmentRequestVO);

    String findParentDepartment();

}