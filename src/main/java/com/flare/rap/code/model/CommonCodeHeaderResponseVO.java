package com.flare.rap.code.model;

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
public class CommonCodeHeaderResponseVO {

    @Schema(description = "옵션속성1번항목명", name = "옵션속성1번항목명")
    private String optValNm1;
    @Schema(description = "옵션속성2번항목명", name = "옵션속성2번항목명")
    private String optValNm2;
    @Schema(description = "옵션속성3번항목명", name = "옵션속성3번항목명")
    private String optValNm3;
    @Schema(description = "옵션속성4번항목명", name = "옵션속성4번항목명")
    private String optValNm4;
    @Schema(description = "옵션속성5번항목명", name = "옵션속성5번항목명")
    private String optValNm5;
    @Schema(description = "옵션속성6번항목명", name = "옵션속성6번항목명")
    private String optValNm6;
    @Schema(description = "옵션속성7번항목명", name = "옵션속성7번항목명")
    private String optValNm7;
    @Schema(description = "옵션속성8번항목명", name = "옵션속성8번항목명")
    private String optValNm8;
    @Schema(description = "옵션속성9번항목명", name = "옵션속성9번항목명")
    private String optValNm9;
    @Schema(description = "옵션속성10번항목명", name = "옵션속성10번항목명")
    private String optValNm10;
    @Schema(description = "옵션속성11번항목명", name = "옵션속성11번항목명")
    private String optValNm11;
    @Schema(description = "옵션속성12번항목명", name = "옵션속성12번항목명")
    private String optValNm12;
    @Schema(description = "옵션속성13번항목명", name = "옵션속성13번항목명")
    private String optValNm13;
    @Schema(description = "옵션속성14번항목명", name = "옵션속성14번항목명")
    private String optValNm14;
    @Schema(description = "옵션속성15번항목명", name = "옵션속성15번항목명")
    private String optValNm15;
}