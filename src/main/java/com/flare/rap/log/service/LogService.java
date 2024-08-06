package com.flare.rap.log.service;

import com.flare.rap.log.model.EmailSendLogVO;
import com.flare.rap.log.model.IfLogVO;

public interface LogService {

    void createMenuAccessLog(String mnuId);

    long createEmailSendLog(EmailSendLogVO emailSendLogVO);

    void createIfLog(IfLogVO ifLogVO);

    long findIfLogSeq();

    void createIfLogSend(IfLogVO ifLogVO);

    void modifyIfLogReceive(IfLogVO ifLogVO);

}