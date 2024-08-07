package com.flare.rap.hrInterface.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.hrInterface.model.HrDepartmentVO;
import com.flare.rap.hrInterface.model.HrEmployeeVO;

@Mapper
public interface HrInterfaceRepository {
    int insertHrDepartmentI(List<HrDepartmentVO> hrDepartments);

    int insertHrEmployeeI(List<HrEmployeeVO> hrEmployee);

    int insertHrDepartmentM(List<DepartmentVO> departmentVO);

    int insertHrEmployeeM(List<HrEmployeeVO> hrEmployee);

    int selectDepartmentMCount(String deptCd);
    int selectEmployeeMCount(String userId);

    int updateDeptMaster(List<HrDepartmentVO> hrDepartmentlist);
    int insertDeptMaster(List<HrDepartmentVO> hrDepartmentlist);

    int updateEmpMaster(List<HrEmployeeVO> hrEmployeeList);
    int insertEmpMaster(List<HrEmployeeVO> hrEmployeeList);

    int updateDeptITranfered();
    int updateEmpITranfered();

    String selectDetpIfId();
    String selectEmpIfId();

    List<HrDepartmentVO>selectDepartmentI();

    List<HrEmployeeVO>selectEmployeeI();
}