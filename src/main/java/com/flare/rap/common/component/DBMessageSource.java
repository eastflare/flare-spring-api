package com.flare.rap.common.component;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import com.flare.rap.message.model.MessageSimpleVO;
import com.flare.rap.message.service.MessageService;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {
    @Autowired
    private MessageService messageService;
    private static final String DEFAULT_LOCALE_CODE = "ko";

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {

        Locale currentLocale = LocaleContextHolder.getLocale();
        String newLocale;
        if(currentLocale.toString().equals("zht")){
            newLocale = "zhT";
        }else if (currentLocale.toString().equals("zhc")){
            newLocale = "zhC";
        }else{
            newLocale = currentLocale.getLanguage();
        }

        MessageSimpleVO message = messageService.findMessageCache(code, newLocale);

        if (message == null) {
            return new MessageFormat(code,currentLocale);
        }
        return new MessageFormat(message.getMsgTxtCtn(),currentLocale);
    }
}