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
public class ApprovalLineType2UpdateRequestVO {

    @Schema(description = "결재요청ID, 신규일때는 NULL로 보내면 됨")
    private String aprReqId;
    @Schema(description = "결재수행유형코드(위임, 부분, 자가승인), NULL, 자동할당됨")
    private String aprFfilTpCd;
    @Schema(description = "결재승인사용자사번, 필수", example = "10082060")
    private String aprAprvEmpNo;
    @Schema(description = "결재처리상태코드, 필수, 신규일때는 SAVE", example = "SAVE")
    private String aprPsgStatCd;
    @Schema(description = "결재승인일시, NULL")
    private String aprAprvDtm;
    @Schema(description = "결재승인의견UTF8내용, NULL")
    private String aprAprvOpinUtf8Ctn;
    @Schema(description = "결재위임자사번, NULL")
    private String aprDlgtEmpNo;
    @Schema(description = "결재위임번호, NULL")
    private long aprDlgtNo;
}