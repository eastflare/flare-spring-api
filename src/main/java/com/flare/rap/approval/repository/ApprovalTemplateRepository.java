package com.flare.rap.approval.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.ApprovalTemplateVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApprovalTemplateRepository {

    List<ApprovalTemplateVO> selectApprovalTemplateByAprTplNm(String aprTplNm);

    int insertApprovalTemplate(@Param("approvalTemplate") ApprovalTemplateVO approvalTemplateVO, @Param("session") UserSessionVO userSessionVO);

    int updateApprovalTemplate(@Param("approvalTemplate") ApprovalTemplateVO approvalTemplateVO, @Param("session") UserSessionVO userSessionVO);

    int deleteApprovalTemplate(String aprTpId);
}