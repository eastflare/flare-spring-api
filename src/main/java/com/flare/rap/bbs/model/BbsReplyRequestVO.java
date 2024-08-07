package com.flare.rap.bbs.model;

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
public class BbsReplyRequestVO {

    @NotBlank
    @Schema(description = "게시글번호", example = "1")
    private String bbmNo;

    @NotBlank
    @Schema(description = "게시글댓글번호", example = "1")
    private String bbmReNo;

    @NotBlank
    @Schema(description = "게시글댓글내용", example = "안녕하세요")
    private String bbmReCtn;

}