package com.flare.rap.session.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.util.NetworkUtil;
import com.flare.rap.notice.model.NoticePostRequestVO;
import com.flare.rap.session.model.DevLoginRequestVO;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.session.service.SessionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "0. Session")
@Validated
@RequestMapping("/api")
public class SessionController {

    private final SessionService sessionService;

    @Operation(summary = "FW제공 개발용 로그인 및 세션 생성")
    @PostMapping(value = "/v1/dev/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<UserSessionVO>> login(
            @RequestBody DevLoginRequestVO devLoginRequest,
            HttpServletRequest request,
            HttpServletResponse response)
            throws BusinessException {

        HttpSession session = request.getSession();
        String userIp = NetworkUtil.getClientIP(request);
        UserSessionVO userSession = sessionService.createUserSession(devLoginRequest.getUserId(), devLoginRequest.getLangCd(), userIp);

        if (userSession != null) {
            session.setAttribute(CommonConstants.HTTP_SESSION_KEY, userSession);

            return new ResponseEntity(CommonResponseVO.<UserSessionVO>builder()
                    .successOrNot(CommonConstants.YES_FLAG)
                    .statusCode(StatusCodeConstants.SUCCESS)
                    .data(userSession)
                    .build(), OK);
        } else {
            return new ResponseEntity(CommonResponseVO.<UserSessionVO>builder()
                    .successOrNot(CommonConstants.NO_FLAG)
                    .statusCode(StatusCodeConstants.USER_NOT_FOUND)
                    .build(), UNAUTHORIZED);
        }
    }

    @Operation(summary = "세션 조회")
    @GetMapping(value = "/v1/session", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<UserSessionVO>> getSession(
            HttpServletRequest request)
            throws BusinessException {

        HttpSession session = request.getSession();
        UserSessionVO userSession = (UserSessionVO)session.getAttribute(CommonConstants.HTTP_SESSION_KEY);

        if (userSession != null) {
            return new ResponseEntity(CommonResponseVO.<UserSessionVO>builder()
                    .successOrNot(CommonConstants.YES_FLAG)
                    .statusCode(StatusCodeConstants.SUCCESS)
                    .data(userSession)
                    .build(), OK);
        } else {
            return new ResponseEntity(CommonResponseVO.<UserSessionVO>builder()
                    .successOrNot(CommonConstants.NO_FLAG)
                    .statusCode(StatusCodeConstants.SESSION_EXPIRE)
                    .build(), UNAUTHORIZED);
        }
    }

    @Operation(summary = "세션 언어 변경")
    @PutMapping(value = "/v1/session/langCd", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> updateUserSessionLangCd(
            @RequestBody@Parameter(description = "언어", example = "ko", required = true) String langCd)
            throws BusinessException {

        sessionService.updateUserSessionLangCd(langCd);

        return new ResponseEntity(CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .build(), OK);
    }
}