package com.flare.rap.hrInterface.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class HrEmployeeVO {

    @Schema(description = "법인코드", name = "법인코드")
    private String saComp;

    @Schema(description = "부서코드(옛날부서)", name = "부서코드(옛날부서)")
    private String saDept;

    @Schema(description = "부서명", name = "부서명")
    private String saDeptName;

    @Schema(description = "부서중문명", name = "부서중문명")
    private String saDeptNameC;

    @Schema(description = "부서영문명", name = "부서영문명")
    private String saDeptNameE;

    @Schema(description = "부서코드(현재부서코드)", name = "부서코드(현재부서코드)")
    private String saDeptNew;

    @Schema(description = "영문부서명", name = "영문부서명")
    private String saEdeptName;

    @Schema(description = "직책", name = "직책")
    private String saFunc;

    @Schema(description = "직책명", name = "직책명")
    private String saFuncName;

    @Schema(description = "직책중문명", name = "직책중문명")
    private String saFuncNameC;

    @Schema(description = "직책영문명", name = "직책영문명")
    private String saFuncNameE;

    @Schema(description = "핸드폰 번호(보안으로 데이터값 없음)", name = "핸드폰 번호(보안으로 데이터값 없음)")
    private String saHand;

    @Schema(description = "이름중문명", name = "이름중문명")
    private String saHname;

    @Schema(description = "직위코드", name = "직위코드")
    private String saJobx;

    @Schema(description = "직위명", name = "직위명")
    private String saJobxName;

    @Schema(description = "직위중문명", name = "직위중문명")
    private String saJobxNameC;

    @Schema(description = "직위영문명", name = "직위영문명")
    private String saJobxNameE;

    @Schema(description = "이름", name = "이름")
    private String saName;

    @Schema(description = "영문이름", name = "영문이름")
    private String saNameE;

    @Schema(description = "지역번호(집전화)", name = "지역번호(집전화)")
    private String saPhonArea;

    @Schema(description = "전화번호2(내선번호)", name = "전화번호2(내선번호)")
    private String saPhonD;

    @Schema(description = "전화번호3(집전화번호)", name = "전화번호3(집전화번호)")
    private String saPhonH;

    @Schema(description = "지역번호(사무실전화)", name = "지역번호(사무실전화)")
    private String saPhonHarea;

    @Schema(description = "전화번호1(사무실전화번호)", name = "전화번호1(사무실전화번호)")
    private String saPhonO;

    @Schema(description = "입사날자", name = "입사날자")
    private String saRect;

    @Schema(description = "사번(옛날 사번)", name = "사번(옛날 사번)")
    private String saSabun;

    @Schema(description = "상급자 사번", name = "상급자 사번")
    private String saSabunLeader;

    @Schema(description = "사번(현재 사번)", name = "사번(현재 사번)")
    private String saSabunNew;

    @Schema(description = "문서중앙화 권한", name = "문서중앙화 권한")
    private String saSystem;

    @Schema(description = "입사현황", name = "입사현황")
    private String saTemp;

    @Schema(description = "퇴직날자", name = "퇴직날자")
    private String saTempDate;

    @Schema(description = "id", name = "id")
    private String saUser;

    @Schema(description = "정보 변경 코드(c생성, u:변경, d:삭제)", name = "정보 변경 코드(c생성, u:변경, d:삭제)")
    private String ssoExFlag;

    @Schema(description = "메일 서버", name = "메일 서버")
    private String ssoMailServer;

    @Schema(description = "변경날짜", name = "변경날짜")
    private String ssoPsDate;

    @Schema(description = "인사정보상 근무지코드", name = "인사정보상 근무지코드")
    private String saGnmu;

    @Schema(description = "인사정보상 근무지", name = "인사정보상 근무지")
    private String saGnmuName;

    @Schema(description = "myinfo상 근무지", name = "myinfo상 근무지")
    private String ssoLocate;

    @Schema(description = "생산직,사무직구분(사무직:e, 생산/기술직:h)", name = "생산직,사무직구분(사무직:e, 생산/기술직:h)")
    private String saPayxgb;

    @Schema(description = "사원하위그룹", name = "사원하위그룹")
    private String saSnbngb;

    @Schema(description = "사원상위그룹", name = "사원상위그룹")
    private String saSnbngr;

    @Schema(description = "email 도메인", name = "email 도메인")
    private String saMail;

    @Schema(description = "sso 근무지코드", name = "sso 근무지코드")
    private String ssoSuGnmu;

    @Schema(description = "sso 이름 중문명", name = "sso 이름 중문명")
    private String ssoCname;

    @Schema(description = "국가구분", name = "국가구분")
    private String saNationality;

    @Schema(description = "인터페이스 수신일시", name = "인터페이스 수신일시")
    private String ifCreationDate;

    @Schema(description = "마스터 반영 여부", name = "마스터 반영 여부")
    private String transferFlag;

    @Schema(description = "마스터 반영 일시", name = "마스터 반영 일시")
    private String transferDate;

    @Schema(description = "인터페이스 순번", name = "인터페이스 순번")
    private String ifId;

    @Schema(description = "사용여부", name = "사용여부")
    private String useYn;






}