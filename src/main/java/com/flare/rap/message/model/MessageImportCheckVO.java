package com.flare.rap.message.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageImportCheckVO {

    @Schema(description = "메시지코드", example = "multilanguage.page.hello")
    private String msgCtn;

    @Schema(description = "언어코드", example = "ko")
    private String langCd;

    @Schema(description = "메시지명", example = "안녕하세요!")
    private String msgTxtCtn;

    @Schema(description = "번역완료 여부", example = "Y")
    private String transYn;

    @Schema(description = "사용여부", example = "Y")
    private String useYn;

}