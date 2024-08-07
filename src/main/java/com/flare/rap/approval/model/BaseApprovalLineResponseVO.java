package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseApprovalLineResponseVO {
    @Schema(description = "결재라인구분코드(APPD:결재라인, INFR:통보라인)", example = "APPD")
    private String aprLnDivsCd;
    @Schema(description = "결재라인기본ID", example = "AR-001")
    private String aprRuleId;
    @Schema(description = "결재규칙명")
    private String aprRuleNm;
    @Schema(description = "결재라인추가허용여부")
    private String aprLnAddPmitYn;
    @Schema(description = "결재참조자추가가능여부")
    private String aprRferAddPsblYn;
    @Schema(description = "결재라인재설정허용여부")
    private String aprLnRstbPmitYn;
    @Schema(description = "결재라인중복허용여부")
    private String aprLnDuplPmitYn;
    @Schema(description = "결재제외대상ID")
    private String aprExcTgtId;
    @Schema(description = "기본통보처ID")
    private Integer mstNtdkId;
    @Schema(description = "양식결재선아이디", example = "ARL-001")
    private String aprLnId;
    @Schema(description = "결재유형코드 ( 담당,협의,합의,결재,보고,참조 )", example = "APV")
    private String aprTpDivsCd;
    @Schema(description = "병렬여부 (순차/병렬)", example = "")
    private String prlYn;
    @Schema(description = "결재차수 (병렬일경우 동일차수)", example = "1")
    private int aprLnSnb;
    @Schema(description = "단순순번", example = "1")
    private int aprLnSeq;
    @Schema(description = "역할코드( 특정사용자, 기안자의 상위자, 기안자의 차상위자, 특정부서장지정 )", example = "USER")
    private String aprLnRoleCd;
    @Schema(description = "특정부서장일경우 기준 부서코드", example = "")
    private String basDeptCd;
    @Schema(description = "특정사용자일경우 기준 사용자ID", example = "")
    private String basUserId;
    @Schema(description = "결재라인사용자수정가능여부", example = "N")
    private String aprLnChgPsblYn;
    @Schema(description = "결재라인삭제가능여부", example = "N")
    private String aprLnDelPsblYn;
    @Schema(description = "결재자사용자ID")
    private String userId;
    @Schema(description = "결재자사용자Info", example = "")
    private String userInfo;
    @Schema(description = "결재자사원번호")
    private String empNo;
    @Schema(description = "결재자사원명")
    private String empNm;
    @Schema(description = "사원영어명")
    private String empEngNm;
    @Schema(description = "사원중국어명")
    private String empCngNm;
    @Schema(description = "부서코드")
    private String deptCd;
    @Schema(description = "부서명")
    private String deptNm;
    @Schema(description = "부서영어명")
    private String deptEngNm;
    @Schema(description = "부서중국어명")
    private String deptCngNm;
    @Schema(description = "법인코드")
    private String copCd;
    @Schema(description = "직위코드")
    private String jtiCd;
    @Schema(description = "직위명")
    private String jtiNm;
    @Schema(description = "직위영어명")
    private String jtiEngNm;
    @Schema(description = "직위중국어명")
    private String jtiCngNm;
    @Schema(description = "직책코드")
    private String jpsCd;
    @Schema(description = "직책명")
    private String jpsNm;
    @Schema(description = "직책영어명")
    private String jpsEngNm;
    @Schema(description = "직책중국어명")
    private String jpsCngNm;
    @Schema(description = "상위사원번호")
    private String upprEmpNo;
    @Schema(description = "근무지역코드")
    private String onduRegnCd;
    @Schema(description = "근무지역명")
    private String onduRegnNm;
    @Schema(description = "국가코드")
    private String ctryCd;
    @Schema(description = "메일서버정보")
    private String emlSvrDmnIfoNm;
    @Schema(description = "사용여부")
    private String useYn;
    @Schema(description = "결재위임번호")
    private String aprDlgtNo;
    @Schema(description = "결재위임사용자ID")
    private String aprDlgtUserId;
    @Schema(description = "결재위임사용자명")
    private String aprDlgtUserEmpNm;
    @Schema(description = "결재위임직위명")
    private String aprDlgtUserJtiNm;
    @Schema(description = "결재위임부서명")
    private String aprDlgtUserDeptNm;
    @Schema(description = "결재위임사용자정보")
    private String aprDlgtUserInfo;
    @Schema(description = "결재수임사용자ID")
    private String aprDeleUserId;
    @Schema(description = "결재수임사용자명")
    private String aprDeleEmpName;
    @Schema(description = "결재수임사용자직위명")
    private String aprDeleJtiNm;
    @Schema(description = "결재수임사용자부서명")
    private String aprDeleDeptNm;
    @Schema(description = "결재수임사용자정보")
    private String aprDeleUserInfo;
    @Schema(description = "결재위임시작일자")
    private String aprDlgtStDt;
    @Schema(description = "결재위임종료일자")
    private String aprDlgtEndDt;
}