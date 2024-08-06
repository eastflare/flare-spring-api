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
public class CommonCodeNameResponseVO {

    @Schema(description = "공통코드", name = "공통코드")
    private String cmnCd;

    @Schema(description = "공통코드명", name = "공통코드명")
    private String cmnCdNm;

    @Schema(description = "공통코드설명", name = "공통코드설명")
    private String cmnCdDesc;

    @Schema(description = "상위공통코드", name = "상위공통코드")
    private String upprCmnCd;

    @Schema(description = "공통그룹코드", example = "APR_PSG_STAT_CD")
    private String cmnGrCd;
}