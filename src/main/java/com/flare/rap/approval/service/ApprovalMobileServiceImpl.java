package com.flare.rap.approval.service;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.constant.ApprovalTypeConstants;
import com.flare.rap.approval.model.ApprovalLineRequestVO;
import com.flare.rap.approval.model.ApprovalMobileApprovalDetailVO;
import com.flare.rap.approval.model.ApprovalMobileApprovalResultResponseVO;
import com.flare.rap.approval.model.ApprovalMobileApproversVO;
import com.flare.rap.approval.model.ApprovalMobileFilesVO;
import com.flare.rap.approval.model.ApprovalMobileRequestVO;
import com.flare.rap.approval.model.ApprovalRequestIdRequestVO;
import com.flare.rap.approval.model.ApprovalRequestMasterResponseVO;
import com.flare.rap.common.config.WebServiceConfiguration;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.session.service.SessionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApprovalMobileServiceImpl implements ApprovalMobileService{

    private final WebServiceConfiguration webServiceConfiguration;
    private final ApprovalRequestType3Service approvalRequestType3Service;
    private final ApprovalRequestService approvalRequestService;
    private final ApprovalLineService approvalLineService;
    private final SessionService sessionService;
    private final MessageSource messageSource;

    private final String decKey = "ThisIsIkepSecurityKey"; //TODO : Key에 대한 처리 수정

    /**
     * userID	string	N	요청 ID	G-Portal ID	결재 문서를 조회하고자 하는 사용자 ID	AES128 암호화 권장(key값 따로 문의)
     * mbCode	string	N	사용자 확인 코드	8012 + userId	8012를 떼고 ID와 비교하여 유효성 검증을 위해 쓰인다	AES128 암호화 권장(key값 따로 문의)
     * empNo	string	N	요청자 사번	사번	결재 처리에 사번 정보가 꼭 필요할 경우만 보낸다	AES128 암호화 권장(key값 따로 문의)
     * mbLanguage	string	N	언어정보	KR, EN	다국어 처리가 필요할 경우 쓴다(기본값으로 KR을 권장)
     */
    @Override
    public ApprovalMobileApprovalDetailVO approvalMobileDetail(ApprovalMobileRequestVO approvalMobileRequest,
                                                               String userIp) {

        ApprovalMobileRequestVO  approvalMobileDec = this.decryptMobileRequest(approvalMobileRequest);

        this.setSession(approvalMobileDec, userIp);

        ApprovalRequestIdRequestVO approvalRequestId =
                ApprovalRequestIdRequestVO.of(approvalMobileRequest.getAprReqId());

        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestService.getApprovalRequestMaster(approvalRequestId);

        if(ValidateUtil.isEmpty(approvalRequestMaster)) {
            return ApprovalMobileApprovalDetailVO.ofEmpty(approvalMobileRequest.getAprReqId(),
                    webServiceConfiguration.getSystemId());
        }

        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();

        String apprSummary = "<p>" + messageSource.getMessage("com.approval.원문보기를 눌러 결재 할 내용을 확인해 주세요.",
                null, new Locale(SessionScopeUtil.getContextSession().getLangCd())) +  "</p>";
        if(!ValidateUtil.isEmpty(approvalRequestMaster.getTrnmBdyCtn())){
            apprSummary = ValidateUtil.charUnescape(approvalRequestMaster.getTrnmBdyCtn());
        }

        ApprovalLineRequestVO currentApprovalLine =
                approvalRequestService.getWaitApprovalLineByUserId(approvalRequestId);

        int aprLnSeq = 0;
        if(!ValidateUtil.isEmpty(currentApprovalLine)){
            aprLnSeq = (int)currentApprovalLine.getAprLnSeq();
        }

        List<ApprovalMobileApproversVO> mobileApprovers =
                approvalLineService.getApprovalLinesForMobile(approvalRequestId);

        List<ApprovalMobileFilesVO> atchFiles = approvalRequestService.getApprovalFilesForMobile(approvalRequestId);

        return ApprovalMobileApprovalDetailVO
                .ofSuccess(approvalRequestMaster, approvalMobileRequest, mobileApprovers, atchFiles,
                        aprLnSeq, apprSummary, webServiceConfiguration.getSystemId());
    }

    private ApprovalMobileRequestVO decryptMobileRequest(ApprovalMobileRequestVO approvalMobileRequest){
        ApprovalMobileRequestVO  approvalMobileDec = approvalMobileRequest;
        if(webServiceConfiguration.isMobileParamEncrypted()) {
            approvalMobileDec = ApprovalMobileRequestVO.decrypt(approvalMobileRequest, decKey);
        }

        return approvalMobileDec;
    }

    private void setSession(ApprovalMobileRequestVO approvalMobileRequest, String userIp){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        if(userSession == null || userSession.isSessionEmpty()){
            sessionService.createUserSession(approvalMobileRequest.getUserID(),
                    "KR".equals(approvalMobileRequest.getMbLanguage()) ? "ko" : "en", userIp);
        }
    }

    /**
     * userID		string	N	사용자아이디	G-Portal ID	레거시 마다 암호화 방식의 차이가 있음(기본 AES128)
     * docId		string	N	결재 문서 ID 	0002821933
     * apprIndex		string	N	결재 차수	2	결재 상세조회시 받은 <apprIndex> 값 보내줌
     * apprType		string	N	01 : 승인 / 04 : 반려	01 : 승인 / 04 : 반려	레거시 마다 값이 다를수 있음 01, 04가 기본
     * empNo		string	N	사번	75411	사번값으로 필요한 레거시만 보내준다. 레거시마다 암호화 방식의 차이가 있음(기본 AES128)
     * apprComment		string	N	결재의견	승인합니다
     * mbLanguage		string	N	언어정보	KR/EN	다국어 처리가 필요한 경우
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ApprovalMobileApprovalResultResponseVO approvalMobileProcess(ApprovalMobileRequestVO approvalMobileRequest,
                                                                        String userIp){

        ApprovalMobileRequestVO  approvalMobileDec = this.decryptMobileRequest(approvalMobileRequest);

        this.setSession(approvalMobileDec, userIp);

        ApprovalRequestIdRequestVO  approvalRequestIdRequestVO = ApprovalRequestIdRequestVO
                .of(approvalMobileDec.getDocId(), approvalMobileDec.getApprIndex());

        ApprovalLineRequestVO curApprovalLine =
                approvalRequestService.getApprovalLineMasterWithSeq(approvalRequestIdRequestVO);

        String aprPsgStatCd =
                this.getApprTypeName(approvalMobileDec.getApprType(), curApprovalLine.getGrnrAprTpDivsCd());
        curApprovalLine.setAprPsgStatCd(aprPsgStatCd);
        curApprovalLine.setAprAprvOpinUtf8Ctn(approvalMobileDec.getApprComment());

        try {
            approvalRequestType3Service.updateType3ApprovalProgress(curApprovalLine);
        } catch( BusinessException e) {
            return ApprovalMobileApprovalResultResponseVO.builder()
                    .returnCode(-1)
                    .returnDesc(e.getMessage())
                    .build();
        }

        return  ApprovalMobileApprovalResultResponseVO.builder()
                .returnCode(0)
                .returnDesc("Success")
                .build();
    }

    private String getApprTypeName(String apprType, String approvalType){

        if(ApprovalTypeConstants.DISCUSSION_MANDATORY.equals(approvalType) ||
                ApprovalTypeConstants.DISCUSSION_OPTIONAL.equals(approvalType)){
            if("01".equals(apprType)) return "OK";
            else if("04".equals(apprType)) return "NO";
        }else if(ApprovalTypeConstants.AGREEMENT.equals(approvalType)){
            if("01".equals(apprType)) return "AGREE";
            else if("04".equals(apprType)) return "DISAGREE";
        }else{
            if("01".equals(apprType)) return "APPROVE";
            else if("04".equals(apprType)) return "REJECT";
        }

        return "";
    }
}