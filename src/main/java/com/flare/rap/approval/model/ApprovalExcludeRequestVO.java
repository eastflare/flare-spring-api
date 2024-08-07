package com.flare.rap.approval.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalExcludeRequestVO {

    @Schema(description = "결제자 제외 추가/수정 리스트")
    private List<ApprovalExcludeMasterRequestVO> approvalExcludeMaster;

    @Schema(description = "결제자 제외 목록 추가/수정/삭제 리스트")
    private List<ApprovalExcludeDetailRequestVO> approvalExcludeDetail;
}