package com.flare.rap.role.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.role.repository.RoleDepartmentRepository;
import com.flare.rap.role.repository.RoleMenuRepository;
import com.flare.rap.session.model.EmployeeVO;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleMenuServiceImpl implements RoleMenuService{

    private final RoleMenuRepository roleMenuRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MenuResponseVO> findMenusByRole(String roleCd) {
        return roleMenuRepository.selectMenusByRoleCd(roleCd);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int saveMenusByRole(String roleCd, List<String> mnuIdList) {
        UserSessionVO session = SessionScopeUtil.getContextSession();
        roleMenuRepository.deleteRoleMenuByRoleCd(roleCd);
        return roleMenuRepository.insertRoleMenusByRoleCd(roleCd, mnuIdList, session);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuResponseVO> findMenusByRoleCodes(List<String> roleCodes){
        return roleMenuRepository.selectMenusByRoleCds(roleCodes);
    }
}