package com.flare.rap.common.util;

import static com.flare.rap.common.util.ValidateUtil.isEmpty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class ExcelUtil {
    public static String getCellValue(XSSFCell cell){
        String value = "";

        if(cell == null) return value;

        switch(cell.getCellType()){
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                value = String.valueOf((int) cell.getNumericCellValue());
                break;
            default:
                break;
        }
        return value;
    }

    //엑셀 파일의 데이터 목록 가져오기
    public static List<Map<String, Object>> getListData(MultipartFile file, int startRowNum, int columnLength){
        List<Map<String, Object>> excelList = new ArrayList<>();
        try{
            OPCPackage opcPackage = OPCPackage.open(file.getInputStream());
            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for(int rowIndex = startRowNum; rowIndex < sheet.getLastRowNum()+1; rowIndex++){
                XSSFRow row = sheet.getRow(rowIndex);

                if(!isEmpty(row.getCell(0).toString())) {
                    Map<String, Object> map = new HashMap<>();

                    for(int columnIndex = 0; columnIndex < columnLength; columnIndex++){
                        XSSFCell cell = row.getCell(columnIndex);
                        map.put(String.valueOf(columnIndex), getCellValue(cell));
                    }
                    excelList.add(map);
                }
            }

        } catch (IOException e){
            throw new BusinessException("IOException Occurred", StatusCodeConstants.FAIL);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return excelList;
    }
}