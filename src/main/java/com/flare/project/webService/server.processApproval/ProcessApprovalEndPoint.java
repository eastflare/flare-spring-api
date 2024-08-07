package com.flare.project.webService.server.processApproval;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.flare.rap.approval.constant.ApprovalProgressStatus;
import com.flare.rap.approval.constant.ApprovalRequestProgressStatus;
import com.flare.rap.approval.model.ApprovalLineRequestVO;
import com.flare.rap.approval.model.ApprovalLineType2UpdateRequestVO;
import com.flare.rap.approval.model.ApprovalRequestIdRequestVO;
import com.flare.rap.approval.service.ApprovalLineService;
import com.flare.rap.approval.service.ApprovalRequestType2Service;
import com.flare.rap.common.config.WebServiceConfiguration;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.employee.service.EmployeeService;
import com.flare.rap.log.model.IfLogVO;
import com.flare.rap.log.service.LogService;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.session.service.SessionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Service
@Slf4j
@RequiredArgsConstructor
public class ProcessApprovalEndPoint {

    private final ApprovalRequestType2Service approvalRequestType2Service;
    private final ApprovalLineService approvalLineService;
    private final EmployeeService employeeService;
    private final SessionService sessionService;
    private final LogService logService;
    private final WebServiceConfiguration configuration;

    // 설명:NAMESPACE_URI localhost이지만 각 개발/운영환경에서도 정상동작함.
    private static final String NAMESPACE_URI = "http://localhost:7070/soap/processApproval";

    private static final String APPROVAL_STATE_UPDATE = "A01";
    private static final String APPROVAL_LINE_UPDATE = "A02";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProcessApprovalRequest")
    @ResponsePayload
    @Transactional(rollbackFor = {Exception.class})
    public GetProcessApprovalResponse processApproval(@RequestPayload GetProcessApprovalRequest request) {

        this.saveInterfaceLog(request);

        if(!configuration.getSystemId().equals(request.getSYSTEMID())) {
            return null;
        }

        if(APPROVAL_STATE_UPDATE.equals(request.getAPITYPE())) {
            this.updateApprovalState(request);
        }

        if(APPROVAL_LINE_UPDATE.equals(request.getAPITYPE())) {
            this.updateApprovalLine(request);
        }

        return  GetProcessApprovalResponse.of(request, configuration.getSystemId());
    }

    private void updateApprovalState(GetProcessApprovalRequest request){
        try {
            ApprovalLineType2UpdateRequestVO approvalLine = ApprovalLineType2UpdateRequestVO.builder()
                    .aprReqId(request.getAPPKEY01())
                    .aprAprvEmpNo(request.getAPPROVER())
                    .aprPsgStatCd(request.getRESULT())
                    .aprAprvDtm(request.getAPPRDATE())
                    .aprAprvOpinUtf8Ctn(request.getCOMMENTUTF8())
                    .build();

            // 위임 결재인 경우 결재자 사번 분리 - 위임한 경우 결재자 사번;위임자 사번이 ;를 구분자로 하여 전달됨
            if (request.getAPPROVER().contains(";")) {
                String[] approvers = request.getAPPROVER().split(";");
                approvalLine.setAprFfilTpCd("M");
                approvalLine.setAprAprvEmpNo(approvers[0]);
                approvalLine.setAprDlgtEmpNo(approvers[1]);
            }

            this.setSession(approvalLine.getAprAprvEmpNo());

            ApprovalRequestIdRequestVO approvalRequestId = ApprovalRequestIdRequestVO.of(request.getAPPKEY01());

            if (!ApprovalProgressStatus.CANCEL.equals(request.getRESULT())) {
                approvalLineService.updateType2ApprovalLine(approvalLine);
            } else {
                approvalRequestId.setAprReqProgStatCd(ApprovalRequestProgressStatus.CANCEL);
            }

            approvalRequestType2Service.updateType2CheckLastApproval(approvalRequestId);
        } catch (BusinessException e) {
            log.debug(e.getMessage());
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void updateApprovalLine(GetProcessApprovalRequest request){
        try {

            String approver = request.getAPPROVER();  // 결재선을 수정한 사람인가?
            if (request.getAPPROVER().contains(";")) {
                String[] approvers = request.getAPPROVER().split(";");
                approver = approvers[0];
            }

            this.setSession(approver);

            String[] aprTpDivsCds = request.getNEXTAPPRTYPE().split(";");
            String[] aprAprvUserIds = request.getNEXTAPPROVER().split(";");
            String[] infrUserIds = request.getREADUSER().split(";");

            List<ApprovalLineRequestVO> approvalLineRequestVOList = new ArrayList<>();

            // APPD 결재라인 생성
            for (int i = 0; i < aprTpDivsCds.length; i++) {
                ApprovalLineRequestVO approvalLine = ApprovalLineRequestVO.builder()
                        .aprLnDivsCd("APPD")
                        .grnrAprTpDivsCd(aprTpDivsCds[i])
                        .aprAprvUserId(aprAprvUserIds[i])
                        .aprPsgStatCd(ApprovalProgressStatus.WAIT) // 이미 기안된 결재문서이므로 승인대기로 남긴다.
                        .build();
                approvalLineRequestVOList.add(approvalLine);
            }

            //INFR 통보자 생성
            for (String infrUserId : infrUserIds) {
                ApprovalLineRequestVO approvalLine = ApprovalLineRequestVO.builder()
                        .aprLnDivsCd("INFR")
                        .aprAprvUserId(infrUserId)
                        .build();
                approvalLineRequestVOList.add(approvalLine);
            }

            approvalLineService.createApprovalLinesByAprvCall( request.getAPPKEY01(), approvalLineRequestVOList,
                    SessionScopeUtil.getContextSession());
        } catch (BusinessException e) {
            log.debug(e.getMessage());
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void setSession(String useId){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        if(userSession == null || userSession.isSessionEmpty()){
            sessionService.createUserSession(useId, "ko", "SAP PI");
        }
    }

    private void saveInterfaceLog(GetProcessApprovalRequest request){
        log.debug("Request is coming from APRV : " + request.toString());

        IfLogVO ifLog = IfLogVO.builder()
                .ifNm("Type2 Approval")
                .ifDivsCd("SERVICE")
                .ifTrmtValCtn("")
                .ifRestValCtn(request.toString())
                .optValNm1(request.getAPPKEY01())
                .optValNm2(request.getAPPROVER())
                .optValNm3(request.getRESULT())
                .dataInsUserId("SAP PI")
                .dataInsUserIp("SAP PI")
                .build();

        logService.createIfLog(ifLog);
    }
}