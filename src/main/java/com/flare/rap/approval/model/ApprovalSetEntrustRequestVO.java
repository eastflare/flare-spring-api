package com.flare.rap.approval.model;

import com.flare.rap.webservice.model.WebServiceRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalSetEntrustRequestVO implements WebServiceRequest {
    @Schema(description = "API유형", example = "(A01:위임정보 등록,A02:위임정보 삭제)")
    private String apiType;
    @Schema(description = "위임자 사번", example = "")
    private String reqUser;
    @Schema(description = "수임자 사번", example = "")
    private String signUser;
    @Schema(description = "위임 시작일", example = "2018.05.26")
    private String startDate;
    @Schema(description = "위임 종료일", example = "2018.05.31")
    private String endDate;
    @Schema(description = "Legacy시스템ID", example = "")
    private String systemId;
}