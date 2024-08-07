package com.flare.rap.approval.service;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.constant.ApprovalRequestProgressStatus;
import com.flare.rap.approval.model.*;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.service.WebService;
import com.flare.rap.webservice.service.WebServiceFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalRequestType2ServiceImpl implements ApprovalRequestType2Service{
    private final ApprovalRequestService approvalRequestService;
    private final ApprovalLineService approvalLineService;
    private final AfterApprovalService afterApprovalService;
    private final WebServiceFactory webServiceFactory;

    private final MessageSource messageSource;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ApprovalCommonResponseVO sendType2ApprovalRequest(ApprovalRequestIdRequestVO approvalRequestId) {

        ApprovalCommonResponseVO approvalCommonResponse = this.sendWebServiceApprovalRequest(approvalRequestId);

        if(approvalCommonResponse.hasSucceed()) {
            // IS_RETURN_APPR_ID 을 1로 전송했기때문에, 통합결재에서 IF_ERRMSG 항목에 APPR_ID 값을 반환해 줌.
            this.updateApprovalRequestMasterAndLineToRequest(approvalRequestId.getAprReqId(),
                    approvalRequestId.getAprReqId());
        }

        return approvalCommonResponse;
    }

    private ApprovalCommonResponseVO sendWebServiceApprovalRequest(ApprovalRequestIdRequestVO approvalRequestId){
        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMasterForRequest(approvalRequestId);

        this.checkValidation(approvalRequestMaster);

        String formMobileData = "<p>" +
                messageSource.getMessage("com.approval.원문보기를 눌러 결재 할 내용을 확인해 주세요.",
                        null, new Locale(SessionScopeUtil.getContextSession().getLangCd())) + "</p>";

        ApprovalCommonRequestVO approvalCommonRequestVO =
                ApprovalCommonRequestVO.ofType2Request(approvalRequestMaster, formMobileData);

        return this.sendWebServiceApprovalType2(approvalCommonRequestVO);
    }

    private void checkValidation(ApprovalRequestMasterResponseVO approvalRequestMaster){
        if (approvalRequestMaster == null) {
            throw new BusinessException("결재 정보가 존재하지 않습니다..", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }

        if(!approvalRequestMaster.isApprovalType2()) {
            throw new BusinessException( "Type2 결재 정보가 아닙니다.", StatusCodeConstants.EXPECTATION_FAILED);
        }
    }

    private ApprovalCommonResponseVO sendWebServiceApprovalType2(ApprovalCommonRequestVO approvalCommonRequest){
        ApprovalCommonResponseVO approvalCommonResponseVO = null;
        try {
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.APPROVAL_AUTO);
            approvalCommonResponseVO = (ApprovalCommonResponseVO) webService.execute(approvalCommonRequest);
        } catch (Exception e) {
            throw new BusinessException("통합결재 Type2 WebService 결재 호출 실패", StatusCodeConstants.FAIL);
        }

        return approvalCommonResponseVO;
    }

    private void updateApprovalRequestMasterAndLineToRequest(String aprReqId, String aprId){
        int approvalRequestUpdateCnt = approvalRequestService.updateApprovalRequestMasterToRequest(aprReqId, aprId);
        int approvalLineUpdateCnt = approvalLineService.updateApprovalLineToRequest(aprReqId);

        if(approvalRequestUpdateCnt == 0 || approvalLineUpdateCnt == 0 ) {
            throw new BusinessException("Type2 결재정보 오류-결재요청기본, 결재라인기본 확인 바랍니다.",
                    StatusCodeConstants.FAIL);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String updateType2CheckLastApproval(ApprovalRequestIdRequestVO approvalRequestId) {

        if(approvalRequestId.isStatusCancel()) {
            this.doCancelProcess(approvalRequestId);
            return "Y";
        }

        boolean isRejected =  approvalLineService.isApprovalLineRejected(approvalRequestId.getAprReqId());
        if( isRejected ) {
            this.doRejectProcess(approvalRequestId);
            return  "Y";
        }

        boolean isAllApproved = approvalLineService.isApprovalLineAllApproved(approvalRequestId.getAprReqId());
        ApprovalLineResponseVO lastApprovalLine =
                approvalLineService.getLastApprovalLineStatus(approvalRequestId.getAprReqId());
        if(isAllApproved && lastApprovalLine.isApproved()) {
            this.doCompleteProcess(approvalRequestId);
            return "Y";
        }

        this.doInProgressProcess(approvalRequestId);
        return "Y";
    }

    private void doCancelProcess(ApprovalRequestIdRequestVO approvalRequestId){
        boolean isCancelAvailable = approvalRequestService.getCancelAvailableCheck(approvalRequestId.getAprReqId());
        if (!isCancelAvailable) {
            throw new BusinessException("결재 취소 권한이 없습니다.", StatusCodeConstants.EXPECTATION_FAILED);
        }

        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.CANCEL);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);

        approvalLineService.updateApprovalLineToCancel(approvalRequestId);

        afterApprovalService.afterApprovalProcess(approvalRequestId);
    }

    private void doRejectProcess(ApprovalRequestIdRequestVO approvalRequestId){
        approvalLineService.updateApprovalLineAfterReject(approvalRequestId);

        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.REJECT);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);

        afterApprovalService.afterApprovalProcess(approvalRequestId);
    }

    private void doCompleteProcess(ApprovalRequestIdRequestVO approvalRequestId){
        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.COMPLETE);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);

        afterApprovalService.afterApprovalProcess(approvalRequestId);
    }

    private void doInProgressProcess(ApprovalRequestIdRequestVO approvalRequestId){
        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.IN_PROGRESS);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);
    }
}