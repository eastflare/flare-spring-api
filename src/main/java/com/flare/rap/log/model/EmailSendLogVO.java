package com.flare.rap.log.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailSendLogVO {
    @Schema(description = "이메일발송순번", example = "자동")
    private long emlSndoSeq;
    @Schema(description = "이메일로그순번", example = "자동")
    private long emlLogSeq;
    @Schema(description = "이메일유형코드", example = "APPROVAL 등 발송 업무 구분")
    private String emlTpCd;
    @Schema(description = "이메일제목", example = "메일제목입니다.")
    private String emlTitNm;
    @Schema(description = "이메일수신자목록내용", example = "recv@abc.com,recv2@zzz.com")
    private String emlRcvrLstCtn;
    @Schema(description = "발신이메일주소", example = "recv@abc.com")
    private String sedEmal;
    @Schema(description = "발신이메일이름", example = "법무지원시스템")
    private String sedEmalNm;
    @Schema(description = "발신일시", example = "date형")
    private String sedDtm;
    @Schema(description = "이메일전송상태코드", example = "SMTP응답코드")
    private String emlTrnmStatCd;
    @Schema(description = "이메일전송결과내용", example = "SMTP응답내용")
    private String emlTrnmRltCtn;
    @Schema(description = "이메일본문내용", example = "본문내용 4000자")
    private String emlBdyCtn;
    @Schema(description = "이메일상세내용", example = "본문내용 TEXT")
    private String emlDtlCtn;
    @Schema(description = "결재요청ID", example = "결재관련메일일경우만")
    private String aprReqId;
    @Schema(description = "옵션값명1", example = "참조자")
    private String optValNm1;
    @Schema(description = "옵션값명2", example = "임의값")
    private String optValNm2;
    @Schema(description = "옵션값명3", example = "임의값")
    private String optValNm3;
    @Schema(description = "옵션값명4", example = "임의값")
    private String optValNm4;
    @Schema(description = "옵션값명5", example = "임의값")
    private String optValNm5;
    @Schema(description = "데이터입력사용자ID", example = "userid")
    private String dataInsUserId;
    @Schema(description = "데이터입력사용자IP주소", example = "1.1.1.1")
    private String dataInsUserIp;
    @Schema(description = "데이터입력일시", example = "date형")
    private String dataInsDtm;
}