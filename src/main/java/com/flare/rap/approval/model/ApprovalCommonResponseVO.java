package com.flare.rap.approval.model;

import com.flare.rap.webservice.constant.InterfaceResult;
import com.flare.rap.webservice.model.WebServiceResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalCommonResponseVO implements WebServiceResponse {

    @Schema(description = "성공여부", example = "S or F")
    private String ifStatus;
    @Schema(description = "리턴메세지", example = "")
    private String ifErrMsg;

    public static ApprovalCommonResponseVO ofError(){
        return ApprovalCommonResponseVO.builder().ifStatus(InterfaceResult.FAIL).build();
    }

    public boolean hasFailed(){
        return InterfaceResult.FAIL.equals(ifStatus);
    }

    public boolean hasSucceed(){
        return InterfaceResult.SUCCESS.equals(ifStatus);
    }
}