package com.flare.rap.approval.model;

import com.flare.rap.session.model.EmployeeVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ApproverVO extends EmployeeVO {

    @Schema(description = "결재 상태")
    private String status;
}