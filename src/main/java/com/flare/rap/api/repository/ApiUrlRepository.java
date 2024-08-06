package com.flare.rap.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.api.model.ApiUrlConditionVO;
import com.flare.rap.api.model.ApiUrlRequestVO;
import com.flare.rap.api.model.ApiUrlResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface ApiUrlRepository {

    //Management
    List<ApiUrlResponseVO> selectApiUrls(@Param("apiUrlCondition") ApiUrlConditionVO apiUrlCondition, @Param("session")UserSessionVO userSession);

    int insertApiUrl(@Param("apiUrl") ApiUrlRequestVO apiUrl, @Param("session")UserSessionVO userSession);

    int updateApiUrl(@Param("apiUrl")ApiUrlRequestVO apiUrl, @Param("session")UserSessionVO userSession);

    int deleteApiUrl(String apiId);

    List<String> selectApiRoleCodes(String apiId);

    int deleteAllApiRoles(String apiId);

    int insertApiRoles(@Param("apiId")String apiId, @Param("roleCodes")List<String> roleCodes, @Param("session")UserSessionVO userSession);

    //Service
    boolean existApiUrl(@Param("apiUrl")String apiUrl, @Param("httpMthdCd")String httpMthdCd);

    boolean checkAccessibleApiUrlsByRoleCodes(@Param("apiUrl")String apiUrl, @Param("httpMthdCd")String httpMthdCd, @Param("roleCodes") List<String> roleCodes);

}