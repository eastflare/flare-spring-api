package com.flare.rap.approval.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.ApprovalDelegateRequestVO;
import com.flare.rap.approval.model.ApprovalDelegateResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApprovalDelegateRepository {

    List<ApprovalDelegateResponseVO> selectApprovalDelegates(@Param("aprDlgtUserId") String aprDlgtUserId, @Param("statusFlag") String statusFlag, @Param("session") UserSessionVO userSession);

    ApprovalDelegateResponseVO selectApprovalDelegatesForOne(@Param("aprDlgtNo") long aprDlgtNo, @Param("session") UserSessionVO userSession);

    List<String> selectDlgtDuplicateCheck(@Param("approvalDelegates") ApprovalDelegateRequestVO approvalDelegates);

    int updateApprovalDelegate(@Param("approvalDelegates") ApprovalDelegateRequestVO approvalDelegates, @Param("session") UserSessionVO userSession);

    int insertApprovalDelegate(@Param("approvalDelegates") ApprovalDelegateRequestVO approvalDelegates, @Param("session") UserSessionVO userSession);

}