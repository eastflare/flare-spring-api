package com.flare.rap.common.util;

import org.apache.commons.text.StringEscapeUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    private static final Pattern TAG_REG = Pattern.compile(
"<((/?)([a-zA-Z]+)([^<>]*)(\\s*/?))>?", 106);

    public static boolean checkXSS(String value) {
        if(value == null || value.length() == 0)
            return true;

        /*
        Matcher tagMatcher = TAG_REG.matcher(value);
        while (tagMatcher.find()){
            String tag = tagMatcher.group(3).toLowerCase();
            if(TAGLIST.contains(tag)){
                return false;
            }
        }
        */

        return true;
    }

    public static String charEscape(String value) {
        return value == null ? value : StringEscapeUtils.escapeHtml4(value);
    }

    public static String charUnescape(String value) {
        return value == null ? value : StringEscapeUtils.unescapeHtml4(value);
    }
}
