package com.flare.rap.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.role.service.RoleDepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "RoleDepartment")
@Validated
@RequestMapping("/api")
public class RoleDepartmentController {

    private final RoleDepartmentService roleDepartmentService;

    @Operation(summary = "역할별 부서 조회")
    @GetMapping(value = "/v1/role/{roleCd}/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<DepartmentVO>>> findRoleDepartments(@Parameter(name = "roleCd") @PathVariable @NotBlank String roleCd){
        return new ResponseEntity<>(CommonResponseVO.<List<DepartmentVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(roleDepartmentService.findDepartmentsByRoleCd(roleCd))
                .build(), HttpStatus.OK);

    }

    @Operation(summary = "역할별 부서 추가")
    @PostMapping(value = "/v1/role/{roleCd}/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> createRoleDepartments(@Parameter(name = "roleCd") @PathVariable @NotBlank String roleCd, @RequestBody @Valid List<String> deptCdList){
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .insertedRows(roleDepartmentService.createRoleDepartments(roleCd, deptCdList))
                        .build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "역할별 부서 삭제")
    @DeleteMapping(value = "/v1/role/{roleCd}/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> removeRoleDepartments(@Parameter(name = "roleCd") @PathVariable @NotBlank String roleCd, @RequestParam @Valid List<String> deptCdList){
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .deletedRows(roleDepartmentService.removeRoleDepartments(roleCd, deptCdList))
                        .build())
                .build(), HttpStatus.OK);
    }
}