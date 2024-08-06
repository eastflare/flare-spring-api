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
public class IfLogResponseVO {
    @Schema(description = "인터페이스로그순번")
    String ifLogSeq;
    @Schema(description = "인터페이스로그일시")
    String ifLogDtm;
    @Schema(description = "인터페이스명")
    String ifNm;
    @Schema(description = "인터페이스구분코드")
    String ifDivsCd;
    @Schema(description = "공통코드명")
    String cmnCdNm;
    @Schema(description = "인터페이스송신값내용")
    String ifTrmtValCtn;
    @Schema(description = "인터페이스수신값내용")
    String ifRestValCtn;
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