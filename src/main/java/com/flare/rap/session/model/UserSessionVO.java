package com.flare.rap.session.model;

import java.io.Serializable;
import java.util.List;

import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.menu.model.MenuResponseVO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSessionVO implements Serializable {

    private String userId;
    private String userIp;
    private String langCd;
    private List<String> roleCodes;
    private List<MenuResponseVO> menus;
    private String timeZoneCd;
    private String userCopCd;
    private String userDeptCd;
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
    private String upprEmpNo;
    private String upprUserId;
    private String onduRegnCd;
    private String onduRegnNm;
    private String ctryCd;
    private String emlSvrDmnIfoNm;

    // 법무지원시스템 전용 Session 값.
    private String teamYn; // 법무팀이 아닌 일반사용자 (팀장제외) : 현업 여부
    private String tldYn; // 법무팀 외 팀장 : 현업팀장 여부
    private String leasTeamYn; // 법무팀 팀원 (팀장제외 해외제외) 여부
    private String leasTldYn; // 법무팀 팀장 (해외제외) 여부
    private String gLeasTeamYn; // 해외 법무팀 팀원 (국내제외 팀장제외) 여부
    private String gLeasTldYn; // 해외 법무팀 팀장 (국내제외) 여부
    private String mgrDeptCd; // 내가 관리하는 담당법무부서코드들

    public UserSessionVO(EmployeeVO employee, List<String> roleCodes, List<MenuResponseVO> menus, String langCd, String timeZoneCd, String userIp) {
        this.userId = employee.getUserId();
        this.userIp = userIp;
        this.langCd = langCd;
        this.roleCodes = roleCodes;
        this.menus = menus;
        this.userCopCd = employee.getCopCd();
        this.userDeptCd = employee.getDeptCd();
        this.timeZoneCd = timeZoneCd;
        this.empNo = employee.getEmpNo();
        this.empNm = employee.getEmpNm();
        this.empEngNm = employee.getEmpEngNm();
        this.empCngNm = employee.getEmpCngNm();
        this.deptCd = employee.getDeptCd();
        this.deptNm = employee.getDeptNm();
        this.deptEngNm = employee.getDeptEngNm();
        this.deptCngNm = employee.getDeptCngNm();
        this.copCd = employee.getCopCd();
        this.jtiCd = employee.getJtiCd();
        this.jtiNm = employee.getJtiNm();
        this.jtiEngNm = employee.getJtiEngNm();
        this.jtiCngNm = employee.getJtiCngNm();
        this.jpsCd = employee.getJpsCd();
        this.jpsNm = employee.getJpsNm();
        this.jpsEngNm = employee.getJpsEngNm();
        this.jpsCngNm = employee.getJpsCngNm();
        this.upprEmpNo = employee.getUpprEmpNo();
        this.upprUserId = employee.getUpprUserId();
        this.onduRegnCd = employee.getOnduRegnCd();
        this.onduRegnNm = employee.getOnduRegnNm();
        this.ctryCd = employee.getCtryCd();
        this.emlSvrDmnIfoNm = employee.getEmlSvrDmnIfoNm();
    }

    public boolean isSessionEmpty(){
        return ValidateUtil.isEmpty(userId);
    }

}