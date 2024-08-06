package com.flare.project.sample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExcelSampleVO {

    @Schema(description = "excel download sample 1")
    private String cmnGrCd;

    @Schema(description = "excel download sample 2")
    private String cmnCd;

    @Schema(description = "excel download sample 3")
    private String cmnCdNm;

}