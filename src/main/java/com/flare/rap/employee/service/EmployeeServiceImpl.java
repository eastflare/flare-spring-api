package com.flare.rap.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.FormatUtil;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.employee.model.BbsEmployeeResponseVO;
import com.flare.rap.employee.model.EmployeeConditionVO;
import com.flare.rap.employee.model.TeamLeaderInfo;
import com.flare.rap.employee.repository.EmployeeRepository;
import com.flare.rap.session.model.EmployeeVO;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public EmployeeVO selectEmployeeByUserId(String userId) throws BusinessException {
        return employeeRepository.selectEmployeeByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeVO> searchEmployees(EmployeeConditionVO employeeCondition) throws BusinessException {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        List<EmployeeVO> employeeList = employeeRepository.searchEmployees(employeeCondition, userSession);
        return employeeList;
    }

    @Override
    @Transactional(readOnly = true)
    public BbsEmployeeResponseVO findBbsEmployeeByUserId(String userId, String langCd) throws BusinessException {
        BbsEmployeeResponseVO bbsEmployee = employeeRepository.selectBbsEmployeeByUserId(userId, langCd);
        String email = FormatUtil.getEmployeeEmail(bbsEmployee.getUserId(),bbsEmployee.getEmpNo());
         bbsEmployee.setEmail(email);
        return bbsEmployee;
    }

    @Override
    @Transactional(readOnly = true)
    public String getUserInfo() {
            UserSessionVO userSession = SessionScopeUtil.getContextSession();
            return employeeRepository.selectUserInfo(userSession.getLangCd(), userSession);
    }

    @Override
    @Transactional(readOnly = true)

    public TeamLeaderInfo findTeamLeaderIdByDeptCd(String deptCd) {
        UserSessionVO session = SessionScopeUtil.getContextSession();
        return employeeRepository.selectTeamLeaderIdByDeptCd(deptCd, session.getLangCd());
    }

    @Override
    public String getUserInfo2() {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return employeeRepository.selectUserInfo2(userSession.getLangCd(), userSession);
    }

    @Override
    public String findEmpNoToUserId(String empNo) {
        return employeeRepository.selectEmpNoToUserId(empNo);
    }

    @Override
    public String findUserIdToEmpNo(String userId) {
        return employeeRepository.selectUserIdToEmpNo(userId);
    }

}