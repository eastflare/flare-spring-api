package com.flare.rap.approval.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalRequestVO {
    ApprovalRequestMasterRequestVO approvalRequestMasterRequest;
    List<ApprovalLineRequestVO> approvalLineRequests;
}