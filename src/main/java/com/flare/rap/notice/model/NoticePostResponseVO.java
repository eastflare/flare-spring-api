package com.flare.rap.notice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class NoticePostResponseVO {

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

    @Schema(description = "내용")
    private String bbmCtn;

    @Schema(description = "첨부파일 유무")
    private String atchFileExist;

    @Schema(description = "첨부파일그룹ID")
    private String atchFileGrId;

    @Schema(description = "데이터입력사용자ID")
    private String dataInsUserId;

    @Schema(description = "작성자")
    private String dataInsUserInfo;

    @Schema(description = "작성일")
    private String dataInsDtm;

    @Schema(description = "조회수")
    private String bbmVwct;

    @Schema(description = "팝업노출미사용일수")
    private String poupEpsNuseDdn;

    @Schema(description = "읽음/읽지않음")
    private String readYn;

    @Schema(description = "미리보기 텍스트")
    private String smryCtn;

    @Schema(description = "본문 첫 img 태그")
    private String firstImgTag;
}