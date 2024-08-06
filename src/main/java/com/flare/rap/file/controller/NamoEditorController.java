package com.flare.rap.file.controller;

import static com.flare.rap.common.util.ValidateUtil.isEmpty;

import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flare.rap.common.constant.StatusCodeConstants;
import com.flare.rap.common.exception.BusinessException;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NamoEditorController {

    @Value("${namo.upload-path}")
    private String uploadPath;

    @Value("${namo.backend-url}")
    private String backendUrl;

    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @PostMapping(value = "/v1/namoFileUpload", produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadFile(@RequestParam("imageFile") MultipartFile file,
                              @RequestParam(value="imageKind", required = false) String imageKind,
                              @RequestParam(value="fileKind", required = false) String fileKind,
                              @RequestParam("editorFrame") String editorFrame
                             )
    {
        ClassLoader classLoader = getClass().getClassLoader();
        String classpath = classLoader.getResource("").getPath();
        if(!file.isEmpty()){
            try{
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssSSS"));
                String saveFileName = (file.getOriginalFilename() != null) ? addTimestampSuffix(file.getOriginalFilename(), timestamp) : "NoFileName";
                String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                String folderPath;
                if("default".equals(profile) || "local".equals(profile)){
                    folderPath = classpath+uploadPath + "/" + currentDate;
                }else{folderPath = uploadPath + "/" + currentDate;}
                String filePath = folderPath + "/" + saveFileName;
                if(filePath.contains("../") || filePath.contains("/..") || filePath.contains("/../")){
                    throw new BusinessException("UnAuthorized Path", StatusCodeConstants.FAIL);
                }

                File folder = new File(folderPath);
                if(!folder.exists()) folder.mkdirs();

                file.transferTo(new File(filePath));

                String imageAlign = "backgroundimage".equals(imageKind) ? "repeat" : "baseline";
                String imgKind = isEmpty(imageKind) ? fileKind : imageKind;
                String resultPath = backendUrl + "/api/v1/file/download/"+ currentDate + timestamp + "/" + file.getOriginalFilename();

                String result = "";

                if("file".equals(imgKind)){
                    result = "{\n" +
                            "  "result": "success",\n" +
                            "  "addmsg": [\n" +
                            "    {\n" +
                            "      "fileURL": "" + resultPath +"",\n" +
                            "      "fileTitle": "",\n" +
                            "      "fileId": "",\n" +
                            "      "fileClass": "",\n" +
                            "      "fileKind": "" + imgKind + "",\n" +
                            "      "fileType": "" + file.getContentType() + "",\n" +
                            "      "fileSize": ""+ file.getSize() +"",\n" +
                            "      "editorFrame": ""+ editorFrame +""\n" +
                            "    }\n" +
                            "  ]\n" +
                            "}";
                } else{
                    result = "{\n" +
                            "  "result": "success",\n" +
                            "  "addmsg": [\n" +
                            "    {\n" +
                            "      "imageURL": "" + resultPath + "",\n" +
                            "      "imageTitle": "",\n" +
                            "      "imageAlt": "",\n" +
                            "      "imageWidth": "",\n" +
                            "      "imageWidthUnit": "px",\n" +
                            "      "imageHeight": "",\n" +
                            "      "imageHeightUnit": "px",\n" +
                            "      "imageSize": ""+ file.getSize() +"",\n" +
                            "      "imageMarginLeft": "",\n" +
                            "      "imageMarginLeftUnit": "px",\n" +
                            "      "imageMarginRight": "",\n" +
                            "      "imageMarginRightUnit": "px",\n" +
                            "      "imageMarginTop": "",\n" +
                            "      "imageMarginTopUnit": "px",\n" +
                            "      "imageMarginBottom": "",\n" +
                            "      "imageMarginBottomUnit": "px",\n" +
                            "      "imageAlign": ""+ imageAlign +"",\n" +
                            "      "imageId": "",\n" +
                            "      "imageClass": "",\n" +
                            "      "imageBorder": "0",\n" +
                            "      "imageKind": ""+ imgKind +"",\n" +
                            "      "imageOrgPath": ""+file.getOriginalFilename() + "|" + resultPath +"",\n" +
                            "      "imageOrgWidth": "960",\n" +
                            "      "imageOrgHeight": "540",\n" +
                            "      "editorFrame": "" + editorFrame + ""\n" +
                            "    }\n" +
                            "  ]\n" +
                            "}";
                }
                return result;
            } catch(Exception e){

                throw new BusinessException("Download File Failed.", StatusCodeConstants.FAIL, e);
            }
        }
        return "redirect:/error";
    }

    @GetMapping(value = "/v1/file/download/{currentDate}/{fileName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void downloadFile(@PathVariable String fileName, @PathVariable String currentDate, HttpServletResponse response) throws IOException {
        if(fileName.contains("../") || fileName.contains("/..") || fileName.contains("/../")){
            throw new BusinessException("UnAuthorized Path", StatusCodeConstants.FAIL);
        };
        String timestamp = currentDate.substring(8);
        String newFileName = URLEncoder.encode(removeTimestampSuffix(fileName), "UTF-8");

        ClassLoader classLoader = getClass().getClassLoader();
        String classpath = classLoader.getResource("").getPath();

        String filePath;
        if("default".equals(profile) || "local".equals(profile)){
            filePath = classpath+uploadPath;
        }else{filePath = uploadPath;}

        File file = new File(filePath + "/" + currentDate.substring(0, 8) + "/" + addTimestampSuffix(fileName, timestamp));

        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream out = response.getOutputStream()
        ) {
            response.addHeader("Content-Disposition", "attachment;filename="" + newFileName + """);
            response.setContentLength((int) file.length());

            int read = 0;

            while ((read = bis.read()) != -1) {
                out.write(read);
            }
        } catch (IOException e) {
            throw new BusinessException("Download File Failed.", StatusCodeConstants.FAIL);
        }
    }
    @GetMapping(value = "/v1/file/compare/{currentDate}/{fileName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void downloadCompareFile(@PathVariable String fileName, @PathVariable String currentDate, HttpServletResponse response) throws IOException {
        if(fileName.contains("../") || fileName.contains("/..") || fileName.contains("/../")){
            throw new BusinessException("UnAuthorized Path", StatusCodeConstants.FAIL);
        };
        String timestamp = currentDate.substring(8);
        String newFileName = URLEncoder.encode(removeTimestampSuffix(fileName), "UTF-8");

        ClassLoader classLoader = getClass().getClassLoader();
        String classpath = classLoader.getResource("").getPath();

        String filePath;
        if("default".equals(profile) || "local".equals(profile)){
            filePath = classpath+uploadPath;
        }else{filePath = uploadPath;}
        File file = new File(filePath + "/" + currentDate.substring(0, 8) + "/" + addTimestampSuffix(fileName, timestamp));

        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream out = response.getOutputStream()
        ) {
            response.addHeader("Content-Disposition", "attachment;filename="" + newFileName + """);
            response.setContentLength((int) file.length());

            int read = 0;

            while ((read = bis.read()) != -1) {
                out.write(read);
            }
        } catch (IOException e) {
            throw new BusinessException("Download File Failed.", StatusCodeConstants.FAIL);
        }
    }
    private static String addTimestampSuffix(String fileName, String timestamp){
        int dotIndex = fileName.lastIndexOf(".");

        if(dotIndex != -1){
            String extension = fileName.substring(dotIndex);
            String nameWithOutExtension = fileName.substring(0,dotIndex);
            return nameWithOutExtension + "_" + timestamp + extension;
        } else{
            return fileName + "_" + timestamp;
        }
    }

    private static String removeTimestampSuffix(String fileName){
        int underscoreIndex = fileName.lastIndexOf("_");

        if(underscoreIndex != -1){
            return fileName.substring(0, underscoreIndex) + fileName.substring(fileName.lastIndexOf("."));
        }else{
            return fileName;
        }
    }
}