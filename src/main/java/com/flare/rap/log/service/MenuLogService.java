package com.flare.rap.log.service;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.log.model.MenuLogRequestVO;
import com.flare.rap.log.model.MenuLogResponseVO;

public interface MenuLogService {
    PaginationResponseVO<MenuLogResponseVO> findMenuLogList(MenuLogRequestVO condition);
}