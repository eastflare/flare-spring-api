package com.flare.rap.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.text.StringEscapeUtils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public final class ValidateUtil {
    public static final String NUMERIC_PATTERN = "^\\d+$";
    public static final String ALPHA_NUMERIC_PATTERN = "^[A-Za-z0-9]+$";
    public static final String ALPHABETIC_PATTERN = "^[a-zA-Z]+$";
    public static final String FLOAT_PATTERN = "^(\\-|\\+)?\\d+(\\.\\d+|\\d*)\\d*$";
    public static final String INTEGER_PATTERN = "^(\\+|\\-)?\\d+$";
    public static final String LOWER_CASE_PATTERN = "^\\p{Lower}+$";
    public static final String UPPER_CASE_PATTERN = "^\\p{Upper}+$";
    public static final String DOMAIN_PATTERN = "^[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]{2,4}$";
    private static final String MOBILE_PHONE_EXCHANGE_NUMBER_PATTERN = "01[016789]";
    private static final String TELEPHONE_EXCHANGE_NUMBER_PATTERN = "02|03[1-3]|04[1-3]|05[1-5]|06[1-4]|030|0303|050[1-9]|0[6-8]0|0130";
    private static final String PHONE_MIDDLE_NUMBER_PATTERN = "[1-9]{1}[0-9]{2,3}";
    private static final String TELEPHONE_NOT_EXIST_MIDDLE_NUMBER_PATTERN = "1[56][0-9]{2}";
    private static final String PHONE_BACK_NUMBER_PATTERN = "\\d{4}";
    private static final Pattern TAG_REG = Pattern.compile(
            "<((/?)([a-zA-Z]+)([^<>]*)(\\s*/?))>?", 106);

    private static final Pattern EVENT_REG = Pattern.compile(
            "(\\s+)([a-zA-Z]+)(.*?)(=)(.+?[\\(|\\#].+?)", 106);

    private static final Pattern KISA_REG = Pattern.compile(
            "<((/?)([a-zA-Z]+)([^<>]*)(\\s*/?))>?", 106);

    public static final String[] ALLTAGS = { "a", "abbr", "acronym", "address",
            "applet", "area", "b", "base", "basefont", "bdo", "big",
            "blockquote", "body", "br", "button", "caption", "center", "cite",
            "code", "col", "colgroup", "dd", "del", "dfn", "dir", "div", "dl",
            "dt", "em", "fieldset", "font", "form", "frame", "frameset", "h1",
            "h2", "h3", "h4", "h5", "h6", "head", "hr", "html", "i", "iframe",
            "img", "input", "ins", "isindex", "kbd", "label", "legend", "li",
            "link", "map", "menu", "meta", "noframes", "noscript", "object",
            "ol", "optgroup", "option", "p", "param", "pre", "q", "samp",
            "script", "select", "small", "span", "strong", "style", "sub",
            "sup", "table", "tbody", "td", "textarea", "tfoot", "th", "thead",
            "title", "tr", "tt", "ul", "var", "bgsound", "comment", "embed",
            "listing", "marquee", "nextid", "nobr", "plaintext", "rt", "ruby",
            "s", "strike", "u", "wbr", "xml", "xmp" };

    public static final String[] ALLEVENTS = { "fscommand", "onabort",
            "onactivate", "onafterprint", "onafterupdate", "onbeforeactivate",
            "onbeforecopy", "onbeforecut", "onbeforedeactivate",
            "onbeforeeditfocus", "onbeforepaste", "onbeforeprint",
            "onbeforeunload", "onbeforeupdate", "onbegin", "onblur",
            "onbounce", "oncellchange", "onchange", "onclick", "oncontextmenu",
            "oncontrolselect", "oncopy", "oncut", "ondataavailable",
            "ondatasetchanged", "ondatasetcomplete", "ondblclick",
            "ondeactivate", "ondrag", "ondragdrop", "ondragend", "ondragenter",
            "ondragleave", "ondragover", "ondragstart", "ondrop", "onend",
            "onerror", "onerrorupdate", "onfilterchange", "onfinish",
            "onfocus", "onfocusin", "onfocusout", "onhelp", "onkeydown",
            "onkeypress", "onkeyup", "onlayoutcomplete", "onload",
            "onlosecapture", "onmediacomplete", "onmediaerror", "onmousedown",
            "onmouseenter", "onmouseleave", "onmousemove", "onmouseout",
            "onmouseover", "onmouseup", "onmousewheel", "onmove", "onmoveend",
            "onmovestart", "onoutofsync", "onpaste", "onpause", "onprogress",
            "onpropertychange", "onreadystatechange", "onrepeat", "onreset",
            "onresize", "onresizeend", "onresizestart", "onresume",
            "onreverse", "onrowdelete", "onrowenter", "onrowexit",
            "onrowinserted", "onrowsdelete", "onrowsenter", "onrowsinserted",
            "onscroll", "onseek", "onselect", "onselectionchange",
            "onselectstart", "onstart", "onstop", "onsubmit", "onsyncrestored",
            "ontimeerror", "ontrackchange", "onunload", "onurlflip",
            "seeksegmenttime" };

    public static final String[] KISA_XSS = {"alert", "append", "binding", "blink",
            "charset", "cookie", "create", "document", "eval", "expression", "href",
            "ilayer", "innerHTML", "javascript", "layer", "msgbox", "refresh",
            "string", "vbscript", "void"};

    // EDITOR 용 XSS 처리
    public static final String[] EDITOR_TAGS = { "form", "frame", "frameset",
            "iframe", "input", "ins", "isindex", "kbd", "noframes", "noscript",
            /*"object", "param",*/ "pre", "script", "sub", "ruby",
            /*"embed",*/  "listing", "marquee", "nextid", "nobr", "plaintext", "rt",
            "wbr", "xml", "xmp" };

    public static final String[] EDITOR_EVENTS = { "fscommand", "onabort",
            "onactivate", "onafterprint", "onafterupdate", "onbeforeactivate",
            "onbeforecopy", "onbeforecut", "onbeforedeactivate",
            "onbeforeeditfocus", "onbeforepaste", "onbeforeprint",
            "onbeforeunload", "onbeforeupdate", "onbegin", "onblur",
            "onbounce", "oncellchange", "onchange",/* "onclick",*/ "oncontextmenu",
            "oncontrolselect", "oncopy", "oncut", "ondataavailable",
            "ondatasetchanged", "ondatasetcomplete", "ondblclick",
            "ondeactivate", "ondrag", "ondragdrop", "ondragend", "ondragenter",
            "ondragleave", "ondragover", "ondragstart", "ondrop", "onend",
            "onerror", "onerrorupdate", "onfilterchange", "onfinish",
            "onfocus", "onfocusin", "onfocusout", "onhelp", "onkeydown",
            "onkeypress", "onkeyup", "onlayoutcomplete", "onload",
            "onlosecapture", "onmediacomplete", "onmediaerror", "onmousedown",
            "onmouseenter", "onmouseleave", "onmousemove", "onmouseout",
            "onmouseover", "onmouseup", "onmousewheel", "onmove", "onmoveend",
            "onmovestart", "onoutofsync", "onpaste", "onpause", "onprogress",
            "onpropertychange", "onreadystatechange", "onrepeat", "onreset",
            "onresize", "onresizeend", "onresizestart", "onresume",
            "onreverse", "onrowdelete", "onrowenter", "onrowexit",
            "onrowinserted", "onrowsdelete", "onrowsenter", "onrowsinserted",
            "onscroll", "onseek", "onselect", "onselectionchange",
            "onselectstart", "onstart", "onstop", "onsubmit", "onsyncrestored",
            "ontimeerror", "ontrackchange", "onunload", "onurlflip",
            "seeksegmenttime" };

    public static final String[] EDITOR_KISA_XSS = {"alert", "append", "binding", "blink",
            "charset", "cookie", "create", "document", "eval", "expression",
            "ilayer", "innerHTML", "javascript", "layer", "msgbox", "refresh",
            "string", "vbscript", "void"};

    private static final Pattern[] scriptPatterns = new Pattern[] {
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };

    public static final List<String> TAGLIST = Arrays.asList(ALLTAGS);

    public static final List<String> EVENTLIST = Arrays.asList(ALLEVENTS);

    public static final List<String> KISAXSSLIST = Arrays.asList(KISA_XSS);
    // editor 용
    public static final List<String> EDITOR_TAGLIST = Arrays.asList(EDITOR_TAGS);

    public static final List<String> EDITOR_EVENTLIST = Arrays.asList(EDITOR_EVENTS);

    public static final List<String> EDITOR_KISAXSSLIST = Arrays.asList(EDITOR_KISA_XSS);


    public static boolean checkXSS(String value) {
        if (value == null || value.length() == 0)
            return true;

        Matcher tagMatcher = TAG_REG.matcher(value);
        while (tagMatcher.find()) {
            String tag = tagMatcher.group(3).toLowerCase();
            if (TAGLIST.contains(tag)) {
                return false;
            }
        }

        Matcher eventMatcher = EVENT_REG.matcher(value);
        while (eventMatcher.find()) {
            String event = eventMatcher.group(2).toLowerCase();
            if (EVENTLIST.contains(event)) {
                return false;
            }
        }

        Matcher kisaxssMatcher = KISA_REG.matcher(value);
        while (kisaxssMatcher.find()) {
            String tag = kisaxssMatcher.group(3).toLowerCase();
            if (KISAXSSLIST.contains(tag)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkXSSEditor(String value) {
        if (value == null || value.length() == 0)
            return true;

        Matcher tagMatcher = TAG_REG.matcher(value);
        while (tagMatcher.find()) {
            String tag = tagMatcher.group(3).toLowerCase();
            if (EDITOR_TAGLIST.contains(tag)) {
                return false;
            }
        }

        Matcher eventMatcher = EVENT_REG.matcher(value);
        while (eventMatcher.find()) {
            String event = eventMatcher.group(2).toLowerCase();
            if (EDITOR_EVENTLIST.contains(event)) {
                return false;
            }
        }

        Matcher kisaxssMatcher = KISA_REG.matcher(value);
        while (kisaxssMatcher.find()) {
            String tag = kisaxssMatcher.group(3).toLowerCase();
            if (EDITOR_KISAXSSLIST.contains(tag)) {
                return false;
            }
        }
        return true;
    }

    public static String charEscape(String value) {
        return value == null ? value : StringEscapeUtils.escapeHtml4(value);
    }

    public static String charUnescape(String value) {
        return value == null ? value : StringEscapeUtils.unescapeHtml4(value);
    }

    public static boolean checkSqlInjection(String value) {
        if ((value == null) || (value.length() == 0))
            return true;
        String str = "#,--,;,'='',&quot;=&quot;&quot;,\\=\\\\,%,'',<,>,(,)";
        String[] pattern = str.split("\\,");
        for (int idx = 0; idx < pattern.length; ++idx) {
            if (value.indexOf(pattern[idx]) > -1)
                return false;
        }
        return true;
    }

    public static boolean checkPhone(String frontNumber, String middleNumber,
                                     String backNumber) {
        if (frontNumber == null || frontNumber.length() == 0) {
            if ((middleNumber == null)
                    || (!(middleNumber.matches("1[56][0-9]{2}"))))
                return false;

        } else {
            if (!(frontNumber
                    .matches("01[016789]|02|03[1-3]|04[1-3]|05[1-5]|06[1-4]|030|0303|050[1-9]|0[6-8]0|0130")))
                return false;

            if ((middleNumber == null)
                    || (!(middleNumber.matches("[1-9]{1}[0-9]{2,3}"))))
                return false;
        }

        return ((backNumber != null) && (backNumber.matches("\\d{4}")));
    }

    public static boolean checkPhone(String number) {
        String phoneNumber = number;
        if (phoneNumber == null)
            return false;

        phoneNumber = phoneNumber.trim().replace("-", "");

        if (phoneNumber.length() == 8) {
            return phoneNumber.matches("1[56][0-9]{2}\\d{4}");
        }

        return phoneNumber
                .matches("(01[016789]|02|03[1-3]|04[1-3]|05[1-5]|06[1-4]|030|0303|050[1-9]|0[6-8]0|0130)[1-9]{1}[0-9]{2,3}\\d{4}");
    }

    public static boolean checkTelephone(String frontNumber,
                                         String middleNumber, String backNumber) {
        if (frontNumber == null || frontNumber.length() == 0) {
            if ((middleNumber == null)
                    || (!(middleNumber.matches("1[56][0-9]{2}"))))
                return false;

        } else {
            if (!(frontNumber
                    .matches("02|03[1-3]|04[1-3]|05[1-5]|06[1-4]|030|0303|050[1-9]|0[6-8]0|0130")))
                return false;

            if ((middleNumber == null)
                    || (!(middleNumber.matches("[1-9]{1}[0-9]{2,3}"))))
                return false;
        }

        return ((backNumber != null) && (backNumber.matches("\\d{4}")));
    }

    public static boolean checkTelephone(String number) {
        String phoneNumber = number;

        if (phoneNumber == null)
            return false;

        phoneNumber = phoneNumber.trim().replace("-", "");

        if (phoneNumber.length() == 8) {
            return phoneNumber.matches("1[56][0-9]{2}\\d{4}");
        }
        return phoneNumber
                .matches("(02|03[1-3]|04[1-3]|05[1-5]|06[1-4]|030|0303|050[1-9]|0[6-8]0|0130)[1-9]{1}[0-9]{2,3}\\d{4}");
    }

    public static boolean checkMobilePhone(String frontNumber,
                                           String middleNumber, String backNumber) {
        if ((frontNumber == null) || (!(frontNumber.matches("01[016789]"))))
            return false;

        if ((middleNumber == null)
                || (!(middleNumber.matches("[1-9]{1}[0-9]{2,3}"))))
            return false;

        return ((backNumber != null) && (backNumber.matches("\\d{4}")));
    }

    public static boolean checkMobilePhone(String number) {
        String phoneNumber = number;
        if (phoneNumber == null)
            return false;

        phoneNumber = phoneNumber.trim().replace("-", "");

        return phoneNumber.matches("01[016789][1-9]{1}[0-9]{2,3}\\d{4}");
    }

    public static boolean checkEmail(String frontAddress, String domainAddress) {
        if ((frontAddress == null) || (domainAddress == null))
            return false;

        int count = 0;

        for (int i = 0; i < frontAddress.length(); ++i) {
            if ((frontAddress.charAt(i) <= 'z')
                    && (frontAddress.charAt(i) >= 'a'))
                continue;
            if ((frontAddress.charAt(i) <= 'Z')
                    && (frontAddress.charAt(i) >= 'A'))
                continue;
            if ((frontAddress.charAt(i) <= '9')
                    && (frontAddress.charAt(i) >= '0'))
                continue;
            if ((frontAddress.charAt(i) != '-')
                    || (frontAddress.charAt(i) != '_')) {
                return false;
            }
        }

        for (int i = 0; i < domainAddress.length(); ++i) {
            if ((domainAddress.charAt(i) <= 'z')
                    && (domainAddress.charAt(i) >= 'a'))
                continue;
            if (domainAddress.charAt(i) == '.') {
                ++count;
            } else {
                return false;
            }
        }

        return (count == 1);
    }

    public static boolean checkEmail(String address) {
        if (address == null)
            return false;

        String[] splitAddress = address.split("@");

        if (splitAddress.length == 2) {
            return checkEmail(splitAddress[0], splitAddress[1]);
        }
        return false;
    }

    public static boolean checkResidentRegNo(String frontNumber,
                                             String backNumber) {
        return checkResidentRegNo(frontNumber + backNumber, false);
    }

    public static boolean checkResidentRegNo(String number) {
        return checkResidentRegNo(number, false);
    }

    public static boolean checkResidentRegNo(String number,
                                             boolean includeHyphen) {
        String ssn = number;
        if (ssn == null)
            return false;

        ssn = ssn.trim();

        if ((ssn.length() != 13) && (ssn.length() != 14))
            return false;

        if (includeHyphen) {
            if (ssn.indexOf(45) != 6) {
                return false;
            }
            ssn = ssn.substring(0, 6) + ssn.substring(7);
        }

        if (!(ssn.matches("\\d{6}[1234]\\d{6}")))
            return false;

        String date = (((ssn.charAt(6) == '1') || (ssn.charAt(6) == '2')) ? "19"
                : "20")
                + ssn.substring(0, 6);

        if (!(checkDate(date, "yyyyMMdd")))
            return false;

        int[] multiplicand = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
        char[] characters = ssn.toCharArray();
        int size = multiplicand.length;

        if (characters.length != size + 1)
            return false;

        int sum = 0;
        for (int inx = 0; inx < size; ++inx) {
            sum += Character.getNumericValue(characters[inx])
                    * multiplicand[inx];
        }

        return ((11 - (sum % 11)) % 10 == Character
                .getNumericValue(characters[size]));
    }

    public static boolean checkAlienRegNo(String frontNumber, String backNumber) {
        return checkAlienRegNo(frontNumber + backNumber, false);
    }

    public static boolean checkAlienRegNo(String number) {
        return checkAlienRegNo(number, false);
    }

    public static boolean checkAlienRegNo(String number, boolean includeHyphen) {
            String frn = number;
            if (frn == null)
                return false;

            frn = frn.trim();

            if ((frn.length() != 13) && (frn.length() != 14))
                return false;

            if (includeHyphen) {
                if (frn.indexOf(45) != 6) {
                    return false;
                }
                frn = frn.substring(0, 6) + frn.substring(7);
            }

            if (!(frn.matches("\\d{6}[5678]\\d{6}")))
                return false;

            String date = (((frn.charAt(6) == '5') || (frn.charAt(6) == '6')) ? "19"
                    : "20")
                    + frn.substring(0, 6);

            if (!(checkDate(date, "yyyyMMdd")))
                return false;

            if ((Character.getNumericValue(frn.charAt(7)) * 10 + Character
                    .getNumericValue(frn.charAt(8))) % 2 != 0)
                return false;

            if ((Character.getNumericValue(frn.charAt(11)) < 6)
                    || (Character.getNumericValue(frn.charAt(11)) > 9))
                return false;

            int[] multiplicand = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
            char[] characters = frn.toCharArray();
            int size = multiplicand.length;

            if (characters.length != size + 1)
                return false;

            int sum = 0;
            for (int inx = 0; inx < size; ++inx) {
                sum += Character.getNumericValue(characters[inx])
                        * multiplicand[inx];
            }
            sum = 11 - (sum % 11);
            sum = (sum >= 10) ? sum - 10 : sum;
            sum += 2;
            sum = (sum >= 10) ? sum - 10 : sum;

            return (sum == Character.getNumericValue(characters[size]));
        }

        public static boolean checkCorpRegNo(String frontNumber, String backNumber) {
            return checkCorpRegNo(frontNumber + backNumber, false);
        }

        public static boolean checkCorpRegNo(String number) {
            return checkCorpRegNo(number, false);
        }

        public static boolean checkCorpRegNo(String number, boolean includeHyphen) {
            String crn = number;
            if (crn == null)
                return false;
            crn = crn.trim();

            if ((crn.length() != 13) && (crn.length() != 14))
                return false;

            if (includeHyphen) {
                if (crn.indexOf(45) != 6) {
                    return false;
                }
                crn = crn.substring(0, 6) + crn.substring(7);
            }

            if (!(crn.matches("\\d{13}")))
                return false;

            char[] characters = crn.toCharArray();

            int sum = 0;
            for (int inx = 0; inx < 12; ++inx) {
                sum += Character.getNumericValue(characters[inx]) * (inx % 2 + 1);
            }

            int digit = 10 - (sum % 10);
            digit = (digit >= 10) ? digit - 10 : digit;

            return (Character.getNumericValue(characters[12]) == digit);
        }

        public static boolean checkBizRegNo(String frontNumber,
                                            String middleNumber, String backNumber) {
            return checkBizRegNo(frontNumber + middleNumber + backNumber, false);
        }

        public static boolean checkBizRegNo(String number) {
            return checkBizRegNo(number, false);
        }

        public static boolean checkBizRegNo(String number, boolean includeHyphen) {
            String crn = number;
            if (crn == null)
                return false;

            if ((crn.length() != 10) && (crn.length() != 12))
                return false;

            if (includeHyphen) {
                if (!(crn.matches("\\d{3}-\\d{2}-\\d{5}"))) {
                    return false;
                }
                crn = crn.substring(0, 3) + crn.substring(4, 6) + crn.substring(7);
            }

            if (!(crn.matches("\\d{10}")))
                return false;

            int[] multiplicand = { 1, 3, 7, 1, 3, 7, 1, 3, 5 };
            char[] characters = crn.toCharArray();
            int size = multiplicand.length;

            if (characters.length != size + 1)
                return false;

            int sum = 0;
            for (int inx = 0; inx < size; ++inx) {
                sum += Character.getNumericValue(characters[inx])
                        * multiplicand[inx];
            }

            return (10 - ((sum + Character.getNumericValue(characters[(size - 1)]) * 5 / 10) % 10) == Character
                    .getNumericValue(characters[size]));
        }

        public static boolean checkDate(String date, String pattern) {
            return checkDate(date, pattern, Locale.getDefault());
        }

        public static boolean checkDate(String date, String pattern, Locale locale) {
            return checkDate(date, pattern, locale, 2);
        }

        public static boolean checkDate(String date, Locale locale) {
            return checkDate(date, null, locale, 2);
        }

        public static boolean checkDate(String date, Locale locale, int dateStyle) {
            return checkDate(date, null, locale, dateStyle);
        }

        public static boolean checkDate(String date, String pattern, Locale locale,
                                        int dateStyle) {
            Locale dateLocale = locale;
            if (date == null)
                return false;

            DateFormat dateFormat = null;

            if (dateLocale == null) {
                dateLocale = Locale.getDefault();
            }

            if ((pattern != null) && (pattern.length() > 0))
                dateFormat = new SimpleDateFormat(pattern, dateLocale);
            else {
                dateFormat = DateFormat.getDateInstance(dateStyle, dateLocale);
            }

            dateFormat.setLenient(false);
            try {
                Date result = dateFormat.parse(date);
                return ((result != null) && (date.equalsIgnoreCase(dateFormat
                        .format(result))));
            } catch (ParseException e) {
            }
            return false;
        }

        public static boolean checkFilePath(String path) {
            if (path == null)
                return true;

            return ((path.indexOf("..\\") == -1) && (path.indexOf("../") == -1));
        }

        public static boolean checkNumeric(String value) {
            if (value == null)
                return false;

            return Pattern.matches("^\\d+$", value);
        }

        public static boolean checkAlphaNumeric(String value) {
            if (value == null)
                return false;

            return Pattern.matches("^[A-Za-z0-9]+$", value);
        }

        public static boolean checkAlphabetic(String value) {
            if (value == null)
                return false;

            return Pattern.matches("^[a-zA-Z]+$", value);
        }

        public static boolean checkFloat(String value) {
            if (value == null)
                return false;

            return Pattern.matches("^(\\-|\\+)?\\d+(\\.\\d+|\\d*)\\d*$", value);
        }

        public static boolean checkInteger(String value) {
            if (value == null)
                return false;

            return Pattern.matches("^(\\+|\\-)?\\d+$", value);
        }

        public static boolean checkLowerCase(String value) {
            if (value == null)
                return false;

            return Pattern.matches("^\\p{Lower}+$", value);
        }

        public static boolean checkUpperCase(String value) {
            if (value == null)
                return false;

            return Pattern.matches("^\\p{Upper}+$", value);
        }

        public static boolean checkDomain(String value) {
            if (value == null)
                return false;

            return Pattern.matches(
                    "^[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]{2,4}$", value);
        }


        public static String validateFilePath(String path) throws IllegalArgumentException{
            if(path == null || "".equals(path)) {
                return "";
            }

            if(path.indexOf("../") > -1) {
                throw new IllegalArgumentException("파일이름에 상대경로가 있습니다.");
            }

            if(path.indexOf(";") > -1 || path.indexOf("%00") > -1) {
                throw new IllegalArgumentException("파일이름�� 정확하지 않습니다. 수정후 다시 사용해주십시요");
            }

            return path;
        }


        public static boolean isEmpty(final Object str) {
            if (str == null) {
                return true;
            }
            if ((str instanceof String) && (((String) str).trim().length() == 0)) {
                return true;
            }
            if (str instanceof Map) {
                return ((Map<?, ?>) str).isEmpty();
            }
            if (str instanceof List) {
                return ((List<?>) str).isEmpty();
            }
            if (str instanceof Object[]) {
                return (((Object[]) str).length == 0);
            }
            return false;
        }
    }