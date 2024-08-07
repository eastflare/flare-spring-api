package com.flare.rap.approval.service;

import java.util.List;

import com.flare.rap.approval.model.ApprovalTemplateVO;

public interface ApprovalTemplateService {

    List<ApprovalTemplateVO> findApprovalTemplate(String aprTplNm);

    int createApprovalTemplate(ApprovalTemplateVO approvalTemplateVO);

    int modifyApprovalTemplate(ApprovalTemplateVO approvalTemplateVO);

    int removeApprovalTemplate(String aprTplId);

}