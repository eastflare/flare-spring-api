package com.flare.rap.session.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeVO{
    private String userId;
    private String empNo;
    private String empNm;
    private String empEngNm;
    private String empCngNm;
    private String deptCd;
    private String deptNm;
    private String deptEngNm;
    private String deptCngNm;
    private String copCd;
    private String jtiCd;
    private String jtiNm;
    private String jtiEngNm;
    private String jtiCngNm;
    private String jpsCd;
    private String jpsNm;
    private String jpsEngNm;
    private String jpsCngNm;
    private String inoStatCd;
    private String jcomDt;
    private String rsgnDt;
    private String upprEmpNo;
    private String upprUserId;
    private String onduRegnCd;
    private String onduRegnNm;
    private String ssoDtplNm;
    private String ofcTano;
    private String ofcPhn;
    private String ofcEtnPhn;
    private String docAuthCd;
    private String emlSvrDmnIfoNm;
    private String inoDivsCd;
    private String empHphn;
    private String ctryCd;
    private String useYn;
    private String userInfo;
}