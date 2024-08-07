package com.flare.rap.approval.service;

import com.flare.rap.approval.model.ApprovalCommonResponseVO;
import com.flare.rap.approval.model.ApprovalRequestIdRequestVO;
import com.flare.rap.session.model.UserSessionVO;

public interface ApprovalRequestType2Service {

    /**
     * sendType2ApprovalRequest
     *   => Type2 결재문서에 대한 기안(최초결재요청) 처리, 호출이 성공되면 TB_SPDM_APR_REQ_M에 전자결재문서번호(EAPR_DOC_NO)가 Update됨
     *   Return : 통합결재 호출 결과,
     *            성공이면 ifStatus : S, ifErrMsg : 최초요청(기안) 일 경우에 한해 전자결재문서번호가 리턴
     *            실패면  ifStatus : F
     */
    ApprovalCommonResponseVO sendType2ApprovalRequest(ApprovalRequestIdRequestVO approvalRequestId);

    /**
     * updateType2CheckLastApproval
     *   => 마지막 승인인지 확인 후 최종승인된 건이면 최종승인 처리 ( 승인시 처리한 BizLogic 호출 포함 )
     *   !!! 중요 : 호출하기전 결재라인에 대해 상태 업데이트를 한 이후 호출해야 합니다.
     *    예) 2번재 결재라인을 승인 처리하는 경우 => 2번째 결재라인을 승인으로 Update 한 후 본 서비스 호출
     *   파라미터로 넘어가는 userSession은 Dummy 값이다. ( Web Service 호출이어서 세션이 없음. )
     *   ApprovalRequestIdRequestVO의 aprReqId 만 넘기면 됨.
     *   Return : 최종승인이면 : Y
     *            최종승인이 아니면 : N
     *            에러면 : E
     */
    String updateType2CheckLastApproval(ApprovalRequestIdRequestVO approvalRequestId);
}