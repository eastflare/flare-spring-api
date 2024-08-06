package com.flare.rap.role.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface RoleDepartmentRepository {
    List<String> selectRolesByDeptCd(String deptCd);

    List<DepartmentVO> selectDepartmentsByRoleCd(@Param("roleCd") String roleCd);

    int insertRoleDepartment(@Param("roleCd") String roleCd, @Param("deptCd") String deptCd, @Param("session") UserSessionVO session);

    int deleteRoleDepartment(@Param("roleCd") String roleCd, @Param("deptCdList") List<String> deptCdList);
}