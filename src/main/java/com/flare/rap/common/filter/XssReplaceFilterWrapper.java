package com.flare.rap.common.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.flare.rap.common.util.ValidateUtil;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class XssReplaceFilterWrapper extends HttpServletRequestWrapper {

    private byte[] rawData;
    private HttpServletRequest request;
    private ResettableServletInputStream servletStream;



    public XssReplaceFilterWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
        this.servletStream = new ResettableServletInputStream();
    }

    public void resetInputStream(byte[] data) {
        servletStream.stream = new ByteArrayInputStream(data);
    }


    // XSS replace
    private byte[] replaceXSS(byte[] data) {
        String strData = new String(data);
        strData = ValidateUtil.charEscape(strData);

        return strData.getBytes();
    }

    private String replaceXSS(String value) {
        if(value != null) {
            value = ValidateUtil.charEscape(value);
        }
        return value;
    }

    //새로운 인풋스트림을 리턴하지 않으면 에러가 남
    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (rawData == null) {
            rawData = IOUtils.toByteArray(this.request.getReader());
            servletStream.stream = new ByteArrayInputStream(rawData);
        }
        return servletStream;
    }

    @Override
    public String getQueryString() {
        return replaceXSS(super.getQueryString());
    }


    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value == null) {
            return null;
        }
        value = replaceXSS(value);
        return value;
    }


    @Override
    public Map< String, String[]> getParameterMap() {
        Map< String, String[]> params = super.getParameterMap();
        if(params != null) {
            params.forEach((key, value) -> {
                for(int i=0; i< value.length; i++) {
                    value[i] = replaceXSS(value[i]);
                }
            });
        }
        return params;
    }


    @Override
    public String[] getParameterValues(String parameter) {
        String[] params = super.getParameterValues(parameter);
        if(params != null) {
            for(int i=0; i< params.length; i++) {
                params[i] = replaceXSS(params[i]);
            }
        }
        return params;
    }


    @Override
    public BufferedReader getReader() throws IOException {
        if (rawData == null) {
            rawData = IOUtils.toByteArray(this.request.getReader());
            servletStream.stream = new ByteArrayInputStream(rawData);
        }
        return new BufferedReader(new InputStreamReader(servletStream));
    }

    private class ResettableServletInputStream extends ServletInputStream {

        private InputStream stream;

        @Override
        public int read() throws IOException {
            return stream.read();
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener listener) {
        }
    }

}