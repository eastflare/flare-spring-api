package com.flare.rap.mail.service;

import com.flare.rap.mail.model.MailRequestVO;
import com.flare.rap.mail.model.MailVO;

public interface MailService {
    MailVO parseMailRequest(MailRequestVO mailRequest);

    int sendMail(MailVO mailVO);

    int sendMailBatch();

    int sendMailImmediately(MailVO mailVO);

    String makeTemplate(String templateType, Object contentObject);

}