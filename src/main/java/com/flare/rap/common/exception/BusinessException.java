package com.flare.rap.common.exception;

import com.flare.rap.common.constant.StatusCodeConstants;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String message;
    private final String statusCode;

    public BusinessException(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public BusinessException(String message) {
        this(message, StatusCodeConstants.FAIL);
    }

    public BusinessException(String message, Throwable cause) {
        this(message, StatusCodeConstants.FAIL, cause);
    }

    public BusinessException(String message, String statusCode, Throwable cause) {
        super(cause);
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatusCode() {
        return statusCode;
    }
}