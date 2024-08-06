package com.flare.rap.common.model;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponseVO<T> {

    @Schema(example = CommonConstants.YES_FLAG)
    private String successOrNot;

    @Schema(example = StatusCodeConstants.SUCCESS)
    private String statusCode;

    private T data;

}