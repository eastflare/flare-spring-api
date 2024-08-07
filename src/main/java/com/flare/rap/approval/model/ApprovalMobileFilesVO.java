package com.flare.rap.approval.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ApprovalMobileFilesVO {

    @Schema(description = "첨부파일id", name="첨부파일id")
    @JacksonXmlProperty(localName = "fileID")
    @JacksonXmlCData
    private String fileID;

    @Schema(description = "첨부파일명", name="첨부파일명")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String fileName;

    @Schema(description = "파일크기", name="파일크기")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String fileSize;

    @Schema(description = "파일url", name="파일url")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String fileLinkUrl;
}