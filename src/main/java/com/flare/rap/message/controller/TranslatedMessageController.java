package com.flare.rap.message.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.message.service.MessageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Translated Message")
@Validated
@RequestMapping("/api")
public class TranslatedMessageController {

    private final MessageService messageService;

    @Operation(summary = "다국어 반영")
    @GetMapping(value = "/v1/translated-messages/deploy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> deployTranslatedMessages(
        @RequestParam(required = false) @Parameter(name = "langCd", description = "언어코드", example = "ko") String langCd) {

         return new ResponseEntity<>(CommonResponseVO.builder()
            .successOrNot(CommonConstants.YES_FLAG)
            .statusCode(StatusCodeConstants.SUCCESS)
            .data(messageService.deployTranslatedMessages(langCd))
            .build(), HttpStatus.OK);
    }

    @Operation(summary = "다국어 반영 - FE 내장 빌드용")
    @GetMapping(value = "/v1/translated-messages/deploy-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> deployTranslatedMessagesAll() {

        return new ResponseEntity<>(CommonResponseVO.builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(messageService.deployTranslatedMessagesAll())
                .build(), HttpStatus.OK);
    }


    @Operation(summary = "다국어 조회")
    @GetMapping(value = "/v1/translated-messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<Map<String, String>>> getTranslatedMessages(
        @RequestParam @Parameter(name = "langCd", description = "언어코드", example = "ko") String langCd){

         return new ResponseEntity<>(CommonResponseVO.<Map<String, String>>builder()
            .successOrNot(CommonConstants.YES_FLAG)
            .statusCode(StatusCodeConstants.SUCCESS)
            .data(messageService.readTranslatedMessageFile(langCd))
            .build(), HttpStatus.OK);
    }

}