package com.flare.rap.region.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.region.model.RegionResponseVO;

@Mapper
public interface RegionRepository {
    List<RegionResponseVO> selectSealRegion(@Param("regnNm") String regnNm, @Param("langCd") String langCd);
}