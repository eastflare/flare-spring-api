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
import com.flare.rap.hrInterface.model.HrDepartmentVO;
import com.flare.rap.hrInterface.model.HrDeptResponse;
import com.flare.rap.hrInterface.repository.HrInterfaceRepository;
import com.flare.rap.log.model.IfLogVO;
import com.flare.rap.log.service.LogService;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.model.WebServiceRequest;
import com.flare.rap.webservice.model.WebServiceResponse;
import com.flare.rap.webservice.service.WebService;
import com.flare.project.webService.client.deptWebServiceClient.LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub;
import com.flare.project.webService.client.requestAutoClient.LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WebServiceHrDepartment extends WebService {

    private final WebServiceConfiguration configuration;
    private final HttpTransportPropertiesImpl.Authenticator basicAuthenticator;
    private final HrInterfaceRepository hrInterfaceRepository;
    private final LogService logService;

    @Override
    protected ADBBean generateRequest(WebServiceRequest request){
        LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.DT_LGCY_LCHC_EA_DEPTBATCH_02_S dt_02_s=
                new LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.DT_LGCY_LCHC_EA_DEPTBATCH_02_S();

        dt_02_s.setSystemKey(configuration.getSystemKey());

        LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_DEPTBATCH_02_S mt_02_s=
                new LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_DEPTBATCH_02_S();

        mt_02_s.setMT_LGCY_LCHC_EA_DEPTBATCH_02_S(dt_02_s);

        return mt_02_s;
    }

    @Override
    protected long logBeforeRequest(ADBBean serviceRequest) throws XMLStreamException {
        OMElement requestElement = serviceRequest.getOMElement(
                LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME,
                OMAbstractFactory.getOMFactory());

        long ifLogSeq = logService.findIfLogSeq();
        IfLogVO ifLog = IfLogVO.builder()
                .ifLogSeq(ifLogSeq)
                .ifNm("HR-DEPT")
                .ifDivsCd("CLIENT")
                .ifTrmtValCtn(XmlPrettyPrinter.defaultXmlPrettyPrinter(requestElement.toStringWithConsume()))
                .dataInsUserId("Batch")
                .dataInsUserIp("Batch")
                .build();

        logService.createIfLogSend(ifLog);

        return ifLogSeq;
    }

    @Override
    protected ADBBean requestService(ADBBean request) throws RemoteException {
        LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_DEPTBATCH_02_S mt_02_s =
                (LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_DEPTBATCH_02_S) request;

        return this.getService().lGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(mt_02_s);
    }

    private LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub getService() throws RemoteException {

        LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub service =
                new LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub(configuration.getUrls()
                        .get(InterfaceUrlKeys.HR_DEPARTMENT));

        service._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuthenticator);

        return service;
    }

    private LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.RETURN_type0[] getResults(ADBBean response){
        return ((LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response)response)
                .getMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response().getRETURN();
    }

    @Override
    protected void logAfterResponse(long ifLogSeq, ADBBean serviceRequest, ADBBean serviceResponse){
        // OMElement responseElement = s_response.getOMElement(LGCY_APRV_EA_TOTALAPRV_03_SOServiceStub.MT_LGCY_APRV_EA_TOTALAPRV_03_S.MY_QNAME, OMAbstractFactory.getOMFactory());

        IfLogVO ifLog = IfLogVO.builder()
                .ifLogSeq(ifLogSeq)
                .ifRestValCtn("Data Count : " + this.getResults(serviceResponse).length)
                .dataInsUserId("Batch")
                .dataInsUserIp("Batch")
                .build();

        logService.modifyIfLogReceive(ifLog);
    }

    @Override
    protected WebServiceResponse generateResponse(ADBBean serviceResponse){
        LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.RETURN_type0[] hrResults =
                this.getResults(serviceResponse);

        HrDeptResponse hrDeptResponse = new HrDeptResponse(new ArrayList<>());
        String ifId = hrInterfaceRepository.selectDetpIfId();
        for(LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.RETURN_type0 hrResult : hrResults) {

            HrDepartmentVO hrDepartment = new HrDepartmentVO();

            hrDepartment.setCodeNameCn(hrResult.getCODE_NAME_CN());
            hrDepartment.setCodeNameEn(hrResult.getCODE_NAME_EN());
            hrDepartment.setCodeNameKo(hrResult.getCODE_NAME_KO());
            hrDepartment.setCodeNumb(hrResult.getCODE_NUMB());
            hrDepartment.setCodeUper(hrResult.getCODE_UPER());
            hrDepartment.setCreatedate(hrResult.getCREATEDATE());
            hrDepartment.setDivision(hrResult.getDIVISION());
            hrDepartment.setUpdatedate(hrResult.getUPDATEDATE());
            hrDepartment.setValidFlag(hrResult.getVALID_FLAG());
            hrDepartment.setChiefNumb(hrResult.getChiefNumb());
            hrDepartment.setIfId(ifId);

            hrDeptResponse.getHrDepartmentList().add(hrDepartment);
        }
        return hrDeptResponse;
    }
}