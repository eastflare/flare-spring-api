package com.flare.rap.approval.model;

import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalType3MailSendRequestVO {

    @NotBlank
    @Schema(description = "TB_SPDM_APR_REQ_M.APR_REQ_ID 결재요청ID", example ="REQ-DOC-6")
    private String aprReqId;
    @Schema(description = "메일발송할결재라인순번, Type3 만 사용", example ="1,2,3...")
    private long aprLnSeq;
    @Schema(description = "발송언어", example ="ko")
    private String langCd;

    public static ApprovalType3MailSendRequestVO of(String aprReqId, long aprLnSeq){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return new ApprovalType3MailSendRequestVO(aprReqId, aprLnSeq, userSession.getLangCd());
    }
}