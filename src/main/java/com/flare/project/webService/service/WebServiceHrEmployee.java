package com.flare.project.webService.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.kernel.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.springframework.stereotype.Service;

import com.flare.rap.common.config.WebServiceConfiguration;
import com.flare.rap.common.util.XmlPrettyPrinter;
import com.flare.rap.hrInterface.model.HrEmpResponse;
import com.flare.rap.hrInterface.model.HrEmployeeVO;
import com.flare.rap.hrInterface.repository.HrInterfaceRepository;
import com.flare.rap.log.model.IfLogVO;
import com.flare.rap.log.service.LogService;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.model.WebServiceRequest;
import com.flare.rap.webservice.model.WebServiceResponse;
import com.flare.rap.webservice.service.WebService;
import com.flare.project.webService.client.empWebServiceClient.LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub;
import com.flare.project.webService.client.requestAutoClient.LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WebServiceHrEmployee extends WebService {
    private final WebServiceConfiguration configuration;
    private final HttpTransportPropertiesImpl.Authenticator basicAuthenticator;
    private final HrInterfaceRepository hrInterfaceRepository;
    private final LogService logService;

    @Override
    protected ADBBean generateRequest(WebServiceRequest request){
        LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.DT_LGCY_LCHC_EA_EMPBATCH_02_S dt_02_s=
                new LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.DT_LGCY_LCHC_EA_EMPBATCH_02_S();

        dt_02_s.setSystemKey(configuration.getSystemKey());

        LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_EMPBATCH_02_S mt_02_s =
                new LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_EMPBATCH_02_S();

        mt_02_s.setMT_LGCY_LCHC_EA_EMPBATCH_02_S(dt_02_s);

        return mt_02_s;
    }

    @Override
    protected long logBeforeRequest(ADBBean serviceRequest) throws XMLStreamException {
        OMElement requestElement = serviceRequest.getOMElement(
                LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME,
                OMAbstractFactory.getOMFactory());

        long ifLogSeq = logService.findIfLogSeq();

        IfLogVO ifLogVO = IfLogVO.builder()
                .ifLogSeq(ifLogSeq)
                .ifNm("HR-EMP")
                .ifDivsCd("CLIENT")
                .ifTrmtValCtn(XmlPrettyPrinter.defaultXmlPrettyPrinter(requestElement.toStringWithConsume()))
                .dataInsUserId("Batch")
                .dataInsUserIp("Batch")
                .build();

        logService.createIfLogSend(ifLogVO);

        return ifLogSeq;
    }

    @Override
    protected ADBBean requestService(ADBBean request) throws RemoteException {
        LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_EMPBATCH_02_S mt_02_s =
                (LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_EMPBATCH_02_S) request;

        return this.getService().LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(mt_02_s);
    }

    private LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub getService() throws RemoteException {

        LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub service =
                new LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub(configuration.getUrls()
                        .get(InterfaceUrlKeys.HR_EMPLOYEE));

        service._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuthenticator);

        return service;
    }

    private LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.RETURN_type0[] getResults(ADBBean response){
        return ((LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_EMPBATCH_02_S_response)response)
                .getMT_LGCY_LCHC_EA_EMPBATCH_02_S_response().getRETURN();
    }

    @Override
    protected void logAfterResponse(long ifLogSeq, ADBBean serviceRequest, ADBBean serviceResponse){
        // OMElement responseElement = s_response.getOMElement(LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME, OMAbstractFactory.getOMFactory());

        IfLogVO ifLogVO = IfLogVO.builder()
                .ifLogSeq(ifLogSeq)
                .ifRestValCtn("Data Count : " + this.getResults(serviceResponse).length)
                .dataInsUserId("Batch")
                .dataInsUserIp("Batch")
                .build();

        logService.modifyIfLogReceive(ifLogVO);
    }

    @Override
    protected WebServiceResponse generateResponse(ADBBean serviceResponse){
        LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.RETURN_type0[] hrResults =
                this.getResults(serviceResponse);

        HrEmpResponse hrEmpResponse = new HrEmpResponse(new ArrayList<>());
        String ifId = hrInterfaceRepository.selectEmpIfId();

        for (LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.RETURN_type0 hrResult : hrResults ) {
            HrEmployeeVO hrEmployee = new HrEmployeeVO();

            hrEmployee.setSaComp(hrResult.getSA_COMP());
            hrEmployee.setSaDept(hrResult.getSA_DEPT());
            hrEmployee.setSaDeptName(hrResult.getSA_DEPT_NAME());
            hrEmployee.setSaDeptNameC(hrResult.getSA_DEPT_NAME_C());
            hrEmployee.setSaDeptNameE(hrResult.getSA_DEPT_NAME_E());
            hrEmployee.setSaDeptNew(hrResult.getSA_DEPT_NEW());
            hrEmployee.setSaEdeptName(hrResult.getSA_EDEPT_NAME());
            hrEmployee.setSaFunc(hrResult.getSA_FUNC());
            hrEmployee.setSaFuncName(hrResult.getSA_FUNC_NAME());
            hrEmployee.setSaFuncNameC(hrResult.getSA_FUNC_NAME_C());
            hrEmployee.setSaFuncNameE(hrResult.getSA_FUNC_NAME_E());
            hrEmployee.setSaHand(hrResult.getSA_HAND());
            hrEmployee.setSaHname(hrResult.getSA_HNAME());
            hrEmployee.setSaJobx(hrResult.getSA_JOBX());
            hrEmployee.setSaJobxName(hrResult.getSA_JOBX_NAME());
            hrEmployee.setSaJobxNameC(hrResult.getSA_JOBX_NAME_C());
            hrEmployee.setSaJobxNameE(hrResult.getSA_JOBX_NAME_E());
            hrEmployee.setSaName(hrResult.getSA_NAME());
            hrEmployee.setSaNameE(hrResult.getSA_NAME_E());
            hrEmployee.setSaPhonArea(hrResult.getSA_PHON_AREA());
            hrEmployee.setSaPhonD(hrResult.getSA_PHON_D());
            hrEmployee.setSaPhonH(hrResult.getSA_PHON_H());
            hrEmployee.setSaPhonHarea(hrResult.getSA_PHON_AREA());
            hrEmployee.setSaPhonO(hrResult.getSA_PHON_O());
            hrEmployee.setSaRect(hrResult.getSA_RECT());
            hrEmployee.setSaSabun(hrResult.getSA_SABUN());
            hrEmployee.setSaSabunLeader(hrResult.getSA_SABUN_LEADER());
            hrEmployee.setSaSabunNew(hrResult.getSA_SABUN_NEW());
            hrEmployee.setSaSystem(hrResult.getSA_SYSTEM());
            hrEmployee.setSaTemp(hrResult.getSA_TEMP());
            hrEmployee.setSaTempDate(hrResult.getSA_TEMP_DATE());
            hrEmployee.setSaUser(hrResult.getSA_USER());
            hrEmployee.setSsoExFlag(hrResult.getSSO_EX_FLAG());
            hrEmployee.setSsoMailServer(hrResult.getSSO_MAILSERVER());
            hrEmployee.setSsoPsDate(hrResult.getSSO_PS_DATE());
            hrEmployee.setSaGnmu(hrResult.getSA_GNMU());
            hrEmployee.setSaGnmuName(hrResult.getSA_GNMU_NAME());
            hrEmployee.setSsoLocate(hrResult.getSSO_LOCATE());
            hrEmployee.setSaPayxgb(hrResult.getSA_PAYXGB());
            hrEmployee.setSaSnbngb(hrResult.getSA_SNBNGB());
            hrEmployee.setSaSnbngr(hrResult.getSA_SNBNGR());
            hrEmployee.setSaMail(hrResult.getSA_MAIL());
            hrEmployee.setSsoSuGnmu(hrResult.getSSO_SU_GNMU());
            hrEmployee.setSsoCname(hrResult.getSSO_CNAME());
            hrEmployee.setSaNationality(hrResult.getSA_NATIONALITY());
            hrEmployee.setIfId(ifId);

            hrEmpResponse.getHrEmployeeList().add(hrEmployee);
        }
        return hrEmpResponse;
    }
}