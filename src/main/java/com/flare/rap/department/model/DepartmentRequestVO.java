package com.flare.rap.department.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class DepartmentRequestVO {

    @Schema(description = "검색어", name = "searchItem", example = "기술원")
    private String searchItem;

    @Schema(description = "부서코드", name = "deptCd", example = "50000824")
    private String deptCd;

    @Schema(description = "부서명", name = "deptNm", example = "고문실")
    private String deptNm;

    @Schema(description = "언어", name ="langCd", example = "ko")
    private String langCd;
}