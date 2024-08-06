package com.flare.rap.file.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileVO implements Comparable< FileVO> {

        @NotBlank
        @Schema(description = "파일그룹uuid", name="파일그룹ID")
        private String atchFileGrId;

        @NotBlank
        @Schema(description = "파일uuid", name="파일ID")
        private String atchFileId;

        @Schema(description = "첨부파일명", name="첨부파일명")
        private String atchFileNm;

        @Schema(description = "정렬순서", name="정렬순서")
        private Integer sortOrd;

        @Schema(description = "첨부파일저장위치구분코드", name="첨부파일저장위치구분코드")
        private String atchFileSaveLocDivsCd;

        @Schema(description = "첨부파일저장명", name="첨부파일저장명")
        private String atchFileSaveNm;

        @Schema(description = "첨부파일크기", name="첨부파일크기")
        private Integer atchFileSize;

        @Schema(description = "첨부파일확장자명", name="첨부파일확장자명")
        private String atchFileEfnmNm;

        @Schema(description = "첨부파일저장경로내용", name="첨부파일저장경로내용")
        private String atchFileSavePathCtn;

        @Schema(description = "첨부파일유형코드", name="첨부파일유형코드")
        private String atchFileTpCd;

        @Schema(description = "옵션값내용1", name="옵션값내용1")
        private String optValCtn1;

        @Schema(description = "옵션값내용2", name="옵션값내용2")
        private String optValCtn2;

        @Schema(description = "옵션값내용3", name="옵션값내용3")
        private String optValCtn3;

        @Schema(description = "옵션값내용4", name="옵션값내용4")
        private String optValCtn4;

        @Schema(description = "옵션값내용5", name="옵션값내용5")
        private String optValCtn5;

        @Schema(description = "사용여부", name="사용여부")
        private String useYn;

        @Override
        public int compareTo(FileVO other) {
                if (this.sortOrd == null && other.getSortOrd() == null) {
                        return 0;
                } else if (this.sortOrd == null) {
                        return 1;
                } else if (other.getSortOrd() == null) {
                         return -1;
                } else {
                        return this.sortOrd.compareTo(other.getSortOrd());
                }

        }
}