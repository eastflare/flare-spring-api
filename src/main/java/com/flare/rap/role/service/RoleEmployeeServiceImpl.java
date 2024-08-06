package com.flare.rap.role.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.role.repository.RoleEmployeeRepository;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleEmployeeServiceImpl implements RoleEmployeeService {

    private final RoleEmployeeRepository roleEmployeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RoleResponseVO> findRoleEmployees(String roleCd) {
        return roleEmployeeRepository.selectRoleEmployees(roleCd);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int createRoleEmployees(String roleCd, List<String> userIdList) {

        int result = 0;
        if(!ValidateUtil.isEmpty(userIdList)){
            for(String userId : userIdList){
                result += roleEmployeeRepository.insertRoleEmployee(roleCd, userId, SessionScopeUtil.getContextSession());
            }
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int removeRoleEmployees(String roleCd, List<String> userIdList) {
        return roleEmployeeRepository.deleteRoleEmployees(roleCd, userIdList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findRoleCodesByUserId(String userId){
        return roleEmployeeRepository.selectRoleCdsByUserId(userId);
    }

}