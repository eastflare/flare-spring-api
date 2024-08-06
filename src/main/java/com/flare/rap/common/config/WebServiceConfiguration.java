package com.flare.rap.common.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ConfigurationProperties("interface")
public class WebServiceConfiguration {

    private final String systemKey;
    private final String systemId;
    private final String username;
    private final String password;
    private final boolean isEntrust;
    private final boolean isMobileParamEncrypted;
    private final Map<String, String> urls;

    @ConstructorBinding
    public WebServiceConfiguration(String systemKey, String systemId,
                                   String username, String password,
                                   boolean isEntrust, boolean isMobileParamEncrypted,
                                   Map<String,String> urls){
        this.systemKey = systemKey;
        this.systemId = systemId;
        this.username = username;
        this.password = password;
        this.isEntrust = isEntrust;
        this.isMobileParamEncrypted = isMobileParamEncrypted;
        this.urls = urls;
    }

//    @PostConstruct
//    void checkInitialize(){
//        log.debug("WebServiceConfiguration Check");
//        log.debug(systemkey);
//        log.debug(password);
//        log.debug(String.valueOf(mobileParamEncrypt));
//        log.debug(String.valueOf(urls.size()));
//    }
}