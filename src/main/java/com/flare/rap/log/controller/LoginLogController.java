package com.flare.rap.log.controller;

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
import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.LoginLogRequestVO;
import com.flare.rap.log.model.LoginLogResponseVO;
import com.flare.rap.log.service.LoginLogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Login Log")
@Validated
@RequestMapping("/api")
public class LoginLogController {
    private final LoginLogService loginLogService;
    @Operation(summary = "로그인로그 목록 조회")
    @GetMapping(value = "/v1/admin/login-log", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< CommonResponseVO< PaginationResponseVO< LoginLogResponseVO>>> findBbsPosts(@ParameterObject @Valid LoginLogRequestVO condition) {
        return new ResponseEntity< >(CommonResponseVO.< PaginationResponseVO< LoginLogResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(loginLogService.findLoginLogs(condition))
                .build(), HttpStatus.OK);
    }
}