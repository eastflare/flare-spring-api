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
public class EmailLogRequestVO extends PaginationRequestVO {
    @Schema(description = "이일일로그시작일자", example = "20230501")
    String sedDtmFr;
    @Schema(description = "이메일로그종료일자", example = "20230801")
    String sedDtmTo;
    @Schema(description = "검색어", example = "Type2")
    String searchItem;
    @Schema(description = "유형", example = "CONSULT-RESU-COMPL")
    String searchEmlTpCd;
}