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
public class ApprovalRuleMasterResponseVO {

    @Schema(description = "결재라인기본ID", example = "AR-001")
    private String aprRuleId;
    @Schema(description = "결재라인명", example = "테스트")
    private String aprRuleNm;
    @Schema(description = "결재라인추가허용여부", example = "Y")
    private String aprLnAddPmitYn;
    @Schema(description = "참조자추가허용여부", example = "Y")
    private String aprRferAddPsblYn;
    @Schema(description = "결재라인재설정허용여부", example = "Y")
    private String aprLnRstbPmitYn;
    @Schema(description = "결재라인중복허용여부", example = "Y")
    private String aprLnDuplPmitYn;
    @Schema(description = "결재제외대상ID", example = "aaa")
    private String aprExcTgtId;
    @Schema(description = "기본통보처ID", example = "1")
    private String mstNtdkId;
}