package com.flare.rap.approval.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.model.ApprovalCommonResponseVO;
import com.flare.rap.approval.model.ApprovalDelegateRequestVO;
import com.flare.rap.approval.model.ApprovalDelegateResponseVO;
import com.flare.rap.approval.model.ApprovalSetEntrustRequestVO;
import com.flare.rap.approval.repository.ApprovalDelegateRepository;
import com.flare.rap.common.config.WebServiceConfiguration;
import com.flare.rap.common.constant.CrudConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.DateUtil;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.employee.service.EmployeeService;
import com.flare.rap.session.model.UserSessionVO;
import com.flare.rap.webservice.constant.InterfaceResult;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.model.WebServiceRequest;
import com.flare.rap.webservice.service.WebService;
import com.flare.rap.webservice.service.WebServiceFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalDelegateServiceImpl implements ApprovalDelegateService {

    private final ApprovalDelegateRepository approvalDelegateRepository;
    private final EmployeeService employeeService;
    private final WebServiceConfiguration configuration;
    private final WebServiceFactory webServiceFactory;


    /**
     * 검색조건에 해당하는 결재위임 리스트 전체 조회
     * @param aprDlgtUserId
     * @param statusFlag
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<ApprovalDelegateResponseVO> findApprovalDelegates(String aprDlgtUserId, String statusFlag) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return approvalDelegateRepository.selectApprovalDelegates(aprDlgtUserId, statusFlag, userSession);
    }

    /**
     * 화면에서 입력받은 결재위임 정보목록 저장
     * @param approvalDelegates
     * @return
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public DmlResponseVO saveApprovalDelegates(List<ApprovalDelegateRequestVO> approvalDelegates) {

        int deleted = 0 , inserted = 0, updated = 0;
        for (ApprovalDelegateRequestVO approvalDelegate:approvalDelegates) {
            if (!approvalDelegate.isUsed()) {
                approvalDelegate.setCrudKey(CrudConstants.DELETE);
            }

            if(CrudConstants.CREATE.equals(approvalDelegate.getCrudKey())){
                this.createApprovalDelegate(approvalDelegate);

                if(configuration.isEntrust()) {
                    this.requestCreateDelegateToWebService(approvalDelegate);
                }

                inserted++;
            }else if(CrudConstants.UPDATE.equals(approvalDelegate.getCrudKey())){
                this.updateApprovalDelegate(approvalDelegate);

                if(configuration.isEntrust()){
                    this.requestDeleteDelegateToWebService(approvalDelegate);
                    this.requestCreateDelegateToWebService(approvalDelegate);
                }

                updated++;
            }else if(CrudConstants.DELETE.equals(approvalDelegate.getCrudKey())){
                this.updateApprovalDelegate(approvalDelegate);

                if(configuration.isEntrust()){
                    this.requestDeleteDelegateToWebService(approvalDelegate);
                }

                deleted++;
            }else{
                throw new BusinessException("Primary key not exist", StatusCodeConstants.FAIL);
            }
        }

        return new DmlResponseVO(inserted, updated, deleted);
    }

    private void createApprovalDelegate(ApprovalDelegateRequestVO approvalDelegate){
        if(!approvalDelegateRepository.selectDlgtDuplicateCheck(approvalDelegate).isEmpty())
            throw new BusinessException("Duplicated Delegator data", StatusCodeConstants.DUPLICATED_VALUE_ERROR);

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        approvalDelegateRepository.insertApprovalDelegate(approvalDelegate, userSession);
    }

    private void requestCreateDelegateToWebService(ApprovalDelegateRequestVO approvalDelegate){
        WebServiceRequest approvalSetEntrustRequestCreate = ApprovalSetEntrustRequestVO.builder()
                .apiType("A01") // 위임 등록
                .reqUser(employeeService.findUserIdToEmpNo(approvalDelegate.getAprDlgtUserId())) // 위임자 사번
                .signUser(employeeService.findUserIdToEmpNo(approvalDelegate.getAprDeleUserId())) // 수임자 사번
                .startDate(DateUtil.formatDate(approvalDelegate.getAprDlgtStDt(), ".")) // 위임 시작일 ( YYYY.MM.DD )
                .endDate(DateUtil.formatDate(approvalDelegate.getAprDlgtEndDt(), ".")) // 위임 종료일 ( YYYY.MM.DD )
                .build();

        ApprovalCommonResponseVO ifResult;
        try {
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.APPROVAL_ENTRUST);
            ifResult =
                    (ApprovalCommonResponseVO) webService.execute(approvalSetEntrustRequestCreate);
        } catch (Exception e) {
            throw new BusinessException("Send to approvalSetEntrust Fail(COMM-ERR)", StatusCodeConstants.FAIL);
        }

        if (!InterfaceResult.SUCCESS.equals(ifResult.getIfStatus()))
            throw new BusinessException("Send to approvalSetEntrust Fail(RETURN-FAIL) - " + ifResult.getIfErrMsg()
                    , StatusCodeConstants.FAIL);
    }

    private void updateApprovalDelegate(ApprovalDelegateRequestVO approvalDelegate){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        if(approvalDelegateRepository.updateApprovalDelegate(approvalDelegate, userSession) == 0) {
            throw new BusinessException("Primary key not exist", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }
    }

    private void requestDeleteDelegateToWebService(ApprovalDelegateRequestVO approvalDelegate){
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        ApprovalDelegateResponseVO oldApprovalDelegate =
                approvalDelegateRepository.selectApprovalDelegatesForOne(approvalDelegate.getAprDlgtNo(), userSession);

        WebServiceRequest approvalSetEntrustRequestDelete = ApprovalSetEntrustRequestVO.builder()
                .apiType("A02") // 위임 삭제
                .reqUser(employeeService.findUserIdToEmpNo(oldApprovalDelegate.getAprDlgtUserId())) // 위임자 사번
                .signUser(employeeService.findUserIdToEmpNo(oldApprovalDelegate.getAprDeleUserId())) // 수임자 사번
                .startDate(DateUtil.formatDate(oldApprovalDelegate.getAprDlgtStDt(), ".")) // 위임 시작일 ( YYYY.MM.DD )
                .endDate(DateUtil.formatDate(oldApprovalDelegate.getAprDlgtEndDt(), ".")) // 위임 종료일 ( YYYY.MM.DD )
                .build();

        try {
            WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.APPROVAL_ENTRUST);
            webService.execute(approvalSetEntrustRequestDelete);
        } catch (Exception e) {
            throw new BusinessException("Send to approvalSetEntrust Fail(COMM-ERR)", StatusCodeConstants.FAIL);
        }
    }
}