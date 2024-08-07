package com.flare.rap.approval.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flare.rap.approval.model.ApprovalMobileApproversVO;
import com.flare.rap.approval.model.ApprovalMobileFilesVO;
import com.flare.rap.common.util.ValidateUtil;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Data
@XmlRootElement
@JacksonXmlRootElement(localName = "apprItem")
public class ApprovalMobileApprovalDetailVO {
    @Schema(description = "성공/실패 설명", name="성공/실패 설명")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String returnDesc;

    @Schema(description = "성공/실패 코드", name="성공/실패 코드")
    @JacksonXmlProperty
    @JacksonXmlCData
    private int returnCode;

    @Schema(description = "결재재시스템ID", name="결재재시스템ID")
    @JacksonXmlProperty(localName = "apprSystemID")
    @JacksonXmlCData
    private String apprSystemID;

    @Schema(description = "결재문서ID", name="결재문서ID")
    @JacksonXmlProperty(localName = "apprDocID")
    @JacksonXmlCData
    private String apprDocID;

    @Schema(description = "결재요약정보", name="결재요약정보")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprSummary;

    @Schema(description = "결재자차수정보", name="결재자차수정보")
    @JacksonXmlProperty
    @JacksonXmlCData
    private int apprIndex;

    @Schema(description = "원문보기url", name="원문보기url")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprLinkDocUrl;

    @Schema(description = "결재요청자아이디", name="결재요청자아이디")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprRequestEmpNo;

    @Schema(description = "결재요청자이름", name="결재요청자이름")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprRequestEmpName;

    @Schema(description = "결재요청자부서", name="결재요청자부서")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprRequestEmpDept;

    @Schema(description = "결재요청자직위", name="결재요청자직위")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprRequestEmpTitle;

    @Schema(description = "결재요청자이메일", name="결재요청자이메일")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprRequestEmpEmail;

    @Schema(description = "결재요청사무실전화", name="결재요청자사무실전화")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprRequestEmpOffice;

    @Schema(description = "결재요청자시간", name="결재요청자시간")
    @JacksonXmlProperty
    @JacksonXmlCData
    private String apprRequestDate;

    @Schema(description = "결재자정보", name="결재자정보")
    @JacksonXmlProperty(localName = "approver")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List< ApprovalMobileApproversVO> approver;

    @Schema(description = "파일정보", name="파일정보")
    @JacksonXmlProperty(localName = "file")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List< ApprovalMobileFilesVO> file;


    public static ApprovalMobileApprovalDetailVO ofEmpty(String aprReqId, String systemId){
        return ApprovalMobileApprovalDetailVO.builder()
                .returnDesc("There are no approval information you want to approve.")
                .returnCode(-1)
                .apprSystemID(systemId)
                .apprDocID(aprReqId)
                .build();
    }

    public static ApprovalMobileApprovalDetailVO ofSuccess(ApprovalRequestMasterResponseVO approvalRequestMaster,
                                                           ApprovalMobileRequestVO approvalMobileRequest,
                                                           List< ApprovalMobileApproversVO> approvers,
                                                           List< ApprovalMobileFilesVO> atchFiles,
                                                           int aprLnSeq, String apprSummary, String systemId){
        return ApprovalMobileApprovalDetailVO.builder()
                .returnDesc("Success")
                .returnCode(0)
                .apprSystemID(systemId)
                .apprDocID(approvalRequestMaster.getAprReqId())
                .apprSummary(apprSummary)
                .apprIndex(aprLnSeq)
                .apprLinkDocUrl(approvalRequestMaster.getAprWaitScrnUrl() + "&appint_url=dummy&userID=" +
                        approvalMobileRequest.getUserID() + "&mbLanguage=" + approvalMobileRequest.getMbLanguage())
                .apprRequestEmpNo(approvalRequestMaster.getAprReqUserId())
                .apprRequestEmpName(approvalRequestMaster.getAprReqUserNm())
                .apprRequestEmpDept(approvalRequestMaster.getAprReqUserDeptNm())
                .apprRequestEmpTitle(approvalRequestMaster.getAprReqUserJikwiNm())
                .apprRequestEmpEmail(approvalRequestMaster.getAprReqUserEmail())
                .apprRequestEmpOffice("")
                .apprRequestDate(approvalRequestMaster.getAprReqDtmMobile())
                .approver(approvers)
                .file(atchFiles)
                .build();
    }
}