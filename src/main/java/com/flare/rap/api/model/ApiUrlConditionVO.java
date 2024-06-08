package com.flare.rap.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApiUrlConditionVO {

    @Schema(description = "API 명", example = "Health Check")
    private String apiNm;

    @Schema(description = "API URL", example = "/v1/health" )
    private String apiUrl;

    @Schema(description = "사용여부", example = "Y" )
    private String useYn;
}
