package com.flare.rap.approval.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.constant.ApprovalProgressStatus;
import com.flare.rap.approval.model.*;
import com.flare.rap.approval.repository.ApprovalLineRepository;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApprovalLineServiceImpl implements ApprovalLineService{

    private final ApprovalLineRepository approvalLineRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int createApprovalLines(String aprReqId, List<ApprovalLineRequestVO> approvalLineRequests) {
        this.removeLines(aprReqId);

        return this.createLines(aprReqId, approvalLineRequests);
    }

    @Override
    public int createApprovalLinesByAprvCall(String aprReqId,
                                             List<ApprovalLineRequestVO> approvalLineRequests,
                                             UserSessionVO userSession) {
        this.removeLines(aprReqId);
        int rtnCnt = this.createLines(aprReqId, approvalLineRequests, userSession);

        this.modifyApprovalRelatedUserIdByEmpNo(aprReqId);

        return rtnCnt;
    }

    private int createLines(String aprReqId, List<ApprovalLineRequestVO> approvalLineRequests){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return this.createLines(aprReqId, approvalLineRequests, userSession);
    }

    private int createLines(String aprReqId, List<ApprovalLineRequestVO> approvalLineRequests,
                            UserSessionVO userSession){
        int rtnCnt = 0;
        for(ApprovalLineRequestVO approvalLineRequest : approvalLineRequests) {
            approvalLineRequest.setAprReqId(aprReqId);
            approvalLineRepository.insertApprovalLineMaster(approvalLineRequest, userSession);
            rtnCnt++;
        }

        return rtnCnt;
    }

    private int removeLines(String aprReqId){
        return approvalLineRepository.deleteApprovalLineMaster(aprReqId);
    }

    private int modifyApprovalRelatedUserIdByEmpNo(String aprReqId){
        return approvalLineRepository.updateType2ApprovalLineEmpNoToUserId(aprReqId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int updateApprovalLineDelegate(String aprReqId) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        List<ApprovalLineDelegateResponseVO> approvalLineDelegateResponseList =
                approvalLineRepository.selectApproveLineDelegateList(aprReqId, userSession);

        for (ApprovalLineDelegateResponseVO item : approvalLineDelegateResponseList) {
            approvalLineRepository.updateApprovalLineDelegate(item, userSession);

            int isNotiExistCnt = approvalLineRepository.selectApprovalLineDelegatorCount(item);

            if (isNotiExistCnt == 0) {
                approvalLineRepository.insertApprovalLineNoticeUserByDelegate(item, userSession);
            }
        }

        return approvalLineDelegateResponseList.size();
    }

    @Override
    public List<ApprovalLineRequestVO> getNewApprovalLineRequests(String aprReqId){
        List<ApprovalLineRequestVO> approvalLineRequestVOList =
                approvalLineRepository.selectApprovalLineMaster(aprReqId);

        List<ApprovalLineRequestVO> newApprovalLineRequestVOList = new ArrayList<>();
        for(ApprovalLineRequestVO approvalLineRequestVO: approvalLineRequestVOList) {
            ApprovalLineRequestVO newApprovalLineRequestVO = ApprovalLineRequestVO.initialCopy(approvalLineRequestVO);
            newApprovalLineRequestVOList.add(newApprovalLineRequestVO);
        }

        return newApprovalLineRequestVOList;
    }

    @Override
    public int updateApprovalLineToRequest(String aprReqId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalLineRequestVO approvalLineRequestVO = new ApprovalLineRequestVO();
        approvalLineRequestVO.setAprReqId(aprReqId);
        approvalLineRequestVO.setAprPsgStatCd(ApprovalProgressStatus.WAIT);

        return approvalLineRepository.updateApprovalLineToRequest(approvalLineRequestVO, userSession);
    }

    @Override
    public int updateApprovalLineToComplete(ApprovalRequestIdRequestVO approvalRequestIdRequestVO){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return approvalLineRepository.updateType3ApprovalLineToComplete(approvalRequestIdRequestVO, userSession);
    }

    @Override
    public int updateApprovalLineToSelfApproved(ApprovalRequestIdRequestVO approvalRequestId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return approvalLineRepository.updateApprovalLineSelfApproved(approvalRequestId, userSession);
    }

    @Override
    public int updateApprovalLineToApprove(ApprovalLineRequestVO approvalLineRequest){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return approvalLineRepository.updateApprovalLineApprove(approvalLineRequest, userSession);
    }

    @Override
    public int updateApprovalLineToCancel(ApprovalRequestIdRequestVO approvalRequestId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        long aprLnSeq = approvalLineRepository.selectCancelApprovalLine(approvalRequestId.getAprReqId());
        if (aprLnSeq == 0) return 1;

        approvalRequestId.setAprLnSeq(aprLnSeq);

        return approvalLineRepository.updateApprovalLineToCancel(approvalRequestId, userSession);
    }

    @Override
    public int updateType2ApprovalLine(ApprovalLineType2UpdateRequestVO approvalLine){
        return approvalLineRepository.updateType2ApprovalLine(approvalLine);
    }

    @Override
    public boolean isApprovalLineRejected(String aprReqId){
        return approvalLineRepository.selectCheckRejectCount(aprReqId) > 0;
    }

    @Override
    public boolean isApprovalLineAllApproved(String aprReqId){
        return "Y".equals(approvalLineRepository.selectGetAllApproveYn(aprReqId));
    }

    @Override
    public int updateApprovalLineAfterReject(ApprovalRequestIdRequestVO approvalRequestId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return approvalLineRepository.updateApprovalLineAfterReject(approvalRequestId, userSession);
    }

    @Override
    public ApprovalLineResponseVO getLastApprovalLineStatus(String aprReqId){
        return approvalLineRepository.selectLastApprovalLineStatus(aprReqId);
    }

    @Override
    public ApprovalLineCheckResponseVO getApprovalLineAvailableCheck(
            ApprovalLineRequestVO approvalLineRequest){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return approvalLineRepository.selectApprovalLineCheck(approvalLineRequest, userSession);
    }

    @Override
    public List<ApprovalMobileApproversVO> getApprovalLinesForMobile(ApprovalRequestIdRequestVO approvalRequestId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return approvalLineRepository.selectApprovalLineMasterForMobile(approvalRequestId, userSession);
    }
}