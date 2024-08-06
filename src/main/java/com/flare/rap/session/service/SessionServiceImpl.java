package com.flare.rap.session.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.code.model.CommonCodeResponseVO;
import com.flare.rap.code.repository.CommonCodeRepository;
import com.flare.rap.common.constant.CommonConstants;
import com.flare.rap.common.util.LocaleUtil;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.ValidateUtil;
import com.flare.rap.employee.service.EmployeeService;
import com.flare.rap.log.repository.LoginLogRepository;
import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.menu.service.MenuService;
import com.flare.rap.role.service.RoleDepartmentService;
import com.flare.rap.role.service.RoleEmployeeService;
import com.flare.rap.role.service.RoleMenuService;
import com.flare.rap.session.model.EmployeeVO;
import com.flare.rap.session.model.UserSessionVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class SessionServiceImpl implements SessionService {

    private final EmployeeService employeeService;
    private final RoleEmployeeService roleEmployeeService;
    private final RoleDepartmentService roleDepartmentService;
    private final RoleMenuService roleMenuService;
    private final CommonCodeRepository commonCodeRepository;
    private final LoginLogRepository loginLogRepository;

    @Override
    public UserSessionVO createUserSession(String userId, String langCd, String userIp) {

        EmployeeVO employeeInfo = employeeService.selectEmployeeByUserId(userId);
        if (ValidateUtil.isEmpty(employeeInfo)) {
            return null;
        }

        CommonCodeResponseVO corporate = commonCodeRepository.selectCommonCode("COP_CD", employeeInfo.getCopCd(), langCd);

        List< String> roleCodes = roleEmployeeService.findRoleCodesByUserId(userId);

        List< String> deptRoleCodes = roleDepartmentService.findRolesByDepartment(employeeInfo.getDeptCd());

        roleCodes.addAll(deptRoleCodes);

        List< MenuResponseVO> menus = roleMenuService.findMenusByRoleCodes(roleCodes);

        UserSessionVO userSession = new UserSessionVO(employeeInfo, roleCodes, menus, langCd, corporate.getOptValCtn3(), userIp);

        SessionScopeUtil.setContextSession(userSession);

        loginLogRepository.insertLoginLog(userSession);

        return userSession;
    }

    @Override
    public UserSessionVO createUserSession(String userId, String langCd, String userIp, String timeZone) {
        EmployeeVO employeeInfo = employeeService.selectEmployeeByUserId(userId);
        if (ValidateUtil.isEmpty(employeeInfo)) {
            return null;
        }

        List< CommonCodeResponseVO> gptTmzCds = commonCodeRepository.selectCommonCodes("GPT_TMZ_CD", langCd);
        String timeZoneCd = null;
        if(!ValidateUtil.isEmpty(gptTmzCds)) {
            for( CommonCodeResponseVO gptTmzCd: gptTmzCds ) {
                if(gptTmzCd.getOptValCtn3().equals(timeZone)) {
                    timeZoneCd = gptTmzCd.getCmnCd();
                    break;
                }
            }
        }

        if(timeZoneCd == null) timeZoneCd = "GMT000000009";

        List< String> roleCodes = roleEmployeeService.findRoleCodesByUserId(userId);

        List< String> deptRoleCodes = roleDepartmentService.findRolesByDepartment(employeeInfo.getDeptCd());

        roleCodes.addAll(deptRoleCodes);

        List< MenuResponseVO> menus = roleMenuService.findMenusByRoleCodes(roleCodes);

        UserSessionVO userSession = new UserSessionVO(employeeInfo, roleCodes, menus, langCd, timeZoneCd, userIp);

        SessionScopeUtil.setContextSession(userSession);

        loginLogRepository.insertLoginLog(userSession);

        return userSession;
    }

    @Override
    public boolean isAuthentication(HttpServletRequest request) {

        UserSessionVO userSessionContext = SessionScopeUtil.getContextSession();

        if(userSessionContext != null) return true;

        HttpSession session = request.getSession(false);

        if(session == null) {
            log.debug("HttpSession session is null");
            return false;
        }

        UserSessionVO userSession = (UserSessionVO)session.getAttribute(CommonConstants.HTTP_SESSION_KEY);

        if(userSession == null) {
            log.debug("UserSessionVO userSession is null");
            return false;
        }

        String userId = userSession.getUserId();

        if(userId == null ) {
            log.debug("userSession.getUserId() is null");
            return false;
        }

        return true;
    }

    @Override
    public void updateUserSessionLangCd(String langCd) {

        UserSessionVO userSessionContext = SessionScopeUtil.getContextSession();

        if(userSessionContext != null && LocaleUtil.hasLanguageCode(langCd)) {
            SessionScopeUtil.getContextSession().setLangCd(langCd);
        }
    }
}