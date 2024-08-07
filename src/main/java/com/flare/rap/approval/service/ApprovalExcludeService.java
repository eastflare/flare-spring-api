package com.flare.rap.approval.service;

import java.util.List;

import com.flare.rap.approval.model.ApprovalExcludeDetailRequestVO;
import com.flare.rap.approval.model.ApprovalExcludeDetailVO;
import com.flare.rap.approval.model.ApprovalExcludeMasterRequestVO;
import com.flare.rap.approval.model.ApprovalExcludeMasterVO;
import com.flare.rap.approval.model.ApprovalExcludeResponseVO;
import com.flare.rap.common.model.DmlResponseVO;

public interface ApprovalExcludeService {
    List<ApprovalExcludeMasterVO> findApprovalExcludeMasters(String aprExcNm);
    List<ApprovalExcludeDetailVO> findApprovalExcludeDetails(long aprExcTgtId);
    ApprovalExcludeResponseVO saveApprovalExclude(List<ApprovalExcludeMasterRequestVO> masters, List<ApprovalExcludeDetailRequestVO> details);
    ApprovalExcludeResponseVO deleteApprovalExclude(long aprExcTgtId);
    }