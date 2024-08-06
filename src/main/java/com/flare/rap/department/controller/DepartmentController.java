package com.flare.rap.department.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.department.model.DepartmentRequestVO;
import com.flare.rap.department.model.DepartmentResponseVO;
import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.department.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name="Department")
@Validated
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Operation(summary = "부서 조회", description = "부서 조회")
    @GetMapping(value = "/v1/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DepartmentResponseVO>> findDepartments(@ParameterObject DepartmentRequestVO departmentRequestVo) {
        return new ResponseEntity<>(
            CommonResponseVO.<DepartmentResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(departmentService.findDepartmentsAddingUserDeptCode(departmentRequestVo))
                .build(),
            HttpStatus.OK);
    }

    @Operation(summary = "부모 부서 조회", description = "부모 부서 조회")
    @GetMapping(value = "/v1/department/parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<String>> findParentDepartment() {

        return new ResponseEntity<>(
                CommonResponseVO.<String>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(departmentService.findParentDepartment())
                        .build(),
                HttpStatus.OK);
    }
}