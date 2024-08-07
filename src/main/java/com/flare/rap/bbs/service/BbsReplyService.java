package com.flare.rap.bbs.service;

import com.flare.rap.bbs.model.BbsReplyRequestVO;

public interface BbsReplyService {

    int createBbsReply(BbsReplyRequestVO bbsReplyRequest);

    int removeBbsReply(String bbmNo, String bbmReNo);

    int modifyBbsReply(BbsReplyRequestVO bbsReplyRequestVO);

}