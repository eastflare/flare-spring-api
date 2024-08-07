package com.flare.rap.bbs.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.bbs.model.BbsConditionVO;
import com.flare.rap.bbs.model.BbsPostDetailVO;
import com.flare.rap.bbs.model.BbsPostRequestVO;
import com.flare.rap.bbs.model.BbsPostResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface BbsRepository {

    int selectBbsPostsCount(BbsConditionVO bbsCondition);

    List<BbsPostResponseVO> selectBbsPosts(@Param("bbsCondition") BbsConditionVO bbsCondition, @Param("session") UserSessionVO session);

    BbsPostDetailVO selectBbsPost(@Param("bbmNo") int bbmNo, @Param("langCd") String langCd);

    int updateBbsPostVwct(int bbmNo);

    int insertBbsPost(@Param("post") BbsPostRequestVO bbsVo, @Param("session") UserSessionVO userSessionVO);

    int updateBbsPost(@Param("post") BbsPostRequestVO bbsVo, @Param("session") UserSessionVO userSessionVO);

    int deleteBbsPost(int bbmNo, @Param("session") UserSessionVO userSessionVO);

}