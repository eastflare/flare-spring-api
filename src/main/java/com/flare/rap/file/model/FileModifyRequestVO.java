package com.flare.rap.file.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileModifyRequestVO {
    String atchFileGrId;
    List<FileVO> files;
}