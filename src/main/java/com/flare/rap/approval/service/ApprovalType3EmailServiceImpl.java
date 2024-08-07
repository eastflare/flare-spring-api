package com.flare.rap.approval.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flare.rap.approval.constant.ApprovalProgressStatus;
import com.flare.rap.approval.model.ApprovalLineResponseVO;
import com.flare.rap.approval.model.ApprovalNextMailResponseVO;
import com.flare.rap.approval.model.ApprovalType3ApprovedMailSendContentVO;
import com.flare.rap.approval.model.ApprovalType3MailSendRequestVO;
import com.flare.rap.approval.model.ApprovalType3RejectedMailSendContentVO;
import com.flare.rap.approval.model.ApprovalType3RequestMailSendContentVO;
import com.flare.rap.approval.repository.ApprovalType3MailSendRepository;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.mail.model.MailVO;
import com.flare.rap.mail.service.MailService;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalType3EmailServiceImpl implements ApprovalType3EmailService {
    private final ApprovalType3MailSendRepository approvalType3MailSendRepository;
    private final MailService mailService;

    @Override
    public int sendRequestMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO) {

        ApprovalNextMailResponseVO approvalNextMail = this.findNextApprovalMail(approvalType3MailSendRequestVO);

        if( approvalNextMail == null || approvalNextMail.hasSentMail()) {
            return 0;
        }

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        ApprovalType3RequestMailSendContentVO requestMailVO =
                approvalType3MailSendRepository.selectApprovalRequestMailSendInfo(approvalType3MailSendRequestVO,
                        userSession);
        if(!ValidateUtil.isEmpty(requestMailVO)){
            MailVO mailVO = this.makeRequestMailVO(approvalType3MailSendRequestVO.getAprReqId(), requestMailVO);

            int emlSndoSeq = mailService.sendMail(mailVO);
            if(emlSndoSeq > 0) {
                approvalType3MailSendRepository.updateApprovalLineEmlSndoSeq(approvalNextMail, emlSndoSeq);
            }

            return emlSndoSeq;
        }

        return 0;
    }

    private ApprovalNextMailResponseVO findNextApprovalMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO) {

        ApprovalLineResponseVO currentApprovalLine =
                approvalType3MailSendRepository.selectApprovalLineOneBySeq(approvalType3MailSendRequestVO);

        // 기안 상태면 현재(첫번째) 결재자에게 메일을 발송해야함.
        if(ValidateUtil.isEmpty(currentApprovalLine.getAprPsgStatCd()) ||
                ApprovalProgressStatus.WAIT.equals(currentApprovalLine.getAprPsgStatCd())) {
            return ApprovalNextMailResponseVO.builder()
                    .aprReqId(currentApprovalLine.getAprReqId())
                    .aprLnSeq(currentApprovalLine.getAprLnSeq())
                    .aprLnSnb(currentApprovalLine.getAprLnSnb())
                    .grnrAprTpDivsCd(currentApprovalLine.getGrnrAprTpDivsCd())
                    .prlYn(currentApprovalLine.getPrlYn())
                    .aprAprvUserId(currentApprovalLine.getAprAprvUserId())
                    .emlSndoSeq(currentApprovalLine.getEmlSndoSeq())
                    .build();
        }

        return approvalType3MailSendRepository.selectNextApprovalMail(approvalType3MailSendRequestVO);
    }

    private MailVO makeRequestMailVO(String aprReqId, ApprovalType3RequestMailSendContentVO requestMailVO){
        String mailContent = mailService.makeTemplate("ApprovalType3Request", requestMailVO);
        mailContent = this.removeUnsupportedCharacter(mailContent);

        MailVO mailVO = new MailVO();
        mailVO.setFromAddress(requestMailVO.getFromAddress());
        mailVO.setSubject(requestMailVO.getSubject());
        mailVO.setContent(mailContent);
        mailVO.setToAddressList(List.of(requestMailVO.getToAddress()));
        mailVO.setUseHtmlYn(true);
        mailVO.setEmlTpCd("APPROVAL-REQUEST");
        mailVO.setAprReqId(aprReqId);

        return mailVO;
    }

    @Override
    public int sendRejectMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalType3RejectedMailSendContentVO rejectMailVO =
                approvalType3MailSendRepository.selectApprovalRejectMailSendInfo(approvalType3MailSendRequestVO,
                        userSession);

        if(!ValidateUtil.isEmpty(rejectMailVO)){
            MailVO mailVO = this.makeRejectMailVO(approvalType3MailSendRequestVO.getAprReqId(), rejectMailVO);
            return mailService.sendMail(mailVO);
        }
        return 0;
    }

    private MailVO makeRejectMailVO(String aprReqId, ApprovalType3RejectedMailSendContentVO rejectMailVO){
        String mailContent = mailService.makeTemplate("ApprovalType3Rejected", rejectMailVO);
        mailContent = this.removeUnsupportedCharacter(mailContent);

        MailVO mailVO = new MailVO();
        mailVO.setFromAddress(rejectMailVO.getFromAddress());
        mailVO.setSubject(rejectMailVO.getSubject());
        mailVO.setContent(mailContent);
        mailVO.setToAddressList(List.of(rejectMailVO.getToAddress()));
        mailVO.setUseHtmlYn(true);
        mailVO.setEmlTpCd("APPROVAL-REJECT");
        mailVO.setAprReqId(aprReqId);

        return mailVO;
    }

    @Override
    public int sendApprovedMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalType3ApprovedMailSendContentVO approvedMailVO =
                approvalType3MailSendRepository.selectApprovalApprovedMailSendInfo(approvalType3MailSendRequestVO,
                        userSession);

        if(!ValidateUtil.isEmpty(approvedMailVO)){
            MailVO mailVO = this.makeApprovedMailVO(approvalType3MailSendRequestVO.getAprReqId(), approvedMailVO);
            return mailService.sendMail(mailVO);
        }
        return 0;
    }

    private MailVO makeApprovedMailVO(String aprReqId, ApprovalType3ApprovedMailSendContentVO approvedMailVO){
        String mailContent = mailService.makeTemplate("ApprovalType3Approved", approvedMailVO);
        mailContent = this.removeUnsupportedCharacter(mailContent);

        MailVO mailVO = new MailVO();
        mailVO.setFromAddress(approvedMailVO.getFromAddress());
        mailVO.setSubject(approvedMailVO.getSubject());
        mailVO.setContent(mailContent);
        mailVO.setToAddressList(List.of(approvedMailVO.getToAddress()));
        mailVO.setUseHtmlYn(true);
        mailVO.setEmlTpCd("APPROVAL-APPROVED");
        mailVO.setAprReqId(aprReqId);

        return mailVO;
    }

    @Override
    public int sendNoticeMail(ApprovalType3MailSendRequestVO approvalType3MailSendRequestVO) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        List<String> mailReceiverList = approvalType3MailSendRepository.selectNoticeMailMailList(approvalType3MailSendRequestVO);
        if(ValidateUtil.isEmpty(mailReceiverList)) return 0;

        // 통보자 메일 발송 정보 조회
        ApprovalType3ApprovedMailSendContentVO approvedMailVO = approvalType3MailSendRepository.selectApprovalNoticeMailSendInfo(approvalType3MailSendRequestVO, userSession);
        if(!ValidateUtil.isEmpty(approvedMailVO)){
            String mailContent = mailService.makeTemplate("ApprovalType3Notice", approvedMailVO);
            mailContent = this.removeUnsupportedCharacter(mailContent);

            MailVO mailVO = new MailVO();
            mailVO.setFromAddress(approvedMailVO.getFromAddress());
            mailVO.setSubject(approvedMailVO.getSubject());
            mailVO.setContent(mailContent);
            mailVO.setToAddressList(mailReceiverList);
            mailVO.setUseHtmlYn(true);
            mailVO.setEmlTpCd("APPROVAL-NOTICE");
            mailVO.setAprReqId(approvalType3MailSendRequestVO.getAprReqId());

            mailService.sendMail(mailVO);

            return mailReceiverList.size();
        }
        return 0;
    }

    private MailVO makeNoticeMailVO(String aprReqId, ApprovalType3ApprovedMailSendContentVO approvedMailVO,
                                    List<String> mailReceiverList){
        String mailContent = mailService.makeTemplate("ApprovalType3Notice", approvedMailVO);
        mailContent = this.removeUnsupportedCharacter(mailContent);

        MailVO mailVO = new MailVO();
        mailVO.setFromAddress(approvedMailVO.getFromAddress());
        mailVO.setSubject(approvedMailVO.getSubject());
        mailVO.setContent(mailContent);
        mailVO.setToAddressList(mailReceiverList);
        mailVO.setUseHtmlYn(true);
        mailVO.setEmlTpCd("APPROVAL-NOTICE");
        mailVO.setAprReqId(aprReqId);

        return mailVO;
    }

    private String removeUnsupportedCharacter(String content){
        content = content.replaceAll("[^\\u0009\\u000A\\u000D\\u0020-\\uD7FF\\uE000-\\uFFFD\\u10000-\\u10FFF]+", "");
        content = content.replaceAll("<!DOCTYPE html>","");

        return content;
    }
}