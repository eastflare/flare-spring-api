package com.flare.rap.notice.controller;

import java.util.List;

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

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.notice.model.NoticeConditionVO;
import com.flare.rap.notice.model.NoticePostDetailResponseVO;
import com.flare.rap.notice.model.NoticePostRequestVO;
import com.flare.rap.notice.model.NoticePostResponseVO;
import com.flare.rap.notice.service.NoticeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Notice")
@Validated
@RequestMapping("/api")
public class NoticeController {

    private final NoticeService noticeService;

    @Operation(summary = "공지사항 목록 조회")
    @GetMapping(value = "/v1/notice/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<PaginationResponseVO<NoticePostResponseVO>>> findNoticePosts(@ParameterObject @Valid NoticeConditionVO noticeCondition) {
        return new ResponseEntity<>(CommonResponseVO.<PaginationResponseVO<NoticePostResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(noticeService.findNotice(noticeCondition))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "공지사항 상세 조회")
    @GetMapping(value = "/v1/notice/post/{bbmNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<NoticePostDetailResponseVO>> findNoticePost(@PathVariable @NotBlank String bbmNo) {
        return new ResponseEntity<>(CommonResponseVO.<NoticePostDetailResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(noticeService.findNoticePost(Integer.parseInt(bbmNo)))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "공지사항 팝업 상세 조회")
    @GetMapping(value = "/v1/notice/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<NoticePostDetailResponseVO>>> findNoticePopUpPost() {
        return new ResponseEntity<>(CommonResponseVO.<List<NoticePostDetailResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(noticeService.findNoticePopupPost())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "공지사항 생성")
    @PostMapping(value = "/v1/notice/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> createNoticePost(@RequestBody @Valid NoticePostRequestVO noticeVo) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().insertedRows(noticeService.createNoticePost(noticeVo)).build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "공지사항 수정")
    @PutMapping(value = "/v1/notice/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyNoticePost(
            @RequestBody @Valid NoticePostRequestVO noticeVo) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().updatedRows(noticeService.modifyNoticePost(noticeVo)).build())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "공지사항 삭제")
    @PatchMapping(value = "/v1/notice/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyDisableNoticePost(
            @RequestBody @Parameter(description = "게시글번호", example = "1", required = true) int bbmNo) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder().deletedRows(noticeService.modifyDisableNoticePost(bbmNo)).build())
                .build(), HttpStatus.OK);
    }

}