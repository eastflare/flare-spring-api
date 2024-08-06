package com.flare.rap.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.flare.rap.common.interceptor.AuthenticationInterceptor;
import com.flare.rap.common.interceptor.LocaleInterceptor;
import com.flare.rap.common.interceptor.SsoCookieInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authInterceptor;
    private final SsoCookieInterceptor ssoCookieInterceptor;

    @Value("${interceptor.sso-cookie.exclude-paths}")
    private String[] ssoCookieExcludePaths;

    @Value("${interceptor.authentication.exclude-paths}")
    private String[] authenticationExcludePaths;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List< String> urlPatterns = Arrays.asList("/**");

        List< String> excludeSsoPatterns = this.getSsoCookieExcludePaths();
        registry.addInterceptor(ssoCookieInterceptor)
                .addPathPatterns(urlPatterns)
                .excludePathPatterns(excludeSsoPatterns);


        List< String> excludeAuthPatterns = this.getAuthenticationExcludePaths();
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(urlPatterns)
                .excludePathPatterns(excludeAuthPatterns);

        LocaleInterceptor localeInterceptor = new LocaleInterceptor();
        localeInterceptor.setParamName("langCd");
        registry.addInterceptor(localeInterceptor);
    }

    private List< String> getSsoCookieExcludePaths(){
        List< String> excludeSsoPatterns =
                new ArrayList< >(Arrays.asList(
                        "/v1/health", "/error",
                        "/swagger-ui/**", "/swagger-resources/**",
                        "/v3/api-docs/**",
                        "/soap/**",
                        "/file/**","/v1/file/mbdownload",
                        "/v1/DeptBatch", "/v1/EmpBatch",
                        "/v1/mailBatch",
                        "/v1/translated-messages/deploy-all"));

        excludeSsoPatterns.addAll(Arrays.asList(ssoCookieExcludePaths));

        return excludeSsoPatterns;
    }

    private List< String> getAuthenticationExcludePaths(){
        List< String> excludeAuthPatterns =
                new ArrayList< >(Arrays.asList(
                        "/v1/health", "/error",
                        "/swagger-ui/**", "/swagger-resources/**",
                        "/v3/api-docs/**",
                        "/soap/**",
                        "/file/**","/v1/file/mbdownload",
                        "/v1/DeptBatch", "/v1/EmpBatch",
                        "/v1/mailBatch",
                        "/v1/translated-messages/deploy-all"));

        excludeAuthPatterns.addAll(Arrays.asList(authenticationExcludePaths));

        return excludeAuthPatterns;
    }

}