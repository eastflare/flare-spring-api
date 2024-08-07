package com.flare.rap.notification.model;

import com.flare.rap.common.model.CrudVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class NotificationGroupUserRequestVO extends CrudVO {

    @NotNull
    @Schema(description = "통보처아이디", example = "1")
    private Integer ntdkId;

    @NotBlank
    @Schema(description = "통보처구분코드", example = "CMN")
    private String ntdkDivsCd;

    @Schema(description = "통보처순번", example = "1")
    private String ntdkSeq;

    @NotBlank
    @Schema(description = "사용자ID", example = "test")
    private String aprNotfUserId;


}