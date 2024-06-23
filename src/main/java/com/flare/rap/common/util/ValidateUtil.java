package com.flare.rap.common.util;

import org.apache.commons.text.StringEscapeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    private static final Pattern TAG_REG = Pattern.compile(
            "<((/?)([a-zA-Z]+)([^<>]*)(\\s*/?))>?", 106);

    private static final Pattern EVENT_REG = Pattern.compile(
            "(\\s+)([a-zA-Z]+)(.*?)(=)(.+?[\\(|\\#].+?)", 106);

    private static final Pattern KISA_REG = Pattern.compile(
            "<((/?)([a-zA-z]+)([^<>]*)(\\s*/?))>?", 106);

    public static final String[] ALLTAGS = {
            "html", "head", "title", "base", "link", "meta", "style", "script", "noscript", "body", "section", "nav",
            "article", "aside", "h1", "h2", "h3", "h4", "h5", "h6", "header", "footer", "address", "main", "p", "hr",
            "pre", "blockquote", "ol", "ul", "li", "dl", "dt", "dd", "figure", "figcaption", "div", "a", "em", "strong",
            "small", "s", "cite", "q", "dfn", "abbr", "data", "time", "code", "var", "samp", "kbd", "sub", "sup", "i",
            "b", "u", "mark", "ruby", "rt", "rp", "bdi", "bdo", "span", "br", "wbr", "ins", "del", "picture", "source",
            "iframe", "embed", "object", "param", "video", "audio", "track", "canvas", "map", "area", "svg", "math",
            "table", "caption", "colgroup", "col", "tbody", "thead", "tfoot", "tr", "td", "th", "form", "label",
            "input", "button", "select", "datalist", "textarea", "output", "progress", "meter", "fieldset", "legend",
            "details", "summary", "dialog", "script", "style"
    };

    public static final String[] ALLEVENTS = {
            "onabort", "onautocomplete", "onautocompleteerror", "onblur", "oncancel", "oncanplay", "oncanplaythrough",
            "onchange", "onclick", "onclose", "oncontextmenu", "oncuechange", "ondblclick", "ondrag", "ondragend",
            "ondragenter", "ondragexit", "ondragleave", "ondragover", "ondragstart", "ondrop", "ondurationchange",
            "onemptied", "onended", "onerror", "onfocus", "oninput", "oninvalid", "onkeydown", "onkeypress", "onkeyup",
            "onload", "onloadeddata", "onloadedmetadata", "onloadstart", "onmousedown", "onmouseenter", "onmouseleave",
            "onmousemove", "onmouseout", "onmouseover", "onmouseup", "onwheel", "onpause", "onplay", "onplaying",
            "onprogress", "onratechange", "onreset", "onresize", "onscroll", "onseeked", "onseeking", "onselect",
            "onshow", "onsort", "onstalled", "onsubmit", "onsuspend", "ontimeupdate", "ontoggle", "onvolumechange",
            "onwaiting"
    };

    public static final String[] KISA_XSS = {
            "alert", "append", "binding", "blink", "charset", "cookie", "create", "document", "eval", "expression",
            "href", "ilayer", "innerHTML", "javascript", "layer", "msgbox", "refresh", "string", "vbscript", "void"
    };

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
            Pattern.compile("javascript", Pattern.CASE_INSENSITIVE),
            Pattern.compile("vbscript", Pattern.CASE_INSENSITIVE),
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };

    public static final List<String> TAGLIST = Arrays.asList(ALLTAGS);

    public static final List<String> EVENTLIST = Arrays.asList(ALLEVENTS);

    public static final List<String> KISAXSSLIST = Arrays.asList(KISA_XSS);

    public static boolean checkXSS(String value) {
        if(value == null || value.isEmpty())
            return true;

        Matcher tagMatcher = TAG_REG.matcher(value);
        while (tagMatcher.find()){
            String tag = tagMatcher.group(3).toLowerCase();
            if(TAGLIST.contains(tag)){
                return false;
            }
        }

        Matcher eventMatcher = EVENT_REG.matcher(value);
        while (eventMatcher.find()){
            String tag = eventMatcher.group(2).toLowerCase();
            if(EVENTLIST.contains(tag)){
                return false;
            }
        }

        Matcher kisaxssMatcher = KISA_REG.matcher(value);
        while (kisaxssMatcher.find()){
            String tag = kisaxssMatcher.group(3).toLowerCase();
            if(KISAXSSLIST.contains(tag)){
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
}
