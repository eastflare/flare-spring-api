package com.flare.rap.department.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.department.model.DepartmentRequestVO;
import com.flare.rap.department.model.DepartmentVO;

@Mapper
public interface DepartmentRepository {

    List<DepartmentVO> selectAllDepartments(DepartmentRequestVO departmentRequestVo);
    String selectParentDepartment(@Param("deptCd") String deptCd);

}