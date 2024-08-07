package com.flare.rap.hrInterface.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.util.BatchUtil;
import com.flare.rap.hrInterface.model.*;
import com.flare.rap.hrInterface.repository.HrInterfaceRepository;
import com.flare.rap.webservice.constant.InterfaceUrlKeys;
import com.flare.rap.webservice.model.WebServiceResponse;
import com.flare.rap.webservice.service.WebService;
import com.flare.rap.webservice.service.WebServiceFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HrInterfaceServiceImpl implements HrInterfaceService{

    private final HrInterfaceRepository hrInterfaceRepository;
    private final WebServiceFactory webServiceFactory;

    @Transactional(rollbackFor = { Exception.class })
    public void migrateDepartments() throws Exception {

        List<HrDepartmentVO> hrDepartmentlist = this.getHrDepartmentsFromWebService();
        this.createHrDepartmentI(hrDepartmentlist);

        HrDepartmentCUDList hrDepartmentCUDList = this.getHrDepartmentCUDList();
        this.updateDepartmentMaster(hrDepartmentCUDList.getUpdateList());
        this.createDepartmentMaster(hrDepartmentCUDList.getInsertList());

        hrInterfaceRepository.updateDeptITranfered();
    }

    private List<HrDepartmentVO> getHrDepartmentsFromWebService() throws Exception{
        WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.HR_DEPARTMENT);
        WebServiceResponse webServiceResponse = webService.execute(null);

        return  ((HrDeptResponse) webServiceResponse).getHrDepartmentList();
    }

    private void createHrDepartmentI(List<HrDepartmentVO> hrDepartmentlist){
        int loopCount = BatchUtil.getBatchLoopCount(hrDepartmentlist.size());
        for (int i = 0; i < loopCount; i++) {
            List<HrDepartmentVO> batchList = BatchUtil.getSubList(hrDepartmentlist, i);
            hrInterfaceRepository.insertHrDepartmentI(batchList);
        }
    }

    private HrDepartmentCUDList getHrDepartmentCUDList(){
        List<HrDepartmentVO> hrDepartmentTargetlist = hrInterfaceRepository.selectDepartmentI();
        List<HrDepartmentVO> hrDepartmentInsertlist = new ArrayList<>();
        List<HrDepartmentVO> hrDepartmentUpdatelist = new ArrayList<>();

        for(HrDepartmentVO hrDepartmentVO: hrDepartmentTargetlist){
            if(hrInterfaceRepository.selectDepartmentMCount(hrDepartmentVO.getCodeNumb()) >0){
                hrDepartmentUpdatelist.add(hrDepartmentVO);
            }else{
                hrDepartmentInsertlist.add(hrDepartmentVO);
            }
        }

        return new HrDepartmentCUDList(hrDepartmentInsertlist, hrDepartmentUpdatelist);
    }

    private void updateDepartmentMaster(List<HrDepartmentVO> hrDepartmentUpdatelist){
        if(!hrDepartmentUpdatelist.isEmpty()){
            int batchInsertCount = BatchUtil.getBatchLoopCount(hrDepartmentUpdatelist.size());
            for (int i = 0; i < batchInsertCount; i++) {
                List<HrDepartmentVO> batchList = BatchUtil.getSubList(hrDepartmentUpdatelist, i);
                hrInterfaceRepository.updateDeptMaster(batchList);
            }
        }
    }

    private void createDepartmentMaster(List<HrDepartmentVO> hrDepartmentInsertlist){
        if(!hrDepartmentInsertlist.isEmpty()){
            int batchUpdateCount = BatchUtil.getBatchLoopCount(hrDepartmentInsertlist.size());
            for (int i = 0; i < batchUpdateCount; i++) {
                List<HrDepartmentVO> batchList = BatchUtil.getSubList(hrDepartmentInsertlist, i);
                hrInterfaceRepository.insertDeptMaster(batchList);
            }
        }
    }

    @Transactional(rollbackFor = { Exception.class })
    public void migrateEmployees() throws Exception{

        List<HrEmployeeVO> hrEmployeeList = this.getHrEmployeesFromWebService();
        this.createHrEmployeeI(hrEmployeeList);

        HrEmployeeCUDList hrEmployeeCUDList = this.getHrEmployeeCUDList();
        this.updateEmployeeMaster(hrEmployeeCUDList.getUpdateList());
        this.createEmployeeMaster(hrEmployeeCUDList.getInsertList());

        hrInterfaceRepository.updateEmpITranfered();
    }

    private List<HrEmployeeVO> getHrEmployeesFromWebService() throws Exception{
        WebService webService = webServiceFactory.getWebService(InterfaceUrlKeys.HR_EMPLOYEE);
        WebServiceResponse webServiceResponse = webService.execute(null);

        return ((HrEmpResponse) webServiceResponse).getHrEmployeeList();
    }

    private void createHrEmployeeI(List<HrEmployeeVO> hrEmployeeList){
        int loopCount = BatchUtil.getBatchLoopCount(hrEmployeeList.size());
        for (int i = 0; i < loopCount; i++) {
            List<HrEmployeeVO> batchList = BatchUtil.getSubList(hrEmployeeList, i);
            hrInterfaceRepository.insertHrEmployeeI(batchList);
        }
    }

    private HrEmployeeCUDList getHrEmployeeCUDList(){
        List<HrEmployeeVO> hrEmployeeTargetList = hrInterfaceRepository.selectEmployeeI();
        List<HrEmployeeVO> hrEmployeeInsertlist = new ArrayList<>();
        List<HrEmployeeVO> hrEmployeeUpdatelist = new ArrayList<>();
        for(HrEmployeeVO hrEmployeeVO: hrEmployeeTargetList)
        {
            if(hrInterfaceRepository.selectEmployeeMCount(hrEmployeeVO.getSaUser())>0)
            {
                hrEmployeeUpdatelist.add(hrEmployeeVO);
            }else{
                hrEmployeeInsertlist.add(hrEmployeeVO);
            }
        }

        return new HrEmployeeCUDList(hrEmployeeInsertlist, hrEmployeeUpdatelist);
    }

    private void updateEmployeeMaster(List<HrEmployeeVO> hrEmployeeUpdatelist){
        if(!hrEmployeeUpdatelist.isEmpty()) {
            int batchCountEmpUpdate= BatchUtil.getBatchLoopCount(hrEmployeeUpdatelist.size());
            for (int i = 0; i < batchCountEmpUpdate; i++) {
                List<HrEmployeeVO> batchList = BatchUtil.getSubList(hrEmployeeUpdatelist, i);
                hrInterfaceRepository.updateEmpMaster(batchList);
            }
        }
    }

    private void createEmployeeMaster(List<HrEmployeeVO> hrEmployeeInsertlist){
        if(!hrEmployeeInsertlist.isEmpty()){
            int batchCountEmpInsert= BatchUtil.getBatchLoopCount(hrEmployeeInsertlist.size());
            for (int i = 0; i < batchCountEmpInsert; i++) {
                List<HrEmployeeVO> batchList = BatchUtil.getSubList(hrEmployeeInsertlist, i);
                hrInterfaceRepository.insertEmpMaster(batchList);
            }
        }
    }
}