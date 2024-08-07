package com.flare.rap.notification.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@SuperBuilder
@Builder
public class NotificationGroupDivisionResponseVO {

    @Schema(description = "통보처구분코드", example = "CMN")
    private String ntdkDivsCd;

    @Schema(description = "통보처구분코드이름", example = "일반")
    private String ntdkDivsNm;

}