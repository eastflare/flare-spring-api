package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalLineDelegateResponseVO {

    @Schema(description = "위임번호", example = "23")
    private long aprDlgtNo;
    @Schema(description = "위임자ID", example = "testuser1")
    private String aprDlgtUserId;
    @Schema(description = "위임자정보", example = "testuser1/책임/테스트팀")
    private String aprDlgtUserInfo;
    @Schema(description = "수임자ID", example = "testuser2")
    private String aprDeleUserId;
    @Schema(description = "수임자정보", example = "testuser2/책임/테스트팀")
    private String aprDeleUserInfo;
    @Schema(description = "위임시작일", example = "20230101")
    private String aprDlgtStDt;
    @Schema(description = "위임종료일", example = "20230101")
    private String aprDlgtEndDt;
    @Schema(description = "우선순위", example = "1")
    private String rn;
    @Schema(description = "결재요청ID", example = "REQ-DOC-6")
    private String aprReqId;
    @Schema(description = "결재라인순번", example = "1")
    private long aprLnSeq;


}