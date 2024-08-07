package com.flare.rap.approval.model;

import com.flare.rap.common.model.DmlResponseVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalExcludeResponseVO {

    @Schema(description = "결재자 제외 추가/수정 건수")
    private DmlResponseVO approveExcludeMaster;

    @Schema(description = "결재자 제외 대상 목록 추가/수정/삭제 건수")
    private DmlResponseVO approveExcludeDetail;



}