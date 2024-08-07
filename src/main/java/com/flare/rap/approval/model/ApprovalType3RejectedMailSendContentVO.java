package com.flare.rap.approval.model;

import com.flare.rap.mail.model.MailVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ApprovalType3RejectedMailSendContentVO extends MailVO {
    @Schema(description = "결재양식명", name="결재양식명")
    private String aprTplNm;

    @Schema(description = "메일내용 제목", name = "제목")
    private String aprReqTitNm;

    @Schema(description = "반려일시-세션로컬시간 적용", name = "반려일시")
    private String aprRejectedDtm;

    @Schema(description = "기안자-성명(ID/직책직급/팀)", name = "기안자")
    private String aprReqUserNm;

    @Schema(description = "결재자-성명(ID/직책직급/팀)", name = "결재자")
    private String aprAprvUserNm;

    @Schema(description = "메일본문링크", name = "메일본문링크")
    private String linkUrl;

    @Schema(description = "받는사람이메일주소-단건", name = "받는사람이메일주소-단건")
    private String toAddress;
}