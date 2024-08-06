package com.flare.rap.log.service;

import org.springframework.stereotype.Service;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.LoginLogRequestVO;
import com.flare.rap.log.model.LoginLogResponseVO;
import com.flare.rap.log.repository.LoginLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {
    private final LoginLogRepository loginLogRepository;

    @Override
    public PaginationResponseVO<LoginLogResponseVO> findLoginLogs(LoginLogRequestVO condition) {
        return PaginationResponseVO.<LoginLogResponseVO>builder()
                .totalCount(loginLogRepository.selectLoginLogListCount(condition))
                .list(loginLogRepository.selectLoginLogList(condition))
                .build();
    }
}