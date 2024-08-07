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
public class ApprovalExcludeDetailRequestVO extends CrudVO {
    @Schema(description = "결재자제외 ID", example = "1")
    private long aprExcTgtId;

    @Schema(description = "sequence", example = "1")
    private long aprExcSeq;

    @Schema(description = "결재자제외 구분코드", example = "USER")
    private String aprExcDivsCd;

    @Schema(description = "결재자제외 사용자ID", example = "userpopup")
    private String aprExcUserId;
}