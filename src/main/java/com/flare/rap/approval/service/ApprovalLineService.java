package com.flare.rap.approval.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.*;
import com.flare.rap.session.model.UserSessionVO;

public interface ApprovalLineService {

    /**
     * createApprovalLineList
     *   => Type2,3 공용 기존 결재라인 삭제 후, 결재라인 insert, 결재순번, 결재차수는 자동 결정된다. 통보처 Insert 도 가능.
     *   Return : 생성된 결재라인 수 (통보처 포함)
     */
    int createApprovalLines(String aprReqId, List<ApprovalLineRequestVO> approvalLineRequestVOList);

    /**
     * createApprovalLineListByAprvCall
     *   => Type2의 SAP PI 연동 processApproval A02 변경된 전체 결재자, 통보자 정보 처리 호출에 대한 작업
     *   결재라인 삭제 후, 결재라인 insert, 결재순번, 결재차수는 자동 결정된다. 통보처 Insert
     *   사번으로 전송 되므로 Update 하는 과정이 필요함.
     *   파라미터로 전달되는 userSession은 Dummy 임 ( Web Service 호출이어서 세션이 없음. )
     *   Return : 생성된 결재라인 수 (통보처 포함)
     */
    int createApprovalLinesByAprvCall(String aprReqId,
                                      List<ApprovalLineRequestVO> approvalLineRequestVOList,
                                      UserSessionVO userSession);

    /**
     * updateApprovalLineDelegate
     *   => 대기중인 모든 결재라인에 대해 위임 결재자 적용 ( 미승인 결재라인의 위임기간이 종료되어도 원복되지 않음. )
     */
    int updateApprovalLineDelegate(String aprReqId);



    List<ApprovalLineRequestVO> getNewApprovalLineRequests(String aprReqId);

    int updateApprovalLineToRequest(String aprReqId);

    int updateApprovalLineToComplete(ApprovalRequestIdRequestVO approvalRequestId);

    int updateApprovalLineToSelfApproved(ApprovalRequestIdRequestVO approvalRequestId);

    int updateApprovalLineToApprove(ApprovalLineRequestVO approvalLineRequestVO);

    int updateApprovalLineToCancel(ApprovalRequestIdRequestVO approvalRequestId);

    int updateType2ApprovalLine(ApprovalLineType2UpdateRequestVO approvalLine);

    boolean isApprovalLineRejected(String aprReqId);

    boolean isApprovalLineAllApproved(String aprReqId);

    int updateApprovalLineAfterReject(ApprovalRequestIdRequestVO approvalRequestId);

    ApprovalLineResponseVO getLastApprovalLineStatus(String aprReqId);

    ApprovalLineCheckResponseVO getApprovalLineAvailableCheck(ApprovalLineRequestVO approvalLine);

    List<ApprovalMobileApproversVO> getApprovalLinesForMobile(ApprovalRequestIdRequestVO approvalRequestId);
}