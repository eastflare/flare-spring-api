package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalNextMailResponseVO {

    @Schema(description = "결재요청ID")
    private String aprReqId;
    @Schema(description = "결재라인순번", example = "0")
    private long aprLnSeq;
    @Schema(description = "결재라인차수", example = "0")
    private long aprLnSnb;
    @Schema(description = "승인자결재유형구분코드", example = "0")
    private String grnrAprTpDivsCd;
    @Schema(description = "병렬여부", example = "N")
    private String prlYn;
    @Schema(description = "결재승인사용자ID", example = "hanjaesang")
    private String aprAprvUserId;
    @Schema(description = "이메일발송순번")
    private long emlSndoSeq;

    public boolean hasSentMail(){
        return emlSndoSeq > 0;
    }
}