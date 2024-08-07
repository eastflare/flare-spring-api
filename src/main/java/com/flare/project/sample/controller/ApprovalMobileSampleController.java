package com.flare.project.sample.controller;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.approval.model.ApprovalMobileApprovalDetailVO;
import com.flare.rap.approval.model.ApprovalMobileApprovalResultResponseVO;
import com.flare.rap.approval.model.ApprovalMobileRequestVO;
import com.flare.rap.approval.service.ApprovalMobileService;
import com.flare.rap.common.util.NetworkUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Tag(name = "ApprovalMobile")
@Validated
@Slf4j
@RequestMapping("/api")
public class ApprovalMobileSampleController {

    private final ApprovalMobileService approvalMobileService;
    @Operation(summary = "결재상세조회 모바일", description = "결재상세조회 모바일")
    @GetMapping(value = "/v1/approval/mobile/detail")
    @ResponseBody
    public ApprovalMobileApprovalDetailVO findApprovalMobileDetail(
        @Parameter(description = "userID", example = "G-Portal ID") @RequestParam(required = false) String userID,
        @Parameter(description = "mbCode", example = "8012+userId") @RequestParam(required = false) String mbCode,
        @Parameter(description = "empNo", example = "요청자 사번") @RequestParam(required = false) String empNo,
        @Parameter(description = "mbLanguage", example = "KO,EN") @RequestParam(required = false) String mbLanguage,
        @Parameter(description = "aprReqId", example = "BLWC-AR-20230622-00022") @RequestParam(required = false) String aprReqId,
        HttpServletRequest request,
        HttpServletResponse response){

        ApprovalMobileRequestVO approvalMobileRequest = ApprovalMobileRequestVO.builder()
                .aprReqId(aprReqId)
                .userID(userID)
                .mbCode(mbCode)
                .empNo(empNo)
                .mbLanguage(mbLanguage)
                .build();

        String userIp = NetworkUtil.getClientIP(request);
        response.setContentType(MediaType.APPLICATION_XML_VALUE);

        return approvalMobileService.approvalMobileDetail(approvalMobileRequest, userIp);
    }


    @Operation(summary = "모바일 결재 처리", description = "모바일일 결재 처리")
    @GetMapping(value = "/v1/approval/mobile/process")
    public ApprovalMobileApprovalResultResponseVO saveApprovalProcess(
            @Parameter(description = "userID - 승인할 사람 ID, 레거시 마다 암호화 방식의 차이가 있음(기본 AES128)", example = "G-Portal ID") @RequestParam(required = false) String userID,
            @Parameter(description = "docId - 결재 문서 ID", example = "BLWC-AR-20230622-00022") @RequestParam(required = false) String docId,
            @Parameter(description = "apprIndex - 결재 차수 결재 상세조회시 받은 <apprIndex> 값 보내줌", example = "2") @RequestParam(required = false) int apprIndex,
            @Parameter(description = "apprType - 01 : 승인 / 04 : 반려", example = "01") @RequestParam(required = false) String apprType,
            @Parameter(description = "empNo", example = "승인한 사람 사번 사번값으로 필요한 레거시만 보내준다. 레거시마다 암호화 방식의 차이가 있음(기본 AES128)") @RequestParam(required = false) String empNo,
            @Parameter(description = "apprComment - 결재의견", example = "comment") @RequestParam(required = false) String apprComment,
            @Parameter(description = "mbLanguage - 언어정보 KR/EN", example = "KR") @RequestParam(required = false) String mbLanguage,
            HttpServletRequest request,
            HttpServletResponse response
            ) {

        ApprovalMobileRequestVO approvalMobileRequest = ApprovalMobileRequestVO.builder()
                .userID(userID)
                .docId(docId)
                .apprIndex(apprIndex)
                .apprType(apprType)
                .empNo(empNo)
                .apprComment(apprComment)
                .mbLanguage(mbLanguage)
                .build();

        String userIp = NetworkUtil.getClientIP(request);

        response.setContentType(MediaType.APPLICATION_XML_VALUE);

        return approvalMobileService.approvalMobileProcess(approvalMobileRequest, userIp);
    }
}