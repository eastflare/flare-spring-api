package com.flare.rap.approval.model;

import com.flare.rap.common.model.CrudVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ApprovalExcludeMasterRequestVO extends CrudVO {
    @Schema(description = "결재자제외 ID", example = "1")
    private long aprExcTgtId;

    @Schema(description = "결재자제외 명", example = "제외규칙1")
    private String aprExcNm;
}