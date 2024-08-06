package com.flare.rap.log.service;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.LoginLogRequestVO;
import com.flare.rap.log.model.LoginLogResponseVO;

public interface LoginLogService {
    PaginationResponseVO<LoginLogResponseVO> findLoginLogs(LoginLogRequestVO condition);
}