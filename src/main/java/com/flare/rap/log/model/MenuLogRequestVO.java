package com.flare.rap.log.model;

import com.flare.rap.common.model.PaginationRequestVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MenuLogRequestVO extends PaginationRequestVO {
    @Schema(description = "접속시작일자", example = "20230501")
    String contDtmFr;
    @Schema(description = "접속종료일자", example = "20230501")
    String contDtmTo;
    @Schema(description = "검색어", example = "gigi")
    String searchItem;
}