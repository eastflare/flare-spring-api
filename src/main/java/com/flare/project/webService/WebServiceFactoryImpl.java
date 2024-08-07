package com.flare.project.webService;

import org.springframework.stereotype.Component;

import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.service.WebService;
import com.flare.rap.webservice.service.WebServiceFactory;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebServiceFactoryImpl implements WebServiceFactory {

    private final WebService webServiceHrDepartment;
    private final WebService webServiceHrEmployee;
    private final WebService webServiceApprovalEntrust;
    private final WebService webServiceApprovalType2Request;
    private final WebService webServiceApprovalType3;

    @Override
    public WebService getWebService(String serviceCode){

        if(InterfaceUrlKeys.HR_DEPARTMENT.equals(serviceCode)){
            return webServiceHrDepartment;
        }else if(InterfaceUrlKeys.HR_EMPLOYEE.equals(serviceCode)){
            return webServiceHrEmployee;
        }else if(InterfaceUrlKeys.APPROVAL_ENTRUST.equals(serviceCode)){
            return webServiceApprovalEntrust;
        }else if(InterfaceUrlKeys.APPROVAL_AUTO.equals(serviceCode)){
            return webServiceApprovalType2Request;
        }else if(InterfaceUrlKeys.APPROVAL_LIST.equals(serviceCode)){
            return webServiceApprovalType3;
        }

        return null;
    }
}