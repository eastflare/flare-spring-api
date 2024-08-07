package com.flare.rap.hrInterface.model;

import java.util.List;

import com.flare.rap.hrInterface.model.HrDepartmentVO;
import com.flare.rap.webservice.model.WebServiceResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HrDeptResponse implements WebServiceResponse {
    private List<HrDepartmentVO> hrDepartmentList;

}