package com.flare.rap.log.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.log.service.LogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Log")
@Validated
@RequestMapping("/api")
public class LogController {

    private final LogService logService;

    @Operation(summary = "메뉴접근 로그")
    @PostMapping(value = "/v1/log/menu-access", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createMenuAccessLog(
        @RequestBody Map<String, String> mnuId) {
            logService.createMenuAccessLog(mnuId.get("mnuId"));
    }

}