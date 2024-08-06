package com.flare.project.sample.service;

import java.io.IOException;

import com.flare.rap.log.model.EmailLogRequestVO;
import com.flare.rap.log.model.IfLogRequestVO;
import com.flare.rap.log.model.LoginLogRequestVO;
import com.flare.rap.log.model.MenuLogRequestVO;
import com.flare.project.sample.model.ExcelRequestVO;

import jakarta.servlet.http.HttpServletResponse;

public interface LogExcelDownloadService {
    void downloadLogInLogListExcel(ExcelRequestVO<LoginLogRequestVO> condition, HttpServletResponse response) throws IOException;
    void downloadEmailLogListExcel(ExcelRequestVO<EmailLogRequestVO> condition, HttpServletResponse response) throws IOException;
    void downloadMenuAccessLogListExcel(ExcelRequestVO<MenuLogRequestVO> condition, HttpServletResponse response) throws IOException;
    void downloadIFLogListExcel(ExcelRequestVO<IfLogRequestVO> condition, HttpServletResponse response) throws IOException;
}