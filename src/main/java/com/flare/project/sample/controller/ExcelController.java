package com.flare.project.sample.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.project.constants.ExcelConstants;
import com.flare.project.sample.model.ExcelConversionVO;
import com.flare.project.sample.model.ExcelSampleVO;
import com.flare.project.sample.service.ExcelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name="Excel")
@Validated
@RequestMapping("/api")
public class ExcelController {

    private final ExcelService excelService;

    @GetMapping(value = "/v1/excel/download")
    @Operation(summary = "엑셀 다운로드", description = "엑셀 다운로드")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        // search data -> sample data 공통 코드 임시로 넣어놓음

        List<ExcelSampleVO> dataList = excelService.findExcelSample();

        // create excel file
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // header style
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex());
//        headerCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        //create Header
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Column1");
        headerRow.createCell(1).setCellValue("Column2");
        headerRow.createCell(2).setCellValue("Column3");

        for (int i = 0; i < 3; i++) {
            headerRow.getCell(i).setCellStyle(headerCellStyle);
        }

        // create data
        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));

        int rowNum = 1;

        for(ExcelSampleVO data : dataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getCmnGrCd());
            row.createCell(1).setCellValue(data.getCmnCd());
            row.createCell(2).setCellValue(data.getCmnCdNm());
        }

        response.setContentType(ExcelConstants.XLSX);
        response.setHeader("Content-Disposition", "attachment; filename="Data.xlsx"");

        // file export
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    @PostMapping(value = "/v1/excel/convert")
    @Operation(summary = "엑셀 변환", description = "엑셀 변환")
    public void convertToExcel(@RequestBody ExcelConversionVO excelConversion, HttpServletResponse response) throws IOException {

        // create Excel File and Sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(excelConversion.getSheetName());

        // create Header row
        List<String> headers = excelConversion.getHeader();
        Row headerRow = sheet.createRow(0);

        int headerColumnIndex = 0;
        for (String header : headers) {
            headerRow.createCell(headerColumnIndex).setCellValue(header);
            headerColumnIndex++;
        }
        // create Data row
        int rowNum = 1;
        for(List<String> rows : excelConversion.getData()) {
            Row row = sheet.createRow(rowNum++);
            int dataColumnIndex = 0;
            for(String cellvalue : rows) {
            row.createCell(dataColumnIndex).setCellValue(cellvalue);
                dataColumnIndex++;
            }
        }

        response.setContentType(ExcelConstants.XLSX);
        response.setHeader("Content-Disposition", "attachment; filename=""+ excelConversion.getFileName() +".xlsx"");

        // export file
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    @PostMapping(value = "/v1/excel/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "엑셀 업로드", description = "엑셀 업로드")
    public ResponseEntity<CommonResponseVO<List<ExcelSampleVO>>> uploadExcel(@RequestBody MultipartFile file){

        return new ResponseEntity<>(
                CommonResponseVO.<List<ExcelSampleVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(excelService.uploadExcel(file))
                        .build(),
                HttpStatus.OK);
    }
}