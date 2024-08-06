package com.flare.rap.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.api.model.ApiUrlConditionVO;
import com.flare.rap.api.model.ApiUrlRequestVO;
import com.flare.rap.api.model.ApiUrlResponseVO;
import com.flare.rap.api.repository.ApiUrlRepository;
import com.flare.rap.common.constant.CrudConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiUrlServiceImpl implements ApiUrlService {

    private final ApiUrlRepository apiUrlRepository;

    /**
     * 검색조건에 해당하는 api url리스트 조회
     * @param apiUrlCondition
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<ApiUrlResponseVO> findApiUrls(ApiUrlConditionVO apiUrlCondition) {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        List<ApiUrlResponseVO> apiUrls = apiUrlRepository.selectApiUrls(apiUrlCondition, userSession);

        for (ApiUrlResponseVO apiUrl : apiUrls) {
            List<String> roles = apiUrlRepository.selectApiRoleCodes(apiUrl.getApiId());
            apiUrl.setApiRoles(roles);
        }
        return apiUrls;
    }

    /**
     * 수정된 api url 리스트 정보 저장(등록, 수정, 삭제 분기처리)
     * @param apis
     * @return
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public DmlResponseVO saveApiUrls(List<ApiUrlRequestVO> apis) {

        DmlResponseVO dmlResponseVO = new DmlResponseVO();

        List<ApiUrlRequestVO> insertApiList = new ArrayList<>();
        List<ApiUrlRequestVO> updateApiList = new ArrayList<>();
        List<ApiUrlRequestVO> deleteApiList = new ArrayList<>();

        for (ApiUrlRequestVO api : apis) {
            switch (api.getCrudKey().toUpperCase()) {
                case CrudConstants.CREATE:
                    insertApiList.add(api);
                    break;
                case CrudConstants.UPDATE:
                    updateApiList.add(api);
                    break;
                case CrudConstants.DELETE:
                    deleteApiList.add(api);
                    break;
            }
        }

        dmlResponseVO.setDeletedRows(removeApiUrls(deleteApiList));
        dmlResponseVO.setUpdatedRows(modifyApiUrls(updateApiList));
        dmlResponseVO.setInsertedRows(createApiUrls(insertApiList));

        return dmlResponseVO;
    }

    /**
     * 새롭게 입력받은 api url 리스트 저장
     * @param apiUrls
     * @return
     */
    private int createApiUrls(List<ApiUrlRequestVO> apiUrls) {

        if (ValidateUtil.isEmpty(apiUrls))
            return 0;

        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        int result = 0;
        for (ApiUrlRequestVO apiUrl : apiUrls) {
            result += createApiUrl(apiUrl, userSession);
        }
        return result;
    }

    /**
     * 새롭게 입력받은 api url 단건 저장
     * @param apiUrl
     * @param session
     * @return
     */
    private int createApiUrl(ApiUrlRequestVO apiUrl, UserSessionVO session) {
        try {
            apiUrlRepository.insertApiUrl(apiUrl, session);
            List<String> roles = apiUrl.getApiRoles();
            if (!ValidateUtil.isEmpty(roles)) {
                createApiRoles(apiUrl.getApiId(), roles);
            }
            return 1;
        } catch (DuplicateKeyException e) {
            throw new BusinessException("DUPLICATE_KEY_EXCEPTION", StatusCodeConstants.DUPLICATE_KEY_EXCEPTION);
        }
    }

    /**
     * 수정된 api url 리스트 정보 업데이트
     * @param apiUrls
     * @return
     */
    private int modifyApiUrls(List<ApiUrlRequestVO> apiUrls) {

        if (ValidateUtil.isEmpty(apiUrls))
            return 0;

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        int result = 0;
        for (ApiUrlRequestVO apiUrl : apiUrls) {
            result += modifyApiUrl(apiUrl, userSession);
        }
        return result;
    }

    /**
     * 수정된 api url 단건 업데이트
     * @param apiUrl
     * @param userSession
     * @return
     */
    private int modifyApiUrl(ApiUrlRequestVO apiUrl, UserSessionVO userSession) {
        modifyApiRoles(apiUrl.getApiId(), apiUrl.getApiRoles());
        return apiUrlRepository.updateApiUrl(apiUrl, userSession);
    }

    /**
     * api url 리스트 삭제
     * @param apis
     * @return
     */
    private int removeApiUrls(List<ApiUrlRequestVO> apis) {

        if (ValidateUtil.isEmpty(apis))
            return 0;

        int result = 0;
        for (ApiUrlRequestVO api : apis) {
            result += removeApiUrl(api);
        }
        return result;
    }

    /**
     * api url 단건 삭제
     * @param apiUrl
     * @return
     */
    private int removeApiUrl(ApiUrlRequestVO apiUrl) {
        String apiId = apiUrl.getApiId();
        apiUrlRepository.deleteAllApiRoles(apiId);
        return apiUrlRepository.deleteApiUrl(apiId);
    }

    /**
     * 해당 api url에 권한코드 등록
     * @param apiId
     * @param roleCodes
     * @return
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public boolean createApiRoles(String apiId, List<String> roleCodes) {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        apiUrlRepository.insertApiRoles(apiId, roleCodes, userSession);

        return true;
    }

    /**
     * 해당 api url에 대한 권한 수정
     * @param apiId
     * @param roleCodes
     * @return
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public boolean modifyApiRoles(String apiId, List<String> roleCodes) {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();

        apiUrlRepository.deleteAllApiRoles(apiId);
        apiUrlRepository.insertApiRoles(apiId, roleCodes, userSession);

        return true;
    }

    /**
     * 권한으로 해당 api url에 접근할 수 있는지 확인
     * @param apiUrl
     * @param httpMthdCd
     * @param roleCodes
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public boolean checkAccessibleApiUrlsByRoleCodes(String apiUrl, String httpMthdCd, List<String> roleCodes) {

        if (!apiUrlRepository.existApiUrl(apiUrl, httpMthdCd)) {
            return true; /* 등록되지 않은 apiUrl이라면 접근 가능으로 판단한다 */
        }
        return apiUrlRepository.checkAccessibleApiUrlsByRoleCodes(apiUrl, httpMthdCd, roleCodes);
    }

}