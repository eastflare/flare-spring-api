
package com.flare.rap.common.interceptor;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
/**
 * Interceptor that allows for changing the current locale on every request,
 * via a configurable request parameter (default parameter name: "locale").
 *
 * @author Juergen Hoeller
 * @author Rossen Stoyanchev
 * @since 20.06.2003
 * @see LocaleResolver
 */
@Slf4j
public class LocaleInterceptor implements HandlerInterceptor {

    /**
     * Default name of the locale specification parameter: "locale".
     */
    public static final String DEFAULT_PARAM_NAME = "locale";


    protected final Log logger = LogFactory.getLog(getClass());

    private String paramName = DEFAULT_PARAM_NAME;

    @Nullable
    private String[] httpMethods;

    private boolean ignoreInvalidLocale = false;


    /**
     * Set the name of the parameter that contains a locale specification
     * in a locale change request. Default is "locale".
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * Return the name of the parameter that contains a locale specification
     * in a locale change request.
     */
    public String getParamName() {
        return this.paramName;
    }

    /**
     * Configure the HTTP method(s) over which the locale can be changed.
     * @param httpMethods the methods
     * @since 4.2
     */
    public void setHttpMethods(@Nullable String... httpMethods) {
        this.httpMethods = httpMethods;
    }

    /**
     * Return the configured HTTP methods.
     * @since 4.2
     */
    @Nullable
    public String[] getHttpMethods() {
        return this.httpMethods;
    }

    /**
     * Set whether to ignore an invalid value for the locale parameter.
     * @since 4.2.2
     */
    public void setIgnoreInvalidLocale(boolean ignoreInvalidLocale) {
        this.ignoreInvalidLocale = ignoreInvalidLocale;
    }

    /**
     * Return whether to ignore an invalid value for the locale parameter.
     * @since 4.2.2
     */
    public boolean isIgnoreInvalidLocale() {
        return this.ignoreInvalidLocale;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException {

        String newLocale = request.getParameter(getParamName());
        if (newLocale != null) {
            if(newLocale.equals("zhC")){
                LocaleContextHolder.setLocale(new Locale("zh", "CN"));
            } else if (newLocale.equals("zhT")) {
                LocaleContextHolder.setLocale(new Locale("zh", "TW"));
            } else if (newLocale.equals("en")) {
                LocaleContextHolder.setLocale(new Locale("en", "US"));
            } else if (newLocale.equals("pl")) {
                LocaleContextHolder.setLocale(new Locale("pl", "PL"));
            }else {
                LocaleContextHolder.setLocale(new Locale("ko", "KR"));
            }
            if (checkHttpMethod(request.getMethod())) {
                LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
                if (localeResolver == null) {
                    throw new IllegalStateException(
                            "No LocaleResolver found: not in a DispatcherServlet request?");
                }
                try {
                    //localeResolver.setLocale(request, response, parseLocaleValue(newLocale));
                    localeResolver.resolveLocale(request);
                }
                catch (IllegalArgumentException ex) {
                    if (isIgnoreInvalidLocale()) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("Ignoring invalid locale value [" + newLocale + "]: " + ex.getMessage());
                        }
                    }
                    else {
                        throw ex;
                    }
                }
            }
        }
        // Proceed in any case.
        return true;
    }

    private boolean checkHttpMethod(String currentMethod) {
        String[] configuredMethods = getHttpMethods();
        if (ObjectUtils.isEmpty(configuredMethods)) {
            return true;
        }
        for (String configuredMethod : configuredMethods) {
            if (configuredMethod.equalsIgnoreCase(currentMethod)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Parse the given locale value as coming from a request parameter.
     * < p>The default implementation calls {@link StringUtils#parseLocale(String)},
     * accepting the {@link Locale#toString} format as well as BCP 47 language tags.
     * @param localeValue the locale value to parse
     * @return the corresponding {@code Locale} instance
     * @since 4.3
     */
    @Nullable
    protected Locale parseLocaleValue(String localeValue) {
        return StringUtils.parseLocale(localeValue);
    }

}