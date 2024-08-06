package com.flare.rap.employee.service;

import java.util.List;

import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.employee.model.BbsEmployeeResponseVO;
import com.flare.rap.employee.model.EmployeeConditionVO;
import com.flare.rap.employee.model.TeamLeaderInfo;
import com.flare.rap.session.model.EmployeeVO;

public interface EmployeeService {

    EmployeeVO selectEmployeeByUserId (String userId) throws BusinessException;

    List<EmployeeVO> searchEmployees (EmployeeConditionVO employeeCondition) throws BusinessException;

    BbsEmployeeResponseVO findBbsEmployeeByUserId(String userId, String langCd);

    String getUserInfo();

    TeamLeaderInfo findTeamLeaderIdByDeptCd(String deptCd);

    String getUserInfo2();

    String findEmpNoToUserId(String empNo);

    String findUserIdToEmpNo(String userId);
}