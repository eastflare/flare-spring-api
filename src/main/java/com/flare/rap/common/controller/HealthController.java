package com.flare.rap.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/health")
@Tag(name = "Health")
public class HealthController {

    @Operation(summary = "Health Check")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommonResponseVO> healthCheck() {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .build(),
                HttpStatus.OK);
    }
}