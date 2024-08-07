package com.flare.rap.notification.service;

import java.util.List;

import com.flare.rap.approval.model.BaseApprovalLineResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.notification.model.NotificationGroupDivisionResponseVO;
import com.flare.rap.notification.model.NotificationGroupRequestVO;
import com.flare.rap.notification.model.NotificationGroupResponseVO;
import com.flare.rap.notification.model.NotificationGroupUserRequestVO;
import com.flare.rap.notification.model.NotificationGroupUserResponseVO;

public interface NotificationService {

    List<NotificationGroupResponseVO> findNotificationGroups(String ntdkNm);

    List<NotificationGroupDivisionResponseVO> findNotificationGroupDivisions();

    List<NotificationGroupUserResponseVO> findNotificationGroupUsers(Integer ntdkId);

    DmlResponseVO saveNotificationGroups(List<NotificationGroupRequestVO> notificationGroupRequestVO);

    DmlResponseVO modifyDisableNotificationGroup(Integer ntdkId);

    DmlResponseVO saveNotificationGroupUsers(List<NotificationGroupUserRequestVO> notificationGroupUserRequestVO);

    List<BaseApprovalLineResponseVO> findBaseApprovalNtdkByNtdkId(Integer ntdkId);

}