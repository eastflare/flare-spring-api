package com.flare.rap.notification.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.approval.model.BaseApprovalLineResponseVO;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.ValidList;
import com.flare.rap.notification.model.NotificationGroupDivisionResponseVO;
import com.flare.rap.notification.model.NotificationGroupRequestVO;
import com.flare.rap.notification.model.NotificationGroupResponseVO;
import com.flare.rap.notification.model.NotificationGroupUserRequestVO;
import com.flare.rap.notification.model.NotificationGroupUserResponseVO;
import com.flare.rap.notification.service.NotificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Notification")
@Validated
@RequestMapping("/api")
public class NotificationController {

    private final NotificationService notificationService;

    @Operation(summary = "통보처 조회")
    @GetMapping(value = "/v1/notificationGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<NotificationGroupResponseVO>>> findNotificationGroups(
            @Parameter(description = "통보처명", example = "심의 통보처")
            @RequestParam(required = false) String ntdkNm) {
        return new ResponseEntity<>(CommonResponseVO.<List<NotificationGroupResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(notificationService.findNotificationGroups(ntdkNm))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "통보처 구분 조회")
    @GetMapping(value = "/v1/notificationGroup/divisions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<NotificationGroupDivisionResponseVO>>> findNotificationGroupDivisions() {
        return new ResponseEntity<>(CommonResponseVO.<List<NotificationGroupDivisionResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(notificationService.findNotificationGroupDivisions())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "통보처 사용자 조회")
    @GetMapping(value = "/v1/notificationGroup/{ntdkId}/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<NotificationGroupUserResponseVO>>> findNotificationGroupUsers(
            @Parameter(description = "통보처아이디", example = "1") @PathVariable("ntdkId") @NotNull Integer ntdkId) {
        return new ResponseEntity<>(CommonResponseVO.<List<NotificationGroupUserResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(notificationService.findNotificationGroupUsers(ntdkId))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "통보처 추가/수정")
    @PostMapping(value = "/v1/notificationGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveNotificationGroups(@RequestBody @Valid ValidList<NotificationGroupRequestVO> notificationGroups) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(notificationService.saveNotificationGroups(notificationGroups))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "통보처 비활성")
    @PutMapping(value = "/v1/notificationGroup/{ntdkId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyDisableNotificationGroup(
            @Parameter(description = "통보처아이디", example = "1") @PathVariable("ntdkId") @NotNull Integer ntdkId) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(notificationService.modifyDisableNotificationGroup(ntdkId))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "통보처 사용자 추가/삭제")
    @PostMapping(value = "/v1/notificationGroup/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveNotificationGroupUsers(@RequestBody @Valid ValidList<NotificationGroupUserRequestVO> notificationGroupUsers) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(notificationService.saveNotificationGroupUsers(notificationGroupUsers))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "통보처ID로 통보자 목록 조회", description = "통보처ID로 통보자 목록 조회")
    @GetMapping(value = "/v1/notificationGroup/{ntdkId}/approvals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<BaseApprovalLineResponseVO>>> findBaseApprovalNtdkByNtdkId(
            @Parameter(description = "ntdkId", example = "1") @PathVariable("ntdkId") Integer ntdkId) {
        return new ResponseEntity<>(
                CommonResponseVO.<List<BaseApprovalLineResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(notificationService.findBaseApprovalNtdkByNtdkId(ntdkId))
                        .build(),
                HttpStatus.OK);
    }

}