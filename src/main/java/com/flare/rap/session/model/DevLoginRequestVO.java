package com.flare.rap.session.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DevLoginRequestVO {

    @NotBlank
    @Schema(description = "사용자ID", example = "developer")
    private String userId;

    @NotBlank
    @Schema(description = "언어", example = "ko")
    private String langCd;
}