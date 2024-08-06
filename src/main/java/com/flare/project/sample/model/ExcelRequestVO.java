package com.flare.project.sample.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExcelRequestVO<T> {
    @Schema(description = "파일명", example = "File")
    private String fileName;

    @Schema(description = "Sheet명", example = "Sheet1")
    private String sheetName;

    @NotBlank
    @Schema(description = "헤더", example = "['code', 'name']")
    private List<String> header;

    @Schema(description = "검색조건")
    private T searchCondition;
}