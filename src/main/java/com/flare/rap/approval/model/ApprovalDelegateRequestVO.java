package com.flare.rap.approval.model;


import com.flare.rap.common.model.CrudVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ApprovalDelegateRequestVO  extends CrudVO {

    @Schema(description = "결재위임번호", example = "1")
    private long aprDlgtNo;
    @NotBlank
    @Schema(description = "결재위임 사용자ID", example = "user1id")
    private String aprDlgtUserId;
    @NotBlank
    @Schema(description = "결재수임 사용자ID", example = "user2id")
    private String aprDeleUserId;
    @NotBlank
    @Schema(description = "결재위임시작일자", example = "20230101")
    private String aprDlgtStDt;
    @NotBlank
    @Schema(description = "결재위임종료일자", example = "20231231")
    private String aprDlgtEndDt;
    @NotBlank
    @Schema(description = "사용여부", example = "Y")
    private String useYn;

    public boolean isUsed(){
        return "Y".equals(this.useYn);
    }

}