package com.flare.rap.approval.model;

import java.util.Date;

import com.flare.rap.approval.constant.ApprovalRequestProgressStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalRequestMasterRequestVO {

    @Schema(description = "결재요청ID, NULL, 신규일때는 NULL")
    private String aprReqId;
    @NotBlank
    @Schema(description = "결재양식ID", example = "APR_FORM_002")
    private String aprTplId;
    @Schema(description = "전자결재문서번호, NULL, 최초요청(기안)하면 자동으로 채워짐.")
    private String eaprDocNo;
    @NotBlank
    @Schema(description = "결재요청사용자ID(기안자ID), 통합결재에서 인식하는 ID이어야 함.", example = "tmdgus0324")
    private String aprReqUserId;
    @NotBlank
    @Schema(description = "결재보존기한코드, APPRCODE_5Y, 기본값임. 화면에 없으면 APPRCODE_5Y로 지정", example = "APPRCODE_5Y")
    private String aprPvnDdlnCd;
    @Schema(description = "부서코드, NULL, 기안하면 저장됨. 기안 시점의 기안자 부서코드를 저장")
    private String deptCd;
    @Schema(description = "부서명, NULL, 기안하면 저장됨. 기안 시점의 기안자 부서명을 저장")
    private String deptNm;
    @Schema(description = "근무지역코드, NULL, 기안하면 저장됨. 기안 시점의 기안자 근무지역코드를 저장")
    private String onduRegnCd;
    @Schema(description = "근무지역명, NULL, 기안하면 저장됨. 기안 시점의 기안자 근무지역명을 저장")
    private String onduRegnNm;
    @NotBlank
    @Schema(description = "결재요청제목명", example = "결재테스트 제목 1")
    private String aprReqTitNm;
    @NotBlank
    @Schema(description = "전송본문내용", example = "< span>결재요청드립니다.< /span>")
    private String trnmBdyCtn;
    @Schema(description = "결재요청설명, 화면에서 입력받으면 입력", example = "결재바랍니다.")
    private String aprReqDesc;
    @Schema(description = "결재요청일시,NULL,기안하면 저장됨. ")
    private Date aprReqDtm;
    @Schema(description = "동의서동의여부, 화면에 동의서가 있으면 입력", example = "N")
    private String wcstCncYn;
    @Schema(description = "결재요청진행상태코드, TMP:임시저장, 결재진행중에 코드가 변경됨.", example = "TMP")
    private String aprReqProgStatCd;
    @Schema(description = "업무화면URL주소, Type3일때만 입력, 통합결재에서 보여줄 우리쪽 기안/결재진행 URL")
    private String wktScrnUrl;
    @Schema(description = "결재대기화면URL주소, Type3일때만 입력, 통합결재에서 보여줄 우리쪽 화면 URL-승인용화면이 별도로 있는 경우")
    private String aprWaitScrnUrl;
    @Schema(description = "모바일업무화면URL주소, Type3일때만 입력, 모바일전용화면이 있으면")
    private String mbilWktScrnUrl;
    @Schema(description = "결재파일그룹ID", example = "ddbb226e-8491-452c-aa8f-4c8955e80ced")
    private String aprFileGrId;
    @Schema(description = "참조결재요청ID", example = "NULL")
    private String refAprReqId;
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

    public static ApprovalRequestMasterRequestVO of(ApprovalRequestMasterResponseVO approvalRequestMasterResponseVO){
        return ApprovalRequestMasterRequestVO.builder()
                .aprTplId(approvalRequestMasterResponseVO.getAprTplId())
                .aprReqUserId(approvalRequestMasterResponseVO.getAprReqUserId())
                .aprPvnDdlnCd(approvalRequestMasterResponseVO.getAprPvnDdlnCd())
                .deptCd(approvalRequestMasterResponseVO.getDeptCd())
                .deptNm(approvalRequestMasterResponseVO.getDeptNm())
                .onduRegnCd(approvalRequestMasterResponseVO.getOnduRegnCd())
                .onduRegnNm(approvalRequestMasterResponseVO.getOnduRegnNm())
                .aprReqTitNm(approvalRequestMasterResponseVO.getAprReqTitNm())
                .trnmBdyCtn(approvalRequestMasterResponseVO.getTrnmBdyCtn())
                .wcstCncYn(approvalRequestMasterResponseVO.getWcstCncYn())
                .aprReqProgStatCd(ApprovalRequestProgressStatus.TEMPORARY_SAVE)
                .wktScrnUrl(approvalRequestMasterResponseVO.getWktScrnUrl())
                .aprWaitScrnUrl(approvalRequestMasterResponseVO.getAprWaitScrnUrl())
                .mbilWktScrnUrl(approvalRequestMasterResponseVO.getMbilWktScrnUrl())
                .aprFileGrId(approvalRequestMasterResponseVO.getAprFileGrId())
                .refAprReqId(approvalRequestMasterResponseVO.getRefAprReqId())
                .optValCtn1(approvalRequestMasterResponseVO.getOptValCtn1())
                .optValCtn2(approvalRequestMasterResponseVO.getOptValCtn2())
                .optValCtn3(approvalRequestMasterResponseVO.getOptValCtn3())
                .optValCtn4(approvalRequestMasterResponseVO.getOptValCtn4())
                .optValCtn5(approvalRequestMasterResponseVO.getOptValCtn5())
                .build();
    }

    public static ApprovalRequestMasterRequestVO of(String aprReqId, String apprId){
        ApprovalRequestMasterRequestVO approvalRequestMasterUpdate = new ApprovalRequestMasterRequestVO();
        approvalRequestMasterUpdate.setAprReqId(aprReqId);
        approvalRequestMasterUpdate.setEaprDocNo(apprId);

        return approvalRequestMasterUpdate;
    }
}