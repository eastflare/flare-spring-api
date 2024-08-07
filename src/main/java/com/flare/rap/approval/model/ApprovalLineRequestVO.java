package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalLineRequestVO {

    @Schema(description = "결재요청ID, 신규일때는 NULL로 보내면 됨")
    private String aprReqId;
    @Schema(description = "전자결재문서번호")
    private String eaprDocNo;
    @Schema(description = "결재라인순번, 자동할당됨", example = "0")
    private long aprLnSeq;
    @Schema(description = "결재라인차수, 자동할당됨", example = "0")
    private long aprLnSnb;
    @Schema(description = "승인자결재유형구분코드, 0:승인,6:합의", example = "0")
    private String grnrAprTpDivsCd;
    @Schema(description = "결재수행유형코드(위임, 부분, 자가승인), NULL, 자동할당됨")
    private String aprFfilTpCd;
    @Schema(description = "병렬여부, Y/N", example = "N")
    private String prlYn;
    @NotBlank
    @Schema(description = "결재승인사용자ID, 필수", example = "hanjaesang")
    private String aprAprvUserId;
    @NotBlank
    @Schema(description = "결재처리상태코드, 필수, 신규일때는 SAVE", example = "SAVE")
    private String aprPsgStatCd;
    @Schema(description = "결재승인일시, NULL")
    private String aprAprvDtm;
    @Schema(description = "결재승인의견UTF8내용, NULL")
    private String aprAprvOpinUtf8Ctn;
    @Schema(description = "결재위임사용자ID, NULL")
    private String aprDlgtUserId;
    @Schema(description = "결재위임번호, NULL")
    private long aprDlgtNo;
    @Schema(description = "결재라인구분코드, APPD:결재,INFR:통보)", example = "APPD or INFR")
    private String aprLnDivsCd;
    @Schema(description = "이메일발송순번, Type3용, 자동할당됨")
    private long emlSndoSeq;

    public static ApprovalLineRequestVO initialCopy(ApprovalLineRequestVO approvalLineRequestVO){
        return ApprovalLineRequestVO.builder()
                .aprReqId(null)
                .aprLnSeq(approvalLineRequestVO.getAprLnSeq())
                .aprLnSnb(approvalLineRequestVO.getAprLnSnb())
                .grnrAprTpDivsCd(approvalLineRequestVO.getGrnrAprTpDivsCd())
                .aprFfilTpCd(null)
                .prlYn(approvalLineRequestVO.getPrlYn())
                .aprAprvUserId(approvalLineRequestVO.getAprDlgtUserId() != null ? approvalLineRequestVO.getAprDlgtUserId() : approvalLineRequestVO.getAprAprvUserId())
                .aprPsgStatCd("SAVE")
                .aprAprvDtm(null)
                .aprAprvOpinUtf8Ctn(null)
                .aprDlgtUserId(null)
                .aprLnDivsCd(approvalLineRequestVO.getAprLnDivsCd())
                .build();
    }

}