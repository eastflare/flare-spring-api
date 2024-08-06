package com.flare.rap.menu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.menu.model.MenuRequestVO;
import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.menu.service.MenuService;
import com.flare.rap.role.model.RoleEmployeeResponseVO;
import com.flare.rap.role.model.RoleResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Menu")
@Validated
@RequestMapping("/api")
public class MenuController {
    private final MenuService menuService;

    @Operation(summary = "메뉴 전체 조회", description = "메뉴 전체 조회")
    @GetMapping(value = "/v1/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<MenuResponseVO>>> findAllMenus() {
        return new ResponseEntity<>(
                CommonResponseVO.<List<MenuResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(menuService.findAllMenus())
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "메뉴 단건 조회", description = "메뉴 단건 조회")
    @GetMapping(value = "/v1/menu/{mnuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<MenuResponseVO>> findMenu(@Parameter(name = "mnuId") @PathVariable("mnuId") @NotBlank String mnuId) {

        return new ResponseEntity<>(
                CommonResponseVO.<MenuResponseVO>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(menuService.findMenu(mnuId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "메뉴 생성, 업데이트", description = "메뉴 생성, 업데이트")
    @PostMapping(value = "/v1/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<Integer>> saveMenu(@RequestBody @Valid MenuRequestVO menuRequestVO) {

        return new ResponseEntity<>(
                CommonResponseVO.<Integer>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(menuService.saveMenu(menuRequestVO)) // TODO : fix
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "메뉴 다건 삭제", description = "메뉴 다건 삭제")
    @DeleteMapping(value = "/v1/menu/{mnuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<Integer>> deleteMenus(@Parameter(name = "mnuId") @PathVariable @NotBlank String mnuId) {

        return new ResponseEntity<>(
                CommonResponseVO.<Integer>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(menuService.removeMenus(mnuId)) // TODO : fix
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "메뉴별 역할 전체 조회", description = "메뉴별 이용 가능한 역할 전체 조회")
    @GetMapping(value = "/v1/menu/{mnuId}/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<RoleResponseVO>>> findRolesByMenu(@Parameter(name = "mnuId") @PathVariable @NotBlank String mnuId) {

        return new ResponseEntity<>(
                CommonResponseVO.<List<RoleResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(menuService.findRolesByMenuId(mnuId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "메뉴별 사용자 전체 조회", description = "메뉴별 이용 가능한 사용자 전체 조회")
    @GetMapping(value = "/v1/menu/{mnuId}/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<RoleEmployeeResponseVO>>> findEmployeesByMenu(@Parameter(name = "mnuId") @PathVariable @NotBlank String mnuId) {

        return new ResponseEntity<>(
                CommonResponseVO.<List<RoleEmployeeResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(menuService.findEmployeesByMenu(mnuId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "메뉴별 부서 전체 조회", description = "메뉴별 이용 가능한 부서 전체 조회")
    @GetMapping(value = "/v1/menu/{mnuId}/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<DepartmentVO>>> findDepartmentByMenu(@Parameter(name = "mnuId") @PathVariable @NotBlank String mnuId) {

        return new ResponseEntity<>(
                CommonResponseVO.<List<DepartmentVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(menuService.findDepartmentsByMenu(mnuId))
                        .build(),
                HttpStatus.OK);
    }
}