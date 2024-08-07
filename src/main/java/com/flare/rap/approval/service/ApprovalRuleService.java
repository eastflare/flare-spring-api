package com.flare.rap.approval.service;

import java.util.List;

import com.flare.rap.approval.model.ApprovalRuleDetailRequestVO;
import com.flare.rap.approval.model.ApprovalRuleDetailResponseVO;
import com.flare.rap.approval.model.ApprovalRuleMasterRequestVO;
import com.flare.rap.approval.model.ApprovalRuleMasterResponseVO;
import com.flare.rap.approval.model.BaseApprovalLineResponseVO;
import com.flare.rap.common.model.DmlResponseVO;

public interface ApprovalRuleService {

    List<ApprovalRuleMasterResponseVO> findApprovalRuleMasters(String aprRuleId, String searchRuleNm);

    DmlResponseVO saveApprovalRuleMaster(ApprovalRuleMasterRequestVO approvalRuleMaster);
    List<ApprovalRuleDetailResponseVO> findApprovalRuleDetails(String aprRuleId);

    DmlResponseVO saveApprovalRuleDetails(List<ApprovalRuleDetailRequestVO> approvalRuleDetails);

    List<BaseApprovalLineResponseVO> findBaseApprovalLine(String aprRuleId);

    List<BaseApprovalLineResponseVO> findBaseApprovalNtdkByAprRuleId(String aprRuleId);



}