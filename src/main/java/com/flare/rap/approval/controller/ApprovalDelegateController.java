package com.flare.rap.approval.controller;

import java.util.List;

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

import com.flare.rap.approval.model.ApprovalDelegateRequestVO;
import com.flare.rap.approval.model.ApprovalDelegateResponseVO;
import com.flare.rap.approval.service.ApprovalDelegateService;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.ValidList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "ApprovalDelegate")
@Validated
@RequestMapping("/api")
public class ApprovalDelegateController {
    private final ApprovalDelegateService approvalDelegateService;
    @Operation(summary = "결재위임 조회", description = "결재위임 조회")
    @GetMapping(value = "/v1/approval/delegates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<ApprovalDelegateResponseVO>>> findApprovalDelegates(
        @Parameter(description = "aprDlgtUserId", example = "bigsso") @RequestParam(required = false) String aprDlgtUserId,
        @Parameter(description = "statusFlag", example = "B") @RequestParam(required = false) String statusFlag) {
        return new ResponseEntity<>(
            CommonResponseVO.<List<ApprovalDelegateResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalDelegateService.findApprovalDelegates(aprDlgtUserId, statusFlag))
                .build(),
            HttpStatus.OK);
    }

    @Operation(summary = "결재위임 저장", description = "결재위임 저장")
    @PostMapping(value = "/v1/approval/delegates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveApprovalDelegates(@RequestBody @Valid ValidList<ApprovalDelegateRequestVO> approvalDelegates) {
        return new ResponseEntity<>(
            CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalDelegateService.saveApprovalDelegates(approvalDelegates))
                .build(),
            HttpStatus.OK);
    }

}