package com.flare.rap.message.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.ValidList;
import com.flare.rap.message.model.MessageConditionVO;
import com.flare.rap.message.model.MessageVO;
import com.flare.rap.message.service.MessageImportService;
import com.flare.rap.message.service.MessageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Message")
@Validated
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;
    private final MessageImportService messageImportService;

    @Operation(summary = "메시지 조회", tags = { "Message" })
    @GetMapping(value = "/v1/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<MessageVO>>> findMessages(
        @ParameterObject @ModelAttribute MessageConditionVO messageCondition) {
        return new ResponseEntity<>(CommonResponseVO.<List<MessageVO>>builder()
            .successOrNot(CommonConstants.YES_FLAG)
            .statusCode(StatusCodeConstants.SUCCESS)
            .data(messageService.findMessages(messageCondition))
            .build(), HttpStatus.OK);
    }

    @Operation(summary = "메시지 조회-동일코드,여러언어", tags = { "Message" })
    @GetMapping(value = "/v1/messageMsgCtn", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<MessageVO>>> findMessagesMsgCtn(
            @ParameterObject @ModelAttribute MessageConditionVO messageCondition) {
        return new ResponseEntity<>(CommonResponseVO.<List<MessageVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(messageService.findMessagesMsgCtn(messageCondition))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "다건 메시지 생성, 삭제, 수정 일괄 처리", tags = { "Message" })
    @PostMapping(value = "/v1/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveMessages(@RequestBody @Valid ValidList<MessageVO> messages) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
            .successOrNot(CommonConstants.YES_FLAG)
            .statusCode(StatusCodeConstants.SUCCESS)
            .data(messageService.saveMessages(messages))
            .build(), HttpStatus.OK);
    }

    @Operation(summary = "단건 메시지 생성", tags = { "Message" })
    @PostMapping(value = "/v1/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> createMessage(@RequestBody @Valid MessageVO messageVO) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
            .successOrNot(CommonConstants.YES_FLAG)
            .statusCode(StatusCodeConstants.SUCCESS)
            .data(DmlResponseVO.builder().insertedRows(messageService.createMessage(messageVO)).build())
            .build(), HttpStatus.OK);
    }

    @Operation(summary = "단건 메시지 수정", tags = { "Message" })
    @PutMapping(value = "/v1/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyMessage(
        @RequestBody @Valid MessageVO messageVO) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
            .successOrNot(CommonConstants.YES_FLAG)
            .statusCode(StatusCodeConstants.SUCCESS)
            .data(DmlResponseVO.builder().updatedRows(messageService.modifyMessage(messageVO)).build())
            .build(), HttpStatus.OK);
    }

    @Operation(summary = "단건 메시지 삭제", tags = { "Message" })
    @DeleteMapping(value = "/v1/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> deleteMessage(
        @RequestParam @Parameter(description = "메시지코드", example = "multilanguage.page.hello", required = true) String msgCtn,
        @RequestParam @Parameter(description = "언어코드", example = "ko", required = true) String langCd) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
            .successOrNot(CommonConstants.YES_FLAG)
            .statusCode(StatusCodeConstants.SUCCESS)
            .data(DmlResponseVO.builder().deletedRows(messageService.removeMessage(msgCtn, langCd)).build())
            .build(), HttpStatus.OK);
    }

    @Operation(summary = "메시지캐시 Reload", tags = { "Message" })
    @PostMapping(value = "/v1/reloadMessageCache", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> reloadMessageCache() {
        return new ResponseEntity<>(CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(messageService.refreshMessageAll())
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "메시지 Import", tags = { "Message" })
    @PostMapping(value = "/v1/importMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> importMessageCache(
            @Parameter(description = "모두 죽이고 Import 된 것만 살릴지 여부(Y/N)") @RequestParam(required = true, defaultValue = "N") String allUpdateYn) {
        return new ResponseEntity<>(CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(messageImportService.importMessage(allUpdateYn))
                .build(), HttpStatus.OK);
    }

}