package com.flare.rap.code.model;

import com.flare.rap.common.model.CrudVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CommonCodeRequestVO extends CrudVO {

    @NotBlank
    @Schema(description = "공통그룹코드", example = "AD_WORKPLACE")
    private String cmnGrCd;
    @NotBlank
    @Schema(description = "공통코드", example = "SUB001")
    private String cmnCd;
    @Schema(description = "공통코드명", example = "공통코드명")
    private String cmnCdNm;
    @Schema(description = "공통코드설명", example = "공통코드설명")
    private String cmnCdDesc;
    @Schema(description = "상위공통코드", example = "상위공통코드")
    private String upprCmnCd;
    @Schema(description = "정렬순서", example = "1")
    private Integer sortOrd;
    @Schema(description = "메시지코드", example = "com.code.LANG_CD")
    private String msgCtn;
    @NotBlank
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "사용여부", example = "Y")
    private String useYn;
    @Schema(description = "옵션값1번내용", example = "옵션값1번내용")
    private String optValCtn1;
    @Schema(description = "옵션값2번내용", example = "옵션값2번내용")
    private String optValCtn2;
    @Schema(description = "옵션값3번내용", example = "옵션값3번내용")
    private String optValCtn3;
    @Schema(description = "옵션값4번내용", example = "옵션값4번내용")
    private String optValCtn4;
    @Schema(description = "옵션값5번내용", example = "옵션값5번내용")
    private String optValCtn5;
    @Schema(description = "옵션값6번내용", example = "옵션값6번내용")
    private String optValCtn6;
    @Schema(description = "옵션값7번내용", example = "옵션값7번내용")
    private String optValCtn7;
    @Schema(description = "옵션값8번내용", example = "옵션값8번내용")
    private String optValCtn8;
    @Schema(description = "옵션값9번내용", example = "옵션값9번내용")
    private String optValCtn9;
    @Schema(description = "옵션값10번내용", example = "옵션값10번내용")
    private String optValCtn10;
    @Schema(description = "옵션값11번내용", example = "옵션값11번내용")
    private String optValCtn11;
    @Schema(description = "옵션값12번내용", example = "옵션값12번내용")
    private String optValCtn12;
    @Schema(description = "옵션값13번내용", example = "옵션값13번내용")
    private String optValCtn13;
    @Schema(description = "옵션값14번내용", example = "옵션값14번내용")
    private String optValCtn14;
    @Schema(description = "옵션값15번내용", example = "옵션값15번내용")
    private String optValCtn15;
}