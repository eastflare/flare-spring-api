package com.flare.rap.approval.model;

import com.flare.rap.approval.constant.ApprovalApiType;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.webservice.model.WebServiceRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalCommonRequestVO implements WebServiceRequest {

    @Schema(description = "API유형", example = "A02")
    private String apiType;
    @Schema(description = "Legacy시스템ID", example = "")
    private String systemId;
    @Schema(description = "양식ID", example = "")
    private String formId;
    @Schema(description = "결재문서제목", example = "")
    private String apprTitle;
    @Schema(description = "요청자(기안자)사번", example = "")
    private String reqUser;
    @Schema(description = "업무Key01", example = "")
    private String appkey01;
    @Schema(description = "업무Key02", example = "")
    private String appkey02;
    @Schema(description = "업무Key03", example = "")
    private String appkey03;
    @Schema(description = "업무Key04", example = "")
    private String appkey04;
    @Schema(description = "업무Key05", example = "")
    private String appkey05;
    @Schema(description = "본문내용(모바일 연동ㅇ르 하는경우 본문내용 사용", example = "")
    private String formEditorData;
    @Schema(description = "모바일본문내용", example = "")
    private String formMobileData;
    @Schema(description = "문서종류", example = "(비밀문서:1,일반문서:0)")
    private String apprSecurityType;
    @Schema(description = "업무화면 url정보", example = "")
    private String appUrl;
    @Schema(description = "결재대기화면 url정보(승인화면과 요청/완료화면이 다른경우 사용)", example = "")
    private String appWaitUrl;
    @Schema(description = "업무화면 모바일 url 정보", example = "")
    private String appMobileUrl;
    @Schema(description = "결재문서 식별번호", example = "")
    private String apprDocNo;
    @Schema(description = "진행상태", example = "(1:승인,2:반려,5:찬성,6:반대)")
    private String apprStatus;
    @Schema(description = "결재의견", example = "")
    private String apprMessage;
    @Schema(description = "기존 결재선 전체삭제여부", example = "Y:기존 결재선 전체삭제,N:1명만삭제")
    private String isAllDelete;
    @Schema(description = "변경할 사용자 ID,IS_ALL_DELETE=N인 경우에 필수", example = "")
    private String deleteUser;
    @Schema(description = "첫번째 결재자 url", example = "")
    private String nextApproverUrl;
    @Schema(description = "협의유형", example = "(0:순차협의,1:병렬협의)")
    private String apprLineType;
    @Schema(description = "보존영한코드값", example = "APPRCODE_1M")
    private String apprPeriodCd;
    @Schema(description = "첨부파일명", example = "")
    private String fileLinkName;
    @Schema(description = "첨부파일 링크 url", example = "")
    private String fileLinkUrl;
    @Schema(description = "첨부파일 크기", example = "")
    private String fileSize;
    @Schema(description = "첫번째 결재 타입", example = "(0:결재,1협의(필수),2협의(선택))")
    private String nextApprType;
    @Schema(description = "첫번째 결재자 사번", example = "")
    private String nextApprover;
    @Schema(description = "통보자 사번", example = "")
    private String readUser;
    @Schema(description = "공개 부서코드", example = "")
    private String readDept;
    @Schema(description = "연동양식 layout을 사용할 경우 data만 연동하여 본문 생성 처리", example = "")
    private String formData;
    @Schema(description = "결재 시스템 내부 키인 APPR_ID반환 여부", example = "(yes=1,no=0)")
    private String isReturnApprId;
    @Schema(description = "요약보기 내용", example = "")
    private String summaryData;


    public static ApprovalCommonRequestVO ofType2Request(ApprovalRequestMasterResponseVO approvalRequestMaster,
                                                         String formMobileData){
        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId()); // CSR을 통해 전자결재에서 생성해준 양식 ID값 - 필수
        approvalCommonRequestVO.setApprTitle(approvalRequestMaster.getAprReqTitNm()); // 필수
        approvalCommonRequestVO.setReqUser(approvalRequestMaster.getAprReqEmpNo()); // 필수
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId()); // 필수 - 레거시시스템 결재문서번호
        approvalCommonRequestVO.setFormEditorData(approvalRequestMaster.getTrnmBdyCtn()); // 결재문서 본문 내용 html 형식
        approvalCommonRequestVO.setFormMobileData(formMobileData);
        approvalCommonRequestVO.setApprSecurityType("0");  // 필수
        approvalCommonRequestVO.setApprLineType(approvalRequestMaster.getApprLineType());
        approvalCommonRequestVO.setApprPeriodCd(approvalRequestMaster.getAprPvnDdlnCd());
        approvalCommonRequestVO.setFileLinkName(approvalRequestMaster.getFileLinkName());
        approvalCommonRequestVO.setFileLinkUrl(approvalRequestMaster.getFileLinkUrl());
        approvalCommonRequestVO.setFileSize(approvalRequestMaster.getFileSize());
        approvalCommonRequestVO.setNextApprType(approvalRequestMaster.getNextApprType()); // 필수
        approvalCommonRequestVO.setNextApprover(approvalRequestMaster.getNextApprover()); // 필수
        approvalCommonRequestVO.setReadUser(approvalRequestMaster.getReadUser());
        approvalCommonRequestVO.setIsReturnApprId("1");

        return approvalCommonRequestVO;
    }

    public static ApprovalCommonRequestVO ofType3Request(ApprovalRequestMasterResponseVO approvalRequestMaster,
                                                         String formEditorData){
        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setApiType(ApprovalApiType.REQUEST);
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId());
        approvalCommonRequestVO.setApprTitle(approvalRequestMaster.getAprReqTitNm());
        approvalCommonRequestVO.setReqUser(approvalRequestMaster.getAprReqEmpNo());
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId());
        approvalCommonRequestVO.setFormEditorData(formEditorData);
        approvalCommonRequestVO.setApprSecurityType("0");
        approvalCommonRequestVO.setApprPeriodCd(approvalRequestMaster.getAprPvnDdlnCd());
        approvalCommonRequestVO.setAppUrl(approvalRequestMaster.getWktScrnUrl());
        approvalCommonRequestVO.setAppWaitUrl(approvalRequestMaster.getAprWaitScrnUrl());
        approvalCommonRequestVO.setAppMobileUrl(approvalRequestMaster.getMbilWktScrnUrl());
        approvalCommonRequestVO.setNextApprType(approvalRequestMaster.getNextApprType());
        approvalCommonRequestVO.setNextApprover(approvalRequestMaster.getNextApprover());
        approvalCommonRequestVO.setReadUser(approvalRequestMaster.getReadUser());
        approvalCommonRequestVO.setIsReturnApprId("1");

        return approvalCommonRequestVO;
    }

    public static ApprovalCommonRequestVO ofType3Approve(ApprovalRequestMasterResponseVO approvalRequestMaster){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setApiType(ApprovalApiType.APPROVE); // ���재상태처리 - 필수
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId()); // CSR을 통해 전자결재에서 생성해준 양식 ID값 - 필수
        approvalCommonRequestVO.setReqUser(userSession.getEmpNo()); // 필수 - 지금 결재한 사람 사번
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId()); // 필수 - 레거시시스템 결재문서번호
        approvalCommonRequestVO.setApprStatus(approvalRequestMaster.getApprStatus());
        approvalCommonRequestVO.setApprMessage(approvalRequestMaster.getAprAprvOpinUtf8Ctn());
        approvalCommonRequestVO.setNextApprType(approvalRequestMaster.getNextApprType()); // 다음 결재할 타입  - 필수
        approvalCommonRequestVO.setNextApprover(approvalRequestMaster.getNextApprover()); // 다음 결재할 사람 사번  - 필수

        return approvalCommonRequestVO;
    }

    public static ApprovalCommonRequestVO ofType3UpdateLine(ApprovalRequestMasterResponseVO approvalRequestMaster,
                                                            String deleteUser, String nextApprType,
                                                            String nextApprover, String nextApproverUrl){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setApiType(ApprovalApiType.UPDATE_LINE); // 결재상태처리 - 결재선 수정
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId()); // CSR을 통해 전자결재에서 생성해준 양식 ID값 - 필수
        approvalCommonRequestVO.setReqUser(userSession.getEmpNo()); // 필수 - 변경 요청자 사번
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId()); // 필수 - 레거시시스템 결재문서번호
        approvalCommonRequestVO.setIsAllDelete("N"); // 기존 결재선에서 1명만 삭제
        approvalCommonRequestVO.setDeleteUser(deleteUser); // 변경할 사용자 사번  IS_ALL_DELETE=N 인 경우에 필수
        approvalCommonRequestVO.setNextApprType(nextApprType); // 변경할 결재 타입  - 필수 (0:결재, 1:협의(필수), 2:협의(선택), 6:합의)
        approvalCommonRequestVO.setNextApprover(nextApprover); // 변경할 결재자 사번  - 필수 (단일 사용자만 허용)
        approvalCommonRequestVO.setNextApproverUrl(nextApproverUrl); // 변경할 결재자 URL (결재자 URL이 변경될 경우 사용)

        return approvalCommonRequestVO;
    }

    public static ApprovalCommonRequestVO ofType3DeleteLine(ApprovalRequestMasterResponseVO approvalRequestMaster,
                                                            String isAllDeleteYn, String deleteUserEmpNo){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setApiType(ApprovalApiType.DELETE_LINE); // 결재상태처리 - 결재선 삭제
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId()); // CSR을 통해 전자결재에서 생성해준 양식 ID값 - 필수
        approvalCommonRequestVO.setReqUser(userSession.getEmpNo()); // 필수 - 삭제요청자 사번
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId()); // 필수 - 레거시시스템 결재문서번호
        approvalCommonRequestVO.setIsAllDelete(isAllDeleteYn); // Y 면 모든 결재선 삭제, N 이면 기존 결재선에서 1명만 삭제
        approvalCommonRequestVO.setDeleteUser(deleteUserEmpNo); // allDeleteYn 이 N 이면 1명을 지정해야 하는데 여기에 지정.

        return approvalCommonRequestVO;
    }

    public static ApprovalCommonRequestVO ofType3AddLine(ApprovalRequestMasterResponseVO approvalRequestMaster,
                                                         String nextApprType, String nextApprover,
                                                         String nextApproverUrl){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setApiType(ApprovalApiType.ADD_LINE); // 결재상태처리 - 결재선 추가
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId()); // CSR을 통해 전자결재에서 생성해준 양식 ID값 - 필수
        approvalCommonRequestVO.setReqUser(userSession.getEmpNo()); // 필수 - 추가요청자 사번
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId()); // 필수 - 레거시시스템 결재문서번호
        approvalCommonRequestVO.setNextApprType(nextApprType); // 추가할 결재 타입  - 필수
        approvalCommonRequestVO.setNextApprover(nextApprover); // 추가할 결재자 사번  - 필수
        approvalCommonRequestVO.setNextApproverUrl(nextApproverUrl); // 추가할 결재자 URL (결재자 URL이 변경될 경우 사용)

        return approvalCommonRequestVO;
    }

    public static ApprovalCommonRequestVO ofType3DeleteRequest(ApprovalRequestMasterResponseVO approvalRequestMaster){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setApiType(ApprovalApiType.DELETE_REQUEST); // 요청취소(상신취소, 기안취소) - 필수
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId()); // CSR을 통해 전자결재에서 생성해준 양식 ID값 - 필수
        approvalCommonRequestVO.setReqUser(userSession.getEmpNo()); // 필수 - 지금 결재한 사람 사번
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId()); // 필수 - 레거시시스템 결재문서번호
        approvalCommonRequestVO.setApprMessage("결재취소 " + approvalRequestMaster.getAprAprvUserId());

        return approvalCommonRequestVO;
    }

    public static ApprovalCommonRequestVO ofType3UpdatePeriod(ApprovalRequestMasterResponseVO approvalRequestMaster,
                                                              String apprPeriodCd){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalCommonRequestVO approvalCommonRequestVO = new ApprovalCommonRequestVO();
        approvalCommonRequestVO.setApiType(ApprovalApiType.UPDATE_PERIOD); // 보존년한 수정 - 필수
        approvalCommonRequestVO.setFormId(approvalRequestMaster.getEaprTplId()); // CSR을 통해 전자결재에서 생성해준 양식 ID값 - 필수
        approvalCommonRequestVO.setReqUser(userSession.getEmpNo()); // 필수 - 지금 결재한 사람 사번
        approvalCommonRequestVO.setAppkey01(approvalRequestMaster.getAprReqId()); // 필수 - 레거시시스템 결재문서번호
        approvalCommonRequestVO.setApprPeriodCd(apprPeriodCd);

        return approvalCommonRequestVO;
    }

}