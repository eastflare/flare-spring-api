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
public class CommonCodeGroupRequestVO extends CrudVO {

    @NotBlank
    @Schema(description = "공통그룹코드", example = "AD_WORKPLACE")
    private String cmnGrCd;
    @Schema(description = "공통그룹코드명", example = "공통그룹코드명")
    private String cmnGrCdNm;
    @Schema(description = "공통그룹코드설명", example = "공통그룹코드설명")
    private String cmnGrCdDesc;
    @Schema(description = "업무영역구분코드", example = "업무영역구분코드")
    private String wktAreaDivsCd;
    @Schema(description = "정렬순서", example = "1")
    private Integer sortOrd;
    @Schema(description = "메시지코드", example = "com.code.LANG_CD")
    private String msgCtn;
    @Schema(description = "옵션속성1번항목명", example = "옵션속성1번항목명")
    private String optValNm1;
    @Schema(description = "옵션속성2번항목명", example = "옵션속성2번항목명")
    private String optValNm2;
    @Schema(description = "옵션속성3번항목명", example = "옵션속성3번항목명")
    private String optValNm3;
    @Schema(description = "옵션속성4번항목명", example = "옵션속성4번항목명")
    private String optValNm4;
    @Schema(description = "옵션속성5번항목명", example = "옵션속성5번항목명")
    private String optValNm5;
    @Schema(description = "옵션속성6번항목명", example = "옵션속성6번항목명")
    private String optValNm6;
    @Schema(description = "옵션속성7번항목명", example = "옵션속성7번항목명")
    private String optValNm7;
    @Schema(description = "옵션속성8번항목명", example = "옵션속성8번항목명")
    private String optValNm8;
    @Schema(description = "옵션속성9번항목명", example = "옵션속성9번항목명")
    private String optValNm9;
    @Schema(description = "옵션속성10번항목명", example = "옵션속성10번항목명")
    private String optValNm10;
    @Schema(description = "옵션속성11번항목명", example = "옵션속성11번항목명")
    private String optValNm11;
    @Schema(description = "옵션속성12번항목명", example = "옵션속성12번항목명")
    private String optValNm12;
    @Schema(description = "옵션속성13번항목명", example = "옵션속성13번항목명")
    private String optValNm13;
    @Schema(description = "옵션속성14번항목명", example = "옵션속성14번항목명")
    private String optValNm14;
    @Schema(description = "옵션속성15번항목명", example = "옵션속성15번항목명")
    private String optValNm15;
    @Schema(description = "비고", example = "비고")
    private String rmk;
    @NotBlank
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "사용여부", example = "Y")
    private String useYn;
}