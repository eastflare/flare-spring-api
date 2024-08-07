package com.flare.rap.bbs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.bbs.model.BbsReplyRequestVO;
import com.flare.rap.bbs.service.BbsReplyService;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Reply")
@Validated
@RequestMapping("/api")
public class BbsReplyController {

    private final BbsReplyService bbsReplyService;

    @Operation(summary = "게시글 댓글 생성")
    @PostMapping(value = "/v1/bbs/reply", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> createReply(@RequestBody @Valid BbsReplyRequestVO bbsReplyRequest) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                                .insertedRows(bbsReplyService.createBbsReply(bbsReplyRequest))
                                .build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "게시글 댓글 삭제")
    @DeleteMapping(value = "/v1/bbs/reply/{bbmNo}/{bbmReNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> removeReply(@PathVariable @NotBlank String bbmNo, @PathVariable @NotBlank String bbmReNo) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .deletedRows(bbsReplyService.removeBbsReply(bbmNo, bbmReNo))
                        .build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "게시글 댓글 수정")
    @PutMapping(value = "/v1/bbs/reply", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyReply(@RequestBody @Valid BbsReplyRequestVO bbsReplyRequest) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .updatedRows(bbsReplyService.modifyBbsReply(bbsReplyRequest))
                        .build())
                .build(), HttpStatus.OK);
    }
}