package com.flare.rap.code.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.code.model.*;
import com.flare.rap.code.repository.CommonCodeRepository;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CommonCodeGroupResponseVO> findCommonCodeGroups(
            String searchGroupCode,
            String useYn,
            String searchCode) {

            UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return commonCodeRepository.selectCommonCodeGroups(searchGroupCode, useYn, searchCode, userSession.getLangCd());
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public DmlResponseVO saveCommonCodeGroups(List<CommonCodeGroupRequestVO> codeGroups) {
        DmlResponseVO dmlResponseVO = new DmlResponseVO();

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        commonCodeRepository.upsertCommonCodeGroups(codeGroups, userSession);

        List<CommonCodeGroupRequestVO> deleteCodeGroups = codeGroups.stream().filter((groups) -> "D".equals(groups.getCrudKey())).toList();

        if(!deleteCodeGroups.isEmpty()) {
            commonCodeRepository.deleteCommonCodeGroups(deleteCodeGroups);
            commonCodeRepository.deleteCommonCodesByCodeGroup(deleteCodeGroups);
        }

        return dmlResponseVO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommonCodeResponseVO> findCommonCodes(String cmnGrCd) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        return commonCodeRepository.selectCommonCodes(cmnGrCd, userSession.getLangCd());
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public DmlResponseVO saveCommonCodes(List<CommonCodeRequestVO> codes) {
        DmlResponseVO dmlResponseVO = new DmlResponseVO();

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        commonCodeRepository.upsertCommonCodes(codes, userSession);

        List<CommonCodeRequestVO> deleteCodes = codes.stream().filter((code) -> "D".equals(code.getCrudKey())).toList();
        if(!deleteCodes.isEmpty()) {
            commonCodeRepository.deleteCommonCodes(deleteCodes);
        }

        return dmlResponseVO;
    }

    @Override
    @Transactional(readOnly = true)
    public CommonCodeHeaderResponseVO findCommonCodeHeader(String cmnGrCd) {
        return commonCodeRepository.selectCommonCodeHeader(cmnGrCd);
    }

    @Override
    public List<CommonCodeNameResponseVO> findCommonCodeNames(String cmnGrCd) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return commonCodeRepository.selectCommonCodeNames(cmnGrCd, userSession.getLangCd());
    }

    @Override
    public List<CommonCodeNameResponseVO> findCommonCodeNamesWithCode(String cmnGrCd) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return commonCodeRepository.selectCommonCodeNamesWithCode(cmnGrCd, userSession.getLangCd());
    }

    @Override
    public List<CommonCodeNameResponseVO> findCommonCodeNamesCondition(CommonCodeConditionVO condition) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        return commonCodeRepository.selectCommonCodeNamesCondition(condition, userSession.getLangCd());
    }
}