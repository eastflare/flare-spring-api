package com.flare.rap.approval.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.model.ApprovalTemplateVO;
import com.flare.rap.approval.repository.ApprovalTemplateRepository;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalTemplateServiceImpl implements ApprovalTemplateService {

    private final ApprovalTemplateRepository approvalTemplateRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ApprovalTemplateVO> findApprovalTemplate(String aprTplNm){
        List<ApprovalTemplateVO> approvalTemplates = approvalTemplateRepository.selectApprovalTemplateByAprTplNm(aprTplNm);

        for(ApprovalTemplateVO aprvTmp : approvalTemplates){
            aprvTmp.setPrsDesc(ValidateUtil.charUnescape(aprvTmp.getPrsDesc()));
            aprvTmp.setWcstDesc(ValidateUtil.charUnescape(aprvTmp.getWcstDesc()));
        }

        return approvalTemplates;
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int createApprovalTemplate(ApprovalTemplateVO approvalTemplateVO){
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        return approvalTemplateRepository.insertApprovalTemplate(approvalTemplateVO, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int modifyApprovalTemplate(ApprovalTemplateVO approvalTemplateVO){
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        return approvalTemplateRepository.updateApprovalTemplate(approvalTemplateVO, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int removeApprovalTemplate(String aprTplId){
        return approvalTemplateRepository.deleteApprovalTemplate(aprTplId);
    }
}