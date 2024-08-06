package com.flare.rap.code.service;

import java.util.List;

import com.flare.rap.code.model.CommonCodeConditionVO;
import com.flare.rap.code.model.CommonCodeGroupRequestVO;
import com.flare.rap.code.model.CommonCodeGroupResponseVO;
import com.flare.rap.code.model.CommonCodeHeaderResponseVO;
import com.flare.rap.code.model.CommonCodeNameResponseVO;
import com.flare.rap.code.model.CommonCodeRequestVO;
import com.flare.rap.code.model.CommonCodeResponseVO;
import com.flare.rap.common.model.DmlResponseVO;

public interface CommonCodeService {

    List<CommonCodeGroupResponseVO> findCommonCodeGroups(
            String searchGroupCode,
            String useYn,
            String searchCode);

    DmlResponseVO saveCommonCodeGroups(List<CommonCodeGroupRequestVO> codeGroups);

    List<CommonCodeResponseVO> findCommonCodes(String cmnGrCd);

    DmlResponseVO saveCommonCodes(List<CommonCodeRequestVO> codes);

    CommonCodeHeaderResponseVO findCommonCodeHeader(String cmnGrCd);

    List<CommonCodeNameResponseVO> findCommonCodeNames(String cmnGrCd);

    List<CommonCodeNameResponseVO> findCommonCodeNamesWithCode(String cmnGrCd);

    List<CommonCodeNameResponseVO> findCommonCodeNamesCondition(CommonCodeConditionVO condition);

}