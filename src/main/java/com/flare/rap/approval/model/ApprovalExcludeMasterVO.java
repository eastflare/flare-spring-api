package com.flare.rap.approval.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ApprovalExcludeMasterVO {
    @Schema(description = "결재자제외 ID", example = "1")
    private long aprExcTgtId;

    @Schema(description = "결재자제외 명", example = "제외규칙1")
    private String aprExcNm;

    @Schema(description = "데이터입력사용자ID", example = "admin")
    private String dataInsUserId;

    @Schema(description = "데이터입력사용자IP", example = "1.1.1.1")
    private String dataInsUserIp;

    @Schema(description = "데이터입력일시", example = "2023-05-08 14:43:21")
    private String dataInsDtm;

    @Schema(description = "데이터수정사용자ID", example = "2023-05-08 14:43:21")
    private String dataUpdUserId;

    @Schema(description = "데이터수정사용자IP", example = "2023-05-08 14:43:21")
    private String dataUpdUserIp;

    @Schema(description = "데이터수정일시", example = "2023-05-08 14:43:21")
    private String dataUpdDtm;

}