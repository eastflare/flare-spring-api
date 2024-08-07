package com.flare.rap.mail.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.flare.rap.common.util.MailUtil;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.department.model.DepartmentRequestVO;
import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.department.service.DepartmentService;
import com.flare.rap.log.model.EmailLogResponseVO;
import com.flare.rap.log.model.EmailSendLogVO;
import com.flare.rap.log.service.LogService;
import com.flare.rap.mail.model.AttachFileVO;
import com.flare.rap.mail.model.MailRequestVO;
import com.flare.rap.mail.model.MailVO;
import com.flare.rap.mail.repository.EmailSendQueRepository;
import com.flare.rap.session.model.UserSessionVO;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeUtility;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Autowired
    MessageSource messageSource;

    private final DepartmentService departmentService;
    private final LogService logService;

    private final EmailSendQueRepository emailSendQueRepository;
    @Override
    public MailVO parseMailRequest(MailRequestVO mailRequest) {
        MailVO mailVO = new MailVO();

        List<String> toAddressList;
        List<String> ccAddressList;
        List<String> bccAddressList;

        if (ValidateUtil.isEmpty(mailRequest.getToAddress())) {
            toAddressList = Collections.emptyList();
        } else {
            toAddressList = Arrays.asList(mailRequest.getToAddress().split(","));
        }

        if (ValidateUtil.isEmpty(mailRequest.getCcAddress())) {
            ccAddressList = Collections.emptyList();
        } else {
            ccAddressList = Arrays.asList(mailRequest.getCcAddress().split(","));
        }

        if (ValidateUtil.isEmpty(mailRequest.getBccAddress())) {
            bccAddressList = Collections.emptyList();
        } else {
            bccAddressList = Arrays.asList(mailRequest.getBccAddress().split(","));
        }

        mailVO.setFromAddress(mailRequest.getFromAddress());
        mailVO.setFromAddressName(mailRequest.getFromAddressName());
        mailVO.setToAddressList(toAddressList);
        mailVO.setCcAddressList(ccAddressList);
        mailVO.setBccAddressList(bccAddressList);
        mailVO.setSubject(mailRequest.getSubject());
        mailVO.setContent(mailRequest.getContent());
        mailVO.setUseHtmlYn(true);


        return mailVO;
    }

    @Override
    public int sendMail(MailVO mailVO) {
        UserSessionVO session = SessionScopeUtil.getContextSession();
        long emlSeq  = emailSendQueRepository.selectEmlSndoQueSeq();

        String ccAddress = "";
        if (null != mailVO.getCcAddressList()) {
            ccAddress = String.join(",",  mailVO.getCcAddressList());
        }
        EmailSendLogVO emailSendQue = EmailSendLogVO.builder()
            .emlSndoSeq(emlSeq)
            .emlTpCd(mailVO.getEmlTpCd())
            .emlTitNm(mailVO.getSubject())
            .emlRcvrLstCtn(String.join(",",  mailVO.getToAddressList()))
            .sedEmal(mailVO.getFromAddress())
            .sedEmalNm(mailVO.getFromAddressName())
            .emlDtlCtn(mailVO.getContent())
            .aprReqId(mailVO.getAprReqId())
            .optValNm1(ccAddress)
            .build();
            if(session == null ) {
                session = UserSessionVO.builder()
                        .userId(emailSendQue.getDataInsUserId())
                        .userIp(emailSendQue.getDataInsUserIp())
                        .build();
            }
            emailSendQueRepository.insertEmailSendQue(emailSendQue, session);

        return (int)emlSeq;
    }
    @Override
    public int sendMailBatch() {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        int nResult = 0;
        List<EmailLogResponseVO> emailQue= emailSendQueRepository.selectEmailQueList();
        if (emailQue != null) {
            for (EmailLogResponseVO email : emailQue) {
                List<String> toAddressList = Arrays.asList(email.getEmlRcvrLstCtn().split(","));
                List<String> ccAddressList = new ArrayList<>();
                if(null != email.getOptValNm1())
                    ccAddressList = Arrays.asList(email.getOptValNm1().split(","));

                try {
                    InternetAddress[] toAddress = MailUtil.listToArray(toAddressList, "UTF-8");
                    InternetAddress[] ccAddress = MailUtil.listToArray(ccAddressList, "UTF-8");

                    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); // use multipart (true)
                    mimeMessageHelper.setSubject(MimeUtility.encodeText(email.getEmlTitNm(), "UTF-8", "B")); // Base64 encoding
                    mimeMessageHelper.setFrom(email.getSedEmal());
                    if(email.getSedEmal() == null){
                        Locale currentLocale = LocaleContextHolder.getLocale();
                        email.setSedEmalNm(messageSource.getMessage("tmpl.com.시스템명",null, currentLocale));
                    }
                    mimeMessageHelper.setFrom(new InternetAddress(email.getSedEmal(), email.getSedEmalNm(), "UTF-8"));
                    mimeMessageHelper.setTo(toAddress);
                    mimeMessageHelper.setCc(ccAddress);
                    mimeMessageHelper.setText(email.getEmlDtlCtn(), true);

                    logger.debug("***************" + mimeMessage);
                    javaMailSender.send(mimeMessage);
                    nResult = 1;
                    logger.info("MailServiceImpl.sendMail() :: SUCCESS");
                } catch (Exception e) {
                    logger.info("MailServiceImpl.sendMail() :: FAILED");
                    logger.debug(e.getMessage());
                    nResult = -1;
                } finally {
                    EmailSendLogVO emailSendque = EmailSendLogVO.builder()
                            .emlSndoSeq(email.getEmlSndoSeq())
                            .emlTrnmStatCd((nResult == 1 ? "SUCCESS" : "FAIL"))
                            .emlTrnmRltCtn("SENT")
                            .build();
                    emailSendQueRepository.updateEmailQue(emailSendque);

                    for (String toAddress : toAddressList) {
                        EmailSendLogVO emailSendLog = EmailSendLogVO.builder()
                                .emlSndoSeq(email.getEmlSndoSeq())
                                .emlTpCd(email.getEmlTpCd())
                                .emlRcvrLstCtn(toAddress)
                                .sedEmal(email.getSedEmal())
                                .emlTitNm(email.getEmlTitNm())
                                .emlTrnmStatCd((nResult == 1 ? "SUCCESS" : "FAIL"))
                                .emlTrnmRltCtn("SENT")
                                .optValNm1(email.getOptValNm1())
                                .emlBdyCtn(email.getEmlDtlCtn())
                                .aprReqId(email.getAprReqId())
                                .build();

                        logService.createEmailSendLog(emailSendLog);
                    }

                }
            }
        }
        return nResult;
    }

    @Override
    public int sendMailImmediately(MailVO mailVO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        int nResult = 0;
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            InternetAddress[] toAddress = MailUtil.listToArray(mailVO.getToAddressList(), "UTF-8");
            InternetAddress[] ccAddress = MailUtil.listToArray(mailVO.getCcAddressList(), "UTF-8");
            InternetAddress[] bccAddress = MailUtil.listToArray(mailVO.getBccAddressList(), "UTF-8");

            mimeMessageHelper.setSubject(MimeUtility.encodeText(mailVO.getSubject(), "UTF-8", "B"));
            if(mailVO.getFromAddressName() == null){
                Locale currentLocale = LocaleContextHolder.getLocale();
                mailVO.setFromAddressName(messageSource.getMessage("tmpl.com.시스템명",null, currentLocale));
            }
            mimeMessageHelper.setFrom(new InternetAddress(mailVO.getFromAddress(), mailVO.getFromAddressName(), "UTF-8"));
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setCc(ccAddress);
            mimeMessageHelper.setBcc(bccAddress);
            mimeMessageHelper.setText(mailVO.getContent(), mailVO.isUseHtmlYn());

            if(!CollectionUtils.isEmpty(mailVO.getAttachFileList())) {
                for(AttachFileVO attachFileDto: mailVO.getAttachFileList()) {
                    FileSystemResource fileSystemResource = new FileSystemResource(new File(attachFileDto.getRealFileNm()));
                    mimeMessageHelper.addAttachment(MimeUtility.encodeText(attachFileDto.getAttachFileNm(), "UTF-8", "B"), fileSystemResource);
                }
            }
            logger.debug("***************"+ mimeMessage);
            javaMailSender.send(mimeMessage);
            nResult = 1;
            logger.info("MailServiceImpl.sendMail() :: SUCCESS");
        } catch (Exception e) {
            logger.info("MailServiceImpl.sendMail() :: FAILED");
            logger.debug(e.getMessage());
            nResult = -1;
        }
        return nResult;

    }

    @Override
    public String makeTemplate(String templateType, Object contentObject) {
        String mailContent = "";

        // 샘플 Email Template
        if("test-template".equals(templateType)){
            DepartmentRequestVO testVo = new DepartmentRequestVO();
            testVo.setSearchItem("OCT");
            List<DepartmentVO> departments = departmentService.findDepartments(testVo);

            Context ctx = new Context();
            ctx.setVariable("title", "테스트 제목");
            ctx.setVariable("departments", departments);

            mailContent = templateEngine.process("test-template", ctx);
        } else if ("FastenDocumentException".equals(templateType)) {
            Context ctx = new Context();
            ctx.setVariable("content", contentObject);
            mailContent = templateEngine.process("FastenDocumentException", ctx);
        } else if ("onlineWorkingSurveyRequest".equals(templateType)) {
            Context ctx = new Context();
            ctx.setVariable("content", contentObject);
            mailContent = templateEngine.process(templateType, ctx);
        } else if("ReviewTeamDepartmentTransfer".equals(templateType)) {
            Context ctx = new Context();
            ctx.setVariable("content", contentObject);
            mailContent = templateEngine.process(templateType, ctx);
        }

        return mailContent;
    }

}