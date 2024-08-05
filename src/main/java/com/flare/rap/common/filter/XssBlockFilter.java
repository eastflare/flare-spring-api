package com.flare.rap.common.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flare.rap.common.constants.CommonConstants;
import com.flare.rap.common.constants.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.util.ValidateUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.PathContainer;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
public class XssBlockFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    private final List<PathPattern> excludePathList = new ArrayList<PathPattern>();

    public XssBlockFilter(String[] excludePaths, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        PathPatternParser pathPatternParser = new PathPatternParser();
        for(String excludePath : excludePaths) {
            excludePathList.add(pathPatternParser.parse(excludePath));
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String method = request.getMethod();
        if(method.equals(HttpMethod.GET.name())) {
            validateRequestParameter(request, response, filterChain);
        }else{
            validateRequestBody(request, response, filterChain);
        }
    }

    private void validateRequestParameter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);

            if(!ValidateUtil.checkXSS(parameterValue)){
                onError(HttpStatus.BAD_REQUEST, response, String.format("XSS Forbidden String include : %s, %s", parameterName, parameterValue));
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validateRequestBody(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        XssBlockFilterWrapper xssBlockFilterWrapper =new XssBlockFilterWrapper(request);
        StringBuilder sb = getBodyToStringBuilder(response, filterChain, xssBlockFilterWrapper);
        if (sb == null) return;

        try{
            HashMap map = objectMapper.readValue(sb.toString(), HashMap.class);
            Set<String> keys = map.keySet();
            for(String key : keys) {
                if(!ValidateUtil.checkXSS(map.get(key).toString())){
                    onError(HttpStatus.BAD_REQUEST, response, String.format("XSS Forbidden String include : %s, %s", key, map.get(key).toString()));
                    return;
                }
            }
        } catch (NullPointerException ne) {
            // data 중 null 값이 발생
        } catch (JsonProcessingException e) {
            onError(HttpStatus.INTERNAL_SERVER_ERROR, response, "서버 내부 에러 발생");
            return;
        }
        filterChain.doFilter(xssBlockFilterWrapper, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // 필터를 그냥 통과시키려면 true 를 리턴
        PathContainer parsePath = PathContainer.parsePath(request.getRequestURI());

        for(PathPattern pattern : excludePathList) {
            if(pattern.matches(parsePath)) {
                log.debug(String.format("XssBlockFilter -- ExcludePath is : %s matched requestURI is : %s", pattern.getPatternString(), request.getRequestURI()));
                return true;
            }
        }
        return false;
    }

    private StringBuilder getBodyToStringBuilder(HttpServletResponse response, FilterChain filterChain, XssBlockFilterWrapper xssBlockFilterWrapper) throws IOException, ServletException {
        StringBuilder sb = new StringBuilder();
        try{
            ServletInputStream inputStream = xssBlockFilterWrapper.getInputStream();
            if(inputStream != null){
                String line = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = br.readLine()) != null){
                    sb.append(line);
                }
            }
        } catch (IOException e) {
            log.debug("No request data in body");
            filterChain.doFilter(xssBlockFilterWrapper, response);
            return null;
        }
        return sb;
    }

    void onError(HttpStatus httpStatus, HttpServletResponse response, String message, Error error){

        ResponseEntity<CommonResponseVO> errorResponse = new ResponseEntity<>(CommonResponseVO.builder()
                .successOrNot(CommonConstants.NO_FLAG)
                .statusCode(StatusCodeConstants.XSS_FORBIDDEN_STRING_INCLUDE)
                .data(message)
                .build(), HttpStatus.BAD_REQUEST);

        response.setStatus(httpStatus.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try{
            response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
        } catch (IOException e) {
            log.error("filter error !",e);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    void onError(HttpStatus httpStatus, HttpServletResponse response, String message) {
        onError(httpStatus, response, message, new Error());
    }
}
