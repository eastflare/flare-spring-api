package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalRuleDetailResponseVO {

    @Schema(description = "결재라인기본ID", example = "AR-001")
    private String aprRuleId;
    @Schema(description = "양식결재선아이디", example = "ARL-001")
    private String aprLnId;
    @Schema(description = "결재유형코드 ( 담당,협의,합의,결재,보고,참조 )", example = "APV")
    private String aprTpDivsCd;
    @Schema(description = "병렬여부 (순차/병렬)", example = "")
    private String prlYn;
    @Schema(description = "결재차수 (병렬일경우 동일차수)", example = "1")
    private String aprLnSnb;
    @Schema(description = "단순순번", example = "1")
    private String aprLnSeq;
    @Schema(description = "역할코드( 특정사용자, 기안자의 상위자, 기안자의 차상위자, 특정부서장지정 )", example = "USER")
    private String aprLnRoleCd;
    @Schema(description = "특정부서장일경우 부서코드", example = "")
    private String deptCd;
    @Schema(description = "특정부서장일경우 부서이름", example = "")
    private String deptNm;
    @Schema(description = "특정사용자일경우 사용자ID", example = "")
    private String userId;
    @Schema(description = "특정사용자일경우 사용자명", example = "")
    private String userNm;
    @Schema(description = "특정사용자일경우 사용자Info", example = "")
    private String userInfo;
    @Schema(description = "결재라인사용자수정가능여부", example = "N")
    private String aprLnChgPsblYn;
    @Schema(description = "결재라인삭제가능여부", example = "N")
    private String aprLnDelPsblYn;
    }