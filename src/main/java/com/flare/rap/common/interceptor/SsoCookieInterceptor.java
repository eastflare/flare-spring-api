package com.flare.rap.common.interceptor;


import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.EncryptUtil;
import com.flare.rap.common.util.NetworkUtil;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.session.service.SessionService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class SsoCookieInterceptor implements HandlerInterceptor {

    private final SessionService sessionService;

    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @Value("${sso.nls-url}")
    private static String NLS_URL;
    @Value("${sso.toa}")
    private String TOA = "1";
    @Value("${sso.sso-domain}")
    private String SSO_DOMAIN = ".lgensol.com";
    @Value("${sso.nls-port}")
    private String NLS_PORT = "8001";
    private String NLS_LOGIN_URL = NLS_URL + ":" + NLS_PORT + "/nls3/cookieLogin.jsp";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws Exception {
        log.debug("SsoCookieInterceptor preHandle()");

        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
            return true;
        }

        // 로컬환경에서는 동작하지 않도록 합니다.
        if("default".equals(profile) || "local".equals(profile)){
            return true;
        }

        // Session 정보가 이미 있으면 그냥 Pass
        if(sessionService.isAuthentication(request)) {
            log.debug("Session is already valid");
            return true;
        }

        // SSO 로그인 페이지로 리다이렉션 하기 위한 url 구성
        String uurl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
        // engpuid 에는 암호화된 GPortal ID가 들어있습니다.
        String encUserId = EncryptUtil.parseEncCookies("engpuid", request);
        String timeZone = NetworkUtil.getCookieValue("UserTimeZone", request);
        String timeZoneDecode = null;
        if(timeZone != null) {
            timeZoneDecode = java.net.URLDecoder.decode(timeZone, StandardCharsets.UTF_8);
        }

        if (encUserId == null) { // encUserId가 null인 경우는 SSO 로그인하지 않은 사용자가 접속했을 경우이다.
            throw new BusinessException("You are not logged in to SSO, Access url is " + uurl, StatusCodeConstants.SESSION_EXPIRE);
            // 필요한 경우 SSO 로그인 페이지로 이동
            //response.sendRedirect(NLS_LOGIN_URL + "?UURL=" + uurl + "&RTOA=" + TOA);
            //return false;
        } else {
            String decKey = "ThisIsIkepSecurityKey";
            String decUserId = EncryptUtil.decryptText(encUserId, decKey);
            log.debug("decUserId => " + decUserId);
            decUserId = decUserId.split("\\|")[1];

            String langCd = "ko";
            Cookie[] cookies = request.getCookies();

            if(cookies != null) {
                for(int i=0; i< cookies.length;i++) {
                    if(cookies[i].getName().equals("language")) {
                        langCd = cookies[i].getValue();
                        break;
                    }
                }
            }
            langCd = "ch".equals(langCd) ? "zhC" :
                     "ko".equals(langCd) ? "ko" :
                     "en".equals(langCd) ? "en" :
                             "ko";

            String userIp = NetworkUtil.getClientIP(request);

            UserSessionVO userSession = null;
            if(timeZoneDecode != null)
                userSession = sessionService.createUserSession(decUserId, langCd, userIp, timeZoneDecode);  // 쿠키의 타임존을 설정
            else
                userSession = sessionService.createUserSession(decUserId, langCd, userIp); // 로그인 사용자의 소속 법인 타임존으로 설정

            if (userSession != null) {

                // 시스템에서 사용할 전용 세션값이 필요하다면 여기에 추가 바랍니다.
                //userSession.setAdditionalValueSample("SampleValue");

                HttpSession session = request.getSession(true);
                session.setAttribute(CommonConstants.HTTP_SESSION_KEY, userSession);

                SessionScopeUtil.setContextSession(userSession);

                return true;
            }

        }

        // 필요한 경우 SSO 로그인 페이지로 이동
        //response.sendRedirect(NLS_LOGIN_URL + "?UURL=" + uurl + "&RTOA=" + TOA);
        return false;
    }

}