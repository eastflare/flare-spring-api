package com.flare.rap.log.model;

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
public class MenuLogResponseVO {
    @Schema(description = "접근로그ID")
    String acesLogId;
    @Schema(description = "접속시간")
    String contDtm;
    @Schema(description = "메뉴ID")
    String mnuId;
    @Schema(description = "메뉴명")
    String mnuNm;
    @Schema(description = "접속사용자ID")
    String contUserId;
    @Schema(description = "접속사용자명")
    String empNm;
    @Schema(description = "접속IP")
    String contIp;
}