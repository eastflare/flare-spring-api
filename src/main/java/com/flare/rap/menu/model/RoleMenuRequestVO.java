package com.flare.rap.menu.model;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class RoleMenuRequestVO{

    @NotBlank
    @Schema(description ="역할 코드", example = "ADM")
    private String roleCd;

    @Schema(description = "메뉴 아이디 리스트", example = "[000001,000002,000003]")
    private ArrayList<@NotBlank String> mnuIdList;
}