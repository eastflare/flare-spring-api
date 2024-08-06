package com.flare.rap.role.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.constant.CrudConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.role.model.RoleRequestVO;
import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.role.repository.RoleEmployeeRepository;
import com.flare.rap.role.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleEmployeeRepository roleEmployeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RoleResponseVO> findRoles(String roleNm) {
        return roleRepository.selectRoles(roleNm);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public DmlResponseVO saveRoles(List<RoleRequestVO> roles) {

        DmlResponseVO dmlResponseVO = new DmlResponseVO();

        List<RoleRequestVO> insertRoleList = new ArrayList<>();
        List<RoleRequestVO> updateRoleList = new ArrayList<>();

        for (RoleRequestVO role : roles) {
            switch (role.getCrudKey().toUpperCase()) {
                case CrudConstants.CREATE:
                    insertRoleList.add(role);
                    break;
                case CrudConstants.UPDATE:
                    updateRoleList.add(role);
                    break;
            }
        }

        dmlResponseVO.setUpdatedRows(updateRoles(updateRoleList));
        dmlResponseVO.setInsertedRows(insertRoles(insertRoleList));

        return dmlResponseVO;
    }

    private int insertRoles(List<RoleRequestVO> roles) {
        if (ValidateUtil.isEmpty(roles)) return 0;

        int result = 0;
        try {
            result = roleRepository.insertRoles(roles, SessionScopeUtil.getContextSession());
        } catch (DuplicateKeyException e) {
            throw new BusinessException("DUPLICATE_KEY_EXCEPTION", StatusCodeConstants.DUPLICATE_KEY_EXCEPTION);
        }
        return result;
    }

    private int updateRoles(List<RoleRequestVO> roles) {
        if (ValidateUtil.isEmpty(roles)) return 0;

        return roleRepository.updateRoles(roles, SessionScopeUtil.getContextSession());
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int removeRoles(List<String> roleCodes) {
        int result = 0;
        for (String roleCode : roleCodes) {
            if(roleEmployeeRepository.existRoleEmployees(roleCode)){
                throw new BusinessException(String.format("Cannot delete as employees assigned to %s role", roleCode), StatusCodeConstants.DELETION_IMPOSSIBLE);
            }
            result += roleRepository.deleteRole(roleCode);
        }
        return result;
    }
}