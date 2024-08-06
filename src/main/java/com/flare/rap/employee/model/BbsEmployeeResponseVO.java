package com.flare.rap.employee.model;

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
public class BbsEmployeeResponseVO {

    @Schema(description = "사용자ID")
    private String userId;

    @Schema(description = "사원번호")
    private String empNo;

    @Schema(description = "사원명")
    private String empNm;

    @Schema(description = "부서명")
    private String deptNm;

    @Schema(description = "직위명")
    private String jtiNm;

    @Schema(description = "직책명")
    private String jpsNm;

    @Schema(description = "사무실 전화번호")
    private String ofcTanoPhn;

    @Schema(description = "이메일")
    private String email;

}