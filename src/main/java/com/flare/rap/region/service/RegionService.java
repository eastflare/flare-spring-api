package com.flare.rap.region.service;

import java.util.List;

import com.flare.rap.region.model.RegionResponseVO;

public interface RegionService {
    List<RegionResponseVO> findSealRegion(String regnNm);
}