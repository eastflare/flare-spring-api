package com.flare.rap.approval.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.constant.ApprovalRequestProgressStatus;
import com.flare.rap.approval.model.*;
import com.flare.rap.approval.repository.ApprovalRequestRepository;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository approvalRequestRepository;
    private final ApprovalLineService approvalLineService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String createApprovalRequestAndLine(ApprovalRequestVO approvalRequest) {
        String newAprReqId = this.createApprovalRequest(approvalRequest.getApprovalRequestMasterRequest());

        approvalLineService.createApprovalLines(newAprReqId, approvalRequest.getApprovalLineRequests());

        return newAprReqId;
    }

    private String createApprovalRequest(ApprovalRequestMasterRequestVO approvalRequestMasterRequestVO) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        String newAprReqId = approvalRequestRepository.selectGetApprovalRequestMasterId();

        approvalRequestMasterRequestVO.setAprReqId(newAprReqId);
        approvalRequestRepository.insertApprovalRequestMaster(approvalRequestMasterRequestVO, userSession );

        return newAprReqId;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String createReApprovalRequestAndLine(String aprReqId) {

        ApprovalRequestMasterResponseVO approvalRequestMasterResponseVO =
                approvalRequestRepository.selectApprovalRequestMaster(ApprovalRequestIdRequestVO.of(aprReqId),
                        SessionScopeUtil.getContextSession());

        ApprovalRequestMasterRequestVO approvalRequestMasterRequestVO =
                ApprovalRequestMasterRequestVO.of(approvalRequestMasterResponseVO);
        approvalRequestMasterResponseVO.setAprReqProgStatCd(ApprovalRequestProgressStatus.TEMPORARY_SAVE);

        List<ApprovalLineRequestVO> approvalLineRequestVOs = approvalLineService.getNewApprovalLineRequests(aprReqId);

        return this.createApprovalRequestAndLine(
                new ApprovalRequestVO(approvalRequestMasterRequestVO, approvalLineRequestVOs));
    }

    @Override
    public int updateApprovalRequestMasterToRequest(String aprReqId, String apprId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalRequestMasterRequestVO approvalRequestMasterUpdate =
                ApprovalRequestMasterRequestVO.of(aprReqId, apprId);
        approvalRequestMasterUpdate.setAprReqProgStatCd(ApprovalRequestProgressStatus.REQUEST);

        return approvalRequestRepository.updateApprovalRequestMasterToRequest(approvalRequestMasterUpdate, userSession);
    }

    @Override
    public boolean getCancelAvailableCheck(String aprReqId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        String cancelAvailableYn = approvalRequestRepository.selectCancelAvailableCheck(aprReqId, userSession);

        return "Y".equals(cancelAvailableYn);
    }

    @Override
    public ApprovalRequestMasterResponseVO getApprovalRequestMasterForRequest(ApprovalRequestIdRequestVO approvalRequestId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return approvalRequestRepository.selectApprovalRequestMasterForRequest(approvalRequestId, userSession);
    }

    @Override
    public ApprovalRequestMasterResponseVO getApprovalRequestMaster(ApprovalRequestIdRequestVO approvalRequestId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return approvalRequestRepository.selectApprovalInfoForIf(approvalRequestId, userSession);
    }

    @Override
    public int updateApprovalRequestMasterStatus(ApprovalRequestIdRequestVO approvalRequestId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return approvalRequestRepository.updateApprovalRequestMasterStatus(approvalRequestId, userSession);
    }

    @Override
    public boolean isSelfApprovalAvailable(String aprReqId){
        String selfApprovalAvailableYN = approvalRequestRepository.selectSelfApprovalAvailable(aprReqId);

        return "Y".equals(selfApprovalAvailableYN);
    }

    @Override
    public ApprovalLineRequestVO getWaitApprovalLineByUserId(ApprovalRequestIdRequestVO approvalRequestIdRequestVO){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return approvalRequestRepository.selectWaitApprovalLineByUserId(approvalRequestIdRequestVO, userSession);
    }

    @Override
    public ApprovalLineRequestVO getApprovalLineMasterWithSeq(ApprovalRequestIdRequestVO approvalRequestIdRequestVO){
        return approvalRequestRepository.selectApprovalLineMasterWithSeq(approvalRequestIdRequestVO);
    }

    @Override
    public List<ApprovalMobileFilesVO> getApprovalFilesForMobile(ApprovalRequestIdRequestVO approvalRequestIdRequestVO){
        return approvalRequestRepository.selectApprovalAprFileForMobile(approvalRequestIdRequestVO);
    }
}