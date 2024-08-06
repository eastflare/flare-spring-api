package com.flare.rap.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityUtil {

    public static String XSSEncoding(String target) {
        if (target == null) {
            return target;
        }
        target = target.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        target = target.replaceAll("\\(", "&#40").replaceAll("\\)", "&#41");
        target = target.replaceAll("'", "&#39");
        target = target.replaceAll("eval\\((.*)\\)", "");
        target = target.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        target = target.replaceAll("script", "");
        return target;
    }
}