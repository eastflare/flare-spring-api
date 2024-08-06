package com.flare.rap.file.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flare.rap.file.model.FileVO;
import com.flare.rap.session.model.UserSessionVO;

@Mapper
public interface FileRepository {

    FileVO selectFile(@Param("atchFileGrId") String atchFileGrId, @Param("atchFileId") String atchFileId);

    List<FileVO> selectFiles(String atchFileGrId);

    int upsertFile(@Param("atchFileGrId") String atchFileGrId, @Param("fileUpload")FileVO fileUpload, @Param("session") UserSessionVO userSessionVO);

    int disableAllFiles(@Param("atchFileGrId") String atchFileGrId, @Param("session") UserSessionVO userSessionVO);

    int updateFiles(@Param("files") List<FileVO> files, @Param("session") UserSessionVO userSessionVO);

    int deleteFiles(@Param("atchFileGrId") String atchFileGrId, @Param("atchFileIdList") List<String> atchFileIdList);

    int deleteFileGroup(@Param("atchFileGrId") String atchFileGrId);
}