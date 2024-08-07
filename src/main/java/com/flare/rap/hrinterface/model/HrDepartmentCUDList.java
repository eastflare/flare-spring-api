package com.flare.rap.hrInterface.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HrDepartmentCUDList {
    List<HrDepartmentVO> insertList;
    List<HrDepartmentVO> updateList;
}