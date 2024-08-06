package com.flare.rap.notice.model;

import java.util.List;

import com.flare.rap.employee.model.BbsEmployeeResponseVO;
import com.flare.rap.file.model.FileVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class NoticePostDetailResponseVO {

    @Schema(description = "게시물 번호")
    private String bbmNo;

    @Schema(description = "조회수")
    private String bbmVwct;

    @Schema(description = "작성자")
    private BbsEmployeeResponseVO dataInsUser;

    @Schema(description = "작성일")
    private String dataInsDtm;

    @Schema(description = "수정자")
    private BbsEmployeeResponseVO dataUpdUser;

    @Schema(description = "수정일")
    private String dataUpdDtm;

    @Schema(description = "게시판 분류 코드")
    private String bbsTpCd;

    @Schema(description = "게시판 분류 명")
    private String bbsTpNm;

    @Schema(description = "게시대상법인코드")
    private String ptupTgtCopCd;

    @Schema(description = "게시대상법인명")
    private String ptupTgtCopNm;

    @Schema(description = "제목")
    private String bbmTitNm;

    @Schema(description = "내용")
    private String bbmCtn;

    @Schema(description = "첨부파일 목록")
    private List< FileVO> atchFiles;

    @Schema(description = "첨부파일그룹ID")
    private String atchFileGrId;

    @Schema(description = "게시종료일자")
    private String ptupEndDt;

    @Schema(description = "팝업게시시작일시")
    private String poupStDtm;

    @Schema(description = "팝업게시종료일시")
    private String poupEndDtm;

    @Schema(description = "팝업노출미사용일수")
    private String poupEpsNuseDdn;


    public NoticePostDetailResponseVO(NoticePostDetailVO bbsDetail,
                                      BbsEmployeeResponseVO insertUser,
                                      BbsEmployeeResponseVO updateUser,
                                      List< FileVO> atchFiles ) {

        this.bbmNo = bbsDetail.getBbmNo();
        this.bbmVwct = bbsDetail.getBbmVwct();
        this.dataInsUser = insertUser;
        this.dataInsDtm = bbsDetail.getDataInsDtm();
        this.dataUpdUser = updateUser;
        this.dataUpdDtm = bbsDetail.getDataUpdDtm();
        this.bbsTpCd = bbsDetail.getBbsTpCd();
        this.bbsTpNm = bbsDetail.getBbsTpNm();
        this.ptupTgtCopCd = bbsDetail.getPtupTgtCopCd();
        this.ptupTgtCopNm = bbsDetail.getPtupTgtCopNm();
        this.bbmTitNm = bbsDetail.getBbmTitNm();
        this.bbmCtn = bbsDetail.getBbmCtn();
        this.atchFiles = atchFiles;
        this.atchFileGrId = bbsDetail.getAtchFileGrId();
        this.ptupEndDt = bbsDetail.getPtupEndDt();
        this.poupStDtm = bbsDetail.getPoupStDtm();
        this.poupEndDtm = bbsDetail.getPoupEndDtm();
        this.poupEpsNuseDdn = bbsDetail.getPoupEpsNuseDdn();
    }
}