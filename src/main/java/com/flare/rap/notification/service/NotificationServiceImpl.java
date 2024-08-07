package com.flare.rap.notification.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.model.BaseApprovalLineResponseVO;
import com.flare.rap.common.constant.CrudConstants;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.notification.model.NotificationGroupDivisionResponseVO;
import com.flare.rap.notification.model.NotificationGroupRequestVO;
import com.flare.rap.notification.model.NotificationGroupResponseVO;
import com.flare.rap.notification.model.NotificationGroupUserRequestVO;
import com.flare.rap.notification.model.NotificationGroupUserResponseVO;
import com.flare.rap.notification.repository.NotificationRepository;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<NotificationGroupResponseVO> findNotificationGroups(String ntdkNm) {
        return notificationRepository.selectNotificationGroups(ntdkNm);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationGroupDivisionResponseVO> findNotificationGroupDivisions() {
        return notificationRepository.selectNotificationGroupDivisions(SessionScopeUtil.getContextSession());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationGroupUserResponseVO> findNotificationGroupUsers(Integer ntdkId) {
        return notificationRepository.selectNotificationGroupUsers(ntdkId, SessionScopeUtil.getContextSession());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public DmlResponseVO saveNotificationGroups(List<NotificationGroupRequestVO> notificationGroupRequestVO) {
        List<NotificationGroupRequestVO> insertNotificationGroups = new ArrayList<>();
        List<NotificationGroupRequestVO> updateNotificationGroups = new ArrayList<>();

        for (NotificationGroupRequestVO notificationGroup : notificationGroupRequestVO) {
            if (CrudConstants.CREATE.equalsIgnoreCase(notificationGroup.getCrudKey())) {
                insertNotificationGroups.add(notificationGroup);
            } else if (CrudConstants.UPDATE.equalsIgnoreCase(notificationGroup.getCrudKey())) {
                updateNotificationGroups.add(notificationGroup);
            }
        }

        int insertedRows = 0, updatedRows = 0;
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        for (NotificationGroupRequestVO updateNotificationGroup : updateNotificationGroups) {
            updatedRows += notificationRepository.updateNotificationGroup(updateNotificationGroup, userSession);
        }

        for (NotificationGroupRequestVO insertNotificationGroup : insertNotificationGroups) {
            insertedRows += notificationRepository.insertNotificationGroup(insertNotificationGroup, userSession);
        }

        return DmlResponseVO.builder().insertedRows(insertedRows).updatedRows(updatedRows).build();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public DmlResponseVO modifyDisableNotificationGroup(Integer ntdkId) {
        int deletedRows = 0;
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        deletedRows += notificationRepository.updateDisableNotificationGroupUser(
                NotificationGroupUserRequestVO.builder().ntdkId(ntdkId).build(), userSession);
        deletedRows += notificationRepository.updateDisableNotificationGroup(ntdkId, userSession);

        return DmlResponseVO.builder().deletedRows(deletedRows).build();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public DmlResponseVO saveNotificationGroupUsers(List<NotificationGroupUserRequestVO> notificationGroupUserRequestVO) {
        int insertedRows = 0, deletedRows = 0, updatedRows =0;
        List<NotificationGroupUserRequestVO> insertNotificationGroupUsers = new ArrayList<>();
        List<NotificationGroupUserRequestVO> deleteNotificationGroupUsers = new ArrayList<>();
        List<NotificationGroupUserRequestVO> updateNotificationGroupUsers = new ArrayList<>();

        for (NotificationGroupUserRequestVO notificationGroupUser : notificationGroupUserRequestVO) {
            if (CrudConstants.CREATE.equalsIgnoreCase(notificationGroupUser.getCrudKey())) {
                insertNotificationGroupUsers.add(notificationGroupUser);
            } else if (CrudConstants.DELETE.equalsIgnoreCase(notificationGroupUser.getCrudKey())) {
                deleteNotificationGroupUsers.add(notificationGroupUser);
            }else if (CrudConstants.UPDATE.equalsIgnoreCase(notificationGroupUser.getCrudKey())){
                updateNotificationGroupUsers.add(notificationGroupUser);
            }
        }

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        long maxId = notificationRepository.selectMaxNtdkId();

        for (NotificationGroupUserRequestVO deleteNotificationGroupUser : deleteNotificationGroupUsers) {
            deletedRows += notificationRepository.updateDisableNotificationGroupUser(deleteNotificationGroupUser, userSession);
        }

        for (NotificationGroupUserRequestVO insertNotificationUser : insertNotificationGroupUsers) {
            if (ValidateUtil.isEmpty(insertNotificationUser.getNtdkId())) insertNotificationUser.setNtdkId((int) maxId);
            insertedRows += notificationRepository.insertNotificationGroupUser(insertNotificationUser, userSession);
        }

        for (NotificationGroupUserRequestVO updateNotificationUser: updateNotificationGroupUsers){
            updatedRows += notificationRepository.updateNotificationGroupUser(updateNotificationUser, userSession);
        }

        return DmlResponseVO.builder().insertedRows(insertedRows).updatedRows(updatedRows).deletedRows(deletedRows).build();
    }

    @Override
    public List<BaseApprovalLineResponseVO> findBaseApprovalNtdkByNtdkId(Integer ntdkId) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return notificationRepository.selectBaseApprovalNtdkByNtdkId(ntdkId, userSession);
    }
}