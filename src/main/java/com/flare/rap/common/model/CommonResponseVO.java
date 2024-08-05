package com.flare.rap.common.model;

import com.flare.rap.common.constants.CommonConstants;
import com.flare.rap.common.constants.StatusCodeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

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
