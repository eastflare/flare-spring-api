package com.flare.rap.common.config;

import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebServiceAuthenticationConfig {

    private final WebServiceConfiguration configuration;

    @Bean(name = "basicAuthenticator")
    public HttpTransportPropertiesImpl.Authenticator basicAuthenticator(){
        HttpTransportPropertiesImpl.Authenticator basicAuthentication = new HttpTransportPropertiesImpl.Authenticator();
        basicAuthentication.setUsername(configuration.getUsername());
        basicAuthentication.setPassword(configuration.getPassword());
        basicAuthentication.setAllowedRetry(true);

        return basicAuthentication;
    }
}