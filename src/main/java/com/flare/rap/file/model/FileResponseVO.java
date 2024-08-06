package com.flare.rap.file.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponseVO {

    private String atchFileGrId;

    private List<FileVO> files;

}