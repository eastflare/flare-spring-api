package com.flare.rap.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.session.model.UserSessionVO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SessionScopeUtil {
    public static void setRequestContext(String name, Object value) {
        RequestContextHolder.getRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_REQUEST);
    }

    public static Object getRequestContext(String name) {
        return RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_REQUEST);
    }

    public static UserSessionVO getContextSession() {
        return (UserSessionVO) getRequestContext(CommonConstants.HTTP_SESSION_KEY);
    }

    public static void setContextSession(Object value) {
        setRequestContext(CommonConstants.HTTP_SESSION_KEY, value);
    }

}