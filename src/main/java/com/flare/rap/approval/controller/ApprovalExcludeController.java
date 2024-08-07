package com.flare.rap.approval.controller;

import java.util.ArrayList;
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

import com.flare.rap.approval.model.*;
import com.flare.rap.approval.service.ApprovalExcludeService;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name="ApprovalExclude")
@Validated
@RequestMapping("/api")
public class ApprovalExcludeController {
    private final ApprovalExcludeService approvalExcludeService;

    @Operation(summary = "결재자 제외 전체 조회", description="결재자 제외 목록 검색어 포함/미포함 조회")
    @GetMapping(value = "/v1/approval/excludes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<ApprovalExcludeMasterVO>>> findApprovalExcludeMasters(
            @Parameter(description = "제외명", example = "결재") String aprExcNm){
        return new ResponseEntity<>(
                CommonResponseVO.<List<ApprovalExcludeMasterVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalExcludeService.findApprovalExcludeMasters(aprExcNm))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "결재자 제외 대상 목록 전체 조회", description="특정 제외ID에 해당하는 제외 대상 목록 전체 조회")
    @GetMapping(value = "/v1/approval/exclude/{aprExcTgtId}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<ApprovalExcludeDetailVO>>> findApprovalExcludeDetails(
            @Parameter(description = "제외ID", example = "1")
            @PathVariable("aprExcTgtId") @NotNull long aprExcTgtId){
        return new ResponseEntity<>(
                CommonResponseVO.<List<ApprovalExcludeDetailVO>>builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalExcludeService.findApprovalExcludeDetails(aprExcTgtId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "다건 결재자 제외/대상 목록 생성, 삭제, 수정 일괄 처리", tags = { "ApproveExclude" })
    @PostMapping(value = "/v1/approval/exclude", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<ApprovalExcludeResponseVO>> saveApprovalExcludes(
            @RequestBody @Valid ApprovalExcludeRequestVO crudRequest) {

        return new ResponseEntity<>(CommonResponseVO.<ApprovalExcludeResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalExcludeService.saveApprovalExclude(crudRequest.getApprovalExcludeMaster(),
                        crudRequest.getApprovalExcludeDetail()))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "단건 결재자 제외 삭제", tags = {"ApprovalExclude"})
    @DeleteMapping(value = "/v1/approval/exclude/{aprExcTgtId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<ApprovalExcludeResponseVO>> deleteApprovalExclude(
            @Parameter(description = "제외ID", example = "1", required = true)
            @PathVariable("aprExcTgtId") long aprExcTgtId){

        return new ResponseEntity<>(CommonResponseVO.<ApprovalExcludeResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalExcludeService.deleteApprovalExclude(aprExcTgtId))
                .build(), HttpStatus.OK
        );
    }

}