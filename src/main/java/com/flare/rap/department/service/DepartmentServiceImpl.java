package com.flare.rap.department.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.department.model.DepartmentRequestVO;
import com.flare.rap.department.model.DepartmentResponseVO;
import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.department.repository.DepartmentRepository;
import com.flare.rap.employee.service.EmployeeService;
import com.flare.rap.session.model.EmployeeVO;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;
    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentVO> findDepartments(DepartmentRequestVO departmentRequestVo) {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        departmentRequestVo.setLangCd(userSession.getLangCd());

        return departmentRepository.selectAllDepartments(departmentRequestVo);
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentResponseVO findDepartmentsAddingUserDeptCode(DepartmentRequestVO departmentRequestVo){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        EmployeeVO user = employeeService.selectEmployeeByUserId(userSession.getUserId());

        return DepartmentResponseVO.builder()
                .departmentList(this.findDepartments(departmentRequestVo))
                .userDeptCd(user.getDeptCd())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public String findParentDepartment() {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return departmentRepository.selectParentDepartment(userSession.getUserDeptCd());
    }

}