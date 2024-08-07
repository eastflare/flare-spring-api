package com.flare.rap.bbs.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.bbs.model.BbsReplyRequestVO;
import com.flare.rap.bbs.model.BbsReplyResponseVO;
import com.flare.rap.bbs.model.BbsReplyVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface BbsReplyRepository {

    List<BbsReplyResponseVO> selectBbsReplies(@Param("bbmNo") int bbmNo, @Param("langCd") String langCd);

    BbsReplyVO selectBbsReply(@Param("bbmNo") String bbmNo, @Param("bbmReNo") String bbmReNo);

    int insertBbsReply(@Param("bbsReply") BbsReplyRequestVO bbsReply, @Param("session") UserSessionVO userSession);

    int deleteBbsReply(@Param("bbmNo") String bbmNo, @Param("bbmReNo") String bbmReNo);

    int updateBbsReply(@Param("bbsReply") BbsReplyRequestVO bbsReply, @Param("session") UserSessionVO userSessionVO);

}