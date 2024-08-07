package com.flare.rap.notification.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.approval.model.BaseApprovalLineResponseVO;
import com.flare.rap.notification.model.NotificationGroupDivisionResponseVO;
import com.flare.rap.notification.model.NotificationGroupRequestVO;
import com.flare.rap.notification.model.NotificationGroupResponseVO;
import com.flare.rap.notification.model.NotificationGroupUserRequestVO;
import com.flare.rap.notification.model.NotificationGroupUserResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface NotificationRepository {

    List<NotificationGroupResponseVO> selectNotificationGroups(String ntdkNm);

    List<NotificationGroupDivisionResponseVO> selectNotificationGroupDivisions(@Param("session") UserSessionVO userSession);

    List<NotificationGroupUserResponseVO> selectNotificationGroupUsers(@Param("ntdkId") Integer ntdkId, @Param("session") UserSessionVO userSession);

    long selectMaxNtdkId();

    int insertNotificationGroup(@Param("notification") NotificationGroupRequestVO notificationGroupRequestVO, @Param("session") UserSessionVO userSession);

    int updateNotificationGroup(@Param("notification") NotificationGroupRequestVO notificationGroupRequestVO, @Param("session") UserSessionVO userSession);

    int insertNotificationGroupUser(@Param("notification") NotificationGroupUserRequestVO notificationGroupUserRequestVO, @Param("session") UserSessionVO userSession);

    int updateNotificationGroupUser(@Param("notification") NotificationGroupUserRequestVO notificationGroupUserRequestVO, @Param("session") UserSessionVO userSession);

    int updateDisableNotificationGroup(@Param("ntdkId") Integer ntdkId, @Param("session") UserSessionVO userSession);

    int updateDisableNotificationGroupUser(@Param("notification") NotificationGroupUserRequestVO notificationGroupUserRequestVO, @Param("session") UserSessionVO userSession);

    List<BaseApprovalLineResponseVO> selectBaseApprovalNtdkByNtdkId(@Param("ntdkId") Integer ntdkId, @Param("session") UserSessionVO userSession);
}