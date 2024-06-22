package com.flare.rap.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flare.rap.common.filter.XssBlockFilter;
import com.flare.rap.common.filter.XssReplaceFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final ObjectMapper objectMapper;

    @Value("/api/v1/namoFileUpload,/api/v1/approval/mobile/**")
    private final String[] xssBlockExcludePaths;

    @Value("/api/v1/namoFileUpload,/api/v1/approval/mobile/**")
    private final String[] xssReplaceExcludePaths;

    @Bean
    public FilterRegistrationBean<XssReplaceFilter> XssReplaceFilter(){

        // 필터적용을 제외할 Path Pattern
        String[] excludePaths = {
                "/swagger-ui/**"
                ,"swagger-resources/**"
                ,"v3/api-docs/**"
                ,"/soap/**"
                ,"file/**"
                ,"/api/v1/file/upload"
        };

        String[] totalExcludePaths = this.concatenateStringArray(excludePaths, xssReplaceExcludePaths);
        XssReplaceFilter xssReplaceFilter = new XssReplaceFilter(totalExcludePaths, objectMapper);

        FilterRegistrationBean<XssReplaceFilter> registrationBean = new FilterRegistrationBean<>(xssReplaceFilter);
        registrationBean.setFilter(xssReplaceFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        registrationBean.setName("xssReplaceFilter");
        return registrationBean;
    }

    /**
     * XssBlockFilter 설명
     * XSS 에 해당하는 단어가 포함되어있으면 요청을 Block 합니다.
     * 문자열 체크는 ValidationUtil.checkXSS 를 사용합니다.
     * 이건 사용하지 않습니다.
     */
    @Bean
    public FilterRegistrationBean<XssBlockFilter> xssBlockFilter(){

        // 필터적용을 제외할 Path Pattern
        String[] excludePaths = {
                "/swagger-ui/**"
                ,"swagger-resources/**"
                ,"v3/api-docs/**"
                ,"/soap/**"
                ,"file/**"
                ,"/api/v1/file/upload"
        };

        String[] totalExcludePaths = this.concatenateStringArray(excludePaths, xssBlockExcludePaths);
        XssBlockFilter xssBlockFilter = new XssBlockFilter(totalExcludePaths, objectMapper);

        FilterRegistrationBean<XssBlockFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(xssBlockFilter);
        registrationBean.addUrlPatterns("/NOT-YET/**");
        registrationBean.setOrder(2);
        registrationBean.setName("xssBlockFilter");
        return registrationBean;
    }

    private String[] concatenateStringArray(String[] ary1, String[] ary2) {
        if(ary1 == null || ary1.length == 0) return ary2;
        if(ary2 == null || ary2.length == 0) return ary1;

        String[] rtnAry = new String[ary1.length + ary2.length];
        System.arraycopy(ary1, 0, rtnAry, 0, ary1.length);
        System.arraycopy(ary2, 0, rtnAry, ary1.length, ary2.length);

        return rtnAry;
    }
}
