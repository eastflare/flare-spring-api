package com.flare.rap.bbs.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.bbs.model.BbsReplyRequestVO;
import com.flare.rap.bbs.model.BbsReplyVO;
import com.flare.rap.bbs.repository.BbsReplyRepository;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BbsReplyServiceImpl implements BbsReplyService {

    private final BbsReplyRepository bbsReplyRepository;

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int createBbsReply(BbsReplyRequestVO bbsReplyRequest) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return bbsReplyRepository.insertBbsReply(bbsReplyRequest, userSession);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int removeBbsReply(String bbmNo, String bbmReNo) {

        int result = 0;
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        if(userSession.getRoleCodes().contains("ADM")){
            result = bbsReplyRepository.deleteBbsReply(bbmNo,bbmReNo);
        }else{
            BbsReplyVO replyToDelete = bbsReplyRepository.selectBbsReply(bbmNo, bbmReNo);
            if(replyToDelete.getDataInsUserId() == null || !replyToDelete.getDataInsUserId().equals(userSession.getUserId())){
                throw new BusinessException("User does not have permission to delete", StatusCodeConstants.NOT_AUTHORIZED_EXCEPTION);
            }
            result = bbsReplyRepository.deleteBbsReply(bbmNo,bbmReNo);
        }

        return result;
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int modifyBbsReply(BbsReplyRequestVO bbsReplyRequestVO) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        BbsReplyVO reply = bbsReplyRepository.selectBbsReply(bbsReplyRequestVO.getBbmNo(), bbsReplyRequestVO.getBbmReNo());
        if(reply == null) {
            throw new BusinessException("The reply doesn't exist", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }
        if(!reply.getDataInsUserId().equals(userSession.getUserId())) {
            throw new BusinessException("User does not have permission to update", StatusCodeConstants.NOT_AUTHORIZED_EXCEPTION);
        }

        return bbsReplyRepository.updateBbsReply(bbsReplyRequestVO, userSession);
    }
}