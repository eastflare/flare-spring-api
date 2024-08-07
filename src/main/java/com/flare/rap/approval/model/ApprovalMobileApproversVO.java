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
public class ApprovalMobileApproversVO {

    @Schema(description = "결재자아이디", name="결재자아이디")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveEmpNo;

    @Schema(description = "결재자이름", name="결재자이름")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveEmpName;

    @Schema(description = "결재자부서", name="결재자부서")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveEmpDept;

    @Schema(description = "결재자직위", name="결재자직위")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveEmpTitle;

    @Schema(description = "결재자이메일", name="결재자이메일")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveEmpEmail;

    @Schema(description = "결재자전번호", name="결재자전번호")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveEmpOffice;

    @Schema(description = "결재자회사한글명", name="결재자회사한글명")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveCompanyKorName;

    @Schema(description = "결재완료시각", name="결재완료시각")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveDate;

    @Schema(description = "결재승인종류", name="결재승인종류")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprApproveType;

    @Schema(description = "결처리구분", name="결처리구분")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprType;

    @Schema(description = "결재처리의견", name="결재처리의견")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprComment;

    @Schema(description = "현재결재자지여부", name="현재결재자지여부")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprCurFlag;
}