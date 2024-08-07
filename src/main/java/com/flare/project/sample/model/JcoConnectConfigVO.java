package com.flare.project.sample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder

public class JcoConnectConfigVO {

    @Schema(description = "국내 Message server IP")
    private String hqJcoMshost;

    @Schema(description = "국내 Client")
    private String hqJcoClient;

    @Schema(description = "국내 Language")
    private String hqJcoLang;

    @Schema(description = "국내 System ID")
    private String hqJcoR3name;

    @Schema(description = "국내 Group")
    private String hqJcoGroup;

    @Schema(description = "국내 JcoTrace")
    private String hqJcoTrace;

    @Schema(description = "해외 Message server IP")
    private String glJcoMshost;

    @Schema(description = "해외 Client")
    private String glJcoClient;

    @Schema(description = "해외 Language")
    private String glJcoLang;

    @Schema(description = "해외 System ID")
    private String glJcoR3name;

    @Schema(description = "해외 Group")
    private String glJcoGroup;

    @Schema(description = "해외 JcoTrace")
    private String glJcoTrace;

    @Schema(description = "SAP User")
    private String jcoUser;

    @Schema(description = "SAP Password")
    private String jcoPasswd;

}