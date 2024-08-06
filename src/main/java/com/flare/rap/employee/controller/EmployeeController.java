package com.flare.rap.employee.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.employee.model.EmployeeConditionVO;
import com.flare.rap.employee.model.TeamLeaderInfo;
import com.flare.rap.employee.service.EmployeeService;
import com.flare.rap.session.model.EmployeeVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name="Employee")
@Validated
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Operation(summary = "조건별 사원 조회")
    @GetMapping(value="/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<EmployeeVO>>> findEmployeeBySearchItem(EmployeeConditionVO employeeCondition){

        return new ResponseEntity<>(
                CommonResponseVO.<List<EmployeeVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(employeeService.searchEmployees(employeeCondition))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "사용자 정보 조회 ex) 시*자(admin/사원/업무용)")
    @GetMapping(value = "/v1/employee/userInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> getUserInfo() {
      return new ResponseEntity<>(CommonResponseVO.builder()
          .successOrNot(CommonConstants.YES_FLAG)
          .statusCode(StatusCodeConstants.SUCCESS)
          .data(employeeService.getUserInfo())
          .build(), HttpStatus.OK);
    }

    @Operation(summary = "사용자 정보 조회 ex) 시*자(admin/사원/업무용)")
    @GetMapping(value = "/v1/employee/userInfo/short", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> getUserInfo2() {
        return new ResponseEntity<>(CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(employeeService.getUserInfo2())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "팀장 id 조회")
    @GetMapping(value = "/v1/employee/teamLeaderId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<TeamLeaderInfo>> findTeamLeaderId(@Parameter(description = "부서코드", example = "30313985") @RequestParam String deptCd) {
        return new ResponseEntity<>(CommonResponseVO.<TeamLeaderInfo>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(employeeService.findTeamLeaderIdByDeptCd(deptCd))
                .build(), HttpStatus.OK);
    }
}