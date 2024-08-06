package com.flare.rap.code.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.code.model.*;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface CommonCodeRepository {

    List<CommonCodeGroupResponseVO> selectCommonCodeGroups(
                @Param("searchGroupCode") String searchGroupCode,
                @Param("useYn") String useYn,
                @Param("searchCode") String searchCode,
                @Param("langCd") String langCd);

    int upsertCommonCodeGroups(@Param("codeGroups") List<CommonCodeGroupRequestVO> codeGroups, @Param("session") UserSessionVO userSession);

    int deleteCommonCodeGroups(@Param("codeGroups") List<CommonCodeGroupRequestVO> codeGroups);

    int deleteCommonCodesByCodeGroup(@Param("codeGroups") List<CommonCodeGroupRequestVO> codeGroups);

    List<CommonCodeResponseVO> selectCommonCodes(@Param("cmnGrCd")String cmnGrCd, @Param("langCd")String langCd);

    List<CommonCodeResponseVO> selectCommonCodesNoLangCd(@Param("cmnGrCd")String cmnGrCd);

    int upsertCommonCodes(@Param("codes")List<CommonCodeRequestVO> codes, @Param("session")UserSessionVO userSession);

    int deleteCommonCodes(@Param("codes") List<CommonCodeRequestVO> codes);

    CommonCodeHeaderResponseVO selectCommonCodeHeader(String cmnGrCd);

    List<CommonCodeNameResponseVO> selectCommonCodeNames(@Param("cmnGrCd")String cmnGrCd, @Param("langCd")String langCd);

    List<CommonCodeNameResponseVO> selectCommonCodeNamesWithCode(@Param("cmnGrCd")String cmnGrCd, @Param("langCd")String langCd);

    List<CommonCodeNameResponseVO> selectCommonCodeNamesCondition(@Param("condition")CommonCodeConditionVO condition, @Param("langCd")String langCd);

    CommonCodeResponseVO selectCommonCode(@Param("cmnGrCd")String cmnGrCd, @Param("cmnCd")String cmnCd, @Param("langCd")String langCd);

}