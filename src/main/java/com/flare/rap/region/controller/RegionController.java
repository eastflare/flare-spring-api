package com.flare.rap.region.controller;

import java.util.List;

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
import com.flare.rap.region.model.RegionResponseVO;
import com.flare.rap.region.service.RegionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Region")
@Validated
@RequestMapping("/api")
public class RegionController {
    private final RegionService regionService;
    @Operation(summary = "지역명 목록 조회")
    @GetMapping(value = "/v1/region", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<RegionResponseVO>>> findSealRegion(@Parameter(description = "지역명", example ="서울") @RequestParam(required = false) String regnNm) {
        return new ResponseEntity<>(CommonResponseVO.<List<RegionResponseVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(regionService.findSealRegion(regnNm))
                .build(), HttpStatus.OK);
    }
}