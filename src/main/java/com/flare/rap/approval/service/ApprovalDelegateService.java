package com.flare.rap.approval.service;

import java.util.List;

import com.flare.rap.approval.model.ApprovalDelegateRequestVO;
import com.flare.rap.approval.model.ApprovalDelegateResponseVO;
import com.flare.rap.common.model.DmlResponseVO;

public interface ApprovalDelegateService {

    List<ApprovalDelegateResponseVO> findApprovalDelegates(String aprDlgtUserId, String statusFlag);

    DmlResponseVO saveApprovalDelegates(List<ApprovalDelegateRequestVO> approvalDelegates);

}