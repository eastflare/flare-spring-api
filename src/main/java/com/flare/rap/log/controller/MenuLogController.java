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
import com.flare.rap.log.model.MenuLogRequestVO;
import com.flare.rap.log.model.MenuLogResponseVO;
import com.flare.rap.log.service.MenuLogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Menu Log")
@Validated
@RequestMapping("/api")
public class MenuLogController {
    private final MenuLogService menuLogService;

    @Operation(summary = "메뉴로그 목록 조회")
    @GetMapping(value = "/v1/admin/menu-log", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<PaginationResponseVO<MenuLogResponseVO>>> findBbsPosts(@ParameterObject @Valid MenuLogRequestVO condition) {
        return new ResponseEntity<>(CommonResponseVO.<PaginationResponseVO<MenuLogResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(menuLogService.findMenuLogList(condition))
                .build(), HttpStatus.OK);
    }
}