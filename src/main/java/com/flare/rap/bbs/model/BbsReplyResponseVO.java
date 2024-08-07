package com.flare.rap.bbs.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class BbsReplyResponseVO {

    @Schema(description = "게시물 번호")
    private String bbmNo;

    @Schema(description = "게시글 댓글 번호")
    private String bbmReNo;

    @Schema(description = "게시글 댓글 내용")
    private String bbmReCtn;

    @Schema(description = "데이터입력일시")
    private String dataInsDtm;

    @Schema(description = "데이터입력사용자ID")
    private String dataInsUserId;

    @Schema(description = "사원명")
    private String empNm;

    @Schema(description = "부서명")
    private String deptNm;

    @Schema(description = "직위명")
    private String jtiNm;

    @Schema(description = "직책명")
    private String jpsNm;

}