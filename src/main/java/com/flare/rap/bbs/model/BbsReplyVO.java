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
public class BbsReplyVO {
    private String bbmNo;
    private String bbmReNo;
    private String bbmReCtn;
    private String dataInsDtm;
    private String dataInsUserId;
}