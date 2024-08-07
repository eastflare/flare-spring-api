package com.flare.rap.approval.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.approval.model.ApprovalExcludeDetailRequestVO;
import com.flare.rap.approval.model.ApprovalExcludeDetailVO;
import com.flare.rap.approval.model.ApprovalExcludeMasterRequestVO;
import com.flare.rap.approval.model.ApprovalExcludeMasterVO;
import com.flare.rap.approval.model.ApprovalExcludeResponseVO;
import com.flare.rap.approval.repository.ApprovalExcludeRepository;
import com.flare.rap.common.constant.CrudConstants;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalExcludeServiceImpl implements ApprovalExcludeService {
    private final ApprovalExcludeRepository approvalExcludeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ApprovalExcludeMasterVO> findApprovalExcludeMasters(String aprExcNm) {
        return approvalExcludeRepository.selectApprovalExcludeMasters(aprExcNm);
    }

    @Override
    public List<ApprovalExcludeDetailVO> findApprovalExcludeDetails(long aprExcTgtId) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return approvalExcludeRepository.selectApprovalExcludeDetails(aprExcTgtId, userSession);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public ApprovalExcludeResponseVO saveApprovalExclude(List<ApprovalExcludeMasterRequestVO> masters,
                                                         List<ApprovalExcludeDetailRequestVO> details){
        DmlResponseVO masterResult = saveApprovalExcludeMasters(masters);
        DmlResponseVO detailResult = saveApprovalExcludeDetails(details);

        return ApprovalExcludeResponseVO.builder().approveExcludeMaster(masterResult).approveExcludeDetail(detailResult).build();
    }

    private DmlResponseVO saveApprovalExcludeMasters(List<ApprovalExcludeMasterRequestVO> masters){
        int insertedRows = 0, updatedRows = 0;

        if(ValidateUtil.isEmpty(masters)) {
            return DmlResponseVO.builder().insertedRows(insertedRows).updatedRows(updatedRows).build();
        }

        List<ApprovalExcludeMasterRequestVO> insertMasters = new ArrayList<>();
        List<ApprovalExcludeMasterRequestVO> updateMasters = new ArrayList<>();
        for (ApprovalExcludeMasterRequestVO master : masters) {
            if (CrudConstants.CREATE.equalsIgnoreCase(master.getCrudKey())) {
                insertMasters.add(master);
            } else if (CrudConstants.UPDATE.equalsIgnoreCase(master.getCrudKey())) {
                updateMasters.add((master));
            }
        }

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        for(ApprovalExcludeMasterRequestVO master: insertMasters) {
            insertedRows += approvalExcludeRepository.insertApprovalExcludeMaster(master, userSession);
        }

        for (ApprovalExcludeMasterRequestVO master : updateMasters) {
            updatedRows += approvalExcludeRepository.updateApprovalExcludeMaster(master, userSession);
        }

        return DmlResponseVO.builder().insertedRows(insertedRows).updatedRows(updatedRows).build();
    }

    private DmlResponseVO saveApprovalExcludeDetails(List<ApprovalExcludeDetailRequestVO> details){
        int insertedRows = 0, updatedRows = 0, deletedRows = 0;

        if(ValidateUtil.isEmpty(details)) {
            return DmlResponseVO.builder().insertedRows(insertedRows).updatedRows(updatedRows).deletedRows(deletedRows).build();
        }

        List<ApprovalExcludeDetailRequestVO> insertDetails = new ArrayList<>();
        List<ApprovalExcludeDetailRequestVO> updateDetails = new ArrayList<>();
        List<ApprovalExcludeDetailRequestVO> deleteDetails = new ArrayList<>();

        for (ApprovalExcludeDetailRequestVO detail : details) {
            if (CrudConstants.CREATE.equalsIgnoreCase(detail.getCrudKey())) {
                insertDetails.add(detail);
            } else if (CrudConstants.UPDATE.equalsIgnoreCase(detail.getCrudKey())) {
                updateDetails.add(detail);
            } else if (CrudConstants.DELETE.equalsIgnoreCase(detail.getCrudKey())) {
                deleteDetails.add(detail);
            }
        }

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        long maxId = approvalExcludeRepository.selectMaxMasterId();

        for (ApprovalExcludeDetailRequestVO detail : insertDetails) {
            if(ValidateUtil.isEmpty(detail.getAprExcTgtId())) detail.setAprExcTgtId(maxId);
            insertedRows += approvalExcludeRepository.insertApprovalExcludeDetail(detail, userSession);
        }

        for (ApprovalExcludeDetailRequestVO detail : updateDetails) {
            updatedRows += approvalExcludeRepository.updateApprovalExcludeDetail(detail, userSession);
        }

        for (ApprovalExcludeDetailRequestVO detail : deleteDetails) {
            deletedRows += approvalExcludeRepository.deleteApprovalExcludeDetail(detail);
        }

        return DmlResponseVO.builder().insertedRows(insertedRows).updatedRows(updatedRows).deletedRows(deletedRows).build();

    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public ApprovalExcludeResponseVO deleteApprovalExclude(long aprExcTgtId){
        DmlResponseVO masterResult = DmlResponseVO.builder()
                .deletedRows(approvalExcludeRepository.deleteApprovalExcludeMaster(aprExcTgtId)).build();
        DmlResponseVO detailResult = DmlResponseVO.builder()
                .deletedRows(approvalExcludeRepository.deleteDetailsByAprExcTgtId(aprExcTgtId)).build();

        return ApprovalExcludeResponseVO.builder().approveExcludeMaster(masterResult).approveExcludeDetail(detailResult).build();
    }
}