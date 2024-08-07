package com.flare.rap.region.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class RegionResponseVO {
    @Schema(description = "지역코드", example = "3")
    private String regnCd;
    @Schema(description = "지역명", example = "서울")
    private String regnNm;
}