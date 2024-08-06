package com.lgensol.eswf.log.service;

import com.lgensol.eswf.log.model.EmailSendLogVO;
import com.lgensol.eswf.log.model.IfLogVO;

public interface LogService {

    void createMenuAccessLog(String mnuId);

    long createEmailSendLog(EmailSendLogVO emailSendLogVO);

    void createIfLog(IfLogVO ifLogVO);

    long findIfLogSeq();

    void createIfLogSend(IfLogVO ifLogVO);

    void modifyIfLogReceive(IfLogVO ifLogVO);

}