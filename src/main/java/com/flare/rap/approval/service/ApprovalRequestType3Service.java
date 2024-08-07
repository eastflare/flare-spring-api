package com.flare.rap.approval.service;

import com.flare.rap.approval.model.ApprovalCommonResponseVO;
import com.flare.rap.approval.model.ApprovalLineRequestVO;
import com.flare.rap.approval.model.ApprovalRequestIdRequestVO;

public interface ApprovalRequestType3Service {

    /**
     * sendType3ApprovalRequestProcess
     *   => Type3 결재문서에 대한 기안(최초결재요청) 처리, 호출이 성공되면 TB_SPDM_APR_REQ_M에 전자결재문서번호(EAPR_DOC_NO)가 Update됨
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S, ifErrMsg : 최초요청(기안) 일 경우에 한해 전자결재문서번호가 리턴됨
     *                실패면  ifStatus : F
     */
    ApprovalCommonResponseVO sendType3ApprovalRequestProcess(ApprovalRequestIdRequestVO approvalRequestIdRequest);

    ApprovalCommonResponseVO sendType3Delete(String aprReqId);

    /**
     * updateType3ApprovalProgress
     *   => 전달된 결재번호, 결재라인에 대한 승인/부결/확정 Update 후
     *      최종승인을 확인(updateType3CheckLastApproval 호출)하여 통합결재 I/F를 하던지 다음 결재라인에 메일을 발송한다.
     *   Input : 결재요청ID, 결재라인순번, 승인자결재유형구분코드, 결재승인사용자ID, 결재처리상태코드, 결재승인의견UTF8내용
     *   Return : 최종승인이면 : Y
     *            최종승인이 아니면 : N
     */
    String updateType3ApprovalProgress(ApprovalLineRequestVO approvalLine);

    /**
     * updateType3ApprovalCancel
     *   => 전달된 결재번호에 대해서 결재 취소 처리함.
     *   결재요청기본 Update, 결재라인 Update, 통합결재 I/F
     * !!! 중요 : 세션의 user 와 기안자의 user가 같아야 합니다.
     *   Return : 취소 성공 : Y
     *            실패 : N:실패사유
     */
    String updateType3ApprovalCancel(ApprovalRequestIdRequestVO approvalRequestId);


    /**
     * sendType3DeleteLine
     *   => Type3 결재라인 삭제 통합결재로 I/F 함 ( I/F 만 처리 )
     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.
     * @Param aprReqId : 변경할 레거시 결재문서 번호
     * @Param allDeleteYn : 결재라인 전부 삭제할지 여부
     * @Param deleteUserEmpNo : 삭제할 결재자 사번 ( allDeleteYn='N' 일경우 필수 )
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S
     *                실패면  ifStatus : F, ifErrMsg
     */
    ApprovalCommonResponseVO sendType3DeleteLine(String aprReqId, String allDeleteYn, String deleteUserEmpNo);

    /**
     * sendType3AddLine
     *   => Type3 결재라인 추가 통합결재로 I/F 함 ( I/F 만 처리 )
     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.
     * @Param aprReqId : 변경할 레거시 결재문서 번호
     * @Param addApprType : 추가할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..
     * @Param addApproverEmpNo : 추가할 결재자 사번
     * @Param addApproverUrl : 추가 결재자가 볼 화면
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S
     *                실패면  ifStatus : F, ifErrMsg
     */
    ApprovalCommonResponseVO sendType3AddLine(String aprReqId, String addApprType, String addApproverEmpNo,
                                              String addApproverUrl);

    /**
     * sendType3UpdateApprPeriod
     *   => Type3 결재문서 보전년한 수정 통합결재로 I/F 함 ( I/F 만 처리 )
     *   !!! 중요 : 결재요청기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재요청기본 데이터는 별도 처리해야 합니다.
     * @Param aprReqId 변경할 레거시 결재문서 번호
     * @Param aprPvnDdlnCd 결재보존기한코드 APPRCODE_1M, APPRCODE_1Y, APPRCODE_3Y, APPRCODE_5Y, APPRCODE_10Y, APPRCODE_100Y
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S
     *                실패면  ifStatus : F, ifErrMsg
     */
    ApprovalCommonResponseVO sendType3UpdateApprPeriod(String aprReqId, String aprPvnDdlnCd);

    /**
     * sendType3UpdateLineUseUserId
     *   => Type3 결재라인 Update 통합결재로 I/F 함 ( I/F 만 처리 ) -- EmpNo 대신 UserId를 사용
     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.
     * @Param aprReqId : 변경할 레거시 결재문서 번호
     * @Param targetUserId : 변경대상 결재라인의  UserId
     * @Param chgApprType : 변경할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..
     * @Param chgApproverUserId : 변경할 결재자 UserId
     * @Param chgApproverUrl : 만약 결재자에 따라 결재할 화면이 다르다면 여기에 담아서 전송.
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S
     *                실패면  ifStatus : F, ifErrMsg
     */
    ApprovalCommonResponseVO sendType3UpdateLineUseUserId(String aprReqId, String targetUserId,
                                                          String chgApprType, String chgApproverUserId,
                                                          String chgApproverUrl);

    /**
     * sendType3UpdateLineUseUserId
     *   => Type3 결재라인 Update 통합결재로 I/F 함 ( I/F 만 처리 ) -- EmpNo 대신 UserId를 사용
     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.
     * @Param aprReqId : 변경할 레거시 결재문서 번호
     * @Param targetUserId : 변경대상 결재라인의  UserId
     * @Param chgApprType : 변경할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..
     * @Param chgApproverUserId : 변경할 결재자 UserId
     * @Param chgApproverUrl : 만약 결재자에 따라 결재할 화면이 다르다면 여기에 담아서 전송.
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S
     *                실패면  ifStatus : F, ifErrMsg
     */
    ApprovalCommonResponseVO sendType3UpdateLine(String aprReqId, String targetEmpNo, String chgApprType,
                                                 String chgApproverEmpNo, String chgApproverUrl);

    /**
     * sendType3DeleteLineUseUserId
     *   => Type3 결재라인 삭제 통합결재로 I/F 함 ( I/F 만 처리 ) -- EmpNo 대신 UserId를 사용
     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.
     * @Param aprReqId : 변경할 레거시 결재문서 번호
     * @Param allDeleteYn : 결재라인 전부 삭제할지 여부
     * @Param deleteUserId : 삭제할 결재자 ID ( allDeleteYn='N' 일경우 필수 )
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S
     *                실패면  ifStatus : F, ifErrMsg
     */
    ApprovalCommonResponseVO sendType3DeleteLineUseUserId(String aprReqId, String allDeleteYn,
                                                          String deleteUserId);

    /**
     * sendType3AddLine
     *   => Type3 결재라인 추가 통합결재로 I/F 함 ( I/F 만 처리 ) -- EmpNo 대신 UserId를 사용
     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.
     * @Param aprReqId : 변경할 레거시 결재문서 번호
     * @Param addApprType : 추가할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, ��의..
     * @Param addApproverUserId : 추가할 결재자  UserId
     * @Param addApproverUrl : 추가 결재자가 볼 화면
     *   Return : 통합결재 호출 결과,
     *                성공이면 ifStatus : S
     *                실패면  ifStatus : F, ifErrMsg
     */
    ApprovalCommonResponseVO sendType3AddLineUseUserId(String aprReqId, String addApprType, String addApproverUserId,
                                                       String addApproverUrl);
}