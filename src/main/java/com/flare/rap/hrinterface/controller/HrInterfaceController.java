package com.flare.rap.hrInterface.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.hrInterface.service.HrInterfaceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "HrInterface")
@Validated
@RequestMapping("/api")
public class HrInterfaceController {

    private final HrInterfaceService hrInterfaceService;
    @Operation(summary = "DeptBatch", description = "DeptBatch")
    @PostMapping(value = "/v1/DeptBatch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> migrateDepartments() throws Exception{
        hrInterfaceService.migrateDepartments();
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(' ')
                        .build(),
                HttpStatus.OK);
    }
    @Operation(summary = "EmpBatch", description = "EmpBatch")
    @PostMapping(value = "/v1/EmpBatch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> migrateEmployees() throws Exception{
        hrInterfaceService.migrateEmployees();
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(' ')
                        .build(),
                HttpStatus.OK);
    }
}