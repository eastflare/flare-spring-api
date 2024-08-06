package com.flare.rap.role.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.role.repository.RoleDepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleDepartmentServiceImpl implements RoleDepartmentService {

    private final RoleDepartmentRepository roleDepartmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<String> findRolesByDepartment(String deptCd) {
        return roleDepartmentRepository.selectRolesByDeptCd(deptCd);
    }
    @Override
    @Transactional(readOnly = true)
    public List<DepartmentVO> findDepartmentsByRoleCd(String roleCd){
        return roleDepartmentRepository.selectDepartmentsByRoleCd(roleCd);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int createRoleDepartments(String roleCd, List<String> deptCdList){
        int result = 0;

        if(!ValidateUtil.isEmpty(deptCdList)){
            for(String deptCd : deptCdList){
                int insertResult = roleDepartmentRepository.insertRoleDepartment(roleCd, deptCd, SessionScopeUtil.getContextSession());
                if(insertResult == 0){
                    throw new BusinessException("Department Insert Failed.", StatusCodeConstants.FAIL);
                }

                result += insertResult;
            }
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int removeRoleDepartments(String roleCd, List<String> deptCdList){
        return roleDepartmentRepository.deleteRoleDepartment(roleCd, deptCdList);
    }

}