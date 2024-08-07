package com.flare.rap.webservice.service;

import com.flare.rap.webservice.service.WebService;

public interface WebServiceFactory {
    WebService getWebService(String serviceCode);
}