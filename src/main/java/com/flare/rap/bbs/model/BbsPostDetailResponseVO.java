package com.flare.rap.bbs.model;

import java.util.List;

import com.flare.rap.bbs.model.BbsReplyResponseVO;
import com.flare.rap.employee.model.BbsEmployeeResponseVO;
import com.flare.rap.file.model.FileVO;

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
public class BbsPostDetailResponseVO {

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

    @Schema(description = "첨부파일 그룹ID")
    private String atchFileGrId;

    @Schema(description = "첨부파일 목록")
    private List<FileVO> atchFiles;

    @Schema(description = "댓글 목록")
    private List<BbsReplyResponseVO> replies;

    @Schema(description = "게시종료일자")
    private String ptupEndDt;


    public BbsPostDetailResponseVO(BbsPostDetailVO bbsDetail,
                                   BbsEmployeeResponseVO insertUser,
                                   BbsEmployeeResponseVO updateUser,
                                   List<FileVO> atchFiles,
                                   List<BbsReplyResponseVO> replies ) {

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
        this.atchFileGrId = bbsDetail.getAtchFileGrId();
        this.atchFiles = atchFiles;
        this.replies = replies;
        this.ptupEndDt = bbsDetail.getPtupEndDt();
    }
}