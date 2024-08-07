package com.flare.rap.approval.model;

import java.util.Date;

import com.flare.rap.approval.constant.ApprovalRequestProgressStatus;
import com.flare.rap.approval.constant.IntegratedApprovalType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class

ApprovalRequestMasterResponseVO {

    @Schema(description = "결재요청ID", example = "REQ-DOC-6")
    private String aprReqId;
    @Schema(description = "결재양식ID, 레거시 자체 결제양식ID", example = "FORM-0001")
    private String aprTplId;
    @Schema(description = "통합결재유형코드, 기본 Type2", example = "TYPE2")
    private String intgAprTpCd;
    @Schema(description = "전자결재양식ID, CSR를 통해 통합결재에서 부여해준 양식ID", example = "BLWC-FORM-001")
    private String eaprTplId;
    @Schema(description = "전자결재문서번호", example = "XX")
    private String eaprDocNo;
    @Schema(description = "결재요청사용자ID", example = "tmdgus0324")
    private String aprReqUserId;
    @Schema(description = "결재요청사용자명", example = "김*현")
    private String aprReqUserNm;
    @Schema(description = "결재요청사용자부서명", example = "모바일사업부")
    private String aprReqUserDeptNm;
    @Schema(description = "결재요청자직위", example = "차장")
    private String aprReqUserJikwiNm;
    @Schema(description = "결재요청자 이메일", example = "mobile@hlds.co.kr")
    private String aprReqUserEmail;
    @Schema(description = "결재요청자사번", example = "FP021972")
    private String aprReqEmpNo;
    @Schema(description = "결재보존기한코드", example = "APPRCODE_3Y")
    private String aprPvnDdlnCd;
    @Schema(description = "부서코드", example = "XX")
    private String deptCd;
    @Schema(description = "부서명", example = "XX")
    private String deptNm;
    @Schema(description = "근무지역코드", example = "XX")
    private String onduRegnCd;
    @Schema(description = "근무지역명", example = "XX")
    private String onduRegnNm;
    @Schema(description = "결재요청제목명", example = "결재테스트 제목 1")
    private String aprReqTitNm;
    @Schema(description = "전송본문내용", example = "< span>결재요청드립니다.< /span>")
    private String trnmBdyCtn;
    @Schema(description = "결재요청설명", example = "결재바랍니다.")
    private String aprReqDesc;
    @Schema(description = "결재요청일시", example = "2023-05-17 07:42:13")
    private Date aprReqDtm;
    @Schema(description = "결재요청일시(모바일)", example = "20230517074213")
    private String aprReqDtmMobile;
    @Schema(description = "동의서동의여부", example = "Y")
    private String wcstCncYn;
    @Schema(description = "결재요청진행상태코드", example = "SAVE")
    private String aprReqProgStatCd;
    @Schema(description = "업무화면URL주소", example = "http://devsite.lgensol.com/approval/request/req-template/0031")
    private String wktScrnUrl;
    @Schema(description = "결재대기화면URL주소", example = "http://devsite.lgensol.com/approval/approve/appr-doc-000001")
    private String aprWaitScrnUrl;
    @Schema(description = "모바일업무화면URL주소", example = "http://m.lgensol.com/approval/request/req-template/0031")
    private String mbilWktScrnUrl;
    @Schema(description = "결재파일그룹ID", example = "ddbb226e-8491-452c-aa8f-4c8955e80ced")
    private String aprFileGrId;
    @Schema(description = "참조결재요청ID", example = "NULL")
    private String refAprReqId;
    @Schema(description = "데이터입력사용자ID", example = "testuser")
    private String dataInsUserId;
    @Schema(description = "데이터입력사용자IP주소", example = "0.0.0.0")
    private String dataInsUserIp;
    @Schema(description = "데이터입력일시", example = "2023-05-17 07:42:13")
    private String dataInsDtm;
    @Schema(description = "데이터수정사용자ID", example = "testuser")
    private String dataUpdUserId;
    @Schema(description = "데이터수정사용자IP주소", example = "0.0.0.0")
    private String dataUpdUserIp;
    @Schema(description = "데이터수정일시", example = "2023-05-17 07:42:13")
    private String dataUpdDtm;
    @Schema(description = "협의유형 (0:순차협의, 1:병렬협의)", example = "1")
    private String apprLineType;
    @Schema(description = "전체 또는 다음 결재선의 결재 타입", example = "0;1;0;0")
    private String nextApprType;
    @Schema(description = "전체 또는 다음 결재선의 결재자 사번, 구분자’;’", example = "00216355;FP014767")
    private String nextApprover;
    @Schema(description = "통보자 사번, 구분자’;’", example = "00216355;FP014767")
    private String readUser;
    @Schema(description = "첨부파일명, 구분자’;’", example = "화면목록.xlsx;화면목록_last.xlsx")
    private String fileLinkName;
    @Schema(description = "첨부파일 링크 URL, 구분자’;’", example = "http://10.94.13.121/v1/atchfiledownload/ddbb226e-8491-452c-aa8f-4c8955e80ced/ae2714e5-5d02-4d17-947a-a4f965a00b8e;http://10.94.13.121/v1/atchfiledownload/ddbb226e-8491-452c-aa8f-4c8955e80ced/ae2714e5-5d02-4d17-947a-a4f965a00b81")
    private String fileLinkUrl;
    @Schema(description = "첨부파일 크기(Byte 기준), 구분자 ‘;’", example = "40210;40677")
    private String fileSize;
    @Schema(description = "결재라인의 결재자ID", example = "testuser")
    private String aprAprvUserId;
    @Schema(description = "결재라인의 결재자사번", example = "00216355")
    private String aprAprvEmpNo;
    @Schema(description = "결재라인의 결재처리상태에 대한 통합결재 전송용 진행상태 코드", example = "1,2,5,6")
    private String apprStatus;
    @Schema(description = "결재라인의 결재의견", example = "승인합니다.")
    private String aprAprvOpinUtf8Ctn;
    @Schema(description = "결재라인의 승인자결재유형코드", example = "0,1,2")
    private String grnrAprTpDivsCd;
    @Schema(description = "결재라인의 병렬여부", example = "N")
    private String prlYn;
    @Schema(description = "옵션값내용1(사용:추가결재파일그룹ID)", example = "1dbb226e-8491-452c-aa8f-4c8955e80ced,2dbb226e-8491-452c-aa8f-4c8955e80ced")
    private String optValCtn1;
    @Schema(description = "옵션값내용2", example = "여분필드")
    private String optValCtn2;
    @Schema(description = "옵션값내용3", example = "여분필드")
    private String optValCtn3;
    @Schema(description = "옵션값내용4", example = "여분필드")
    private String optValCtn4;
    @Schema(description = "옵션값내용5", example = "여분필드")
    private String optValCtn5;

    public boolean isApprovalType2(){
        return IntegratedApprovalType.APPROVAL_TYPE2.equals(intgAprTpCd);
    }

    public boolean isApprovalType3(){
        return IntegratedApprovalType.APPROVAL_TYPE3.equals(intgAprTpCd);
    }


    public boolean isApprovalStatusTemporarySave(){
        return ApprovalRequestProgressStatus.TEMPORARY_SAVE.equals(aprReqProgStatCd);
    }

    public boolean isApprovalStatusRequest(){
        return ApprovalRequestProgressStatus.REQUEST.equals(aprReqProgStatCd);
    }

    public boolean isApprovalStatusCancel(){
        return ApprovalRequestProgressStatus.CANCEL.equals(aprReqProgStatCd);
    }

    public boolean isApprovalStatusReject(){
        return ApprovalRequestProgressStatus.REJECT.equals(aprReqProgStatCd);
    }

    public boolean isApprovalStatusInProgress(){
        return ApprovalRequestProgressStatus.IN_PROGRESS.equals(aprReqProgStatCd);
    }

    public boolean isApprovalStatusComplete(){
        return ApprovalRequestProgressStatus.COMPLETE.equals(aprReqProgStatCd);
    }
}