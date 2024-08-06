package com.flare.rap.common.util;

public enum LocaleUtil {
    KO_KR("ko_KR", "ko"),
    EN_US("en_US", "en"),
    PL_PL("pl_PL", "pl"),
    ZH_CN("zh_CN", "zhC"),
    ZH_TW("zh_TW", "zhT");

    private final String localeCode;
    private final String languageCode;

    LocaleUtil(String localeCode, String languageCode) {
        this.localeCode = localeCode;
        this.languageCode = languageCode;
    }

    public static String getLanguageCodeFromLocale(String locale) {
        for (LocaleUtil loc : LocaleUtil.values()) {
            if (loc.localeCode.equals(locale)) {
                return loc.languageCode;
            }
        }
        return "ko";
    }

    public static boolean hasLanguageCode(String languageCode) {
        for (LocaleUtil loc : LocaleUtil.values()) {
            if (loc.languageCode.equals(languageCode)) {
                return true;
            }
        }
        return false;
    }
}