package com.flare.rap.approval.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.approval.model.ApprovalRuleDetailRequestVO;
import com.flare.rap.approval.model.ApprovalRuleMasterRequestVO;
import com.flare.rap.approval.service.ApprovalRuleService;
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
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Approval")
@Validated
@RequestMapping("/api")
public class ApprovalRuleController {
    private final ApprovalRuleService approvalRuleService;
    @Operation(summary = "결재규칙 마스터 조회", description = "결재규칙 마스터 조회")
    @GetMapping(value = "/v1/approval/rules", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findApprovalRuleMasters(
        @Parameter(description = "aprRuleId", example = "AR-001") @RequestParam(required = false) String aprRuleId,
        @Parameter(description = "searchRuleNm", example = "품의") @RequestParam(required = false) String searchRuleNm) {
        return new ResponseEntity<>(
            CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalRuleService.findApprovalRuleMasters(aprRuleId, searchRuleNm))
                .build(),
            HttpStatus.OK);
    }

    @Operation(summary = "결재규칙 마스터 저장", description = "결재규칙 마스터 저장")
    @PostMapping(value = "/v1/approval/rule", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveApprovalRuleMaster(@RequestBody @Valid ApprovalRuleMasterRequestVO approvalRuleMaster) {
        return new ResponseEntity<>(
            CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalRuleService.saveApprovalRuleMaster(approvalRuleMaster))
                .build(),
            HttpStatus.OK);
    }

    @Operation(summary = "결재규칙 상세 조회", description = "결재규칙 상세 조회")
    @GetMapping(value = "/v1/approval/rule/{aprRuleId}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findApprovalRuleDetails(
        @Parameter(name = "aprRuleId", example = "AR-001")
        @PathVariable("aprRuleId") @NotBlank String aprRuleId) {
        return new ResponseEntity<>(
            CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalRuleService.findApprovalRuleDetails(aprRuleId))
                .build(),
            HttpStatus.OK);
    }

    @Operation(summary = "결재규칙 상세 저장", description = "결재규칙 상세 저장")
    @PostMapping(value = "/v1/approval/rule/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveApprovalRuleDetails(
        @RequestBody @Valid ValidList<ApprovalRuleDetailRequestVO> approvalRuleDetails) {
        return new ResponseEntity<>(
            CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalRuleService.saveApprovalRuleDetails(approvalRuleDetails))
                .build(),
            HttpStatus.OK);
    }

    @Operation(summary = "결재규칙에 따른 결재라인 조회", description = "결재규칙에 따른 결재라인 조회")
    @GetMapping(value = "/v1/approval/rule/{aprRuleId}/lines", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findBaseApprovalLine(
            @Parameter(description = "aprRuleId", example = "AR-001")
            @PathVariable("aprRuleId") @NotBlank String aprRuleId) {
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRuleService.findBaseApprovalLine(aprRuleId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "결재규칙에 따른 통보자 목록 조회", description = "결재규칙에 따른 통보자 목록 조회")
    @GetMapping(value = "/v1/approval/rule/{aprRuleId}/notifications", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> findBaseApprovalNtdkByAprRuleId(
            @Parameter(description = "aprRuleId", example = "AR-001") String aprRuleId) {
        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRuleService.findBaseApprovalNtdkByAprRuleId(aprRuleId))
                        .build(),
                HttpStatus.OK);
    }



}