package com.flare.rap.approval.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.ApprovalLineResponseVO;
import com.flare.rap.approval.model.ApprovalNextMailResponseVO;
import com.flare.rap.approval.model.ApprovalType3ApprovedMailSendContentVO;
import com.flare.rap.approval.model.ApprovalType3MailSendRequestVO;
import com.flare.rap.approval.model.ApprovalType3RejectedMailSendContentVO;
import com.flare.rap.approval.model.ApprovalType3RequestMailSendContentVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApprovalType3MailSendRepository {

    ApprovalLineResponseVO selectApprovalLineOneBySeq(@Param("approvalRequestId") ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO);

    ApprovalNextMailResponseVO selectNextApprovalMail(@Param("approvalRequestId") ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO);

    ApprovalType3RequestMailSendContentVO selectApprovalRequestMailSendInfo(@Param("approvalRequestId") ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO, @Param("session") UserSessionVO userSessionVO );

    int updateApprovalLineEmlSndoSeq(@Param("nextApprovalLine") ApprovalNextMailResponseVO approvalNextMailResponseVO, long emlSndoSeq);

    ApprovalType3RejectedMailSendContentVO selectApprovalRejectMailSendInfo(@Param("approvalRequestId") ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO, @Param("session") UserSessionVO userSessionVO );

    ApprovalType3ApprovedMailSendContentVO selectApprovalApprovedMailSendInfo(@Param("approvalRequestId") ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO, @Param("session") UserSessionVO userSessionVO );

    ApprovalType3ApprovedMailSendContentVO selectApprovalNoticeMailSendInfo(@Param("approvalRequestId") ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO, @Param("session") UserSessionVO userSessionVO );

    List<String> selectNoticeMailMailList(@Param("approvalRequestId") ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO);

}