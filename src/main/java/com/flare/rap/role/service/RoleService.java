package com.flare.rap.role.service;

import java.util.List;

import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.role.model.RoleRequestVO;
import com.flare.rap.role.model.RoleResponseVO;

public interface RoleService {

    List<RoleResponseVO> findRoles(String roleNm);

    DmlResponseVO saveRoles(List<RoleRequestVO> roles);

    int removeRoles(List<String> roleCodes);

}