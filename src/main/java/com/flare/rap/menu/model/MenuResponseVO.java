package com.flare.rap.menu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = {"mnuId"})
public class MenuResponseVO implements Comparable< MenuResponseVO> {

    @Schema(description = "메뉴아이디", name = "메뉴아이디")
    private String mnuId;

    @Schema(description = "메뉴이름", name = "메뉴이름")
    private String mnuNm;

    @Schema(description = "메뉴클릭시경로", name = "메뉴클릭시경로")
    private String mnuUrl;

    @Schema(description = "메뉴레벨", name = "메뉴레벨")
    private Integer mnuLvNo;

    @Schema(description = "상위메뉴아이디", name = "상위메뉴아이디")
    private String upprMnuId;

    @Schema(description = "정렬순서", name = "정렬순서")
    private Integer sortOrd;

    @Schema(description = "노출여부", name = "노출여부")
    private String mnuEpsYn;

    @Schema(description = "메뉴옵션값내용1", name = "메뉴옵션값내용1")
    private String mnuOptValCtn1;

    @Schema(description = "메뉴옵션값내용2", name = "메뉴옵션값내용2")
    private String mnuOptValCtn2;

    @Schema(description = "메뉴옵션값내용3", name = "메뉴옵션값내용3")
    private String mnuOptValCtn3;

    @Schema(description = "메뉴옵션값내용4", name = "메뉴옵션값내용4")
    private String mnuOptValCtn4;

    @Schema(description = "메뉴옵션값내용5", name = "메뉴옵션값내용5")
    private String mnuOptValCtn5;

    @Schema(description = "사용여부", name = "사용여부")
    private String useYn;

    @Schema(description = "메뉴설명", name = "메뉴설명")
    private String mnuDesc;

    @Schema(description = "메시지코드", name = "메시지코드")
    private String msgCtn;

    private String mnuKoNm;
    private String mnuEnNm;
    private String mnuPlNm;
    private String mnuZhtNm;
    private String mnuZhcNm;

    @Override
    public int compareTo(MenuResponseVO menuResponseVO) {
        if(menuResponseVO.sortOrd <  sortOrd){
            return 1;
        } else if(menuResponseVO.sortOrd > sortOrd){
            return -1;
        }
        return 0;
    }
}