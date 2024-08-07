package com.flare.rap.mail.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@SuperBuilder
public class MailVO {

    @Schema(description = "이메일발송순번리턴용도", example = "자동")
    private int emlSndoSeq;

    @Schema(description = "발신자", name = "발신자")
    private String fromAddress;

    @Schema(description = "발신자명", name = "발신자명")
    private String fromAddressName;

    @Schema(description = "수신자", name = "수신자")
    private  List< String> toAddressList;

    @Schema(description = "참조자", name = "참조자")
    private  List< String> ccAddressList;

    @Schema(description = "숨은참조자", name = "숨은참조자")
    private  List< String> bccAddressList;

    @Schema(description = "제목", name = "제목")
    private String subject;

    @Schema(description = "내용", name = "내용")
    private String content;

    @Schema(description = "이메일유형코드", name = "이메일유형코드")
    private String emlTpCd;

    @Schema(description = "결재요청ID", name = "결재요청ID")
    private String aprReqId;

    @Schema(description = "html여부", name = "html여부")
    private boolean isUseHtmlYn; // 메일 형식이 HTML인지 여부(true, false)

    @Schema(description = "첨부파일", name = "첨부파일")
    private  final List<AttachFileVO> attachFileList = new ArrayList<>();
}