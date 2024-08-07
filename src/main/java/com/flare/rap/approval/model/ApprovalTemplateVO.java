package com.flare.rap.approval.model;

import jakarta.persistence.Lob;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalTemplateVO {

    @NotBlank
    @Schema(description = "양식ID", example ="SEC-FORM-1234")
    private String aprTplId;

    @Schema(description = "양식유형코드(Type2, Type3)", example ="TYPE3")
    private String intgAprTpCd;

    @Schema(description = "양식명", example = "TempName")
    private String aprTplNm;

    @Schema(description = "정렬번호", example = "999")
    private int sortOrd;

    @Schema(description = "양식설명", example = "temp description")
    private String aprTplDesc;

    @Schema(description = "사용여부", example = "Y")
    private String useYn;

    @Schema(description = "프로세스설명", example = "prs description")
    private String prsDesc;

    @Schema(description = "동의서사용여부", example = "Y")
    private String wcstUseYn;

    @Schema(description = "동의서설명", example = """
            <html xml:lang="ko" lang="ko">
            <head>
            <title>동의서 제목</title>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <style type="text/css"> body{font-family :Malgun Gothic; color : #000000; font-size : 10pt;  margin : 0 0 0 3px;} p,li{line-height:1.2; margin-top:0; margin-bottom:0;}
            </style>
            </head>
            <body>
            <p>동의서 내용...</p>
            <p>동의서 내용...</p>
            </body>
            </html>""")
    @Lob
    private String wcstDesc;

    @Schema(description = "통보처사용여부", example = "Y")
    private String notfUseYn;

    @Schema(description = "통보처ID", example = "ntdkTempId")
    private int ntdkId;

    @Schema(description = "담당자사용여부", example = "Y")
    private String mgrUseYn;

}