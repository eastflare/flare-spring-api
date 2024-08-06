package com.flare.rap.api.service;

import java.util.List;

import com.flare.rap.api.model.ApiUrlConditionVO;
import com.flare.rap.api.model.ApiUrlRequestVO;
import com.flare.rap.api.model.ApiUrlResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.session.model.UserSessionVO;

public interface ApiUrlService {

    //Management
    List<ApiUrlResponseVO> findApiUrls(ApiUrlConditionVO apiCondition);

    DmlResponseVO saveApiUrls(List<ApiUrlRequestVO> apis);

    // TODO: 주석 제거 필요
//    int createApiUrls(List<ApiUrlRequestVO> apis);
//
//    int createApiUrl(ApiUrlRequestVO api, UserSessionVO userSession);
//
//    int modifyApiUrls(List<ApiUrlRequestVO> apis);
//
//    int modifyApiUrl(ApiUrlRequestVO api, UserSessionVO userSession);
//
//    int removeApiUrls(List<ApiUrlRequestVO> apis);
//
//    int removeApiUrl(ApiUrlRequestVO api);

    boolean createApiRoles(String apiId, List<String> roleCodes);

    boolean modifyApiRoles(String apiId, List<String> roleCodes);

    //Service
    boolean checkAccessibleApiUrlsByRoleCodes(String apiUrl, String httpMthdCd, List<String> roleCodes);

}