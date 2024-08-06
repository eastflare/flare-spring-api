package com.flare.rap.api.model;

import java.util.List;

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
public class ApiUrlRequestVO extends CrudVO {

    @Schema(description = "API ID", example = "API0000")
    private String apiId;

    @NotBlank
    @Schema(description = "API 명", example = "조회")
    private String apiNm;

    @NotBlank
    @Schema(description = "API URL", example = "/v1/test")
    private String apiUrl;

    @NotBlank
    @Schema(description = "API Method", example = "GET", allowableValues = { "GET", "POST", "PUT", "DELETE" })
    private String httpMthdCd;

    @NotBlank
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "사용여부", example = "Y")
    private String useYn;

    @Schema(description = "역할 목록")
    private List<@NotBlank String> apiRoles;

}