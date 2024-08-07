package com.flare.rap.approval.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.*;
import com.flare.rap.approval.model.ApprovalLineCheckResponseVO;
import com.flare.rap.approval.model.ApprovalLineResponseVO;
import com.flare.rap.approval.model.ApprovalLineType2UpdateRequestVO;
import com.flare.rap.approval.model.ApprovalMobileApproversVO;
import com.flare.rap.approval.model.ApprovalMobileFilesVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApprovalRequestRepository {

    int insertApprovalRequestMaster(@Param("approvalRequestMaster") ApprovalRequestMasterRequestVO approvalRequestMasterRequestVO, @Param("session") UserSessionVO userSessionVO);

    int updateApprovalRequestMasterToRequest(@Param("approvalRequestMasterUpdate") ApprovalRequestMasterRequestVO approvalRequestMasterRequestVO, @Param("session") UserSessionVO userSessionVO);

    int updateApprovalRequestMasterStatus(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSessionVO);

    ApprovalRequestMasterResponseVO selectApprovalRequestMasterForRequest(@Param("approvalRequestId") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSession);

    ApprovalRequestMasterResponseVO selectApprovalInfoForIf(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSession);

    String selectSelfApprovalAvailable(String aprReqId);

    String selectGetApprovalRequestMasterId();

    ApprovalRequestMasterResponseVO selectApprovalRequestMaster(@Param("approvalRequestId") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSession);

    List<ApprovalMobileFilesVO> selectApprovalAprFileForMobile(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO);

    String selectCancelAvailableCheck(@Param("aprReqId") String aprReqId, @Param("session") UserSessionVO userSession);

    ApprovalLineRequestVO selectApprovalLineMasterWithSeq(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO);

    ApprovalLineRequestVO selectWaitApprovalLineByUserId(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSession);

}