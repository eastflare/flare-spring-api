package com.flare.rap.log.service;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.IfLogRequestVO;
import com.flare.rap.log.model.IfLogResponseVO;

public interface IfLogService {
    PaginationResponseVO<IfLogResponseVO> findIfLogList(IfLogRequestVO condition);
}