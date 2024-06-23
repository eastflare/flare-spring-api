package com.flare.rap.common.interceptor;

import com.flare.rap.api.service.ApiUrlService;
import com.flare.rap.common.constants.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final ApiUrlService apiUrlService;

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {

        if(request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }

        String uurl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();

        HttpSession session = request.getSession(false);
        if( session == null) {
            throw new BusinessException("Session Expire - session, Access url is " + uurl, StatusCodeConstants.SESSION_EXPIRE);
        }

        return true;
    }
}
