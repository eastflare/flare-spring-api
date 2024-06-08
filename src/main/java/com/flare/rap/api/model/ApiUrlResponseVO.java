package com.flare.rap.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApiUrlResponseVO {

    @Schema(description = "API ID")
    private String apiId;

    @Schema(description = "API 명")
    private String apiNm;

    @Schema(description = "API URL")
    private String apiUrl;

    @Schema(description = "API Method")
    private String httpMthdCd;

    @Schema(description = "역할")
    private List<String> apiRoles;

    @Schema(description = "사용여부")
    private String useYn;
}
