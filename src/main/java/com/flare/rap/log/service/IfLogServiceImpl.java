package com.flare.rap.log.service;

import org.springframework.stereotype.Service;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.IfLogRequestVO;
import com.flare.rap.log.model.IfLogResponseVO;
import com.flare.rap.log.repository.IfLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IfLogServiceImpl implements IfLogService{
    private final IfLogRepository ifLogRepository;

    @Override
    public PaginationResponseVO<IfLogResponseVO> findIfLogList(IfLogRequestVO condition) {
        return PaginationResponseVO.<IfLogResponseVO>builder()
                .totalCount(ifLogRepository.selectIfLogListCount(condition))
                .list(ifLogRepository.selectIfLogList(condition))
                .build();
    }
}