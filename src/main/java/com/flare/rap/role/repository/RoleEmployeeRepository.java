package com.flare.rap.role.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface RoleEmployeeRepository {

    List<RoleResponseVO> selectRoleEmployees(@Param("roleCd") String roleCd);

    boolean existRoleEmployees(String roleCd);

    int insertRoleEmployee(@Param("roleCd") String roleCd, @Param("userId") String userId, @Param("session") UserSessionVO userSession);

    int deleteRoleEmployees(@Param("roleCd") String roleCd, @Param("userIdList") List<String> userIdList);

    List<String> selectRoleCdsByUserId(@Param("userId") String userId);

}