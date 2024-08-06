package com.flare.rap.notice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class NoticePostRequestVO {

    @Schema(description = "게시물 번호", example = "1")
    private String bbmNo;

    @Schema(description = "게시판유형코드", example = "NOTI")
    private String bbsTpCd;

    @Schema(description = "게시대상법인코드", example = "C100")
    private String ptupTgtCopCd;

    @Schema(description = "게시대상법인명", example = "㈜LG화학")
    private String ptupTgtCopNm;

    @Schema(description = "제목", example = "공지사항1")
    private String bbmTitNm;

    @Schema(description = "내용", example ="내용1")
    private String bbmCtn;

    @Schema(description = "첨부파일그룹ID", example ="1")
    private String atchFileGrId;

    @Schema(description = "게시종료일자", example ="20230516")
    private String ptupEndDt;

    @Schema(description = "팝업게시시작일시", example ="2023-05-16 12:00:00")
    private String poupStDtm;

    @Schema(description = "팝업게시종료일시", example ="2023-05-16 12:00:00")
    private String poupEndDtm;

    @Schema(description = "팝업노출미사용일수", example = "7")
    private String poupEpsNuseDdn;

}