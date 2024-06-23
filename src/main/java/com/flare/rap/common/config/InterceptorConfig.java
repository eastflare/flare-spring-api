package com.flare.rap.common.config;

import com.flare.rap.common.interceptor.AuthenticationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authInterceptor;

    @Value("${interceptor.authentication.exclude-paths}")
    private String[] authenticationExcludePaths;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> urlPatterns = Arrays.asList("/**");

        List<String> excludeAuthPatterns = this.getAuthenticationExcludePaths();
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(urlPatterns)
                .excludePathPatterns(excludeAuthPatterns);

        /*
        LocaleInterceptor localeInterceptor = new LocaleInterCeptor();
        localeInterceptor.setParamName("langCd");
        registry.addInterceptor(localeInterceptor);
        */
    }

    private List<String> getAuthenticationExcludePaths() {
        List<String> excludeAuthPatterns = new ArrayList<>(
                Arrays.asList(
                        "/v1/health", "error",
                        "/swagger-ui/**", "swagger-resources/**",
                        "/v3/api-docs/**",
                        "file/**",
                        "/v1/translated-message/deploy-all"
                )
        );

        excludeAuthPatterns.addAll(Arrays.asList(authenticationExcludePaths));
        return excludeAuthPatterns;
    }
}
