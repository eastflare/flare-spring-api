package com.flare.rap.api.service;

import com.flare.rap.api.model.ApiUrlConditionVO;
import com.flare.rap.api.model.ApiUrlResponseVO;
import com.flare.rap.api.repository.ApiUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiUrlServiceImpl implements ApiUrlService{

    private final ApiUrlRepository apiUrlRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ApiUrlResponseVO> findApiUrls(ApiUrlConditionVO apiUrlCondition) {
        List<ApiUrlResponseVO> apiUrls = apiUrlRepository.selectApiUrls(apiUrlCondition);

        return apiUrls;
    }
}
