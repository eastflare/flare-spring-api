package com.flare.rap.common.interceptor;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.flare.rap.api.service.ApiUrlService;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.StringUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.session.model.UserSessionVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final ApiUrlService apiUrlService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
            return true;
        }

        String uurl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();

        HttpSession session = request.getSession(false);
        if(session == null) {
            throw new BusinessException("Session Expire - session, Access url is " + uurl, StatusCodeConstants.SESSION_EXPIRE);
        }

        UserSessionVO userSession = (UserSessionVO)session.getAttribute(CommonConstants.HTTP_SESSION_KEY);

        String apiUrl = request.getRequestURI();
        String httpMthdCd = request.getMethod();

        if(userSession == null){
            if(httpMthdCd.equals("POST") && apiUrl.contains("/v1/log")){
                return true;
            }

            throw new BusinessException("Session Expire - userSession, Access url is " + uurl, StatusCodeConstants.SESSION_EXPIRE);
        }else {
            String language = request.getHeader("x-language");
            if(!ValidateUtil.isEmpty(language) && !userSession.getLangCd().equals(language)){
                userSession.setLangCd(language);
                session.setAttribute(CommonConstants.HTTP_SESSION_KEY, userSession);
            }
            SessionScopeUtil.setContextSession(userSession);

            String queryString = ValidateUtil.charUnescape(StringUtil.nullConvert(request.getQueryString()));
            log.debug("The user who attempted to access the account is {} - {} ( {} , {} ), API URL : {} - {}{}{} ", userSession.getUserId() , userSession.getEmpNo(), userSession.getLangCd(), userSession.getTimeZoneCd(), httpMthdCd, apiUrl, request.getQueryString() == null ? "":"?", queryString );

            List< String> roleCodes = userSession.getRoleCodes();

            if(ValidateUtil.isEmpty(roleCodes) || !apiUrlService.checkAccessibleApiUrlsByRoleCodes(apiUrl, httpMthdCd, roleCodes)){
                throw new BusinessException("Inaccessible Api, Access url is " + uurl, StatusCodeConstants.NOT_AUTHORIZED_EXCEPTION);
            }
        }
        return true;
    }
}