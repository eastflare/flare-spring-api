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
public class ApprovalDelegateResponseVO {

    @Schema(description = "결재위임번호", example = "1")
    private String aprDlgtNo;
    @Schema(description = "결재위임 사용자ID", example = "user1id")
    private String aprDlgtUserId;
    @Schema(description = "결재위임 사용자", example = "user1display")
    private String aprDlgtUserDisplay;
    @Schema(description = "결재위임자 부서", example = "user1dept")
    private String dlgtUserDept;
    @Schema(description = "결재수임 사용자ID", example = "user2id")
    private String aprDeleUserId;
    @Schema(description = "결재수임 사용자", example = "user2")
    private String aprDeleUserDisplay;
    @Schema(description = "결재수임자 부서", example = "user1dept")
    private String deleUserDept;
    @Schema(description = "결재위임시작일자", example = "20230101")
    private String aprDlgtStDt;
    @Schema(description = "결재위임종료일자", example = "20231231")
    private String aprDlgtEndDt;
    @Schema(description = "상태", example = "위임중")
    private String status;
    @Schema(description = "사용여부", example = "Y")
    private String useYn;
    @Schema(description = "데이터입력사용자ID", example = "system")
    private String dataInsUserId;
    @Schema(description = "데이터입력일시", example = "2023-05-17 07:42:13")
    private String dataInsDtm;

}