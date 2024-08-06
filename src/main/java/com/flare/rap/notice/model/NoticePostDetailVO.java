package com.flare.rap.notice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class NoticePostDetailVO {

    @Schema(description = "게시물 번호")
    private String bbmNo;

    @Schema(description = "게시판 분류 코드")
    private String bbsTpCd;

    @Schema(description = "게시판 분류 명")
    private String bbsTpNm;

    @Schema(description = "제목")
    private String bbmTitNm;

    @Schema(description = "내용")
    private String bbmCtn;

    @Schema(description = "첨부파일그룹ID")
    private String atchFileGrId;

    @Schema(description = "조회수")
    private String bbmVwct;

    @Schema(description = "게시종료일자")
    private String ptupEndDt;

    @Schema(description = "팝업게시시작일시")
    private String poupStDtm;

    @Schema(description = "팝업게시종료일시")
    private String poupEndDtm;

    @Schema(description = "게시대상법인코드")
    private String ptupTgtCopCd;

    @Schema(description = "게시대상법인명")
    private String ptupTgtCopNm;

    @Schema(description = "팝업노출미사용일수")
    private String poupEpsNuseDdn;

    @Schema(description = "데이터입력사용자ID")
    private String dataInsUserId;

    @Schema(description = "데이터입력일시")
    private String dataInsDtm;

    @Schema(description = "데이터수정사용자ID")
    private String dataUpdUserId;

    @Schema(description = "데이터수정일시")
    private String dataUpdDtm;
}