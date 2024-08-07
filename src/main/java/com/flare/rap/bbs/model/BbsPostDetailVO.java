package com.flare.rap.bbs.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class BbsPostDetailVO {
    private String bbmNo;
    private String bbmVwct;
    private String dataInsUserId;
    private String dataInsDtm;
    private String dataUpdUserId;
    private String dataUpdDtm;
    private String bbsTpCd;
    private String bbsTpNm;
    private String ptupTgtCopCd;
    private String ptupTgtCopNm;
    private String bbmTitNm;
    private String bbmCtn;
    private String atchFileGrId;
    private String ptupEndDt;
}