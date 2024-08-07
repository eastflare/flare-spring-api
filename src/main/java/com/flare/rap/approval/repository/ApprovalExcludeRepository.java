package com.flare.rap.approval.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.ApprovalExcludeDetailRequestVO;
import com.flare.rap.approval.model.ApprovalExcludeDetailVO;
import com.flare.rap.approval.model.ApprovalExcludeMasterRequestVO;
import com.flare.rap.approval.model.ApprovalExcludeMasterVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApprovalExcludeRepository {
    List<ApprovalExcludeMasterVO> selectApprovalExcludeMasters(String aprExcNm);

    List<ApprovalExcludeDetailVO> selectApprovalExcludeDetails(@Param("aprExcTgtId") long aprExcTgtId, @Param("session") UserSessionVO session);

    long selectMaxMasterId();

    int insertApprovalExcludeMaster(@Param("master") ApprovalExcludeMasterRequestVO master, @Param("session") UserSessionVO session);

    int updateApprovalExcludeMaster(@Param("master") ApprovalExcludeMasterRequestVO master, @Param("session") UserSessionVO session);

    int deleteApprovalExcludeMaster(@Param("aprExcTgtId") long aprExcTgtId);

    int deleteDetailsByAprExcTgtId(@Param("aprExcTgtId") long aprExcTgtId);

    int insertApprovalExcludeDetail(@Param("detail") ApprovalExcludeDetailRequestVO detail, @Param("session") UserSessionVO session);

    int updateApprovalExcludeDetail(@Param("detail") ApprovalExcludeDetailRequestVO detail, @Param("session") UserSessionVO session);

    int deleteApprovalExcludeDetail(@Param("detail") ApprovalExcludeDetailRequestVO detail);

}