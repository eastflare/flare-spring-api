package com.flare.project.sample.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.approval.model.ApprovalCommonRequestVO;
import com.flare.rap.approval.model.ApprovalCommonResponseVO;
import com.flare.rap.approval.model.ApprovalSetEntrustRequestVO;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.mail.model.MailRequestVO;
import com.flare.rap.mail.model.MailVO;
import com.flare.rap.mail.service.MailService;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.service.WebService;
import com.flare.rap.webservice.service.WebServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Sample")
@RequestMapping("/api")
public class SampleController {
    private final MailService mailService;
    private final WebServiceFactory webServiceFactory;
    private final MessageSource messageSource;

    @Operation(summary = "EmailTest", description = "EmailTest")
    @PostMapping(value = "/v1/emailTest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> sendEmail(
        @RequestBody MailRequestVO mailRequest){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        MailVO mailVO = mailService.parseMailRequest(mailRequest);
        mailVO.setFromAddress(userSession.getEmlSvrDmnIfoNm());

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(mailService.sendMail(mailVO))
                        .build(),
                HttpStatus.OK);
    }
    @Operation(summary = "WebServiceDept", description = "WebServiceDept")
    @GetMapping(value = "/v1/WebServiceDept", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> webServiceDept(){

        try{
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.HR_DEPARTMENT);
            webService.execute(null);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(' ')
                        .build(),
                HttpStatus.OK);
    }
    @Operation(summary = "WebServiceEmp", description = "WebServiceEmp")
    @GetMapping(value = "/v1/WebServiceEmp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> webServiceEmp(){

        try{
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.HR_EMPLOYEE);
            webService.execute(null);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(' ')
                        .build(),
                HttpStatus.OK);
    }
    @Operation(summary = "WebServiceRequestAuto", description = "WebServiceRequestAuto")
    @PostMapping(value = "/v1/WebServiceRequestAuto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> webServiceRequestAuto(
            @RequestBody ApprovalCommonRequestVO approvalCommonRequestVO){

        ApprovalCommonResponseVO approvalCommonResponseVO = new ApprovalCommonResponseVO();

        try{
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.APPROVAL_AUTO);
            approvalCommonResponseVO = (ApprovalCommonResponseVO) webService.execute(approvalCommonRequestVO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalCommonResponseVO)
                        .build(),
                HttpStatus.OK);
    }
    @Operation(summary = "WebServiceSetEntrust", description = "WebServiceSetEntrust")
    @PostMapping(value = "/v1/WebServiceSetEntrust", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> webServiceSetEntrust(
            @RequestBody ApprovalSetEntrustRequestVO approvalSetEntrustRequestVO){

        ApprovalCommonResponseVO approvalCommonResponseVO = new ApprovalCommonResponseVO();

        try{
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.APPROVAL_ENTRUST);
            approvalCommonResponseVO = (ApprovalCommonResponseVO) webService.execute(approvalSetEntrustRequestVO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalCommonResponseVO)
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "WebServiceRequestList", description = "WebServiceRequestList")
    @PostMapping(value = "/v1/WebServiceRequestList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> WebServiceRequestList(
            @RequestBody ApprovalCommonRequestVO approvalCommonRequestVO){

        ApprovalCommonResponseVO approvalCommonResponseVO = new ApprovalCommonResponseVO();

        try{
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.APPROVAL_LIST);
            approvalCommonResponseVO = (ApprovalCommonResponseVO) webService.execute(approvalCommonRequestVO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalCommonResponseVO)
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "EmailTemplate", description = "EmailTemplate")
    @GetMapping(value = "/v1/emailTemplate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findEmailTemplate(
        @Parameter(description = "템플릿유형", example = "test-template") String templateType){

        return new ResponseEntity<>(
            CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(mailService.makeTemplate(templateType, null))
                .build(),
            HttpStatus.OK);
    }

    @Operation(summary = "MessageTest", description = "MessageTest")
    @GetMapping(value = "/v1/multiLanguageTest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> multiLanguageTest(){

        log.debug("Default Locale: " + Locale.getDefault());

        Locale currentLocale = LocaleContextHolder.getLocale();
        log.debug("**************************");
        log.debug(currentLocale.toString());

        /*LocaleContextHolder.getLocale();로 현재 로케일 판단하여 셋팅 해줌 */

        log.debug("currentLocale");
        log.debug(messageSource.getMessage("com.code.COP_CD.회사명",null, currentLocale));

        log.debug("Default");
        log.debug(messageSource.getMessage("com.code.COP_CD.회사명",null, Locale.getDefault()));

        log.debug("폴란드");
        Locale polandLocale = new Locale("pl", "PL");
        log.debug(messageSource.getMessage("com.code.COP_CD.회사명",null, polandLocale));

        log.debug("중국");
        Locale chinaLocale = new Locale("zh", "CN");
        log.debug(messageSource.getMessage("com.code.COP_CD.회사명",null, chinaLocale));

        log.debug("대만");
        Locale taiwanLocale = new Locale("zh", "TW");
        log.debug(messageSource.getMessage("com.code.COP_CD.회사명",null, taiwanLocale));

        log.debug("영어");
        Locale englishLocale = new Locale("en", "US");
        log.debug(messageSource.getMessage("com.code.COP_CD.회사명",null, englishLocale));
        log.debug(englishLocale.toString());

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(messageSource.getMessage("com.code.COP_CD.회사명",null, taiwanLocale))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "mailBatchTest", description = "mailBatchTest")
    @GetMapping(value = "/v1/mailBatchTest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> mailBatchTest(){

        mailService.sendMailBatch();

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data("")
                        .build(),
                HttpStatus.OK);
    }

}