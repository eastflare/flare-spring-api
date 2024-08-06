package com.flare.rap.common.util;

import com.flare.rap.common.exception.BusinessException;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class FormatUtil {

    public static String getEmployeeEmail(String userId, String empNo) throws BusinessException {
        if (empNo.matches("^[0-9]+$")) {
            return userId + "@lgensol.com";
        } else if (empNo.matches("^F[0-9]+$")) {
            return userId + "@lgespartner.com";
        }
        return null;
    }
}