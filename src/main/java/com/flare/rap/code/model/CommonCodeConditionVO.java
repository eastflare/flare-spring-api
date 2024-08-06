package com.flare.rap.code.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
public class CommonCodeConditionVO {

    @NotBlank
    @Schema(description = "공통그룹코드", example = "AD_WORKPLACE")
    private String cmnGrCd;
    @Schema(description = "공통코드", example = "cop_cd")
    private String cmnCd;
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