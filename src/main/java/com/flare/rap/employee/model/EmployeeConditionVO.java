package com.flare.rap.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class EmployeeConditionVO {

    @Schema(description = "검색어",  example = "userpopup")
    private String searchItem;

    @Schema(description = "부서코드", example = "50000007")
    private String deptCd;

    @Schema(description = "부서명", example = "고문실")
    private String deptNm;

    @Schema(description = "사용자이름", example = "userpopup")
    private String empNm;

}