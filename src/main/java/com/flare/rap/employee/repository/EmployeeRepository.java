package com.flare.rap.employee.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.employee.model.BbsEmployeeResponseVO;
import com.flare.rap.employee.model.EmployeeConditionVO;
import com.flare.rap.employee.model.TeamLeaderInfo;
import com.flare.rap.session.model.EmployeeVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface EmployeeRepository {

    EmployeeVO selectEmployeeByUserId(String userId);

    List<EmployeeVO> searchEmployees(@Param("condition") EmployeeConditionVO condition, @Param("session") UserSessionVO userSession);

    BbsEmployeeResponseVO selectBbsEmployeeByUserId(@Param("userId") String userId, @Param("langCd") String langCd);

    String selectUserInfo(@Param("langCd") String langCd, @Param("session") UserSessionVO userSession);

    TeamLeaderInfo selectTeamLeaderIdByDeptCd(@Param("deptCd") String deptCd, @Param("langCd") String langCd);

    String selectUserMailAddress(@Param("userId") String userId);

    String selectUserInfo2(@Param("langCd") String langCd, @Param("session") UserSessionVO userSession);

    String selectEmpNoToUserId(String empNo);

    String selectUserIdToEmpNo(String userId);

}