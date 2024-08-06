package com.flare.rap.department.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class DepartmentVO {
    @NotBlank
    @Schema(description = "부서코드", name = "부서코드")
    private String deptCd;

    @Schema(description = "법인코드", name = "법인코드")
    private String copCd;

    @Schema(description = "부서명", name = "부서명")
    private String deptNm;

    @Schema(description = "부서영문명", name = "부서영문명")
    private String deptEngNm;

    @Schema(description = "부서중문명", name = "부서중문명")
    private String deptCngNm;

    @Schema(description = "팀리더사용자ID", name = "팀리더사용자ID")
    private String temLdrUserId;

    @Schema(description = "상위부서코드", name = "상위부서코드")
    private String upprDeptCd;

    @Schema(description = "유효여부", name = "유효여부")
    private String useYn;

}