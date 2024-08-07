package com.flare.rap.approval.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.ApprovalRuleDetailRequestVO;
import com.flare.rap.approval.model.ApprovalRuleDetailResponseVO;
import com.flare.rap.approval.model.ApprovalRuleMasterRequestVO;
import com.flare.rap.approval.model.ApprovalRuleMasterResponseVO;
import com.flare.rap.approval.model.BaseApprovalLineResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApprovalRuleRepository {

    List<ApprovalRuleMasterResponseVO> selectApprovalRuleMasters(@Param("aprRuleId") String aprRuleId, @Param("searchRuleNm") String searchRuleNm);

    int insertApprovalRuleMaster(@Param("approvalRuleMaster") ApprovalRuleMasterRequestVO approvalRuleMaster, @Param("session") UserSessionVO userSession);

    int updateApprovalRuleMaster(@Param("approvalRuleMaster") ApprovalRuleMasterRequestVO approvalRuleMaster, @Param("session") UserSessionVO userSession);

//    int upsertApprovalRuleMaster(@Param("approvalRuleMaster") ApprovalRuleMasterRequestVO approvalRuleMaster, @Param("session") UserSessionVO userSession);

    List<ApprovalRuleDetailResponseVO> selectApprovalRuleDetails(@Param("aprRuleId") String aprRuleId, @Param("session") UserSessionVO userSession);

    int deleteApprovalRuleDetails(String aprRuleId);

    int insertApprovalRuleDetails(@Param("approvalRuleDetails") List<ApprovalRuleDetailRequestVO> approvalRuleDetails, @Param("session") UserSessionVO userSession);

    BaseApprovalLineResponseVO selectBaseApprovalLineUser(@Param("approvalRule") ApprovalRuleDetailResponseVO approvalRuleDetail, @Param("session") UserSessionVO userSession);

    BaseApprovalLineResponseVO selectBaseApprovalLineDept(@Param("approvalRule") ApprovalRuleDetailResponseVO approvalRuleDetail, @Param("session") UserSessionVO userSession);

    BaseApprovalLineResponseVO selectBaseApprovalLineUppr1(@Param("approvalRule") ApprovalRuleDetailResponseVO approvalRuleDetail, @Param("session") UserSessionVO userSession);

    BaseApprovalLineResponseVO selectBaseApprovalLineUppr2(@Param("approvalRule") ApprovalRuleDetailResponseVO approvalRuleDetail, @Param("session") UserSessionVO userSession);

    BaseApprovalLineResponseVO selectBaseApprovalLineSelf(@Param("approvalRule") ApprovalRuleDetailResponseVO approvalRuleDetail, @Param("session") UserSessionVO userSession);

    List<BaseApprovalLineResponseVO> selectBaseApprovalNtdkByAprRuleId(@Param("aprRuleId") String aprRuleId, @Param("session") UserSessionVO userSession);

}