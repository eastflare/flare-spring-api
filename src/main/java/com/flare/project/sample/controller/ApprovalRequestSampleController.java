package com.flare.project.sample.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flare.rap.approval.model.ApprovalLineRequestVO;
import com.flare.rap.approval.model.ApprovalRequestIdRequestVO;
import com.flare.rap.approval.model.ApprovalRequestVO;
import com.flare.rap.approval.service.ApprovalRequestService;
import com.flare.rap.approval.service.ApprovalRequestType2Service;
import com.flare.rap.approval.service.ApprovalRequestType3Service;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "ApprovalRequestSample")
@RequestMapping("/api")
public class ApprovalRequestSampleController {
    private final ApprovalRequestService approvalRequestService;
    private final ApprovalRequestType2Service approvalRequestType2Service;
    private final ApprovalRequestType3Service approvalRequestType3Service;

    @Operation(summary = "결재요청 Master 및 결재라인 생성", description = "결제요청 Master와 결재라인 생성을 위한 샘플")
    @PostMapping(value = "/v1/approval", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> createApprovalRequestAndLine(
            @RequestBody @Valid ApprovalRequestVO approvalRequest
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestService.createApprovalRequestAndLine(approvalRequest))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "Type2 결재유형-기안, 통합결재 전송", description = "Type2결재유형-통합결재 전송, 결과: 통합결재에서 주는 return code, message")
    @PutMapping(value = "/v1/approval/type2/request", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> sendType2ApprovalRequest(
            @ParameterObject @Valid ApprovalRequestIdRequestVO approvalRequestId) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType2Service.sendType2ApprovalRequest(approvalRequestId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "Type3 결재유형-기안, 통합결재 전송", description = "Type3결재유형-통합결재 전송, 결과: 통합결재에서 주는 return code, message")
    @PutMapping(value = "/v1/approval/type3/request", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> sendType3ApprovalRequestProcess(
            @ParameterObject @Valid ApprovalRequestIdRequestVO approvalRequestId) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3ApprovalRequestProcess(approvalRequestId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "Type3 결재유형-결재라인별 승인, 통합결재 전송", description = "Type3 결재유형-결재라인별 승인, 통합결재 전송, 필수 Param : aprReqId, aprLnSeq, aprPsgStatCd(APPROVE, REJECT, AGREE, DISAGREE, OK, NO), aprAprvOpinUtf8Ctn  결과: 최종 승인 여부(Y/N)")
    @PutMapping(value = "/v1/approval/type3/approve", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> updateType3ApprovalProgress(
            @ParameterObject @Valid ApprovalLineRequestVO approvalLine) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.updateType3ApprovalProgress(approvalLine))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "복사생성-결재요청 Master 및 결재라인 ", description = "재결재 요청을 위해 기존 결재요청ID를 이용하여 신규 결재요청데이터 생성, 결과 : 신규 결재요청ID")
    @PutMapping(value = "/v1/approval", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> createReApprovalRequestAndLine(
            @Parameter(description = "복사할 결재요청ID") @RequestParam(required = true) String aprReqId
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestService.createReApprovalRequestAndLine(aprReqId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "Type3 결재유형-결재취소, 통합결재 전송, 기안자만 취소가능", description = "Type3결재유형-결재취소 처리 및 전송, 결과: Y")
    @PutMapping(value = "/v1/approval/type3/cancel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> sendType3ApprovalCancel(
            @ParameterObject @Valid ApprovalRequestIdRequestVO approvalRequestId) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.updateType3ApprovalCancel(approvalRequestId))
                        .build(),
                HttpStatus.OK);
    }


    @Operation(summary = "**** 통합결재 보정용 - 결재라인 단건 Update (UserId 사용) - 결재유형, 변경할승인자, 변경할 업무화면 URL 변경가능 ", description = "=> Type3 결재라인 Update 통합결재로 I/F 함 ( I/F 만 처리 ) -- EmpNo 대신 UserId를 사용<br/>" +
            "     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     * @Param aprReqId : 변경할 레거시 결재문서 번호<br/>" +
            "     * @Param targetUserId : 변경대상 결재라인의  UserId<br/>" +
            "     * @Param chgApprType : 변경할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..<br/>" +
            "     * @Param chgApproverUserId : 변경할 결재자 UserId<br/>" +
            "     * @Param chgApproverUrl : 만약 결재자에 따라 결재할 화면이 다르다면 여기에 담아서 전송.<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @PutMapping(value = "/v1/approval/type3/line/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> updateApprovalLineOneUseUserId(
            @Parameter(description = "대상 결재요청ID") @RequestParam(required = true) String aprReqId,
            @Parameter(description = "변경대상 결재라인의 UserId") @RequestParam(required = true) String targetUserId,
            @Parameter(description = "변경할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의.") @RequestParam(required = true) String chgApprType,
            @Parameter(description = "변경할 결재자 UserId") @RequestParam(required = true) String chgApproverUserId,
            @Parameter(description = "만약 결재자에 따라 결재할 화면이 다르다면 여기에 담아서 전송.") @RequestParam(required = false) String chgApproverUrl
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3UpdateLineUseUserId(aprReqId, targetUserId, chgApprType,
                                chgApproverUserId, chgApproverUrl))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "**** 통합결재 보정용 - 결재라인 단건 Update ( EmpNo 사용 ) - 결재유형, 변경할승인자, 변경할 업무화면 URL 변경가능", description = "=> Type3 결재라인 Update 통합결재로 I/F 함 ( I/F 만 처리 )<br/>" +
            "     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     * @Param aprReqId : 변경할 레거시 결재문서 번호<br/>" +
            "     * @Param targetEmpNo : 변경대상 결재라인의 사번<br/>" +
            "     * @Param chgApprType : 변경할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..<br/>" +
            "     * @Param chgApproverEmpNo : 변경할 결재자 사번<br/>" +
            "     * @Param chgApproverUrl : 만약 결재자에 따라 결재할 화면이 다르다면 여기에 담아서 전송.<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @PutMapping(value = "/v1/approval/type3/line/no", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> updateApprovalLineOneUseEmpNo(
            @Parameter(description = "대상 결재요청ID") @RequestParam(required = true) String aprReqId,
            @Parameter(description = "변경대상 결재라인의 사번") @RequestParam(required = true) String targetEmpNo,
            @Parameter(description = "변경할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의.") @RequestParam(required = true) String chgApprType,
            @Parameter(description = "변경할 결재자 사번") @RequestParam(required = true) String chgApproverEmpNo,
            @Parameter(description = "만약 결재자에 따라 결재할 화면이 다르다면 여기에 담아서 전송.") @RequestParam(required = false) String chgApproverUrl
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3UpdateLine(aprReqId, targetEmpNo, chgApprType, chgApproverEmpNo, chgApproverUrl))
                        .build(),
                HttpStatus.OK);
    }


    @Operation(summary = "**** 통합결재 보정용 - 결재라인 삭제 (UserId 사용) ", description = "=> Type3 결재라인 삭제 통합결재로 I/F 함 ( I/F 만 처리 ) -- EmpNo 대신 UserId를 사용<br/>" +
            "     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     * @Param aprReqId : 변경할 레거시 결재문서 번호<br/>" +
            "     * @Param allDeleteYn : 결재라인 전부 삭제할지 여부<br/>" +
            "     * @Param deleteUserId : 삭제할 결재자 ID ( allDeleteYn='N' 일경우 필수 )<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @DeleteMapping(value = "/v1/approval/type3/line/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> deleteApprovalLineUseUserId(
            @Parameter(description = "대상 결재요청ID") @RequestParam(required = true) String aprReqId,
            @Parameter(description = "결재라인 전부 삭제할지 여부") @RequestParam(required = true) String allDeleteYn,
            @Parameter(description = "삭제할 결재자 ID ( allDeleteYn='N' 일경우 필수 )") @RequestParam(required = false) String deleteUserId
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3DeleteLineUseUserId(aprReqId,allDeleteYn,deleteUserId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "**** 통합결재 보정용 - 결재라인 삭제 ( EmpNo 사용 )  ", description = "=> Type3 결재라인 삭제 통합결재로 I/F 함 ( I/F 만 처리 )<br/>" +
            "     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     * @Param aprReqId : 변경할 레거시 결재문서 번호<br/>" +
            "     * @Param allDeleteYn : 결재라인 전부 삭제할지 여부<br/>" +
            "     * @Param deleteUserEmpNo : 삭제할 결재자 사번 ( allDeleteYn='N' 일경우 필수 )<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @DeleteMapping(value = "/v1/approval/type3/line/no", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> deleteApprovalLineUseEmpNo(
            @Parameter(description = "대상 결재요청ID") @RequestParam(required = true) String aprReqId,
            @Parameter(description = "결재라인 전부 삭제할지 여부") @RequestParam(required = true) String allDeleteYn,
            @Parameter(description = "삭제할 결재자 ID ( allDeleteYn='N' 일경우 필수 )") @RequestParam(required = false) String deleteUserId
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3DeleteLine(aprReqId,allDeleteYn,deleteUserId))
                        .build(),
                HttpStatus.OK);
    }


    @Operation(summary = "**** 통합결재 보정용 - 결재라인 추가 (UserId 사용) ", description = "=> Type3 결재라인 추가 통합결재로 I/F 함 ( I/F 만 처리 ) -- EmpNo 대신 UserId를 사용<br/>" +
            "     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     * @Param aprReqId : 변경할 레거시 결재문서 번호<br/>" +
            "     * @Param addApprType : 추가 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..<br/>" +
            "     * @Param addApproverUserId : 추가할 결재자  UserId<br/>" +
            "     * @Param addApproverUrl : 추가 결재자가 볼 화면<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @PostMapping(value = "/v1/approval/type3/line/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> addApprovalLineUseUserId(
            @Parameter(description = "추가 대상 결재요청ID") @RequestParam(required = true) String aprReqId,
            @Parameter(description = "추가 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..") @RequestParam(required = true) String addApprType,
            @Parameter(description = "추가할 결재자  UserId") @RequestParam(required = true) String addApproverUserId,
            @Parameter(description = "추가 결재자가 볼 화면") @RequestParam(required = false) String addApproverUrl
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3AddLineUseUserId(aprReqId,addApprType,addApproverUserId,addApproverUrl))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "**** 통합결재 보정용 - 결재라인 추가 ( EmpNo 사용 )  ", description = "=> Type3 결재라인 추가 통합결재로 I/F 함 ( I/F 만 처리 )<br/>" +
            "     *   !!! 중요 : 결재라인기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재라인기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     * @Param aprReqId : 변경할 레거시 결재문서 번호<br/>" +
            "     * @Param addApprType : 추가할 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..<br/>" +
            "     * @Param addApproverEmpNo : 추가할 결재자 사번<br/>" +
            "     * @Param addApproverUrl : 추가 결재자가 볼 화면<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @PostMapping(value = "/v1/approval/type3/line/no", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO> addApprovalLineUseEmpNo(
            @Parameter(description = "추가 대상 결재요청ID") @RequestParam(required = true) String aprReqId,
            @Parameter(description = "추가 결재 유형 ( 0, 1, 2, 6, ... ) 결재, 합의..") @RequestParam(required = true) String addApprType,
            @Parameter(description = "추가할 결재자 사번") @RequestParam(required = true) String addApproverEmpNo,
            @Parameter(description = "추가 결재자가 볼 화면") @RequestParam(required = false) String addApproverUrl
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3AddLine(aprReqId,addApprType,addApproverEmpNo,addApproverUrl))
                        .build(),
                HttpStatus.OK);
    }


    @Operation(summary = "**** 통합결재 보정용 - 결재취소 == 결재삭제 - 조심하세요!! 완료된 결재도 삭제가능! ", description = "=> Type3 결재취소(상신취소) 통합결재로 I/F 함 ( I/F 만 처리 )<br/>" +
            "     *   !!! 중요 : 결재요청기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재요청기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @DeleteMapping(value = "/v1/approval", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO>  deleteApprovalDoc(
            @Parameter(description = "삭제하려는 결재요청ID") @RequestParam(required = true) String aprReqId
    ) {

        return new ResponseEntity<>(
                CommonResponseVO.builder()
                        .successOrNot(CommonConstants.YES_FLAG)
                        .statusCode(StatusCodeConstants.SUCCESS)
                        .data(approvalRequestType3Service.sendType3Delete(aprReqId))
                        .build(),
                HttpStatus.OK);
    }

    @Operation(summary = "**** 통합결재 보정용 - 보존년한 변경 (완료,삭제된 결재는 불가) ", description = "=> Type3 결재문서 보전년한 수정 통합결재로 I/F 함 ( I/F 만 처리 )<br/>" +
            "     *   !!! 중요 : 결재요청기본 테이블 데이터 상태와 관계없이 호출 되므로, 결재요청기본 데이터는 별도 처리해야 합니다.<br/>" +
            "     * @Param aprReqId 변경할 레거시 결재문서 번호<br/>" +
            "     * @Param aprPvnDdlnCd 결재보존기한코드 APPRCODE_1M, APPRCODE_1Y, APPRCODE_3Y, APPRCODE_5Y, APPRCODE_10Y, APPRCODE_100Y<br/>" +
            "     *   Return : 통합결재 호출 결과,<br/>" +
            "     *                성공이면 ifStatus : S<br/>" +
            "     *                실패면  ifStatus : F, ifErrMsg")
    @PutMapping(value = "/v1/approval/type3/period", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO>  updateApprPeriod(
            @Parameter(description = "변경하려는 결재요청ID") @RequestParam(required = true) String aprReqId,
            @Parameter(description = "결재보존기한코드") @RequestParam(required = true) String aprPvnDdlnCd

    ) {

        return new ResponseEntity<>(
                        CommonResponseVO.builder()
                                .successOrNot(CommonConstants.YES_FLAG)
                                .statusCode(StatusCodeConstants.SUCCESS)
                                .data(approvalRequestType3Service.sendType3UpdateApprPeriod(aprReqId, aprPvnDdlnCd))
                                .build(),
                        HttpStatus.OK);
    }


}