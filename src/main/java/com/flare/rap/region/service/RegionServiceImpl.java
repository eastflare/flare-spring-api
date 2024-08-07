package com.flare.rap.region.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.region.model.RegionResponseVO;
import com.flare.rap.region.repository.RegionRepository;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RegionResponseVO> findSealRegion(String regnNm) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return regionRepository.selectSealRegion(regnNm, userSession.getLangCd());
    }

}