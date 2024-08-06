package com.flare.rap.api.model;

import java.util.List;

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
    private List< String> apiRoles;

    @Schema(description = "사용여부")
    private String useYn;

    @Schema(description = "작성자")
    private String dataInsUserName;

    @Schema(description = "작성일시")
    private String dataInsDtm;

    @Schema(description = "수정자")
    private String dataUpdUserName;

    @Schema(description = "수정일시")
    private String dataUpdDtm;
}