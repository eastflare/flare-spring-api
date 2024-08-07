package com.flare.rap.approval.service;

import com.flare.rap.approval.model.ApprovalMobileApprovalDetailVO;
import com.flare.rap.approval.model.ApprovalMobileApprovalResultResponseVO;
import com.flare.rap.approval.model.ApprovalMobileRequestVO;

public interface ApprovalMobileService {

    /**
     * approvalMobileDetail 에서 요청된 정보를 기반으로 세션을 생성하고, 모바일용 XML을 리턴
     * @param approvalMobileRequest
     * userID	string	N	요청 ID	G-Portal ID	결재 문서를 조회하고자 하는 사용자 ID	AES128 암호화 권장(key값 따로 문의)
     * mbCode	string	N	사용자 확인 코드	8012 + userId	8012를 떼고 ID와 비교하여 유효성 검증을 위해 쓰인다	AES128 암호화 권장(key값 따로 문의)
     * empNo	string	N	요청자 사번	사번	결재 처리에 사번 정보가 꼭 필요할 경우만 보낸다	AES128 암호화 권장(key값 따로 문의)
     * mbLanguage	string	N	언어정보	KR, EN	다국어 처리가 필요할 경우 쓴다(기본값으로 KR을 권장)
     * @param userIp Controller에서 알아낸 IP
     *
     * @return 모바일용 결재정보 조회 XML을 리턴
     */
    ApprovalMobileApprovalDetailVO approvalMobileDetail(ApprovalMobileRequestVO approvalMobileRequest, String userIp);

    /**
     * decInfo 모바일에서 전달된 파라미터를 복호화, 레거시 마다 암호화 방식의 차이가 있음(기본 AES128)
     * @param approvalMobileRequest
     * @return
     */
//    ApprovalMobileRequestVO decInfo(ApprovalMobileRequestVO approvalMobileRequest);

    /**
     * approvalMobileProcess 모바일에서 요청된 승인/부결 요청을 처리
     * @param approvalMobileRequest
     * userID		string	N	사용자아이디	G-Portal ID	레거시 마다 암호화 방식의 차이가 있음(기본 AES128)
     * docId		string	N	결재 문서 ID 	0002821933
     * apprIndex		string	N	결재 차수	2	결재 상세조회시 받은 <apprIndex> 값 보내줌
     * apprType		string	N	01 : 승인 / 04 : 반려	01 : 승인 / 04 : 반려	레거시 마다 값이 다를수 있음 01, 04가 기본
     * empNo		string	N	사번	75411	사번값으로 필요한 레거시만 보내준다. 레거시마다 암호화 방식의 차이가 있음(기본 AES128)
     * apprComment		string	N	결재의견	승인합니다
     * mbLanguage		string	N	언어정보	KR/EN	다국어 처리가 필요한 경우
     * @return
     * apprResult    returnCode	int	N	성공/실패 코드	0 : 성공    other values :  실패
     * 	returnDesc	string	N	성공/실패 설명	Success
     */
    ApprovalMobileApprovalResultResponseVO approvalMobileProcess(ApprovalMobileRequestVO approvalMobileRequest, String userIp);
}