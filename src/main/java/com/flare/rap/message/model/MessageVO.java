package com.flare.rap.message.model;

import com.flare.rap.common.model.CrudVO;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MessageVO extends CrudVO {

    @NotBlank
    @Schema(description = "메시지코드", requiredMode = RequiredMode.REQUIRED, example = "multilanguage.page.hello")
    private String msgCtn;

    @NotBlank
    @Schema(description = "언어코드", requiredMode = RequiredMode.REQUIRED, example = "ko")
    private String langCd;

    @NotNull
    @Schema(description = "메시지명", requiredMode = RequiredMode.REQUIRED, example = "안녕하세요!")
    private String msgTxtCtn;

    @Schema(description = "비고")
    private String rmk;

    @Schema(description = "속성1")
    private String optValCtn1;

    @Schema(description = "속성2")
    private String optValCtn2;

    @Schema(description = "속성3")
    private String optValCtn3;

    @Schema(description = "사용여부", example = "Y")
    private String useYn;

    @Schema(description = "데이터입력사용자ID")
    private String dataInsUserId;

    @Schema(description = "데이터입력사용자IP")
    private String dataInsUserIp;

    @Schema(description = "데이터입력일시")
    private String dataInsDtm;

    @Schema(description = "데이터입력사용자ID")
    private String dataUpdUserId;

    @Schema(description = "데이터입력사용자IP")
    private String dataUpdUserIp;

    @Schema(description = "데이터수정일시")
    private String dataUpdDtm;

}