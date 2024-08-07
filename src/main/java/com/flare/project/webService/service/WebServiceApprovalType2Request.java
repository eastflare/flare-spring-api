package com.flare.project.webService.service;

import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.kernel.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.springframework.stereotype.Service;

import com.flare.rap.approval.model.ApprovalCommonRequestVO;
import com.flare.rap.approval.model.ApprovalCommonResponseVO;
import com.flare.rap.common.config.WebServiceConfiguration;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.XmlPrettyPrinter;
import com.flare.rap.log.model.IfLogVO;
import com.flare.rap.log.service.LogService;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.model.WebServiceRequest;
import com.flare.rap.webservice.model.WebServiceResponse;
import com.flare.rap.webservice.service.WebService;
import com.flare.project.webService.client.requestAutoClient.LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebServiceApprovalType2Request extends WebService {
    private final WebServiceConfiguration configuration;
    private final HttpTransportPropertiesImpl.Authenticator basicAuthenticator;
    private final LogService logService;

    @Override
    protected ADBBean generateRequest(WebServiceRequest request){

        LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.
                RequestAuto_type0 requestData = new LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.RequestAuto_type0() ;

        ApprovalCommonRequestVO approvalCommonRequestVO = (ApprovalCommonRequestVO) request;

        requestData.setSYSTEM_ID(configuration.getSystemId());
        requestData.setFORM_ID(approvalCommonRequestVO.getFormId());
        requestData.setAPPR_TITLE(approvalCommonRequestVO.getApprTitle());
        requestData.setREQ_USER(approvalCommonRequestVO.getReqUser());
        requestData.setAPPKEY_01(approvalCommonRequestVO.getAppkey01());
        requestData.setAPPKEY_02(approvalCommonRequestVO.getAppkey02());
        requestData.setAPPKEY_03(approvalCommonRequestVO.getAppkey03());
        requestData.setAPPKEY_04(approvalCommonRequestVO.getAppkey04());
        requestData.setAPPKEY_05(approvalCommonRequestVO.getAppkey05());
        requestData.setFORM_EDITOR_DATA(approvalCommonRequestVO.getFormEditorData());
        requestData.setFORM_MOBILE_DATA(approvalCommonRequestVO.getFormMobileData());
        requestData.setAPPR_SECURITY_TYPE(approvalCommonRequestVO.getApprSecurityType());
        requestData.setAPPR_DOC_NO(approvalCommonRequestVO.getApprDocNo());
        requestData.setAPPR_LINE_TYPE(approvalCommonRequestVO.getApprLineType());
        requestData.setAPPR_PERIOD_CD(approvalCommonRequestVO.getApprPeriodCd());
        requestData.setFILE_LINK_NAME(approvalCommonRequestVO.getFileLinkName());
        requestData.setFILE_LINK_URL(approvalCommonRequestVO.getFileLinkUrl());
        requestData.setFILE_SIZE(approvalCommonRequestVO.getFileSize());
        requestData.setNEXT_APPR_TYPE(approvalCommonRequestVO.getNextApprType());
        requestData.setNEXT_APPROVER(approvalCommonRequestVO.getNextApprover());
        requestData.setREAD_USER(approvalCommonRequestVO.getReadUser());
        requestData.setREAD_DEPT(approvalCommonRequestVO.getReadDept());
        requestData.setFORM_DATA(approvalCommonRequestVO.getFormData());
        requestData.setIS_RETURN_APPR_ID(approvalCommonRequestVO.getIsReturnApprId());

        LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.DT_LGCY_APRV_EA_TOTALAPRV_03_S dt_02_s =
                new LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.DT_LGCY_APRV_EA_TOTALAPRV_03_S();

        dt_02_s.addRequestAuto(requestData);

        LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S mt_02_s =
                new LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S();

        mt_02_s.setMT_LGCY_APRV_EA_TOTALAPRV_03_S(dt_02_s);

        return mt_02_s;
    }

    @Override
    protected ADBBean requestService(ADBBean request) throws Exception {
        LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S mt_02_s =
                (LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S) request;

        return this.getService().lGCY_APRV_EA_TOTALAPRV_03_SO(mt_02_s);
    }

    private LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub getService() {

        LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub service;
        try {
            service = new LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub(configuration.getUrls()
                            .get(InterfaceUrlKeys.APPROVAL_AUTO));
        } catch(RemoteException e) {
            throw new BusinessException("통합결재와 통신중 오류가 발생했습니다. 관리자에게 문의해주세요.",
                    StatusCodeConstants.FAIL);
        }

        service._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuthenticator);

        return service;
    }

    private LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.RequestAutoResponse_type0[] getResults(ADBBean response){
        return ((LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S_response) response)
                .getMT_LGCY_APRV_EA_TOTALAPRV_03_S_response().getRequestAutoResponse();
    }

    @Override
    protected void logAfterResponse(long ifLogSeq, ADBBean serviceRequest, ADBBean serviceResponse) throws XMLStreamException{

        OMElement requestElement = serviceRequest.getOMElement(
                LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME,
                OMAbstractFactory.getOMFactory());

        OMElement responseElement = serviceResponse.getOMElement(
                LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME,
                OMAbstractFactory.getOMFactory());

        LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.RequestAutoResponse_type0[] results =
                this.getResults(serviceResponse);

        UserSessionVO session = SessionScopeUtil.getContextSession();

        // 후처리 Log만 처리합니다.
        IfLogVO ifLog =  IfLogVO.builder()
                .ifNm("TYPE2-APPROVAL-REQUEST")
                .ifDivsCd("CLIENT")
                .ifTrmtValCtn(XmlPrettyPrinter.defaultXmlPrettyPrinter(requestElement.toStringWithConsume()))
                .ifRestValCtn(XmlPrettyPrinter.defaultXmlPrettyPrinter(responseElement.toStringWithConsume()))
                .optValNm1((results != null && results.length > 0) ? results[0].getIF_STATUS() : "")
                .optValNm2((results != null && results.length > 0) ? results[0].getIF_ERRMSG() : "")
                .dataInsUserId((session == null )  ? "NA" : session.getUserId())
                .dataInsUserIp((session == null )  ? "NA" : session.getUserIp())
                .build();

        logService.createIfLog(ifLog);
    }

    @Override
    protected WebServiceResponse generateResponse(ADBBean serviceResponse){

        LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.RequestAutoResponse_type0[] results =
                this.getResults(serviceResponse);

        ApprovalCommonResponseVO approvalCommonResponseVO = new ApprovalCommonResponseVO();

        if(results == null || results.length == 0) {
            return approvalCommonResponseVO;
        }

        approvalCommonResponseVO.setIfStatus(results[0].getIF_STATUS());
        approvalCommonResponseVO.setIfErrMsg(results[0].getIF_ERRMSG());

        for (LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.RequestAutoResponse_type0 result : results) {
            log.debug("IF_ERRMSG : " + result.getIF_ERRMSG());
            log.debug("IF_STATUS : " + result.getIF_STATUS());
        }

        return approvalCommonResponseVO;
    }
}