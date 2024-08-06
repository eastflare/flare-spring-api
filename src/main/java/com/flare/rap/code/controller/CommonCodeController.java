package com.flare.rap.code.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.code.model.CommonCodeConditionVO;
import com.flare.rap.code.model.CommonCodeGroupRequestVO;
import com.flare.rap.code.model.CommonCodeNameResponseVO;
import com.flare.rap.code.model.CommonCodeRequestVO;
import com.flare.rap.code.service.CommonCodeService;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.ValidList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "CommonCode")
@Validated
@RequestMapping("/api")
public class CommonCodeController {
    private final CommonCodeService commonCodeService;
    @Operation(summary = "공통코드그룹 조회", description = "공통코드그룹 조회")
    @GetMapping(value = "/v1/commonCodeGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findCommonCodeGroups(
        @Parameter(description = "searchGrCd", example = "LANG_CD") @RequestParam(required = false) String searchGrCd,
        @Parameter(description = "useYn", example = "Y") @RequestParam(required = false) String searchUseYn,
        @Parameter(description = "searchCode", example = "KO") @RequestParam(required = false) String searchCode) {
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(commonCodeService.findCommonCodeGroups(searchGrCd, searchUseYn, searchCode))
                        .build(),
                HttpStatus.OK);
    }
    @Operation(summary = "공통코드그룹 저장", description = "header값에 따라 insert/update. C: Insert, U: Update")
    @PostMapping(value = "/v1/commonCodeGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveCommonCodeGroups(@RequestBody @Valid ValidList<CommonCodeGroupRequestVO> codeGroups) {
        return new ResponseEntity<>(
                CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(commonCodeService.saveCommonCodeGroups(codeGroups))
                .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "공통코드 조회", description = "공통코드 조회")
    @GetMapping(value = "/v1/commonCodes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findCommonCodes(@Parameter(description = "cmnGrCd", example = "LANG_CD") @RequestParam @NotNull String cmnGrCd) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(commonCodeService.findCommonCodes(cmnGrCd))
                        .build(),
                HttpStatus.OK);
    }
    @Operation(summary = "공통코드 저장", description = "header값에 따라 insert/update. C: Insert, U: Update")
    @PostMapping(value = "/v1/commonCodes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveCommonCodes(@RequestBody @Valid ValidList<CommonCodeRequestVO> codes) {
        return new ResponseEntity<>(
            CommonResponseVO.<DmlResponseVO>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(commonCodeService.saveCommonCodes(codes))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "공통코드 헤더 조회", description = "공통코드 헤더 조회")
    @GetMapping(value = "/v1/commonCodeHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findCommonCodeHeader(@Parameter(description = "cmnGrCd", example = "LANG_CD") @RequestParam @NotNull String cmnGrCd) {
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(commonCodeService.findCommonCodeHeader(cmnGrCd))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "공통코드명 조회", description = "공통코드명 조회")
    @GetMapping(value = "/v1/commonCodeNames", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<CommonCodeNameResponseVO>>> findCommonCodeNames(
            @Parameter(name = "cmnGrCd", example = "LANG_CD", required = true) @RequestParam @NotBlank String cmnGrCd) {
        return new ResponseEntity<>(
                CommonResponseVO.<List<CommonCodeNameResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(commonCodeService.findCommonCodeNames(cmnGrCd))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "공통코드명 조회", description = "공통코드명 조회")
    @GetMapping(value = "/v1/commonCodeNamesWithCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<CommonCodeNameResponseVO>>> findCommonCodeNamesWithcode(
            @Parameter(name = "cmnGrCd", example = "LANG_CD", required = true) @RequestParam @NotBlank String cmnGrCd) {
        return new ResponseEntity<>(
                CommonResponseVO.<List<CommonCodeNameResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(commonCodeService.findCommonCodeNamesWithCode(cmnGrCd))
                        .build(),
                HttpStatus.OK);
    }

    // TODO: 공통코드명 조회API와 통합 가능함 (Front-End 통합여부 확인 필요)
    @Operation(summary = "공통코드명 조회 (조건 포함)", description = "공통코드명 조회 (조건 포함)")
    @GetMapping(value = "/v1/commonCodeNamesCondition", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<CommonCodeNameResponseVO>>> findCommonCodeNamesCondition(
            @ParameterObject @Valid CommonCodeConditionVO condition) {
        return new ResponseEntity<>(
                CommonResponseVO.<List<CommonCodeNameResponseVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(commonCodeService.findCommonCodeNamesCondition(condition))
                        .build(),
                HttpStatus.OK);
    }

}