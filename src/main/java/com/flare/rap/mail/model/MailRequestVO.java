package com.flare.rap.mail.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class MailRequestVO {

    @Schema(description = "발신자", example = "sender@test.com")
    private String fromAddress;

    @Schema(description = "발신이름", example = "법무시스템")
    private String fromAddressName;

    @NotBlank
    @Schema(description = "수신자", example = "receiver@test.com")
    private  String toAddress;

    @Schema(description = "참조자", example = "test@test.com")
    private  String ccAddress;

    @Schema(description = "숨은참조자", example = "test@test.com")
    private  String bccAddress;

    @Schema(description = "제목", example = "이메일 제목입니다")
    private String subject;

    @Schema(description = "내용", example = "메일 내용입니다")
    private String content;

}