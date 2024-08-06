package com.flare.rap.menu.model;

import com.flare.rap.common.model.CrudVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MenuRequestVO extends CrudVO{


    @Schema(description = "메뉴아이디", example = "000001")
    private String mnuId;

    @NotBlank
    @Schema(description = "타겟메뉴아이디", example = "000002")
    private String targetMenuId;


    @Schema(description = "상위메뉴아이디", example = "000000")
    private String upprMnuId;

    @NotBlank
    @Schema(description = "메뉴 위치('1' : up, '2' : down, '3':inner '4':none)", example = "2")
    private String menuLocation;

    @Schema(description = "메뉴클릭시경로", example = "/menu/contract/detail")
    private String mnuUrl;

    @NotBlank
    @Schema(description = "메뉴이름", example = "계약 관리")
    private String mnuNm;

    @Schema(description = "사용여부 Y/N", example = "Y")
    private String useYn;

    @Schema(description = "화면노출여부 Y/N", example = "Y")
    private String mnuEpsYn;

    @Schema(description = "메뉴옵션값내용1", example = "1")
    private String mnuOptValCtn1;

    @Schema(description = "메뉴옵션값내용2", example = "2")
    private String mnuOptValCtn2;

    @Schema(description = "메뉴옵션값내용3", example = "3")
    private String mnuOptValCtn3;

    @Schema(description = "메뉴옵션값내용4", example = "4")
    private String mnuOptValCtn4;

    @Schema(description = "메뉴옵션값내용5", example = "5")
    private String mnuOptValCtn5;

    @Schema(description = "메뉴설명", example = "이 메뉴는요~")
    private String mnuDesc;

    @Schema(description = "메시지코드", example = "com.menu.000001")
    private String msgCtn;

    @Schema(description = "같은 레벨상에서 화면에 보여줄 순서 (오름차순)", example = "0")
    private Integer sortOrd;
}