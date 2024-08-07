package com.flare.rap.approval.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.approval.model.ApprovalTemplateVO;
import com.flare.rap.approval.service.ApprovalTemplateService;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "ApprovalTemplate")
@RequestMapping("/api")
public class ApprovalTemplateController {

    private final ApprovalTemplateService approvalTemplateService;

    @Operation(summary = "결재 양식 조회")
    @GetMapping(value="/v1/approval/templates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<ApprovalTemplateVO>>> findApprovalTemplate(
            @Parameter(description = "결재양식명", example = "비정형품의")
            @RequestParam(required = false) String aprTplNm) {
        return new ResponseEntity<>(CommonResponseVO.<List<ApprovalTemplateVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(approvalTemplateService.findApprovalTemplate(aprTplNm))
                .build(), HttpStatus.OK);
    }

    @Operation(summary="결재 양식 생성", tags = {"ApprovalTemplate"})
    @PostMapping(value="/v1/approval/template", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> createApprovalTemplate(
            @RequestBody @Valid ApprovalTemplateVO approvalTemplateVO) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().insertedRows(approvalTemplateService.createApprovalTemplate(approvalTemplateVO)).build())
                .build(),HttpStatus.OK);
    }

    @Operation(summary = "결재 양식 수정", tags = {"ApprovalTemplate"})
    @PutMapping(value = "/v1/approval/template", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modfiyApprovalTemplate(
            @RequestBody @Valid ApprovalTemplateVO approvalTemplateVO) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().updatedRows(approvalTemplateService.modifyApprovalTemplate(approvalTemplateVO)).build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "결재 양식 삭제", tags = {"ApprovalTemplate"})
    @DeleteMapping(value = "/v1/approval/template/{aprTplId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> deleteApprovalTemplate(
            @Parameter(description = "결재양식ID", example = "SEC-FORM-001") @PathVariable @NotBlank String aprTplId) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().deletedRows(approvalTemplateService.removeApprovalTemplate(aprTplId)).build())
                .build(), HttpStatus.OK);
    }

}