package com.flare.project.sample.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import com.flare.project.sample.model.ExcelConversionVO;
import com.flare.project.sample.model.ExcelSampleVO;

public interface ExcelService {
    List<ExcelSampleVO> findExcelSample();
    List<ExcelSampleVO> uploadExcel(MultipartFile file);
    Workbook excelDownload(ExcelConversionVO excelConversion);
}