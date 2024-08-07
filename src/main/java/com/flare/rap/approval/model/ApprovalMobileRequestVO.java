package com.flare.rap.approval.model;

import com.flare.rap.common.util.EncryptUtil;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class ApprovalMobileRequestVO {

    @Schema(description = "결재문서Id", name="결재문서Id")
    private String aprReqId;

    @Schema(description = "결재문서ID-승인부결할때 사용", name="결재문서Id")
    private String docId;

    @Schema(description = "결재차수", name="결재차수")
    private int apprIndex;

    @Schema(description = "01 : 승인 / 04 : 반려", name="01 : 승인 / 04 : 반려")
    private String apprType;

    @Schema(description = "결재의견", name="결재의견")
    private String apprComment;

    @Schema(description = "요청 ID - 결재 문서를 조회/승인하고자 하는 사용자 ID, AES128 암호화 권장(key값 따로 문의)", name="요청 ID")
    private String userID;

    @Schema(description = "사용자 확인 코드 - 8012를 떼고 ID와 비교하여 유효성 검증을 위해 쓰인다. AES128 암호화 권장(key값 따로 문의)", name="사용자 확인 코드")
    private String mbCode;

    @Schema(description = "요청자 사번 - 결재 처리에 사번 정보가 꼭 필요할 경우만 보낸다. AES128 암호화 권장(key값 따로 문의) ", name="요청자 사번")
    private String empNo;

    @Schema(description = "언어정보-KR, EN, 다국어 처리가 필요할 경우 쓴다(기본값으로 KR을 권장)", name="언어정보")
    private String mbLanguage;


    public static ApprovalMobileRequestVO decrypt(ApprovalMobileRequestVO approvalMobileRequest, String key){
        ApprovalMobileRequestVO approvalMobileRequestDec = new ApprovalMobileRequestVO();
        approvalMobileRequestDec.setEmpNo(EncryptUtil.decryptText(approvalMobileRequest.getEmpNo(), key));
        approvalMobileRequestDec.setUserID(EncryptUtil.decryptText(approvalMobileRequest.getUserID(), key));
        approvalMobileRequestDec.setMbLanguage(approvalMobileRequest.getMbLanguage());

        if(!approvalMobileRequest.getMbCode().isBlank()){
            approvalMobileRequestDec.setMbCode(EncryptUtil.decryptText(approvalMobileRequest.getMbCode(), key));
        }
        if(!approvalMobileRequest.getDocId().isBlank()){
            approvalMobileRequestDec.setAprReqId(approvalMobileRequest.getDocId());
        }
        if(approvalMobileRequest.getApprIndex() != 0){
            approvalMobileRequestDec.setApprIndex(approvalMobileRequest.getApprIndex());
        }
        if(!approvalMobileRequest.getApprType().isBlank()){
            approvalMobileRequestDec.setApprType(approvalMobileRequest.getApprType());
        }
        if(!approvalMobileRequest.getApprComment().isBlank()){
            approvalMobileRequestDec.setApprComment(approvalMobileRequest.getApprComment());
        }

        return approvalMobileRequestDec;
    }
}