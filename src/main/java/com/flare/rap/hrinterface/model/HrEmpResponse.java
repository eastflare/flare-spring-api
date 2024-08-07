package com.flare.rap.hrInterface.model;

import java.util.List;

import com.flare.rap.hrInterface.model.HrEmployeeVO;
import com.flare.rap.webservice.model.WebServiceResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HrEmpResponse implements WebServiceResponse {
    private List<HrEmployeeVO> hrEmployeeList;
}