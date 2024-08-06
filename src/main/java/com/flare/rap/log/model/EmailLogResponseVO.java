package com.flare.rap.log.model;

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
public class EmailLogResponseVO {
    @Schema(description = "이메일발송순번")
    private long emlSndoSeq;
    @Schema(description = "이메일로그순번")
    private long emlLogSeq;
    @Schema(description = "이메일유형코드")
    String emlTpCd;
    @Schema(description = "이메일제목")
    String emlTitNm;
    @Schema(description = "이메일수신자목록내용")
    String emlRcvrLstCtn;
    @Schema(description = "발신이메일주소")
    String sedEmal;
    @Schema(description = "발신이메일이름", example = "법무지원시스템")
    private String sedEmalNm;
    @Schema(description = "발신일시")
    String sedDtm;
    @Schema(description = "이메일전송상태코드")
    String emlTrnmStatCd;
    @Schema(description = "이메일전송결과내용")
    String emlTnmRltCtn;
    @Schema(description = "이메일본문내용-4000")
    String emlBdyCtn;
    @Schema(description = "이메일상세내용-TEXT")
    String emlDtlCtn;
    @Schema(description = "결재요청ID")
    String aprReqId;
    @Schema(description = "옵션값명1")
    String optValNm1;
    @Schema(description = "옵션값명2")
    String optValNm2;
    @Schema(description = "옵션값명3")
    String optValNm3;
    @Schema(description = "옵션값명4")
    String optValNm4;
    @Schema(description = "옵션값명5")
    String optValNm5;
}