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
public class IfLogRequestVO extends PaginationRequestVO {
    @Schema(description = "인터페이스로그시작일자", example = "20230501")
    String ifLogDtmFr;
    @Schema(description = "인터페이스로그종료일자", example = "20230801")
    String ifLogDtmTo;
    @Schema(description = "검색어", example = "Type2")
    String searchItem;
}