package com.flare.rap.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.api.model.ApiUrlConditionVO;
import com.flare.rap.api.model.ApiUrlRequestVO;
import com.flare.rap.api.model.ApiUrlResponseVO;
import com.flare.rap.api.service.ApiUrlService;
import com.flare.rap.common.constant.CommonConstants;package com.flare.rap.api.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApiUrlResponseVO {

    @Schema(description = "API ID")
    private String apiId;

    @Schema(description = "API 명")
    private String apiNm;

    @Schema(description = "API URL")
    private String apiUrl;

    @Schema(description = "API Method")
    private String httpMthdCd;

    @Schema(description = "역할")
    private List<String> apiRoles;

    @Schema(description = "사용여부")
    private String useYn;

    @Schema(description = "작성자")
    private String dataInsUserName;

    @Schema(description = "작성일시")
    private String dataInsDtm;

    @Schema(description = "수정자")
    private String dataUpdUserName;

    @Schema(description = "수정일시")
    private String dataUpdDtm;
}
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.model.ValidList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Api")
@Validated
@RequestMapping("/api")
public class ApiUrlController {
    private final ApiUrlService apiUrlService;

    @Operation(summary = "Api Url 조회")
    @GetMapping(value = "/v1/apiUrls", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<ApiUrlResponseVO>>> findApiUrls(@ParameterObject ApiUrlConditionVO apiUrlCondition) {
        return new ResponseEntity<>(CommonResponseVO.<List<ApiUrlResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(apiUrlService.findApiUrls(apiUrlCondition))
                .build(), HttpStatus.OK);
    }

    @Operation(summary = "Api Url 추가/수정/삭제")
    @PostMapping(value = "/v1/apiUrls", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> saveApiUrls(@RequestBody ValidList<ApiUrlRequestVO> apiUrls) {
        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(apiUrlService.saveApiUrls(apiUrls))
                .build(), HttpStatus.OK);
    }

}