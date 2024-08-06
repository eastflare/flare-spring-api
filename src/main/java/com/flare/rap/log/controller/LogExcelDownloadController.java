package com.flare.rap.log.controller;

import java.io.IOException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.log.model.EmailLogRequestVO;
import com.flare.rap.log.model.IfLogRequestVO;
import com.flare.rap.log.model.LoginLogRequestVO;
import com.flare.rap.log.model.MenuLogRequestVO;
import com.flare.project.sample.model.ExcelRequestVO;
import com.flare.project.sample.service.LogExcelDownloadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Log")
@Validated
@RequestMapping("/api")
public class LogExcelDownloadController {

    private final LogExcelDownloadService logExcelDownloadService;
    @Operation(summary = "로그인 로그 엑셀 다운로드")
    @PostMapping(value = "/v1/login/list/excel-download")
    public void downLoadLogInLogListExcel(@RequestBody ExcelRequestVO<LoginLogRequestVO> condition, HttpServletResponse response) throws IOException {
        logExcelDownloadService.downloadLogInLogListExcel(condition,response);
    }

    @Operation(summary = "이메일 로그 엑셀 다운로드")
    @PostMapping(value = "/v1/email/list/excel-download")
    public void downLoadEmailLogListExcel(@RequestBody ExcelRequestVO<EmailLogRequestVO> condition, HttpServletResponse response) throws IOException {
        logExcelDownloadService.downloadEmailLogListExcel(condition,response);
    }

    @Operation(summary = "메뉴접근 로그 엑셀 다운로드")
    @PostMapping(value = "/v1/menu/list/excel-download")
    public void downLoadMenuAccessLogListExcel(@RequestBody ExcelRequestVO<MenuLogRequestVO> condition, HttpServletResponse response) throws IOException {
        logExcelDownloadService.downloadMenuAccessLogListExcel(condition,response);
    }

    @Operation(summary = "I/F 로그 엑셀 다운로드")
    @PostMapping(value = "/v1/if/list/excel-download")
    public void downLoadIFLogListExcel(@RequestBody ExcelRequestVO<IfLogRequestVO> condition, HttpServletResponse response) throws IOException {
        logExcelDownloadService.downloadIFLogListExcel(condition,response);
    }
}