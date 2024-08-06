package com.flare.rap.role.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.ValidList;
import com.flare.rap.role.model.RoleRequestVO;
import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.role.service.RoleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Role")
@Validated
@RequestMapping("/api")
public class RoleController {
    private final RoleService roleService;


    @Operation(summary = "역할 조회")
    @GetMapping(value = "/v1/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<RoleResponseVO>>> findRoles(@Parameter(description = "역할명") @RequestParam(required = false) String roleNm) {
        return new ResponseEntity<>(CommonResponseVO.<List<RoleResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(roleService.findRoles(roleNm))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "역할 추가/수정")
    @PostMapping(value = "/v1/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveRoles(@RequestBody @Valid ValidList<RoleRequestVO> roles) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(roleService.saveRoles(roles))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "역할 삭제")
    @DeleteMapping(value = "/v1/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> removeRoles(@Parameter(description = "역할코드 목록") @RequestBody List<@NotBlank String> roleCds) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .deletedRows(roleService.removeRoles(roleCds))
                        .build())
                .build(), HttpStatus.OK);
    }

}