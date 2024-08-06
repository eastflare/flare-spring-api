package com.flare.rap.log.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.log.model.EmailSendLogVO;
import com.flare.rap.log.model.IfLogVO;
import com.flare.rap.log.repository.EmailSendLogRepository;
import com.flare.rap.log.repository.IfLogRepository;
import com.flare.rap.log.repository.MenuAccessLogRepository;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class LogServiceImpl implements LogService{

    private final MenuAccessLogRepository menuAccessLogRepository;

    private final EmailSendLogRepository emailSendLogRepository;

    private final IfLogRepository ifLogRepository;

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createMenuAccessLog(String mnuId) {
        try {
            UserSessionVO session = SessionScopeUtil.getContextSession();
            if(session == null) return;
            menuAccessLogRepository.insertMenuAccessLog(mnuId, session);

        } catch (Exception e) {
            log.info("LogServiceImpl.createMenuAccessLog() :: FAILED");
            log.debug(e.getMessage());
        }
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public long createEmailSendLog(EmailSendLogVO emailSendLogVO) {
        try {
            UserSessionVO session = SessionScopeUtil.getContextSession();
            // Batch 등 Session 이 없을때 호출 될 수 도 있음.
            if(session == null ) {
                session = UserSessionVO.builder()
                        .userId(emailSendLogVO.getDataInsUserId())
                        .userIp(emailSendLogVO.getDataInsUserIp())
                        .build();
            }
            long emlLogSeq =  emailSendLogRepository.selectEmlLogSeq();
            emailSendLogVO.setEmlLogSeq(emlLogSeq);

            emailSendLogRepository.insertEmailSendLog(emailSendLogVO, session);

            return emlLogSeq;
        } catch (Exception e) {
            log.info("LogServiceImpl.createEmailSendLog() :: FAILED");
            log.debug(e.getMessage());
        }

        return 0;
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createIfLog(IfLogVO ifLogVO) {
        try {
            UserSessionVO session = SessionScopeUtil.getContextSession();
            // Batch 등 Session 이 없을때 호출 될 수 도 있음.
            if(session == null ) {
                session = UserSessionVO.builder()
                        .userId(ifLogVO.getDataInsUserId())
                        .userIp(ifLogVO.getDataInsUserIp())
                        .build();
            }

            ifLogRepository.insertIfLog(ifLogVO, session);
        } catch (Exception e) {
            log.info("LogServiceImpl.createIfLog() :: FAILED");
            log.debug(e.getMessage());
        }

    }

    @Override
    @Transactional(readOnly = true)
    public long findIfLogSeq() {
        return ifLogRepository.selectIfLogSeq();
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createIfLogSend(IfLogVO ifLogVO) {
        try {
            UserSessionVO session = SessionScopeUtil.getContextSession();
            // Batch 등 Session 이 없을때 호출 될 수 도 있음.
            if(session == null ) {
                session = UserSessionVO.builder()
                        .userId(ifLogVO.getDataInsUserId())
                        .userIp(ifLogVO.getDataInsUserIp())
                        .build();
            }

            ifLogRepository.insertIfLogSend(ifLogVO, session);
        } catch (Exception e) {
            log.info("LogServiceImpl.insertIfLogSend() :: FAILED");
            log.debug(e.getMessage());
        }
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void modifyIfLogReceive(IfLogVO ifLogVO) {
        try {
            UserSessionVO session = SessionScopeUtil.getContextSession();
            // Batch 등 Session 이 없을때 호출 될 수 도 있음.
            if(session == null ) {
                session = UserSessionVO.builder()
                        .userId(ifLogVO.getDataInsUserId())
                        .userIp(ifLogVO.getDataInsUserIp())
                        .build();
            }

            ifLogRepository.updateIfLogReceive(ifLogVO, session);
        } catch (Exception e) {
            log.info("LogServiceImpl.modifyIfLogReceive() :: FAILED");
            log.debug(e.getMessage());
        }
    }

}