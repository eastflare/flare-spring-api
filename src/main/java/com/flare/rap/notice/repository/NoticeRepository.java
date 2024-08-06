package com.flare.rap.notice.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.notice.model.NoticeConditionVO;
import com.flare.rap.notice.model.NoticePostDetailVO;
import com.flare.rap.notice.model.NoticePostRequestVO;
import com.flare.rap.notice.model.NoticePostResponseVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface NoticeRepository {


    int selectNoticePostsCount(NoticeConditionVO noticeCondition);

    List<NoticePostResponseVO> selectNoticePosts(@Param("noticeCondition") NoticeConditionVO noticeCondition, @Param("langCd") String langCd);

    NoticePostDetailVO selectNoticePost(@Param("bbmNo") int bbmNo, @Param("langCd") String langCd);

    List<NoticePostDetailVO> selectNoticePopupPost();

    int updateNoticePostVwct(int bbmNo);

    int insertNoticePost(@Param("post") NoticePostRequestVO noticeVo, @Param("session") UserSessionVO userSessionVO);

    int updateNoticePost(@Param("post") NoticePostRequestVO noticeVo, @Param("session") UserSessionVO userSessionVO);

    int updateDisableNoticePost(@Param("bbmNo") int bbmNo, @Param("session") UserSessionVO userSessionVO);
}