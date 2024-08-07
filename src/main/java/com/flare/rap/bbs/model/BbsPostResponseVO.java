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
public class BbsPostResponseVO {

    @Schema(description = "게시물 번호")
    private String bbmNo;

    @Schema(description = "게시물 번호")
    private String rank;

    @Schema(description = "게시판 분류 코드")
    private String bbsTpCd;

    @Schema(description = "게시판 분류 명")
    private String bbsTpNm;

    @Schema(description = "제목")
    private String bbmTitNm;

    @Schema(description = "첨부파일 유무")
    private String atchFileExist;

    @Schema(description = "작성자")
    private String dataInsUserInfo;

    @Schema(description = "작성일")
    private String dataInsDtm;

    @Schema(description = "조회수")
    private String bbmVwct;

    @Schema(description = "댓글수")
    private String bbmReplyct;

    @Schema(description = "읽음/읽지않음")
    private String readYn;

    @Schema(description = "본문 내용")
    private String bbmCtn;

    @Schema(description = "첨부파일ID")
    private String atchFileGrId;

    @Schema(description = "미리보기 텍스트")
    private String smryCtn;

    @Schema(description = "본문 첫 img 태그")
    private String firstImgTag;
}