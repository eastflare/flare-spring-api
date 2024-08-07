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
public class BbsPostRequestVO {

    @Schema(description = "게시물 번호", example = "1")
    private String bbmNo;

    @Schema(description = "게시판유형코드", example = "LIBRARY")
    private String bbsTpCd;

    @Schema(description = "게시대상법인코드", example = "")
    private String ptupTgtCopCd;

    @Schema(description = "게시대상법인명", example = " ")
    private String ptupTgtCopNm;

    @Schema(description = "제목", example = "첨부파일이 있는 게시글")
    private String bbmTitNm;

    @Schema(description = "내용", example ="내용1")
    private String bbmCtn;

    @Schema(description = "첨부파일그룹ID", example ="7")
    private String atchFileGrId;

    @Schema(description = "게시종료일자", example ="20230507")
    private String ptupEndDt;

}