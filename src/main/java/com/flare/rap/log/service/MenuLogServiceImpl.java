package com.flare.rap.log.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.MenuLogRequestVO;
import com.flare.rap.log.model.MenuLogResponseVO;
import com.flare.rap.log.repository.MenuLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuLogServiceImpl implements MenuLogService {
    private final MenuLogRepository menuLogRepository;
    @Override
    @Transactional(readOnly = true)
    public PaginationResponseVO<MenuLogResponseVO> findMenuLogList(MenuLogRequestVO condition) {
        return PaginationResponseVO.<MenuLogResponseVO>builder()
                .totalCount(menuLogRepository.selectMenuLogListCount(condition))
                .list(menuLogRepository.selectMenuLogList(condition))
                .build();
    }
}