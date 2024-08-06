package com.flare.rap.role.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class RoleResponseVO {

    private String roleCd;

    private String roleNm;

    private String roleDesc;

    private String useYn;
}