package com.flare.rap.approval.service;

import com.flare.rap.approval.model.ApprovalRequestIdRequestVO;
import com.flare.rap.session.model.UserSessionVO;

public interface AfterApprovalService {

    /**
     * afterApprovalProcess
     *   => Type3 용 , 결재 후 처리
     *   Return : 처리 결과
     */

    int afterApprovalProcess(ApprovalRequestIdRequestVO approvalRequestId);

    /**
     * afterApprovalProcess
     *   => Type2 용 , 결재 후 처리, WebService 호출 과 같이 세션이 없는 경우 Dummy Session을 넘기기 위함.
     *   Return : 처리 결과
     */

    int afterApprovalProcess(ApprovalRequestIdRequestVO approvalRequestId, UserSessionVO userSession);


}