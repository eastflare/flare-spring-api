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
import com.flare.project.webService.client.requestListClient.LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebServiceApprovalType3 extends WebService {
    private final WebServiceConfiguration configuration;
    private final HttpTransportPropertiesImpl.Authenticator basicAuthenticator;
    private final LogService logService;

    @Override
    protected ADBBean generateRequest(WebServiceRequest request){

        ApprovalCommonRequestVO approvalCommonRequestVO = (ApprovalCommonRequestVO) request;

        LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.
                RequestList_type0 requestData = new LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.RequestList_type0();

        requestData.setSYSTEM_ID(configuration.getSystemId());
        requestData.setAPI_TYPE(approvalCommonRequestVO.getApiType());
        requestData.setFORM_ID(approvalCommonRequestVO.getFormId());
        requestData.setAPPR_TITLE(approvalCommonRequestVO.getApprTitle());
        requestData.setREQ_USER(approvalCommonRequestVO.getReqUser());
        requestData.setAPPKEY_01(approvalCommonRequestVO.getAppkey01());
        requestData.setAPPKEY_02(approvalCommonRequestVO.getAppkey02());
        requestData.setAPPKEY_03(approvalCommonRequestVO.getAppkey03());
        requestData.setAPPKEY_04(approvalCommonRequestVO.getAppkey04());
        requestData.setAPPKEY_05(approvalCommonRequestVO.getAppkey05());
        requestData.setFORM_EDITOR_DATA(approvalCommonRequestVO.getFormEditorData());
        requestData.setAPPR_SECURITY_TYPE(approvalCommonRequestVO.getApprSecurityType());
        requestData.setAPPR_PERIOD_CD(approvalCommonRequestVO.getApprPeriodCd());
        requestData.setAPP_URL(approvalCommonRequestVO.getAppUrl());
        requestData.setAPP_WAIT_URL(approvalCommonRequestVO.getAppWaitUrl());
        requestData.setAPP_MOBILE_URL(approvalCommonRequestVO.getAppMobileUrl());
        requestData.setAPPR_DOC_NO(approvalCommonRequestVO.getApprDocNo());
        requestData.setAPPR_STATUS(approvalCommonRequestVO.getApprStatus());
        requestData.setAPPR_MESSAGE(approvalCommonRequestVO.getApprMessage());
        requestData.setIS_ALL_DELETE(approvalCommonRequestVO.getIsAllDelete());
        requestData.setDELETE_USER(approvalCommonRequestVO.getDeleteUser());
        requestData.setNEXT_APPR_TYPE(approvalCommonRequestVO.getNextApprType());
        requestData.setNEXT_APPROVER(approvalCommonRequestVO.getNextApprover());
        requestData.setNEXT_APPROVER_URL(approvalCommonRequestVO.getNextApproverUrl());
        requestData.setREAD_USER(approvalCommonRequestVO.getReadUser());
        requestData.setREAD_DEPT(approvalCommonRequestVO.getReadDept());
        requestData.setIS_RETURN_APPR_ID(approvalCommonRequestVO.getIsReturnApprId());

        LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub. DT_LGCY_APRV_EA_TOTALAPRV_04_S dt_02_s =
                new LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.DT_LGCY_APRV_EA_TOTALAPRV_04_S();
        dt_02_s.addRequestList(requestData);

        LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_04_S mt_02_s =
                new LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_04_S();
        mt_02_s.setMT_LGCY_APRV_EA_TOTALAPRV_04_S(dt_02_s);

        return mt_02_s;
    }

    @Override
    protected ADBBean requestService(ADBBean request) throws Exception {
        LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_04_S mt_02_s =
                (LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_04_S) request;

        return this.getService().lGCY_APRV_EA_TOTALAPRV_04_SO(mt_02_s);
    }

    private LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub getService() {

        LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub service;
        try {
            service = new LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub(configuration.getUrls()
                    .get(InterfaceUrlKeys.APPROVAL_LIST));
        }catch (RemoteException e){
            throw new BusinessException("통합결재와 통신중 오류가 발생했습니다. 관리자에게 문의해주세요.",
                    StatusCodeConstants.FAIL);
        }

        service._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE,basicAuthenticator);

        return service;
    }

    private LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.Return_type0 getResults(ADBBean response){
        return ((LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_04_S_response) response)
                .getMT_LGCY_APRV_EA_TOTALAPRV_04_S_response().get_return();
    }

    @Override
    protected void logAfterResponse(long ifLogSeq, ADBBean serviceRequest, ADBBean serviceResponse) throws XMLStreamException{
        OMElement requestElement = serviceRequest.getOMElement(
                LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME,
                OMAbstractFactory.getOMFactory());

        OMElement responseElement = serviceResponse.getOMElement(
                LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME,
                OMAbstractFactory.getOMFactory());

        UserSessionVO session = SessionScopeUtil.getContextSession();

        LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.Return_type0 result = this.getResults(serviceResponse);

        IfLogVO ifLogVO = IfLogVO.builder()
                .ifNm("TYPE3-APPROVAL")
                .ifDivsCd("CLIENT")
                .ifTrmtValCtn(XmlPrettyPrinter.defaultXmlPrettyPrinter(requestElement.toStringWithConsume()))
                .ifRestValCtn(XmlPrettyPrinter.defaultXmlPrettyPrinter(responseElement.toStringWithConsume()))
                .optValNm1((result != null) ? result.getIF_STATUS() : "")
                .optValNm2((result != null) ? result.getIF_ERRMSG() : "")
                .dataInsUserId((session == null )  ? "NA" : session.getUserId())
                .dataInsUserIp((session == null )  ? "NA" : session.getUserIp())
                .build();
        logService.createIfLog(ifLogVO);
    }

    @Override
    protected WebServiceResponse generateResponse(ADBBean serviceResponse){

        LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.Return_type0 result = this.getResults(serviceResponse);

        ApprovalCommonResponseVO approvalCommonResponseVO = new ApprovalCommonResponseVO();
        approvalCommonResponseVO.setIfStatus(result.getIF_STATUS());
        approvalCommonResponseVO.setIfErrMsg(result.getIF_ERRMSG());

        log.debug("IF_ERRMSG : " + result.getIF_ERRMSG());
        log.debug("IF_STATUS : " + result.getIF_STATUS());

        return approvalCommonResponseVO;
    }
}