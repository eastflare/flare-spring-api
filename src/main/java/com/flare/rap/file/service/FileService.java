package com.flare.rap.file.service;

import java.io.OutputStream;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.flare.rap.file.model.FileVO;

public interface FileService {

    FileVO findFile(String atchFileGrId, String atchFileId);

    List<FileVO> findFiles(String atchFileGrId);

    int createFileForUpload(String atchFileGrId, MultipartFile[] files, String[] fileSortOrds, String atchFileTpCd);

    int createFileWithNewFileGroupId(String oldAtchFileGrId, String newAtchFileGrId, MultipartFile[] files, String[] fileSortOrds, String atchFileTpCd);

    Resource createFileForDownload(FileVO fileVO);

    StreamingResponseBody createAllFilesForDownload(List<FileVO> fileVOs);

    int modifyFiles(List<FileVO> files);

    int modifyFilesWithNewGroupId(String atchFileGrId, List<FileVO> files);

    int disableAllFiles(String atchFileGrId);

    void responseZipFromAttachments(OutputStream os, List<FileVO> fileVOs);
}