package com.flare.rap.role.model;

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
public class RoleEmployeeResponseVO {

    @Schema(description = "사용자ID")
    private String userId;

    @Schema(description = "사원번호")
    private String empNo;

    @Schema(description = "사원명")
    private String empNm;

    @Schema(description = "부서코드")
    private String deptCd;

    @Schema(description = "부서명")
    private String deptNm;

    @Schema(description = "법인코드")
    private String copCd;

    @Schema(description = "직위코드")
    private String jtiCd;

    @Schema(description = "직위명")
    private String jtiNm;

    @Schema(description = "직책코드")
    private String jpsCd;

    @Schema(description = "직책명")
    private String jpsNm;

    @Schema(description = "이메일")
    private String emlSvrDmnIfoNm;

    @Schema(description = "회사전화번호")
    private String officeNumber;

}