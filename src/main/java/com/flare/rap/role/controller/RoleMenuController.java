package com.flare.rap.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.role.service.RoleMenuService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "RoleMenu")
@Validated
@RequestMapping("/api")
public class RoleMenuController {

    private final RoleMenuService roleMenuService;

    @Operation(summary = "역할별 메뉴 전체 조회", description = "역할별 메뉴 전체 조회")
    @GetMapping(value = "/v1/role/{roleCd}/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<MenuResponseVO>>> findMenusByRole(@Parameter(name = "roleCd") @PathVariable @NotBlank String roleCd) {

        return new ResponseEntity<>(
                CommonResponseVO.<List<MenuResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(roleMenuService.findMenusByRole(roleCd))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "역할별 메뉴 저장", description = "역할별 메뉴 저장")
    @PostMapping(value = "/v1/role/{roleCd}/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<Integer>> saveMenusByRole(@Parameter(name = "roleCd") @PathVariable @NotBlank String roleCd, @RequestBody @Valid List<String> mnuIdList) {

        return new ResponseEntity<>(
                CommonResponseVO.<Integer>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(roleMenuService.saveMenusByRole(roleCd, mnuIdList))
                        .build(),
                HttpStatus.OK);
    }
}