package com.flare.rap.bbs.service;

import com.flare.rap.bbs.model.BbsConditionVO;
import com.flare.rap.bbs.model.BbsPostDetailResponseVO;
import com.flare.rap.bbs.model.BbsPostRequestVO;
import com.flare.rap.bbs.model.BbsPostResponseVO;
import com.flare.rap.common.model.PaginationResponseVO;

public interface BbsService {

    PaginationResponseVO<BbsPostResponseVO> findBbs(BbsConditionVO bbsCondition);

    BbsPostDetailResponseVO findBbsPost(int bbmNo);

    int createBbsPost(BbsPostRequestVO bbsVO);

    int modifyBbsPost(BbsPostRequestVO bbsVO);

    int removeBbsPost(int bbmNo);
}