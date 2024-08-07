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
public class ApprovalLineResponseVO {

    @Schema(description = "결재요청ID")
    private String aprReqId;
    @Schema(description = "결재라인순번", example = "0")
    private long aprLnSeq;
    @Schema(description = "결재라인차수", example = "0")
    private long aprLnSnb;
    @Schema(description = "승인자결재유형구분코드", example = "0")
    private String grnrAprTpDivsCd;
    @Schema(description = "결재수행유형코드(위임, 부분, 자가승인)")
    private String aprFfilTpCd;
    @Schema(description = "병렬여부", example = "N")
    private String prlYn;
    @Schema(description = "결재승인사용자ID", example = "hanjaesang")
    private String aprAprvUserId;
    @Schema(description = "결재승인사용자이름", example = "한재상")
    private String aprUserNm;
    @Schema(description = "결재승인사용자직위", example = "책임")
    private String aprUserJikwi;
    @Schema(description = "결재승인사용자부서", example = "System운영PI팀")
    private String aprUserDept;
    @Schema(description = "결재처리상태코드", example = "SAVE")
    private String aprPsgStatCd;
    @Schema(description = "결재처리상태", example = "임시저장")
    private String aprPsgStatNm;
    @Schema(description = "결재승인일시")
    private String aprAprvDtm;
    @Schema(description = "결재승인의견UTF8내용")
    private String aprAprvOpinUtf8Ctn;
    @Schema(description = "결재위임사용자ID")
    private String aprDlgtUserId;
    @Schema(description = "결재위임번호")
    private long aprDlgtNo;
    @Schema(description = "결재라인구분코드)", example = "APPD or INFR")
    private String aprLnDivsCd;
    @Schema(description = "이메일발송순번")
    private long emlSndoSeq;
    @Schema(description = "승인여부, 승인:Y, 부결:N")
    private String apvYn;

    public boolean isApproved(){
        return "Y".equals(this.apvYn);
    }
}