package com.flare.rap.notice.model;

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
public class NoticeConditionVO extends PaginationRequestVO {

    @Schema(description = "게시판유형코드", example = "NOTI")
    private String bbsTpCd;

    @Schema(description = "제목", example = "제목")
    private String bbmTitNm;

    @Schema(description = "내용", example = "내용")
    private String bbmCtn;

}