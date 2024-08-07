package com.flare.rap.notification.model;

import com.flare.rap.common.model.CrudVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class NotificationGroupRequestVO extends CrudVO {

    @Schema(description = "통보처아이디", example = "1")
    private Integer ntdkId;

    @Schema(description = "통보처제목", example = "심의 통보처")
    private String ntdkNm;

    @Schema(description = "통보처설명", example = "심의 통보처")
    private String ntdkDesc;

}