package com.flare.rap.message.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageConditionVO {

    @Schema(description = "메시지코드", example = "multilanguage.page.hello")
    private String msgCtn;

    @Schema(description = "메시지명", example = "안녕하세요!")
    private String msgTxtCtn;

    @Schema(description = "언어코드", example = "ko")
    private String langCd;

    @Schema(description = "사용여부", example = "Y")
    private String useYn;

    @Builder
    public MessageConditionVO(String msgCtn, String msgTxtCtn, String langCd, String useYn) {
        this.msgCtn = msgCtn;
        this.msgTxtCtn = msgTxtCtn;
        this.langCd = langCd;
        this.useYn = useYn;
    }

}