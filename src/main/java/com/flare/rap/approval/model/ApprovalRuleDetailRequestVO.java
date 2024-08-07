package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalRuleDetailRequestVO {

    @NotBlank
    @Schema(description = "결재라인기본ID", example = "AR-001")
    private String aprRuleId;
    @Schema(description = "양식결재선아이디", example = "ARL-001")
    private String aprLnId;
    @NotBlank
    @Schema(description = "결재유형코드 ( 0:결재, 1:협의(필수), 2:협의(선택), 6, 합의, 7: 보고, 8:투자담당, 9: 자가승인 )", example = "1")
    private String aprTpDivsCd;
    @Schema(description = "병렬여부 (순차/병렬)", example = "Y")
    private String prlYn;
    @Schema(description = "결재차수 (병렬일경우 동일차수)", example = "1")
    private int aprLnSnb;
    @Schema(description = "단순순번", example = "1")
    private int aprLnSeq;
    @Schema(description = "역할코드( 특정사용자, 기안자의 상위자, 기안자의 차상위자, 특정부서장지정 )", example = "USER")
    private String aprLnRoleCd;
    @Schema(description = "특정부서장일경우 부서코드", example = "")
    private String deptCd;
    @Schema(description = "특정사용자일경우 사용자ID", example = "")
    private String userId;
    @Schema(description = "결재라인사용자수정가능여부", example = "N")
    private String aprLnChgPsblYn;
    @Schema(description = "결재라인삭제가능여부", example = "N")
    private String aprLnDelPsblYn;
    @Schema(description = "생성/수정/삭제 코드", example = "C")
    private String crudKey;
    }