package com.flare.rap.file.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.model.CommonResponseVO;
import com.flare.rap.common.model.DmlResponseVO;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.file.model.FileModifyRequestVO;
import com.flare.rap.file.model.FileVO;
import com.flare.rap.file.service.FileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileUploadController {
    private final FileService fileService;

    @Operation(summary = "파일 불러오기")
    @GetMapping(value = "/v1/files", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<List<FileVO>>> findFiles(@Parameter(name = "atchFileGrId") @RequestParam @NotBlank String atchFileGrId) {
        return new ResponseEntity<>(CommonResponseVO.<List<FileVO>>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(fileService.findFiles(atchFileGrId))
                .build(), HttpStatus.OK
        );
    }

    @Operation(summary = "파일 업로드")
    @PostMapping(value = "/v1/file/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> uploadFiles(@Parameter(name = "atchFileGrId") @RequestParam @NotBlank String atchFileGrId, @Parameter(name = "files") @RequestParam @NotBlank MultipartFile[] files, @Parameter(name = "fileSortOrds") @RequestParam String fileSortOrds, @RequestParam String atchFileTpCd) {
        String[] fileSortOrdArray = null;
       if (!ValidateUtil.isEmpty(fileSortOrds)) { fileSortOrdArray = fileSortOrds.split(",");}

        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .insertedRows(fileService.createFileForUpload(atchFileGrId, files, fileSortOrdArray, atchFileTpCd))
                        .build())
                .build(), HttpStatus.OK
        );
    }

    @Operation(summary = "파일 새로운 아이디로 업로드")
    @PostMapping(value = "/v1/file/upload/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> uploadFilesWithNewGroupId(@Parameter(name = "oldAtchFileGrId") @RequestParam @NotBlank String oldAtchFileGrId, @Parameter(name = "newAtchFileGrId") @RequestParam @NotBlank String newAtchFileGrId, @Parameter(name = "files") @RequestParam @NotBlank MultipartFile[] files, @Parameter(name = "fileSortOrds") @RequestParam String fileSortOrds, @Parameter(name="atchFileTpCd") @RequestParam String atchFileTpCd) {
        String[] fileSortOrdArray = null;
        if (!ValidateUtil.isEmpty(fileSortOrds)) { fileSortOrdArray = fileSortOrds.split(",");}

        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .insertedRows(fileService.createFileWithNewFileGroupId(oldAtchFileGrId, newAtchFileGrId, files, fileSortOrdArray, atchFileTpCd))
                        .build())
                .build(), HttpStatus.OK
        );
    }

    @Operation(summary = "파일 다운로드")
    @GetMapping(value = "/v1/file/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadFile(@Parameter(name = "atchFileGrId") @RequestParam @NotBlank String atchFileGrId, @Parameter(name = "atchFileId") @RequestParam @NotBlank String atchFileId) throws UnsupportedEncodingException {
        FileVO fileVO = fileService.findFile(atchFileGrId, atchFileId);
        Resource resource = fileService.createFileForDownload(fileVO);

        return ResponseEntity.ok().headers(this.headers(URLEncoder.encode(fileVO.getAtchFileNm(),"UTF-8")))
                .contentType(MediaType
                        .parseMediaType("application/octet-stream"))
                .body(resource);
    }

    @Operation(summary = "파일 다운로드(모바일용)")
    @GetMapping(value = "/v1/file/mbdownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadFileMob(@Parameter(name = "atchFileGrId") @RequestParam @NotBlank String atchFileGrId, @Parameter(name = "atchFileId") @RequestParam @NotBlank String atchFileId) throws UnsupportedEncodingException {
        FileVO fileVO = fileService.findFile(atchFileGrId, atchFileId);
        Resource resource = fileService.createFileForDownload(fileVO);

        return ResponseEntity.ok().headers(this.headers(URLEncoder.encode(fileVO.getAtchFileNm(),"UTF-8")))
                .contentType(MediaType
                        .parseMediaType("application/octet-stream"))
                .body(resource);
    }

    @Operation(summary = "파일 비교다운로드")
    @GetMapping(value = "/v1/file/compare", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadCompareFile(@Parameter(name = "atchFileGrId") @RequestParam @NotBlank String atchFileGrId, @Parameter(name = "atchFileId") @RequestParam @NotBlank String atchFileId) throws UnsupportedEncodingException {
        FileVO fileVO = fileService.findFile(atchFileGrId, atchFileId);
        Resource resource = fileService.createFileForDownload(fileVO);

        return ResponseEntity.ok().headers(this.headers(URLEncoder.encode(fileVO.getAtchFileNm(),"UTF-8")))
                .contentType(MediaType
                        .parseMediaType("application/octet-stream"))
                .body(resource);
    }
    @Operation(summary = "파일 전체 다운로드")
    @GetMapping(value = "/v1/file/download/all", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadAllFiles(@Parameter(name = "atchFileGrId") @RequestParam @NotBlank String atchFileGrId , HttpServletResponse response) throws IOException {
        List<FileVO> fileVOs = fileService.findFiles(atchFileGrId);

        response.setHeader("Content-Disposition", "attachment; filename=\"" + "compressed.zip"+ "\";");
        response.setHeader("Content-Type", "APPLICATION_ZIP");

        fileService.responseZipFromAttachments(response.getOutputStream(), fileVOs);
    }

    @Operation(summary = "파일 정보 수정")
    @PutMapping(value = "/v1/files", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyFiles(@RequestBody List<FileVO> files) {

        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .updatedRows(fileService.modifyFiles(files))
                        .build())
                .build(), HttpStatus.OK
        );
    }
    @Operation(summary = "파일 정보 수정 후 새로운 id로 저장")
    @PutMapping(value = "/v1/files/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseVO<DmlResponseVO>> modifyFilesWithNewGroupId(@RequestBody @Valid FileModifyRequestVO request) {

        return new ResponseEntity<>(CommonResponseVO.<DmlResponseVO>builder()
                .successOrNot(CommonConstants.YES_FLAG)
                .statusCode(StatusCodeConstants.SUCCESS)
                .data(DmlResponseVO.builder()
                        .updatedRows(fileService.modifyFilesWithNewGroupId(request.getAtchFileGrId(), request.getFiles()))
                        .build())
                .build(), HttpStatus.OK
        );
    }

    private HttpHeaders headers(String name) {
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + name);
        header.add("Cache-Control",
                "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        return header;
    }

}