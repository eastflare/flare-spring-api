package com.flare.rap.hrInterface.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class HrDepartmentVO {

    @Schema(description = "부서중문명", name = "부서중문명")
    private String codeNameCn;

    @Schema(description = "부서영문명", name = "부서영문명")
    private String codeNameEn;

    @Schema(description = "부서명", name = "부서명")
    private String codeNameKo;

    @Schema(description = "부서코드", name = "부서코드")
    private String codeNumb;

    @Schema(description = "상위부서코드", name = "상위부서코드")
    private String codeUper;

    @Schema(description = "생성일", name = "생성일")
    private String createdate;

    @Schema(description = "구분", name = "구분")
    private String division;

    @Schema(description = "수정일", name = "수정일")
    private String updatedate;

    @Schema(description = "사용유무", name = "사용유무")
    private String validFlag;

    @Schema(description = "팀리더사번", name = "팀리더사번")
    private String chiefNumb;

    @Schema(description = "인터페이수신일시", name = "인터페이수신일시")
    private String ifCreationDate;

    @Schema(description = "마스터반영여부", name = "마스터반영여부")
    private String transferFlag;

    @Schema(description = "마스터반영일시", name = "마스터반영일시")
    private String transferDate;

    @Schema(description = "인터페이스순번", name = "인터페이스순번")
    private String ifId;
}