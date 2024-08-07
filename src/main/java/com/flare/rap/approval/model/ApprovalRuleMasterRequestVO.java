package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ApprovalRuleMasterRequestVO {

    @Schema(description = "결재라인기본ID", example = "AR-001")
    private String aprRuleId;
    @NotBlank
    @Schema(description = "결재라인명", example = "테스트")
    private String aprRuleNm;
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "결재라인추가허용여부", example = "Y")
    private String aprLnAddPmitYn;
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "참조자추가허용여부", example = "Y")
    private String aprRferAddPsblYn;
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "결재라인재설정허용여부", example = "Y")
    private String aprLnRstbPmitYn;
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "결재라인중복허용여부", example = "Y")
    private String aprLnDuplPmitYn;
    @Schema(description = "결재제외대상ID", example = "aaa")
    private String aprExcTgtId;
    @Schema(description = "기본통보처ID", example = "1")
    private Integer mstNtdkId;
}