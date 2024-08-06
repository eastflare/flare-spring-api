package com.flare.rap.department.model;

import java.util.List;

import com.flare.rap.department.model.DepartmentVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class DepartmentResponseVO {

    @Schema(description = "부서 목록", name = "부서 목록")
    private List<DepartmentVO> departmentList;

    @Schema(description = "사용자 부서코드", name = "사용자 부서코드")
    private String userDeptCd;


}