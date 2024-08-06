package com.flare.project.sample.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.flare.rap.log.model.EmailLogRequestVO;
import com.flare.rap.log.model.EmailLogResponseVO;
import com.flare.rap.log.model.IfLogRequestVO;
import com.flare.rap.log.model.IfLogResponseVO;
import com.flare.rap.log.model.LoginLogRequestVO;
import com.flare.rap.log.model.LoginLogResponseVO;
import com.flare.rap.log.model.MenuLogRequestVO;
import com.flare.rap.log.model.MenuLogResponseVO;
import com.flare.rap.log.repository.EmailLogRepository;
import com.flare.rap.log.repository.IfLogRepository;
import com.flare.rap.log.repository.LoginLogRepository;
import com.flare.rap.log.repository.MenuLogRepository;
import com.flare.project.constants.ExcelConstants;
import com.flare.project.sample.model.ExcelConversionVO;
import com.flare.project.sample.model.ExcelRequestVO;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogExcelDownloadServiceImpl implements LogExcelDownloadService{

    private final LoginLogRepository loginLogRepository;
    private final EmailLogRepository emailLogRepository;
    private final MenuLogRepository menuLogRepository;
    private final IfLogRepository ifLogRepository;
    private final ExcelService excelService; // TODO: UTIL로 변경하면 해당 클래스는 eswf-core로 이동

    @Override
    public void downloadLogInLogListExcel(ExcelRequestVO<LoginLogRequestVO> condition, HttpServletResponse response) throws IOException {
        List<LoginLogResponseVO> data = loginLogRepository.selectLoginLogList(condition.getSearchCondition());

        List<List<String>> excelData = new ArrayList<>();
        for(LoginLogResponseVO row : data){
            List<String> rowData = new ArrayList<>();
            rowData.add(row.getContDtm());    //로그인 일시
            rowData.add(row.getContUserId());  //로그인 사용자 id
            rowData.add(row.getEmpNm());      //로그인 사용자 명
            rowData.add(row.getDeptNm());      //로그인 사용자 부서명
            rowData.add(row.getContIp());     //로그인 IP
            excelData.add(rowData);
        }

        ExcelConversionVO excelConversion = ExcelConversionVO.builder()
                .fileName(condition.getFileName())
                .sheetName(condition.getSheetName())
                .header(condition.getHeader())
                .data(excelData)
                .build();

        ServletOutputStream outStream = null;
        Workbook workbook = null;

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();

        try {
            workbook = excelService.excelDownload(excelConversion);

            workbook.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();

            response.setCharacterEncoding("UTF-8");
            response.setContentType(ExcelConstants.XLSX);
            response.setHeader("Content-Disposition", "attachment; filename=""+ URLEncoder.encode(excelConversion.getFileName(),"UTF-8") +".xlsx"");

            outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();

        } catch (IOException ex) {
            log.error("Failed to create report file " + excelConversion.getFileName(), ex);
        } catch (Exception ex) {
            log.error("Error while generating report file " + excelConversion.getFileName(), ex);
        } finally {
            if (outStream != null) {
                outStream.close();
            }
            if (workbook != null) {
                workbook.close();
            }
            if (outByteStream != null) {
                outByteStream.close();
            }
        }
    }

    @Override
    public void downloadEmailLogListExcel(ExcelRequestVO<EmailLogRequestVO> condition, HttpServletResponse response) throws IOException {
        List<EmailLogResponseVO> data = emailLogRepository.selectEmailLogList(condition.getSearchCondition());

        List<List<String>> excelData = new ArrayList<>();
        for(EmailLogResponseVO row : data){
            List<String> rowData = new ArrayList<>();
            rowData.add(String.valueOf(row.getEmlSndoSeq()));       //발송순번
            rowData.add(row.getSedDtm());                           //발송일시
            rowData.add(row.getEmlRcvrLstCtn());                    //수신자
            rowData.add(row.getEmlTpCd());                          //유형
            rowData.add(row.getEmlTrnmStatCd());                    //전송결과
            excelData.add(rowData);
        }

        ExcelConversionVO excelConversion = ExcelConversionVO.builder()
                .fileName(condition.getFileName())
                .sheetName(condition.getSheetName())
                .header(condition.getHeader())
                .data(excelData)
                .build();

        ServletOutputStream outStream = null;
        Workbook workbook = null;

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();

        try {
            workbook = excelService.excelDownload(excelConversion);

            workbook.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();

            response.setCharacterEncoding("UTF-8");
            response.setContentType(ExcelConstants.XLSX);
            response.setHeader("Content-Disposition", "attachment; filename=""+ URLEncoder.encode(excelConversion.getFileName(),"UTF-8") +".xlsx"");

            outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();

        } catch (IOException ex) {
            log.error("Failed to create report file " + excelConversion.getFileName(), ex);
        } catch (Exception ex) {
            log.error("Error while generating report file " + excelConversion.getFileName(), ex);
        } finally {
            if (outStream != null) {
                outStream.close();
            }
            if (workbook != null) {
                workbook.close();
            }
            if (outByteStream != null) {
                outByteStream.close();
            }
        }
    }

    @Override
    public void downloadMenuAccessLogListExcel(ExcelRequestVO<MenuLogRequestVO> condition, HttpServletResponse response) throws IOException {
        List<MenuLogResponseVO> data = menuLogRepository.selectMenuLogList(condition.getSearchCondition());

        List<List<String>> excelData = new ArrayList<>();
        for(MenuLogResponseVO row : data){
            List<String> rowData = new ArrayList<>();
            rowData.add(row.getContDtm());    //접근 일시
            rowData.add(row.getMnuNm());      //접근 메뉴면
            rowData.add(row.getContUserId()); //사용자id
            rowData.add(row.getEmpNm());      //사용자 명
            rowData.add(row.getContIp());     //IP
            excelData.add(rowData);
        }

        ExcelConversionVO excelConversion = ExcelConversionVO.builder()
                .fileName(condition.getFileName())
                .sheetName(condition.getSheetName())
                .header(condition.getHeader())
                .data(excelData)
                .build();

        ServletOutputStream outStream = null;
        Workbook workbook = null;

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();

        try {
            workbook = excelService.excelDownload(excelConversion);

            workbook.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();

            response.setCharacterEncoding("UTF-8");
            response.setContentType(ExcelConstants.XLSX);
            response.setHeader("Content-Disposition", "attachment; filename=""+ URLEncoder.encode(excelConversion.getFileName(),"UTF-8") +".xlsx"");

            outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();

        } catch (IOException ex) {
            log.error("Failed to create report file " + excelConversion.getFileName(), ex);
        } catch (Exception ex) {
            log.error("Error while generating report file " + excelConversion.getFileName(), ex);
        } finally {
            if (outStream != null) {
                outStream.close();
            }
            if (workbook != null) {
                workbook.close();
            }
            if (outByteStream != null) {
                outByteStream.close();
            }
        }
    }

    @Override
    public void downloadIFLogListExcel(ExcelRequestVO<IfLogRequestVO> condition, HttpServletResponse response) throws IOException {
        List<IfLogResponseVO> data = ifLogRepository.selectIfLogList(condition.getSearchCondition());

        List<List<String>> excelData = new ArrayList<>();
        for(IfLogResponseVO row : data){
            List<String> rowData = new ArrayList<>();
            rowData.add(row.getIfLogDtm());         //발생 일시
            rowData.add(row.getIfDivsCd());         //송/수신구분
            rowData.add(row.getIfNm());             //IF명
            rowData.add(row.getIfTrmtValCtn());     //IF송신내용
            rowData.add(row.getIfRestValCtn());     //IF수신내용
            rowData.add(row.getOptValNm1());        //부가정보1
            rowData.add(row.getOptValNm2());        //부가정보2
            rowData.add(row.getOptValNm3());        //부가정보3
            rowData.add(row.getOptValNm4());        //부가정보4
            rowData.add(row.getOptValNm5());        //부가정보5
            excelData.add(rowData);
        }

        ExcelConversionVO excelConversion = ExcelConversionVO.builder()
                .fileName(condition.getFileName())
                .sheetName(condition.getSheetName())
                .header(condition.getHeader())
                .data(excelData)
                .build();

        ServletOutputStream outStream = null;
        Workbook workbook = null;

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();

        try {
            workbook = excelService.excelDownload(excelConversion);

            workbook.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();

            response.setCharacterEncoding("UTF-8");
            response.setContentType(ExcelConstants.XLSX);
            response.setHeader("Content-Disposition", "attachment; filename=""+ URLEncoder.encode(excelConversion.getFileName(),"UTF-8") +".xlsx"");

            outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();

        } catch (IOException ex) {
            log.error("Failed to create report file " + excelConversion.getFileName(), ex);
        } catch (Exception ex) {
            log.error("Error while generating report file " + excelConversion.getFileName(), ex);
        } finally {
            if (outStream != null) {
                outStream.close();
            }
            if (workbook != null) {
                workbook.close();
            }
            if (outByteStream != null) {
                outByteStream.close();
            }
        }
    }
}