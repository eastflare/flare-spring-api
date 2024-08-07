package com.flare.rap.approval.model;

import com.flare.rap.approval.constant.ApprovalProgressStatus;
import com.flare.rap.approval.constant.ApprovalRequestProgressStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalLineCheckResponseVO {

    @Schema(description = "결재요청자확인")
    private String approverYn;
    @Schema(description = "결재처리상태코드", example = "SAVE")
    private String aprPsgStatCd;

    public boolean isApprover(){
        return "Y".equals(approverYn);
    }

    public boolean isWaitStatus(){
        return ApprovalProgressStatus.WAIT.equals(aprPsgStatCd);
    }
}