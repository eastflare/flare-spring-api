package com.flare.project.sample.service;

import static com.flare.rap.common.util.ExcelUtil.getListData;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.project.constants.ExcelConstants;
import com.flare.project.sample.model.ExcelConversionVO;
import com.flare.project.sample.model.ExcelSampleVO;
import com.flare.project.sample.repository.ExcelRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ExcelServiceImpl implements ExcelService {

    private final ExcelRepository excelSampleRepository;

    @Override
    @Transactional(readOnly = true)
    //Sample Query
    public List<ExcelSampleVO> findExcelSample() {
        return excelSampleRepository.selectExcelSamples();
    }

    @Override
    public List<ExcelSampleVO> uploadExcel(MultipartFile file){
        List<ExcelSampleVO> excelSampleVOList = new ArrayList<ExcelSampleVO>();

        try {
            // file이 없을 경우 예외 처리
            if (file == null || file.isEmpty()) {
                log.info("No file");
                throw new BusinessException("No file", StatusCodeConstants.FAIL);
            }

            // file의 타입이 xlsx가 아닐 경우 예외 처리
            String contentType = file.getContentType();
            if (!ExcelConstants.XLSX.equals(contentType)) {
                log.info("Not Excel File");
                throw new BusinessException("Not Excel File", StatusCodeConstants.FAIL);
            }

            InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            int columnCount = workbook.getSheetAt(0).getRow(0).getLastCellNum();
            List<Map<String, Object>> listMap = getListData(file, 1, columnCount);

            for(Map<String, Object> map : listMap){
                ExcelSampleVO excelSampleInfo = new ExcelSampleVO();
                excelSampleInfo.setCmnGrCd(map.get("0").toString());
                excelSampleInfo.setCmnCd(map.get("1").toString());
                excelSampleInfo.setCmnCdNm(map.get("2").toString());
                excelSampleVOList.add(excelSampleInfo);
            }

//            // TODO : DB 저장
//            for(CommonCodeResponseVO commconCodeInfo : commonCodeVOList){
//                // 구현
//            }
        } catch (IOException e) {
            throw new BusinessException("IOException Occurred", StatusCodeConstants.FAIL);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        return excelSampleVOList;
    }

    // TODO: Util로 이동
    @Override
    public Workbook excelDownload(ExcelConversionVO excelConversion) {
        try{
            // create Excel file
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(excelConversion.getSheetName());

            // header style
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLACK.index);

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            //create Header
            Row headerRow = sheet.createRow(0);
            int colIndex = 0;
            for (String header : excelConversion.getHeader()) {
                Cell headerCell = headerRow.createCell((colIndex++));
                headerCell.setCellStyle(headerCellStyle);
                headerCell.setCellValue(header);
            }

            // create Data row
            int rowNum = 1;
            for (List<String> rows : excelConversion.getData()) {
                Row row = sheet.createRow(rowNum++);
                int dataColumnIndex = 0;
                for (String cellvalue : rows) {
                    row.createCell(dataColumnIndex++).setCellValue(cellvalue);
                }
            }

            return workbook;
        }catch(Exception e){
            throw new BusinessException("Create Excel Fail", StatusCodeConstants.FAIL);
        }
    }
}