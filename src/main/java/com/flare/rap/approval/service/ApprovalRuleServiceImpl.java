package com.flare.rap.approval.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.constant.ApprovalLineRoleConstants;
import com.flare.rap.approval.constant.ApprovalTypeConstants;
import com.flare.rap.approval.model.ApprovalRuleDetailRequestVO;
import com.flare.rap.approval.model.ApprovalRuleDetailResponseVO;
import com.flare.rap.approval.model.ApprovalRuleMasterRequestVO;
import com.flare.rap.approval.model.ApprovalRuleMasterResponseVO;
import com.flare.rap.approval.model.BaseApprovalLineResponseVO;
import com.flare.rap.approval.repository.ApprovalRuleRepository;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.StringUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalRuleServiceImpl implements ApprovalRuleService {

    private final ApprovalRuleRepository approvalRuleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ApprovalRuleMasterResponseVO> findApprovalRuleMasters(
            String aprRuleId,
            String searchRuleNm) {
        return approvalRuleRepository.selectApprovalRuleMasters(aprRuleId, searchRuleNm);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public DmlResponseVO saveApprovalRuleMaster(ApprovalRuleMasterRequestVO approvalRuleMaster) {

        DmlResponseVO dmlResponseVO = new DmlResponseVO();

        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        if (StringUtil.isEmpty(approvalRuleMaster.getAprRuleId())) {
            int cnt = approvalRuleRepository.insertApprovalRuleMaster(approvalRuleMaster, userSession);
            dmlResponseVO.setInsertedRows(cnt);
        } else {
            int cnt = approvalRuleRepository.updateApprovalRuleMaster(approvalRuleMaster, userSession);
            dmlResponseVO.setUpdatedRows(cnt);
        }
        return dmlResponseVO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApprovalRuleDetailResponseVO> findApprovalRuleDetails(
            String aprRuleId) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return approvalRuleRepository.selectApprovalRuleDetails(aprRuleId, userSession);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public DmlResponseVO saveApprovalRuleDetails(List<ApprovalRuleDetailRequestVO> approvalRuleDetails) {
        List<ApprovalRuleDetailRequestVO> saveDetailList = new ArrayList<>();
        int aprLnSeq = 0, aprLnSnb = 0;
        for (int i = 0; i < approvalRuleDetails.size(); i++) {
            if (approvalRuleDetails.get(i).getCrudKey() != null && approvalRuleDetails.get(i).getCrudKey().equals("D")) {
                continue;
            }
            if (i > 0 && isParallelAgreement(approvalRuleDetails.get(i - 1), approvalRuleDetails.get(i))) {
                approvalRuleDetails.get(i).setAprLnSnb(aprLnSnb);
            } else {
                approvalRuleDetails.get(i).setAprLnSnb(++aprLnSnb);
            }
            approvalRuleDetails.get(i).setAprLnSeq(++aprLnSeq);
            saveDetailList.add(approvalRuleDetails.get(i));
        }

        int deleted = approvalRuleRepository.deleteApprovalRuleDetails(approvalRuleDetails.get(0).getAprRuleId());
        int inserted = approvalRuleRepository.insertApprovalRuleDetails(saveDetailList, SessionScopeUtil.getContextSession());

        return DmlResponseVO.builder().deletedRows(deleted).insertedRows(inserted).build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BaseApprovalLineResponseVO> findBaseApprovalLine(String aprRuleId) {

        List<ApprovalRuleDetailResponseVO> approvalRuleDetails =
                approvalRuleRepository.selectApprovalRuleDetails(aprRuleId, SessionScopeUtil.getContextSession());

        List<BaseApprovalLineResponseVO> baseApprovalLines = new ArrayList<BaseApprovalLineResponseVO>();
        int aprLnSnb = 0, aprLnSeq = 0;
        for (ApprovalRuleDetailResponseVO approvalRuleDetail : approvalRuleDetails) {
            BaseApprovalLineResponseVO baseApprovalLine = getBaseApprovalLine(approvalRuleDetail);
            if (ValidateUtil.isEmpty(baseApprovalLine)) continue;

            if (aprLnSnb > 0 && isParallelAgreement(baseApprovalLines.get(aprLnSeq - 1), baseApprovalLine)) {
                baseApprovalLine.setAprLnSnb(aprLnSnb);
            } else {
                baseApprovalLine.setAprLnSnb(++aprLnSnb);
            }
            baseApprovalLine.setAprLnSeq(++aprLnSeq);
            baseApprovalLines.add(baseApprovalLine);
        }

        return baseApprovalLines;

    }

    private boolean isParallelAgreement(ApprovalRuleDetailRequestVO previousRule,
                                        ApprovalRuleDetailRequestVO currentRule) {
        return ApprovalTypeConstants.AGREEMENT.equals(previousRule.getAprTpDivsCd()) &&
                ApprovalTypeConstants.AGREEMENT.equals(currentRule.getAprTpDivsCd()) &&
                "Y".equals(previousRule.getPrlYn()) &&
                "Y".equals(currentRule.getPrlYn());
    }

    private boolean isParallelAgreement(BaseApprovalLineResponseVO previousRule,
                                        BaseApprovalLineResponseVO currentRule) {
        return ApprovalTypeConstants.AGREEMENT.equals(previousRule.getAprTpDivsCd()) &&
                ApprovalTypeConstants.AGREEMENT.equals(currentRule.getAprTpDivsCd()) &&
                "Y".equals(previousRule.getPrlYn()) &&
                "Y".equals(currentRule.getPrlYn());
    }

    private BaseApprovalLineResponseVO getBaseApprovalLine(ApprovalRuleDetailResponseVO approvalRuleDetailResponseVO) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        if (ApprovalLineRoleConstants.USER.equals(approvalRuleDetailResponseVO.getAprLnRoleCd())) {
            return approvalRuleRepository.selectBaseApprovalLineUser(approvalRuleDetailResponseVO, userSession);
        } else if (ApprovalLineRoleConstants.DEPT.equals(approvalRuleDetailResponseVO.getAprLnRoleCd())) {
            return approvalRuleRepository.selectBaseApprovalLineDept(approvalRuleDetailResponseVO, userSession);
        } else if (ApprovalLineRoleConstants.UPPR1.equals(approvalRuleDetailResponseVO.getAprLnRoleCd())) {
            return approvalRuleRepository.selectBaseApprovalLineUppr1(approvalRuleDetailResponseVO, userSession);
        } else if (ApprovalLineRoleConstants.UPPR2.equals(approvalRuleDetailResponseVO.getAprLnRoleCd())) {
            return approvalRuleRepository.selectBaseApprovalLineUppr2(approvalRuleDetailResponseVO, userSession);
        } else { // 자가 승인
            return approvalRuleRepository.selectBaseApprovalLineSelf(approvalRuleDetailResponseVO, userSession);
        }
    }

    @Override
    public List<BaseApprovalLineResponseVO> findBaseApprovalNtdkByAprRuleId(String aprRuleId) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return approvalRuleRepository.selectBaseApprovalNtdkByAprRuleId(aprRuleId, userSession);
    }
}