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
public class IfLogVO {
    @Schema(description = "인터페이스로그순번", example = "자동seq")
    private long ifLogSeq;
    @Schema(description = "인터페이스로그일시", example = "date형")
    private String ifLogDtm;
    @Schema(description = "인터페이스명", example = "인터페이스명")
    private String ifNm;
    @Schema(description = "인터페이스구분코드", example = "CLIENT:클라이언트, SERVICE : 수신  구분")
    private String ifDivsCd;
    @Schema(description = "인터페이스송신값내용", example = "송신내용")
    private String ifTrmtValCtn;
    @Schema(description = "인터페이스수신값내용", example = "수신내용")
    private String ifRestValCtn;
    @Schema(description = "옵션값명1", example = "옵션")
    private String optValNm1;
    @Schema(description = "옵션값명2", example = "옵션")
    private String optValNm2;
    @Schema(description = "옵션값명3", example = "옵션")
    private String optValNm3;
    @Schema(description = "옵션값명4", example = "옵션")
    private String optValNm4;
    @Schema(description = "옵션값명5", example = "옵션")
    private String optValNm5;
    @Schema(description = "데이터입력사용자ID", example = "세션ID")
    private String dataInsUserId;
    @Schema(description = "데이터입력사용자IP주소", example = "세션IP")
    private String dataInsUserIp;
    @Schema(description = "데이터입력일시", example = "현재일시")
    private String dataInsDtm;
}