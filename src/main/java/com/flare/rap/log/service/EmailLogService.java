package com.flare.rap.log.service;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.EmailLogRequestVO;
import com.flare.rap.log.model.EmailLogResponseVO;

public interface EmailLogService {
    PaginationResponseVO<EmailLogResponseVO> findEmailLogList(EmailLogRequestVO condition);
}