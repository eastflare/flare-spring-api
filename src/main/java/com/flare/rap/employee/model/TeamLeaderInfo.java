package com.flare.rap.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class TeamLeaderInfo {
    @Schema(description = "사용자ID")
    String userId;
    @Schema(description = "사용자ID")
    String userNm;
}