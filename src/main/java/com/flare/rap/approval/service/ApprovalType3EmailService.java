package com.flare.rap.approval.service;

import com.flare.rap.approval.model.ApprovalNextMailResponseVO;
import com.flare.rap.approval.model.ApprovalType3MailSendRequestVO;

public interface ApprovalType3EmailService {


    /**
     * sendRequestMail
     *   => Type3 전용, 현재 결재순번을 받아 다음 결재라인을 찾아서 승인 요청 메일을 발송
     *   => 결재요청번호, 결재순번, 언어코드
     *   Return : 1 : 성공, 0 or -1 : 실패
     */
    int sendRequestMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO);

    /**
     * sendRejectMail
     *   => Type3 전용, 현재 결재에 대해 반려메일을 보냄
     *   => 결재요청번호, 결재순번, 언어코드
     *   Return : 1 : 성공, 0 or -1 : 실패
     */
    int sendRejectMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO);

    /**
     * sendApprovedMail
     *   => Type3 전용, 현재 결재에 대해 최종 승인 메일을 보냄
     *   => 결재요청번호, 언어코드
     *   Return : 1 : 성공, 0 or -1 : 실패
     */
    int sendApprovedMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO);


    /**
     * sendNoticeMail
     *   => Type3 전용, 현재 결재에 대해 최종 승인 통보메일을 보냄
     *   => 결재요청번호, 언어코드
     *   Return : 통보자수만큼,  -1 : 실패
     */
    int sendNoticeMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO);
}