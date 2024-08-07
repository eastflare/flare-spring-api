package com.flare.project.sample.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.model.ApprovalRequestIdRequestVO;
import com.flare.rap.approval.model.ApprovalRequestMasterResponseVO;
import com.flare.rap.approval.repository.ApprovalRequestRepository;
import com.flare.rap.approval.service.AfterApprovalService;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *  안내 사항 :
 *
 *  업무서비스A -> ApprovalRequestService -> AfterApprovalService -> 업무서비스A
 *  와 같이 서비스 순환참조가 발생할 수 있으므로, 각 업무단에서 처리할 결재 후 처리 서비스는
 *  ApprovalRequestService 를 생성자주입하지 않는  별도 서비스로 개발해주시기 바랍니다.
 *
 *  Type2 는 SAP PI에서 호출되기 때문에 userSession이 없음. ( Dummy UserSessionVo를 넘김. )
 *  Type3 는 내 시스템에서 호출되기 때문에 userSession이 있음.
 *  상횡에 따라서 다르기 때문에 각 업무단에서 처리할 결재 후 처리 서비스는
 *  UserSessionVo를 파라미터로 받아서 처리해야 합니다.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AfterApprovalSampleService implements AfterApprovalService {

    private final ApprovalRequestRepository approvalRequestRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int afterApprovalProcess(ApprovalRequestIdRequestVO approvalRequestId) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return this.afterApprovalProcess(approvalRequestId, userSession);

    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int afterApprovalProcess(ApprovalRequestIdRequestVO approvalRequestId, UserSessionVO userSession) {
        int rtn = 0;

        ApprovalRequestMasterResponseVO approvalRequestMaster =
                approvalRequestRepository.selectApprovalRequestMaster(approvalRequestId, userSession);

        if (approvalRequestMaster == null) {
            throw new BusinessException("결재요청 기본 정보가 없습니다.", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }

        if (!approvalRequestMaster.isApprovalStatusComplete() &&
                !approvalRequestMaster.isApprovalStatusReject() &&
                !approvalRequestMaster.isApprovalStatusCancel()) {
            throw new BusinessException("결재 미완료 건으로 진행 할 수 없습니다.", StatusCodeConstants.EXPECTATION_FAILED);
        }

        // 결재 양식별로 결재 후 처리를 다르게합니다.
        // 결재 후 처리 로직에 대해서 아래 case 문에 추가합니다.
        switch(approvalRequestMaster.getAprTplId()) {
            case "APR_FORM_001" :
                rtn = 1;
                break;
            case "APR_FORM_002" :
                rtn = 1;
                break;
            case "APR_FORM_003" :
                rtn = 1;
                break;
            default :
                log.debug("처리할 결재 후처리가 없습니다. " + approvalRequestMaster);
                break;
        }

        return rtn;
    }
}