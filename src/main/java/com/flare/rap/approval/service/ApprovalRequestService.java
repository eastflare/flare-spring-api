package com.flare.rap.approval.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.*;
import com.flare.rap.approval.model.ApprovalCommonResponseVO;
import com.flare.rap.session.model.UserSessionVO;

public interface ApprovalRequestService {

    /**
     * createApprovalRequestAndLine
     *   => Type2,3 공용 결재요청 Master와 결재라인을 동시에 생성
     *   Return : 생성된 APR_REQ_ID
     */
    String createApprovalRequestAndLine(ApprovalRequestVO approvalRequest);

    /**
     * createReApprovalRequestAndLine
     *   => Type2,3 공용 : 기 결재데이터를 복사하여, 신규 결재가 가능하도록 결재요청마스터와 결재라인을 생성
     *   Return : 생성된 APR_REQ_ID
     */
    String createReApprovalRequestAndLine(String aprReqId);

    int updateApprovalRequestMasterToRequest(String aprReqId, String apprId);

    ApprovalRequestMasterResponseVO getApprovalRequestMasterForRequest(ApprovalRequestIdRequestVO approvalRequestId);

    ApprovalRequestMasterResponseVO getApprovalRequestMaster(ApprovalRequestIdRequestVO approvalRequestId);

    boolean getCancelAvailableCheck(String aprReqId);

    int updateApprovalRequestMasterStatus(ApprovalRequestIdRequestVO approvalRequestId);

    boolean isSelfApprovalAvailable(String aprReqId);

    ApprovalLineRequestVO getWaitApprovalLineByUserId(ApprovalRequestIdRequestVO approvalRequestIdRequestVO);

    ApprovalLineRequestVO getApprovalLineMasterWithSeq(ApprovalRequestIdRequestVO approvalRequestIdRequestVO);

    List<ApprovalMobileFilesVO> getApprovalFilesForMobile(ApprovalRequestIdRequestVO approvalRequestIdRequestVO);
}