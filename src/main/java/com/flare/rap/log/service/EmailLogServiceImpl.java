package com.flare.rap.log.service;

import org.springframework.stereotype.Service;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.EmailLogRequestVO;
import com.flare.rap.log.model.EmailLogResponseVO;
import com.flare.rap.log.repository.EmailLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailLogServiceImpl implements EmailLogService{
    private final EmailLogRepository emailLogRepository;


    @Override
    public PaginationResponseVO<EmailLogResponseVO> findEmailLogList(EmailLogRequestVO condition) {
        return PaginationResponseVO.<EmailLogResponseVO>builder()
                .totalCount(emailLogRepository.selectEmailLogListCount(condition))
                .list(emailLogRepository.selectEmailLogList(condition))
                .build();
    }
}