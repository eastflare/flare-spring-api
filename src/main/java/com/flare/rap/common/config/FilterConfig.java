package com.flare.rap.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flare.rap.common.filter.XssBlockFilter;
import com.flare.rap.common.filter.XssReplaceFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class FilterConfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    @Value("${filter.xss-block.exclude-paths}")
    private final String[] xssBlockExcludePaths;

    @Value("${filter.xss-replace.exclude-paths}")
    private final String[] xssReplaceExcludePaths;

    /**
     * XssReplaceFilter 설명
     * XSS 에 해당하는 문자 ( < , >, \, & 등등)가 포함되어있으면 해당 문자를 Replace(escape) 합니다.
     * 문자 Replace(escape)는 HtmlCharacterEscapes 클래스를 사용합니다.
     * - replace(escape)된 데이터를 다시 조회 할때 아래 조치를 취할 수 있습니다.
     *  예시 ) 제목, 성명 등 XSS 문자열을 허용하지 않은 경우는 replace(escape)된 데이터를 그대로 보여줍니다.
     *         FE에서 보여주는 방법에 따라 &lt; , <  로 보임.
     *  예시 ) 웹에디터를 통한 입력일 경우
     *     html 요소를 화면에 끼워넣기 위한 목적으로 입력한 것이므로 replace(escape) 된 데이터를 unescape 해서 FE에 보내야 합니다.
     *     BE Code Sample :
     *           bbs.setBbmCtn(ValidateUtil.charUnescape(bbs.getBbmCtn()));
     *
     *     따라서 FE에서는 XSS 공격 코드가 포함된 결과를 받아보게 되는데
     *     이를 차단하기 위해 dompurify.sanitize 를 이용해 XSS공격을 위한 패턴을 제거 해야 합니다.
     *     FE Code Sample :
     *          import DOMPurify from 'dompurify';
     *          dangerouslySetInnerHTML={{ __html: DOMPurify.sanitize(post?.bbmCtn + '') }}
     */

    @Bean
    public FilterRegistrationBean< XssReplaceFilter> xssReplaceFilter() {

        // 필터적용을 제외할 Path Pattern
        String [] excludePaths ={
                "/swagger-ui/**"
                ,"/swagger-resources/**"
                ,"/v3/api-docs/**"
                ,"/soap/**"
                ,"/file/**"
                ,"/api/v1/file/upload"
        };

        String[] totalExcludePaths = this.concatenateStringArrays(excludePaths, xssReplaceExcludePaths);
        XssReplaceFilter xssReplaceFilter = new XssReplaceFilter(totalExcludePaths, objectMapper);

        FilterRegistrationBean< XssReplaceFilter> registrationBean = new FilterRegistrationBean< >();
        registrationBean.setFilter(xssReplaceFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        registrationBean.setName("xssReplaceFilter");
        return registrationBean;
    }


    /**
     * XssBlockFilter 설명
     * XSS 에 해당하는 단어가 포함되어있으면 요청을 Block 합니다.
     * 문자열 체크는 ValidateUtil.checkXSS 를 사용합니다.
     * 이건 사용하지 않습니다.
     */
    @Bean
    public FilterRegistrationBean< XssBlockFilter> xssBlockFilter() {

        // 필터적용을 제외할 Path Pattern
        String [] excludePaths ={
                 "/swagger-ui/**"
                , "/swagger-resources/**"
                , "/v3/api-docs/**"
                ,"/soap/**"
                ,"/file/**"
                ,"/api/v1/file/upload"
        };

        String[] totalExcludePaths = this.concatenateStringArrays(excludePaths, xssBlockExcludePaths);
        XssBlockFilter xssBlockFilter = new XssBlockFilter(totalExcludePaths, objectMapper);

        FilterRegistrationBean< XssBlockFilter> registrationBean = new FilterRegistrationBean< >();
        registrationBean.setFilter(xssBlockFilter);
        registrationBean.addUrlPatterns("/NOT-YET/**");
        registrationBean.setOrder(2);
        registrationBean.setName("xssBlockFilter");
        return registrationBean;
    }


    private String[] concatenateStringArrays(String[] ary1, String[] ary2){
        if(ary1 == null || ary1.length == 0) return ary2;
        if(ary2 == null || ary2.length == 0) return ary1;

        String[] rtnAry = new String[ary1.length + ary2.length];
        System.arraycopy(ary1, 0, rtnAry, 0, ary1.length);
        System.arraycopy(ary2, 0, rtnAry, ary1.length, ary2.length);

        return rtnAry;
    }
}