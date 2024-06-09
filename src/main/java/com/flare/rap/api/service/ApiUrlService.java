package com.flare.rap.api.service;

import com.flare.rap.api.model.ApiUrlConditionVO;
import com.flare.rap.api.model.ApiUrlResponseVO;

import java.util.List;

public interface ApiUrlService {

    List<ApiUrlResponseVO> findApiUrls(ApiUrlConditionVO apiCondition);
}
