package com.flare.rap.file.service;

import static com.flare.rap.common.constant.StatusCodeConstants.FILE_DOWNLOAD_FAILED;
import static com.flare.rap.common.constant.StatusCodeConstants.FILE_UPLOAD_FAILED;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.flare.rap.common.exception.BusinessException;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.file.model.FileVO;
import com.flare.rap.file.repository.FileRepository;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Value("${dropzone.upload-path}")
    private String uploadPath;

    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @Override
    @Transactional(readOnly = true)
    public FileVO findFile(String atchFileGrId, String atchFileId) {
        return fileRepository.selectFile(atchFileGrId, atchFileId);
    }

    @Override
    @Transactional(readOnly = true)
public List<FileVO> findFiles(String atchFileGrId) {
        return fileRepository.selectFiles(atchFileGrId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int createFileForUpload(String atchFileGrId, MultipartFile[] files, String[] fileSortOrds, String atchFileTpCd) {
        UserSessionVO userSessionVO = SessionScopeUtil.getContextSession();
        int insertedRows = 0;
        List<FileVO> insertFiles = new ArrayList<FileVO>();
        ClassLoader classLoader = getClass().getClassLoader();
        String classpath = classLoader.getResource("").getPath();
        try {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String uuid = UUID.randomUUID().toString();
                String OriginalFileName = file.getOriginalFilename();
                String atchFileSaveNm = OriginalFileName.substring(0, OriginalFileName.lastIndexOf(".")) + "[" + uuid + "]." + OriginalFileName.substring(OriginalFileName.lastIndexOf(".") + 1);
                String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                String folderPath;
                if("default".equals(profile) || "local".equals(profile)){
                    folderPath = classpath+uploadPath + "/" + currentDate;
                }else{folderPath = uploadPath + "/" + currentDate;}

                String filePath = folderPath + "/" + atchFileSaveNm ;
                Integer sortOrd = null;
                if(fileSortOrds != null && fileSortOrds.length > i && !fileSortOrds[i].equals("")){
                    sortOrd = Integer.parseInt(fileSortOrds[i]);
                }

                File folder = new File(folderPath);
                if (!folder.exists()) folder.mkdirs();
                file.transferTo(new File(filePath));

                FileVO fileVO = FileVO.builder()
                        .atchFileId(UUID.randomUUID().toString())
                        .atchFileNm(file.getOriginalFilename())
                        .sortOrd(sortOrd)
                        .atchFileSaveLocDivsCd("ONSITE")
                        .atchFileSaveNm(atchFileSaveNm)
                        .atchFileSize((int)file.getSize())
                        .atchFileEfnmNm(OriginalFileName.substring(OriginalFileName.lastIndexOf(".") + 1))
                        .atchFileSavePathCtn(filePath)
                        .atchFileTpCd(atchFileTpCd)
                        .useYn("Y").build();

                insertFiles.add(fileVO);
            }

            Collections.sort(insertFiles);
            for(FileVO insertFile: insertFiles){
                insertedRows += fileRepository.upsertFile(atchFileGrId, insertFile, userSessionVO);
            }

        } catch (IOException e) {
            throw new BusinessException("file uplaod failed", FILE_UPLOAD_FAILED);
        }
        return insertedRows;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int createFileWithNewFileGroupId(String oldAtchFileGrId, String newAtchFileGrId, MultipartFile[] files, String[] fileSortOrds, String atchFileTpCd) {
        UserSessionVO session = SessionScopeUtil.getContextSession();
        int insertedRows = 0;
        List<FileVO> oldFileList = fileRepository.selectFiles(oldAtchFileGrId);
        for(FileVO oldFile: oldFileList){
            insertedRows += fileRepository.upsertFile(newAtchFileGrId, oldFile, session);
        }
        insertedRows += createFileForUpload(newAtchFileGrId, files, fileSortOrds, atchFileTpCd);

        return insertedRows;
    }

    @Override
    public Resource createFileForDownload(FileVO fileVO) {
        File file = new File(fileVO.getAtchFileSavePathCtn());
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = null;
        try {
            resource = new ByteArrayResource(Files.readAllBytes(path));
        } catch (IOException ie) {
            throw new BusinessException("file download failed", FILE_DOWNLOAD_FAILED);
        }
        return resource;
    }
    @Override
    public StreamingResponseBody createAllFilesForDownload(List<FileVO> fileVOs) {
        StreamingResponseBody streamingResponseBody = outputStream -> {
            try (ZipOutputStream zipOut = new ZipOutputStream(outputStream)) {
                for (FileVO file : fileVOs) {
                    byte[] fileContent = readFileContent(file.getAtchFileSavePathCtn());
                    ZipEntry zipEntry = new ZipEntry(file.getAtchFileNm());
                    zipOut.putNextEntry(zipEntry);
                    zipOut.write(fileContent);
                    zipOut.closeEntry();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        return streamingResponseBody;
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int modifyFiles(List<FileVO> files) {
        UserSessionVO session = SessionScopeUtil.getContextSession();
        return fileRepository.updateFiles(files, session);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int modifyFilesWithNewGroupId(String atchFileGrId, List<FileVO> files) {
        UserSessionVO session = SessionScopeUtil.getContextSession();

            List<FileVO> oldFileList = new ArrayList<>();
            if(files.size() > 0){
                oldFileList = fileRepository.selectFiles(files.get(0).getAtchFileGrId());
            }

            for(FileVO oldFile: oldFileList){
                fileRepository.upsertFile(atchFileGrId, oldFile, session);
            }
            for(FileVO newFile: files){
                newFile.setAtchFileGrId(atchFileGrId);
            }
            modifyFiles(files);


        return 0;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int disableAllFiles(String atchFileGrId) {
        UserSessionVO session = SessionScopeUtil.getContextSession();
        return fileRepository.disableAllFiles(atchFileGrId, session);
    }

    private byte[] readFileContent(String filename) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        byte[] fileContent = IOUtils.toByteArray(fileInputStream);
        fileInputStream.close();
        return fileContent;
    }
    public void responseZipFromAttachments(OutputStream os, List<FileVO> fileVOs) {
        try(ZipOutputStream zos = new ZipOutputStream(os)) {
            for (FileVO file : fileVOs) {
                byte[] fileContent = readFileContent(file.getAtchFileSavePathCtn());
                ZipEntry zipEntry = new ZipEntry(file.getAtchFileNm());
                zos.putNextEntry(zipEntry);
                zos.write(fileContent);
                zos.closeEntry();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}