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
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.employee.service.EmployeeService;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.service.WebService;
import com.flare.rap.webservice.service.WebServiceFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalRequestType3ServiceImpl implements ApprovalRequestType3Service{
    private final ApprovalRequestService approvalRequestService;
    private final ApprovalLineService approvalLineService;
    private final AfterApprovalService afterApprovalService;
    private final ApprovalType3EmailService approvalType3EmailService;
    private final EmployeeService employeeService;
    private final WebServiceFactory webServiceFactory;

    private final MessageSource messageSource;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ApprovalCommonResponseVO sendType3ApprovalRequestProcess(ApprovalRequestIdRequestVO approvalRequestId) {

        if(!approvalRequestId.isStatusRequest()){ return null; }

        approvalLineService.updateApprovalLineDelegate(approvalRequestId.getAprReqId());

        approvalRequestId.setAprLnSeq(1); // 결재라인을 첫번째로 강제 설정.
        ApprovalCommonResponseVO approvalRequestResult = this.sendType3Request(approvalRequestId);

        // IS_RETURN_APPR_ID 을 1로 전송했기때문에, 통합결재에서 IF_ERRMSG 항목에 APPR_ID 값을 반환해 줌.
        this.updateApprovalRequestMasterAndLineToRequest(approvalRequestId.getAprReqId(),
                approvalRequestResult.getIfErrMsg());

        boolean isSelfApprovalAvailable =
                approvalRequestService.isSelfApprovalAvailable(approvalRequestId.getAprReqId());
        if(isSelfApprovalAvailable) {
            this.doSelfApprovalProcess(approvalRequestId);
        } else {
            this.sendRequestMail(approvalRequestId.getAprReqId(), approvalRequestId.getAprLnSeq());
        }
        return approvalRequestResult;
    }

    private ApprovalCommonResponseVO sendType3Request(ApprovalRequestIdRequestVO approvalRequestId) {
        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMasterForRequest(approvalRequestId);

        this.checkValidation(approvalRequestMaster);

        String formEditorData = approvalRequestMaster.getTrnmBdyCtn();
        if(ValidateUtil.isEmpty(formEditorData)){
            formEditorData =  "<p>" + messageSource.getMessage("com.approval.원문보기를 눌러 결재 할 내용을 확인해 주세요.",
                    null, new Locale(SessionScopeUtil.getContextSession().getLangCd())) +  "</p>";
        }

        ApprovalCommonRequestVO approvalCommonRequestVO =
                ApprovalCommonRequestVO.ofType3Request(approvalRequestMaster, formEditorData);

        ApprovalCommonResponseVO approvalRequestResult = this.sendWebServiceApprovalType3(approvalCommonRequestVO);

        if(!approvalRequestResult.hasSucceed()) {
            throw new BusinessException("통합결재 Type3 WebService 결재요청 호출 실패 - 기안요청 : "
                    + approvalRequestResult.getIfStatus() + " "
                    + approvalRequestResult.getIfErrMsg(), StatusCodeConstants.FAIL);
        }

        return approvalRequestResult;
    }

    private void checkValidation(ApprovalRequestMasterResponseVO approvalRequestMaster){
        if (approvalRequestMaster == null) {
            throw new BusinessException("결재 정보가 존재하지 않습니다..", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }

        if(!approvalRequestMaster.isApprovalType3()) {
            throw new BusinessException("Type3 결재 정보가 아닙니다.", StatusCodeConstants.EXPECTATION_FAILED);
        }
    }

    private ApprovalCommonResponseVO sendWebServiceApprovalType3(ApprovalCommonRequestVO approvalCommonRequest){
        ApprovalCommonResponseVO approvalCommonResponseVO = null;
        try {
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.APPROVAL_LIST);
            approvalCommonResponseVO = (ApprovalCommonResponseVO) webService.execute(approvalCommonRequest);
        } catch (Exception e) {
            throw new BusinessException("통합결재 Type3 WebService 결재 호출 실패", StatusCodeConstants.FAIL);
        }

        return approvalCommonResponseVO;
    }

    private void updateApprovalRequestMasterAndLineToRequest(String aprReqId, String aprId){
        int approvalRequestUpdateCnt = approvalRequestService.updateApprovalRequestMasterToRequest(aprReqId, aprId);
        int approvalLineUpdateCnt = approvalLineService.updateApprovalLineToRequest(aprReqId);

        if(approvalRequestUpdateCnt == 0 || approvalLineUpdateCnt == 0 ) {
            ApprovalCommonResponseVO cancelResult = this.sendType3Delete(aprReqId);
            throw new BusinessException("Type3 결재정보 오류-결재요청기본, 결재라인기본 확인 바랍니다. 결재취소 결과 : "
                    + cancelResult.getIfStatus(), StatusCodeConstants.FAIL);
        }
    }

    private void doSelfApprovalProcess(ApprovalRequestIdRequestVO approvalRequestId){
        // 자가승인이면 결재요청마스터의 결재진행상태를 진행중으로 바꾸고 최종 승인여부판단
        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.IN_PROGRESS);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);
        approvalLineService.updateApprovalLineToSelfApproved(approvalRequestId);

        // 최종 승인여부 판단
        boolean isSuccess = this.updateType3CheckLastApproval(approvalRequestId);
        if(!isSuccess) {
            throw new BusinessException("통합결재 Type3 WebService 결재요청 호출 실패 - 자가승인 처리", StatusCodeConstants.FAIL);
        }
    }

    private boolean updateType3CheckLastApproval(ApprovalRequestIdRequestVO approvalRequestId) {
        boolean isRejected =  approvalLineService.isApprovalLineRejected(approvalRequestId.getAprReqId());
        if( isRejected ) {
            return this.doRejectProcess(approvalRequestId);
        }

        boolean isAllApproved = approvalLineService.isApprovalLineAllApproved(approvalRequestId.getAprReqId());
        ApprovalLineResponseVO lastApprovalLine =
                approvalLineService.getLastApprovalLineStatus(approvalRequestId.getAprReqId());
        if( isAllApproved && lastApprovalLine.isApproved()) {
            approvalRequestId.setAprLnSeq(lastApprovalLine.getAprLnSeq());
            return this.doCompleteProcess(approvalRequestId);
        }

        return this.doInProgressProcess(approvalRequestId);
    }

    private boolean doRejectProcess(ApprovalRequestIdRequestVO approvalRequestId){

        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.REJECT);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);
        approvalLineService.updateApprovalLineAfterReject(approvalRequestId);

        afterApprovalService.afterApprovalProcess(approvalRequestId);

        ApprovalCommonResponseVO rejectResult = this.sendType3Approve(approvalRequestId);
        if(rejectResult.hasFailed()){
            return false;
        }

        this.sendRejectMail(approvalRequestId.getAprReqId(), approvalRequestId.getAprLnSeq());

        return  true;
    }

    private boolean doCompleteProcess(ApprovalRequestIdRequestVO approvalRequestId){

        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.COMPLETE);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);
        approvalLineService.updateApprovalLineToComplete(approvalRequestId);

        afterApprovalService.afterApprovalProcess(approvalRequestId);

        ApprovalCommonResponseVO apvResult = this.sendType3Approve(approvalRequestId);
        if(apvResult.hasFailed()){
            return false;
        }

        this.sendApprovedMail(approvalRequestId.getAprReqId(), approvalRequestId.getAprLnSeq());
        this.sendNoticeMail(approvalRequestId.getAprReqId(), approvalRequestId.getAprLnSeq());

        return true;
    }

    private boolean doInProgressProcess(ApprovalRequestIdRequestVO approvalRequestId){
        // 최종승인이 아니면 대기중인 모든 결재라인에 대해 위임 처리
        approvalLineService.updateApprovalLineDelegate(approvalRequestId.getAprReqId());

        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.IN_PROGRESS);
        ApprovalCommonResponseVO inpResult = this.sendType3Approve(approvalRequestId);
        if(inpResult.hasFailed()){
            return false;
        }

        this.sendRequestMail(approvalRequestId.getAprReqId(), approvalRequestId.getAprLnSeq());

        return true;
    }

    private ApprovalCommonResponseVO sendType3Approve(ApprovalRequestIdRequestVO approvalRequestId) {

        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMaster(approvalRequestId);

        this.checkValidation(approvalRequestMaster);

        if(approvalRequestId.isStatusComplete() || approvalRequestId.isStatusReject()) {
            approvalRequestMaster.setNextApprType(null);
            approvalRequestMaster.setNextApprover(null);
        }

        ApprovalCommonRequestVO approvalCommonRequestVO = ApprovalCommonRequestVO.ofType3Approve(approvalRequestMaster);

        return this.sendWebServiceApprovalType3(approvalCommonRequestVO);
    }

    @Override
    public ApprovalCommonResponseVO sendType3Delete(String aprReqId) {
        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMaster(ApprovalRequestIdRequestVO.of(aprReqId));

        this.checkValidation(approvalRequestMaster);

        ApprovalCommonRequestVO approvalCommonRequestVO =
                ApprovalCommonRequestVO.ofType3DeleteRequest(approvalRequestMaster);

        return this.sendWebServiceApprovalType3(approvalCommonRequestVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String updateType3ApprovalProgress(ApprovalLineRequestVO approvalLine) {

        this.checkValidToUpdateApproval(approvalLine);

        ApprovalRequestIdRequestVO approvalRequestId = ApprovalRequestIdRequestVO.of(approvalLine.getAprReqId(),
                ApprovalRequestProgressStatus.IN_PROGRESS, approvalLine.getAprLnSeq());
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);
        approvalLineService.updateApprovalLineToApprove(approvalLine);

        boolean isSuccess = this.updateType3CheckLastApproval(approvalRequestId);
        if(!isSuccess) {
            throw new BusinessException("통합결재 Type3 WebService 결재요청 호출 실패 - 라인별 승인 처리",
                    StatusCodeConstants.FAIL);
        }

        return "Y";
    }

    private void checkValidToUpdateApproval(ApprovalLineRequestVO approvalLine){
        ApprovalLineCheckResponseVO approvalLineCheck = approvalLineService.getApprovalLineAvailableCheck(approvalLine);
        if (!approvalLineCheck.isApprover()) {
            throw new BusinessException("결재 권한이 없습니다.", StatusCodeConstants.EXPECTATION_FAILED);
        }

        if (!approvalLineCheck.isWaitStatus()) {
            throw new BusinessException("이미 결재 처리 된 결재라인입니다.", StatusCodeConstants.EXPECTATION_FAILED);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String updateType3ApprovalCancel(ApprovalRequestIdRequestVO approvalRequestId) {

        this.checkValidToCancelApproval(approvalRequestId.getAprReqId());

        approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.CANCEL);
        approvalRequestService.updateApprovalRequestMasterStatus(approvalRequestId);
        approvalLineService.updateApprovalLineToCancel(approvalRequestId);

        afterApprovalService.afterApprovalProcess(approvalRequestId);

        ApprovalCommonResponseVO approvalCommonResponse = this.sendType3Delete(approvalRequestId.getAprReqId());
        if(approvalCommonResponse == null) { return "N:통신실패"; }
        else if(!approvalCommonResponse.hasSucceed()){
            return approvalCommonResponse.getIfStatus() + ":" + approvalCommonResponse.getIfErrMsg();
        }

        return "Y";
    }

    private void checkValidToCancelApproval(String aprReqId){
        boolean isCancelAvailable = approvalRequestService.getCancelAvailableCheck(aprReqId);
        if (!isCancelAvailable) {
            throw new BusinessException("결재 취소 권한이 없습니다.", StatusCodeConstants.EXPECTATION_FAILED);
        }
    }

    @Override
    public ApprovalCommonResponseVO sendType3DeleteLine(String aprReqId, String allDeleteYn, String deleteUserEmpNo) {
        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMaster(ApprovalRequestIdRequestVO.of(aprReqId));

        this.checkValidation(approvalRequestMaster);

        ApprovalCommonRequestVO approvalCommonRequestVO =
                ApprovalCommonRequestVO.ofType3DeleteLine(approvalRequestMaster, allDeleteYn, deleteUserEmpNo);

        return this.sendWebServiceApprovalType3(approvalCommonRequestVO);
    }

    @Override
    public ApprovalCommonResponseVO sendType3AddLine(String aprReqId, String addApprType, String addApproverEmpNo,
                                                     String addApproverUrl) {
        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMaster(ApprovalRequestIdRequestVO.of(aprReqId));

        this.checkValidation(approvalRequestMaster);

        ApprovalCommonRequestVO approvalCommonRequestVO = ApprovalCommonRequestVO.ofType3AddLine(approvalRequestMaster,
                addApprType, addApproverEmpNo, addApproverUrl);

        return this.sendWebServiceApprovalType3(approvalCommonRequestVO);
    }

    @Override
    public ApprovalCommonResponseVO sendType3UpdateApprPeriod(String aprReqId, String aprPvnDdlnCd) {
        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMaster(ApprovalRequestIdRequestVO.of(aprReqId));

        this.checkValidation(approvalRequestMaster);

        ApprovalCommonRequestVO approvalCommonRequestVO =
                ApprovalCommonRequestVO.ofType3UpdatePeriod(approvalRequestMaster, aprPvnDdlnCd);

        return this.sendWebServiceApprovalType3(approvalCommonRequestVO);
    }

    @Override
    public ApprovalCommonResponseVO sendType3UpdateLineUseUserId(String aprReqId, String targetUserId,
                                                                 String chgApprType, String chgApproverUserId,
                                                                 String chgApproverUrl) {

        String targetEmpNo = employeeService.findUserIdToEmpNo(targetUserId);
        String chgApproverEmpNo = employeeService.findUserIdToEmpNo(chgApproverUserId);

        if(ValidateUtil.isEmpty(targetEmpNo))
            throw new BusinessException("변경 대상 결재자 정보가 없습니다. ID ���인 바랍니다.", StatusCodeConstants.FAIL);
        if(ValidateUtil.isEmpty(chgApproverEmpNo))
            throw new BusinessException("변경할 결재자 정보가 없습니다. ID 확인 바랍니다.", StatusCodeConstants.FAIL);

        return this.sendType3UpdateLine(aprReqId, targetEmpNo, chgApprType, chgApproverEmpNo, chgApproverUrl);
    }

    @Override
    public ApprovalCommonResponseVO sendType3UpdateLine(String aprReqId, String targetEmpNo,
                                                        String chgApprType, String chgApproverEmpNo,
                                                        String chgApproverUrl) {
        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMaster(ApprovalRequestIdRequestVO.of(aprReqId));

        this.checkValidation(approvalRequestMaster);

        ApprovalCommonRequestVO approvalCommonRequestVO =
                ApprovalCommonRequestVO.ofType3UpdateLine(approvalRequestMaster, targetEmpNo, chgApprType,
                        chgApproverEmpNo, chgApproverUrl);

        return this.sendWebServiceApprovalType3(approvalCommonRequestVO);
    }

    @Override
    public ApprovalCommonResponseVO sendType3DeleteLineUseUserId(String aprReqId, String allDeleteYn,
                                                                 String deleteUserId) {

        String deleteUserEmpNo = employeeService.findUserIdToEmpNo(deleteUserId);

        if(!"Y".equals(allDeleteYn) && ValidateUtil.isEmpty(deleteUserEmpNo))
            throw new BusinessException("삭제 대상 결재자 정보가 없습니다. ID 확인 바랍니다.", StatusCodeConstants.FAIL);

        return this.sendType3DeleteLine(aprReqId, allDeleteYn, deleteUserEmpNo);
    }

    @Override
    public ApprovalCommonResponseVO sendType3AddLineUseUserId(String aprReqId, String addApprType,
                                                              String addApproverUserId, String addApproverUrl) {
        String addApproverEmpNo = employeeService.findUserIdToEmpNo(addApproverUserId);

        if(ValidateUtil.isEmpty(addApproverEmpNo))
            throw new BusinessException("추가할 결재자 정보가 없습니다. ID 확인 바랍니다.", StatusCodeConstants.FAIL);

        return this.sendType3AddLine(aprReqId, addApprType, addApproverEmpNo, addApproverUrl);
    }

    private void sendRequestMail(String aprReqId, long aprLnSeq){
        ApprovalType3MailSendRequestVO approvalType3MailSendRequest =
                ApprovalType3MailSendRequestVO.of(aprReqId, aprLnSeq);
        approvalType3EmailService.sendRequestMail(approvalType3MailSendRequest);
    }

    private void sendApprovedMail(String aprReqId, long aprLnSeq){
        ApprovalType3MailSendRequestVO approvalType3MailSendRequest =
                ApprovalType3MailSendRequestVO.of(aprReqId, aprLnSeq);
        approvalType3EmailService.sendApprovedMail(approvalType3MailSendRequest);
    }

    private void sendNoticeMail(String aprReqId, long aprLnSeq){
        ApprovalType3MailSendRequestVO approvalType3MailSendRequest =
                ApprovalType3MailSendRequestVO.of(aprReqId, aprLnSeq);
        approvalType3EmailService.sendNoticeMail(approvalType3MailSendRequest);
    }

    private void sendRejectMail(String aprReqId, long aprLnSeq){
        ApprovalType3MailSendRequestVO approvalType3MailSendRequest =
                ApprovalType3MailSendRequestVO.of(aprReqId, aprLnSeq);
        approvalType3EmailService.sendRejectMail(approvalType3MailSendRequest);
    }
}