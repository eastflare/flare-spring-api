package com.flare.rap.role.model;

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
public class RoleRequestVO extends CrudVO {

    @NotBlank
    @Schema(description = "역할코드", name = "역할코드")
    private String roleCd;

    @NotBlank
    @Schema(description = "역할명", name = "역할명")
    private String roleNm;

    @Schema(description = "역할설명", name = "역할설명")
    private String roleDesc;

    @NotBlank
    @Pattern(regexp = "^[YN]$")
    @Schema(description = "사용여부", name = "사용여부")
    private String useYn;
}