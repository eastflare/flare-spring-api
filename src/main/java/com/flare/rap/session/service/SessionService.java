package com.flare.rap.session.service;

import com.flare.rap.session.model.UserSessionVO;

import jakarta.servlet.http.HttpServletRequest;

public interface SessionService {

    UserSessionVO createUserSession(String userId, String langCd, String userIp);

    UserSessionVO createUserSession(String userId, String langCd, String userIp, String timeZone);

    public boolean isAuthentication(HttpServletRequest request);

    void updateUserSessionLangCd(String langCd);

}