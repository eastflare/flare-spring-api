package com.flare.rap.api.repository;

import com.flare.rap.api.model.ApiUrlConditionVO;
import com.flare.rap.api.model.ApiUrlResponseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiUrlRepository {

    List<ApiUrlResponseVO> selectApiUrls(@Param("apiUrlCondition") ApiUrlConditionVO apiUrlCondition) ;
}
