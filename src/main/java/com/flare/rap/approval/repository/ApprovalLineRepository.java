package com.flare.rap.approval.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.*;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApprovalLineRepository {

    int insertApprovalLineMaster(@Param("approvalLineMaster") ApprovalLineRequestVO approvalLineRequestVO, @Param("session") UserSessionVO userSessionVO);

    int insertApprovalLineNoticeUserByDelegate(@Param("approvalLineDelegate") ApprovalLineDelegateResponseVO approvalLineDelegateResponseVO, @Param("session") UserSessionVO userSessionVO);

    int deleteApprovalLineMaster(String aprReqId);

    int updateApprovalLineToRequest(@Param("approvalLineUpdate") ApprovalLineRequestVO approvalLineRequestVO, @Param("session") UserSessionVO userSessionVO);

    int updateApprovalLineDelegate(@Param("approvalLineDelegate") ApprovalLineDelegateResponseVO approvalLineDelegateResponseVO, @Param("session") UserSessionVO userSessionVO);

    int updateApprovalLineSelfApproved(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSessionVO);

    int updateApprovalLineAfterReject(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSessionVO);

    int updateApprovalLineApprove(@Param("approvalLine") ApprovalLineRequestVO approvalLineRequestVO, @Param("session") UserSessionVO userSession);

    int updateType2ApprovalLine(@Param("approvalLine") ApprovalLineType2UpdateRequestVO approvalLine);

    int updateType2ApprovalLineEmpNoToUserId(String aprReqId);

    int updateApprovalLineToCancel(@Param("approval") ApprovalRequestIdRequestVO approvalRequestId, @Param("session") UserSessionVO userSession);

    int updateType3ApprovalLineToComplete(@Param("approval") ApprovalRequestIdRequestVO approvalRequestId, @Param("session") UserSessionVO userSession);

    int selectApprovalLineDelegatorCount(@Param("approvalLineDelegate") ApprovalLineDelegateResponseVO approvalLineDelegateResponseVO);

    int selectCheckRejectCount(String aprReqId);

    String selectGetAllApproveYn(String aprReqId);

    ApprovalLineResponseVO selectLastApprovalLineStatus(String aprReqId);

    ApprovalLineCheckResponseVO selectApprovalLineCheck(@Param("approvalLine") ApprovalLineRequestVO approvalLineRequestVO, @Param("session") UserSessionVO userSession);

    List<ApprovalLineRequestVO> selectApprovalLineMaster(String aprReqId );

    List<ApprovalMobileApproversVO> selectApprovalLineMasterForMobile(@Param("approval") ApprovalRequestIdRequestVO approvalRequestIdRequestVO, @Param("session") UserSessionVO userSession);

    long selectCancelApprovalLine(String aprReqId);

    List<ApprovalLineDelegateResponseVO> selectApproveLineDelegateList(@Param("aprReqId") String aprReqId, @Param("session") UserSessionVO userSession);

}