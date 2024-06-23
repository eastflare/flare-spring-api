package com.flare.rap.common.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StatusCodeConstants {

    public static final String SUCCESS = "S";
    public static final String FAIL = "F";
    public static final String MANDATORY_PARAM_ERROR = "MANDATORY_PARAM_ERROR";
    public static final String PARAMETER_VALUE_ERROR = "PARAMETER_VALUE_ERROR";
    public static final String DUPLICATED_VALUE_ERROR = "DUPLICATED_VALUE_ERROR";
    public static final String EXPECTATION_FAILED = "EXPECTATION_FAILED";
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";

    //Common
    public static final String DUPLICATE_KEY_EXCEPTION = "DUPLICATE_KEY_EXCEPTION";

    //Session
    public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
    public static final String SESSION_EXPIRE = "SESSION_EXPIRE";
    public static final String NOT_AUTHORIZED_EXCEPTION = "NOT_AUTHORIZED_EXCEPTION";

    //XSS
    public static final String XSS_FORBIDDEN_STRING_INCLUDE = "XSS_FORBIDDEN_STRING_INCLUDE";
}
