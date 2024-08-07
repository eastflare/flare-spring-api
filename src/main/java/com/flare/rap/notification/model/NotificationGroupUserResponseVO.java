package com.flare.rap.notification.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@SuperBuilder
@Builder
public class NotificationGroupUserResponseVO {

    @Schema(description = "사용자아이디", example = "test")
    private String aprNotfUserId;

    @Schema(description = "사원명", example = "홍길동")
    private String empNm;

    @Schema(description = "부서명", example = "기타부서")
    private String deptNm;

    @Schema(description = "직급 호칭", example = "사원")
    private String jtiNm;

    @Schema(description = "전화번호", example = "02-2021-7677")
    private String ofcPhn;

    @Schema(description = "메일서버정보", example = "djmail.lgchem.com")
    private String emlSvrDmnIfoNm;

    @Schema(description = "순번", example = "1")
    private String ntdkSeq;

    @Schema(description = "통보처구분코드", example = "CMN")
    private String ntdkDivsCd;

    @Schema(description = "통보처아이디", example = "1")
    private String ntdkId;

    @Schema(description = "정렬번호", example = "1")
    private Integer sortOrd;

    @Schema(description = "사용여부 Y/N", example = "Y")
    private String useYn;

}