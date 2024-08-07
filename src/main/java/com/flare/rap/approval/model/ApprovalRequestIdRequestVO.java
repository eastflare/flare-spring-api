package com.flare.rap.approval.model;

import com.flare.rap.approval.constant.ApprovalRequestProgressStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalRequestIdRequestVO {

    @NotBlank
    @Schema(description = "TB_SPDM_APR_REQ_M.APR_REQ_ID 결재요청ID", example ="REQ-DOC-6")
    private String aprReqId;
    @Schema(description = "변경할결재상태코드, Type3 만 사용", example ="REQ,REJ,INP,APV,CCL")
    private String aprReqProgStatCd;
    @Schema(description = "연동할결재라인순번, Type3 만 사용", example ="1,2,3...")
    private long aprLnSeq;
    @Schema(description = "전자결재문서번호", example ="GEA-0000921682")
    private String eaprDocNo;

    public static ApprovalRequestIdRequestVO of (String aprReqId){
        return ApprovalRequestIdRequestVO.builder().aprReqId(aprReqId).aprLnSeq(1).build();
    }

    public static ApprovalRequestIdRequestVO of (String aprReqId, long aprLnSeq){
        return ApprovalRequestIdRequestVO.builder().aprReqId(aprReqId).aprLnSeq(aprLnSeq).build();
    }

    public static ApprovalRequestIdRequestVO of (String aprReqId, String aprReqProgStatCd, long aprLnSeq){
        return ApprovalRequestIdRequestVO.builder()
                .aprReqId(aprReqId)
                .aprReqProgStatCd(aprReqProgStatCd)
                .aprLnSeq(aprLnSeq)
                .build();
    }

    public boolean isStatusRequest(){
        return ApprovalRequestProgressStatus.REQUEST.equals(aprReqProgStatCd);
    }

    public boolean isStatusInProgress(){
        return ApprovalRequestProgressStatus.IN_PROGRESS.equals(aprReqProgStatCd);
    }

    public boolean isStatusComplete(){
        return ApprovalRequestProgressStatus.COMPLETE.equals(aprReqProgStatCd);
    }

    public boolean isStatusReject(){
        return ApprovalRequestProgressStatus.REJECT.equals(aprReqProgStatCd);
    }

    public boolean isStatusCancel(){
        return ApprovalRequestProgressStatus.CANCEL.equals(aprReqProgStatCd);
    }
}