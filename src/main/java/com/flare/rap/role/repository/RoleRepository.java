package com.flare.rap.role.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.role.model.RoleRequestVO;
import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface RoleRepository {

    List<RoleResponseVO> selectRoles(@Param("roleNm")String roleNm);

    int insertRoles(@Param("roles")List<RoleRequestVO> roles, @Param("session")UserSessionVO userSession);

    int updateRoles(@Param("roles")List<RoleRequestVO> roles, @Param("session")UserSessionVO userSession);

    int deleteRole(String roleCode);
}