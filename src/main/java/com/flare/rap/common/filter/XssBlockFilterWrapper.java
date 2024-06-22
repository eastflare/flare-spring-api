package com.flare.rap.common.filter;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
public class XssBlockFilterWrapper extends HttpServletRequestWrapper {

    private String requestData;

    public XssBlockFilterWrapper(HttpServletRequest request) throws IOException {
        super(request);
        requestData = this.requestDataByte(request);
    }

    private String requestDataByte(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        byte[] rawData = StreamUtils.copyToByteArray(inputStream);
        return new String(rawData);
    }

    @Override
    public ServletInputStream getInputStream() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(this.requestData.getBytes(StandardCharsets.UTF_8));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() { return inputStream.available() == 0; }

            @Override
            public boolean isReady() { return true; }

            @Override
            public void setReadListener(ReadListener readListener) { throw new UnsupportedOperationException(); }

            @Override
            public int read() { return inputStream.read(); }
        };
    }

    @Override
    public BufferedReader getReader() { return new BufferedReader(new InputStreamReader(getInputStream())); }
}
