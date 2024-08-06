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
public class CommonCodeResponseVO {

    @Schema(description = "공통그룹코드", name = "공통그룹코드")
    private String cmnGrCd;
    @Schema(description = "공통코드", name = "공통코드")
    private String cmnCd;
    @Schema(description = "공통코드명", name = "공통코드명")
    private String cmnCdNm;
    @Schema(description = "공통코드설명", name = "공통코드설명")
    private String cmnCdDesc;
    @Schema(description = "상위공통코드", name = "상위공통코드")
    private String upprCmnCd;
    @Schema(description = "정렬순서", name = "정렬순서")
    private String sortOrd;
    @Schema(description = "사용여부", name = "사용여부")
    private String useYn;
    @Schema(description = "메시지코드", name = "메시지코드")
    private String msgCtn;
    @Schema(description = "옵션값1번내용", name = "옵션값1번내용")
    private String optValCtn1;
    @Schema(description = "옵션값2번내용", name = "옵션값2번내용")
    private String optValCtn2;
    @Schema(description = "옵션값3번내용", name = "옵션값3번내용")
    private String optValCtn3;
    @Schema(description = "옵션값4번내용", name = "옵션값4번내용")
    private String optValCtn4;
    @Schema(description = "옵션값5번내용", name = "옵션값5번내용")
    private String optValCtn5;
    @Schema(description = "옵션값6번내용", name = "옵션값6번내용")
    private String optValCtn6;
    @Schema(description = "옵션값7번내용", name = "옵션값7번내용")
    private String optValCtn7;
    @Schema(description = "옵션값8번내용", name = "옵션값8번내용")
    private String optValCtn8;
    @Schema(description = "옵션값9번내용", name = "옵션값9번내용")
    private String optValCtn9;
    @Schema(description = "옵션값10번내용", name = "옵션값10번내용")
    private String optValCtn10;
    @Schema(description = "옵션값11번내용", name = "옵션값11번내용")
    private String optValCtn11;
    @Schema(description = "옵션값12번내용", name = "옵션값12번내용")
    private String optValCtn12;
    @Schema(description = "옵션값13번내용", name = "옵션값13번내용")
    private String optValCtn13;
    @Schema(description = "옵션값14번내용", name = "옵션값14번내용")
    private String optValCtn14;
    @Schema(description = "옵션값15번내용", name = "옵션값15번내용")
    private String optValCtn15;
}