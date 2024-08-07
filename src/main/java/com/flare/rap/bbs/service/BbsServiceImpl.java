package com.flare.rap.bbs.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.bbs.model.BbsConditionVO;
import com.flare.rap.bbs.model.BbsPostDetailResponseVO;
import com.flare.rap.bbs.model.BbsPostDetailVO;
import com.flare.rap.bbs.model.BbsPostRequestVO;
import com.flare.rap.bbs.model.BbsPostResponseVO;
import com.flare.rap.bbs.model.BbsReplyResponseVO;
import com.flare.rap.bbs.repository.BbsReplyRepository;
import com.flare.rap.bbs.repository.BbsRepository;
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
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BbsServiceImpl implements BbsService {

    private final BbsRepository bbsRepository;
    private final EmployeeService employeeService;
    private final BbsReplyRepository replyRepository;
    private final FileService fileService;

    @Override
    @Transactional(readOnly = true)
    public PaginationResponseVO<BbsPostResponseVO> findBbs(BbsConditionVO bbsCondition) {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        List<BbsPostResponseVO> bbsList = bbsRepository.selectBbsPosts(bbsCondition, userSession);
        for (BbsPostResponseVO item : bbsList) {
            String firstImgTag = null;
            Pattern pattern = Pattern.compile("(&lt;img.*&gt;)");
            Matcher matcher = pattern.matcher(item.getBbmCtn());
            if (matcher.find()) {
                firstImgTag = matcher.group();
            }
            String htmlRemovedContent = StringUtil.removeHtmlTagsForBbs(item.getBbmCtn()).replaceAll("&nbsp;", "").replaceAll("&amp;nbsp;", "");
            String whiteSpaceRemoved = StringEscapeUtils.unescapeHtml4(htmlRemovedContent).replaceAll("\\s", "");
            item.setSmryCtn(whiteSpaceRemoved);
            item.setFirstImgTag(firstImgTag);
        }
        PaginationResponseVO<BbsPostResponseVO> bbsPaginationList = new PaginationResponseVO<>(bbsList);
        bbsPaginationList.setTotalCount(bbsRepository.selectBbsPostsCount(bbsCondition));

        return bbsPaginationList;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public BbsPostDetailResponseVO findBbsPost(int bbmNo) {

        UserSessionVO userSession = SessionScopeUtil.getContextSession();
        BbsPostDetailVO bbs = Optional.ofNullable(bbsRepository.selectBbsPost(bbmNo, userSession.getLangCd()))
              .orElseThrow(() -> new BusinessException("The post doesn't exist", StatusCodeConstants.NOT_EXIST_EXCEPTION));

        // 에디터 입력 내용에 대한 XSS unescape
        bbs.setBbmCtn(ValidateUtil.charUnescape(bbs.getBbmCtn()));

        BbsEmployeeResponseVO insertUser = employeeService.findBbsEmployeeByUserId(bbs.getDataInsUserId(), userSession.getLangCd());
        BbsEmployeeResponseVO updateUser = employeeService.findBbsEmployeeByUserId(bbs.getDataUpdUserId(), userSession.getLangCd());

        List<BbsReplyResponseVO> replies = replyRepository.selectBbsReplies(bbmNo, userSession.getLangCd());
        List<FileVO> atchFiles = fileService.findFiles(bbs.getAtchFileGrId());

        bbsRepository.updateBbsPostVwct(bbmNo);

        return new BbsPostDetailResponseVO(bbs, insertUser, updateUser, atchFiles, replies);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int createBbsPost(BbsPostRequestVO bbsVo) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        return bbsRepository.insertBbsPost(bbsVo, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int modifyBbsPost(BbsPostRequestVO bbsVo) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();

        BbsPostDetailVO postDetail = bbsRepository.selectBbsPost(Integer.parseInt(bbsVo.getBbmNo()), userSessionVO.getLangCd());
        if(postDetail == null) {
            throw new BusinessException("The post doesn't exist", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }
        if(!postDetail.getDataInsUserId().equals(userSessionVO.getUserId())){
            throw new BusinessException("User does not have permission to update", StatusCodeConstants.NOT_AUTHORIZED_EXCEPTION);
        }

        return bbsRepository.updateBbsPost(bbsVo, userSessionVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int removeBbsPost(int bbmNo) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        BbsPostDetailVO postDetail = bbsRepository.selectBbsPost(bbmNo, userSessionVO.getLangCd());
        if(postDetail == null) {
            throw new BusinessException("The post doesn't exist", StatusCodeConstants.NOT_EXIST_EXCEPTION);
        }
        if(!postDetail.getDataInsUserId().equals(userSessionVO.getUserId())){
            throw new BusinessException("User does not have permission to delete", StatusCodeConstants.NOT_AUTHORIZED_EXCEPTION);
        }
        return bbsRepository.deleteBbsPost(bbmNo, userSessionVO);
    }

}