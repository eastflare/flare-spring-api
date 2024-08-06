package com.flare.project.sample.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.flare.project.sample.model.ExcelSampleVO;

@Mapper
public interface ExcelRepository {
    //temp query
    List<ExcelSampleVO> selectExcelSamples();

}