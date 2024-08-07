package com.flare.rap.bbs.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.bbs.model.BbsConditionVO;
import com.flare.rap.bbs.model.BbsPostDetailResponseVO;
import com.flare.rap.bbs.model.BbsPostRequestVO;
import com.flare.rap.bbs.model.BbsPostResponseVO;
import com.flare.rap.bbs.service.BbsService;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.PaginationResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Bbs")
@Validated
@RequestMapping("/api")
public class BbsController {
    private final BbsService bbsService;

    @Operation(summary = "게시판 목록 조회")
    @GetMapping(value = "/v1/bbs/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<PaginationResponseVO<BbsPostResponseVO>>> findBbsPosts(@ParameterObject @Valid BbsConditionVO bbsCondition) {
        return new ResponseEntity<>(CommonResponseVO.<PaginationResponseVO<BbsPostResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(bbsService.findBbs(bbsCondition))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "게시글 상세 조회")
    @GetMapping(value = "/v1/bbs/post/{bbmNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<BbsPostDetailResponseVO>> findBbsPost(@PathVariable @NotBlank String bbmNo) {
        return new ResponseEntity<>(CommonResponseVO.<BbsPostDetailResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(bbsService.findBbsPost(Integer.parseInt(bbmNo)))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "게시글 생성")
    @PostMapping(value = "/v1/bbs/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> createBbsPost(@RequestBody @Valid BbsPostRequestVO bbsVo) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().insertedRows(bbsService.createBbsPost(bbsVo)).build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "게시글 수정")
    @PutMapping(value = "/v1/bbs/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyBbsPost(
            @RequestBody @Valid BbsPostRequestVO bbsVo) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().updatedRows(bbsService.modifyBbsPost(bbsVo)).build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "게시글 삭제")
    @PatchMapping(value = "/v1/bbs/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> deleteBbsPost(
            @RequestBody @Parameter(description = "게시글번호", example = "1", required = true) int bbmNo) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().deletedRows(bbsService.removeBbsPost(bbmNo)).build())
                .build(), HttpStatus.OK);
    }
}