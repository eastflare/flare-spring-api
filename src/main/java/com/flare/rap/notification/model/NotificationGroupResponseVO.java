package com.flare.rap.notification.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@SuperBuilder
@Builder
public class NotificationGroupResponseVO {

    @Schema(description = "통보처아이디", example = "1")
    private String ntdkId;

    @Schema(description = "통보처제목", example = "심의 통보처")
    private String ntdkNm;

    @Schema(description = "통보처설명", example = "심의 통보처")
    private String ntdkDesc;

    @Schema(description = "통보처구분코드", example = "CMN")
    private String ntdkDivsCd;

    @Schema(description = "사용자아이디", example = "test")
    private String aprNotfUserId;

    @Schema(description = "정렬번호", example = "1")
    private Integer sortOrd;

    @Schema(description = "사용여부 Y/N", example = "Y")
    private String useYn;

}