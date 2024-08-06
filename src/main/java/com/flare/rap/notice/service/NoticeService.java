package com.flare.rap.notice.service;

import java.util.List;

import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.notice.model.NoticeConditionVO;
import com.flare.rap.notice.model.NoticePostDetailResponseVO;
import com.flare.rap.notice.model.NoticePostRequestVO;
import com.flare.rap.notice.model.NoticePostResponseVO;

public interface NoticeService {

    PaginationResponseVO<NoticePostResponseVO> findNotice(NoticeConditionVO noticeCondition);

    NoticePostDetailResponseVO findNoticePost(int bbmNo);

    List<NoticePostDetailResponseVO> findNoticePopupPost();

    int createNoticePost(NoticePostRequestVO noticeVO);

    int modifyNoticePost(NoticePostRequestVO noticeVO);

    int modifyDisableNoticePost(int bbmNo);

}