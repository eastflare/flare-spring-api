package com.flare.rap.notice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.model.PaginationResponseVO;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.StringUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.employee.model.BbsEmployeeResponseVO;
import com.flare.rap.employee.service.EmployeeService;
import com.flare.rap.file.model.FileVO;
import com.flare.rap.file.service.FileService;
import com.flare.rap.notice.model.NoticeConditionVO;
import com.flare.rap.notice.model.NoticePostDetailResponseVO;
import com.flare.rap.notice.model.NoticePostDetailVO;
import com.flare.rap.notice.model.NoticePostRequestVO;
import com.flare.rap.notice.model.NoticePostResponseVO;
import com.flare.rap.notice.repository.NoticeRepository;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository noticeRepository;
    private final EmployeeService employeeService;
    private final FileService fileService;

    @Override
    @Transactional(readOnly = true)
    public PaginationResponseVO<NoticePostResponseVO> findNotice(NoticeConditionVO noticeCondition) {
        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        List<NoticePostResponseVO> noticeList = noticeRepository.selectNoticePosts(noticeCondition, userSession.getLangCd());
        for(NoticePostResponseVO notice: noticeList) {
            String firstImgTag = null;
            Pattern pattern = Pattern.compile("(&lt;img.*&gt;)");
            Matcher matcher = pattern.matcher(notice.getBbmCtn());
            if (matcher.find()) {
                firstImgTag = matcher.group();
            }
            String bbmCtn = StringUtil.removeHtmlTagsForBbs(notice.getBbmCtn()).replaceAll("&nbsp;", "").replaceAll("&amp;nbsp;", "");
            String whiteSpaceRemoved = StringEscapeUtils.unescapeHtml4(bbmCtn).replaceAll("\\s", "");
            notice.setSmryCtn(whiteSpaceRemoved);
            notice.setFirstImgTag(firstImgTag);
        }
        PaginationResponseVO<NoticePostResponseVO> noticePaginationList = new PaginationResponseVO<>(noticeList);
        noticePaginationList.setTotalCount(noticeRepository.selectNoticePostsCount(noticeCondition));

        return noticePaginationList;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public NoticePostDetailResponseVO findNoticePost(int bbmNo) {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        NoticePostDetailVO notice = Optional.ofNullable(noticeRepository.selectNoticePost(bbmNo, userSession.getLangCd()))
                .orElseThrow(() -> new BusinessException("The post doesn't exist", StatusCodeConstants.NOT_EXIST_EXCEPTION));

        BbsEmployeeResponseVO insertUser = employeeService.findBbsEmployeeByUserId(notice.getDataInsUserId(), userSession.getLangCd());
        BbsEmployeeResponseVO updateUser = employeeService.findBbsEmployeeByUserId(notice.getDataUpdUserId(), userSession.getLangCd());

        List<FileVO> atchFiles = fileService.findFiles(notice.getAtchFileGrId());

        noticeRepository.updateNoticePostVwct(bbmNo);

        notice.setBbmCtn(ValidateUtil.charUnescape(notice.getBbmCtn()));

        return new NoticePostDetailResponseVO(notice, insertUser, updateUser, atchFiles);
    }

    @Override
    @Transactional(readOnly = true)
    public  List<NoticePostDetailResponseVO> findNoticePopupPost() {

        List<NoticePostDetailResponseVO> noticePopupResponseList = new ArrayList<>();
        List<NoticePostDetailVO> noticePopupList = noticeRepository.selectNoticePopupPost();

        for (NoticePostDetailVO noticePost : noticePopupList) {
            noticePost.setBbmCtn(ValidateUtil.charUnescape(noticePost.getBbmCtn()));
            noticePopupResponseList.add(new NoticePostDetailResponseVO(noticePost, null, null, null));
        }
        return noticePopupResponseList;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int createNoticePost(NoticePostRequestVO noticeVO) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        return noticeRepository.insertNoticePost(noticeVO, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int modifyNoticePost(NoticePostRequestVO noticeVO) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();

        NoticePostDetailVO postDetail = noticeRepository.selectNoticePost(Integer.parseInt(noticeVO.getBbmNo()), userSessionVO.getLangCd());
        if(postDetail == null) {
            throw new BusinessException("The post doesn't exist", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }
        if(!postDetail.getDataInsUserId().equals(userSessionVO.getUserId())){
            throw new BusinessException("User does not have permission to update", StatusCodeConstants.NOT_AUTHORIZED_EXCEPTION);
        }

        return noticeRepository.updateNoticePost(noticeVO, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int modifyDisableNoticePost(int bbmNo) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        NoticePostDetailVO postDetail = noticeRepository.selectNoticePost(bbmNo, userSessionVO.getLangCd());
        if(postDetail == null) {
            throw new BusinessException("The post doesn't exist", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }
        if(postDetail.getDataInsUserId() == null || !postDetail.getDataInsUserId().equals(userSessionVO.getUserId())){
            throw new BusinessException("User does not have permission to delete", StatusCodeConstants.NOT_AUTHORIZED_EXCEPTION);
        }
        return noticeRepository.updateDisableNoticePost(bbmNo, userSessionVO);
    }

}