package com.flare.rap.common.filter;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flare.rap.common.util.HtmlCharacterEscapes;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.PathContainer;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class XssReplaceFilter extends OncePerRequestFilter {

    private final List<PathPattern> excludePathList = new ArrayList<PathPattern>();
    private ObjectMapper objectMapper;

    public XssReplaceFilter(String[] excludePaths, ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
        PathPatternParser pathPatternParser = new PathPatternParser();
        for(String excludePath : excludePaths){
            excludePathList.add(pathPatternParser.parse(excludePath));
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        XssReplaceFilterWrapper xssReplaceFilterWrapper = new XssReplaceFilterWrapper(request);
        String body = IOUtils.toString(xssReplaceFilterWrapper.getReader());

        if(!StringUtils.isBlank(body)){
            objectMapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());
            Object replacedJsonObject = objectMapper.readValue(body, Object.class);

            xssReplaceFilterWrapper.resetInputStream(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(replacedJsonObject));
        }

        filterChain.doFilter(xssReplaceFilterWrapper, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // 필터를 그냥 통과시키려면 true 를 리턴
        PathContainer parsePath = PathContainer.parsePath(request.getRequestURI());

        for(PathPattern pattern : excludePathList){
            if(pattern.matches(parsePath)){
                log.debug(String.format("XssReplaceFilter -- ExcludePath is : %s matched requestURI is : %s", pattern.getPatternString(), request.getRequestURI() ));
                return true;
            }
        }
        return false;
    }
}
