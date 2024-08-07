package com.flare.rap.webservice.service;

import javax.xml.stream.XMLStreamException;

import org.apache.axis2.databinding.ADBBean;

import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.webservice.model.WebServiceRequest;
import com.flare.rap.webservice.model.WebServiceResponse;

public abstract class WebService {

    public WebServiceResponse execute(WebServiceRequest request){

        ADBBean serviceRequest= this.generateRequest(request);
        ADBBean serviceResponse = null;

        try {
            long ifLogSeq = this.logBeforeRequest(serviceRequest);
            serviceResponse = this.requestService(serviceRequest);
            this.logAfterResponse(ifLogSeq, serviceRequest, serviceResponse);
        }catch(BusinessException ex){
            throw ex;
        }catch(Exception ex){
            ex.printStackTrace();;
        }

        return this.generateResponse(serviceResponse);
    }

    protected long logBeforeRequest(ADBBean serviceRequest) throws XMLStreamException{
        return 0L;
    }

    protected abstract ADBBean generateRequest(WebServiceRequest request);

    protected abstract ADBBean requestService(ADBBean serviceRequest) throws Exception;

    protected abstract void logAfterResponse(long ifLogSeq, ADBBean serviceRequest, ADBBean serviceResponse) throws XMLStreamException;

    protected abstract WebServiceResponse generateResponse(ADBBean serviceResponse);
}