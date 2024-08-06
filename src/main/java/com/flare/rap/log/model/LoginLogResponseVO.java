package com.flare.rap.log.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class LoginLogResponseVO {
    @Schema(description = "접근로그ID")
    String contLogId;
    @Schema(description = "접속시간")
    String contDtm;
    @Schema(description = "접속사용자ID")
    String contUserId;
    @Schema(description = "접속사용자명")
    String empNm;
    @Schema(description = "접속사용자부서명")
    String deptNm;
    @Schema(description = "접속IP")
    String contIp;
}