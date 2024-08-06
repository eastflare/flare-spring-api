package com.flare.rap.menu.service;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flare.rap.common.constant.CrudConstants;
import com.flare.rap.common.util.SessionScopeUtil;
import com.flare.rap.common.util.StringUtil;
import com.flare.rap.department.model.DepartmentVO;
import com.flare.rap.menu.model.MenuRequestVO;
import com.flare.rap.menu.model.MenuResponseVO;
import com.flare.rap.menu.repository.MenuRepository;
import com.flare.rap.role.model.RoleEmployeeResponseVO;
import com.flare.rap.role.model.RoleResponseVO;
import com.flare.rap.session.model.UserSessionVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final String MOVE_UP = "1";
    private final String MOVE_DOWN = "2";
    private final String MOVE_INNER = "3";
    private final String DEFAULT = "4";

    @Override
    @Transactional(readOnly = true)
    public List<MenuResponseVO> findAllMenus() {
        return menuRepository.selectAllMenus();
    }

    @Override
    @Transactional(readOnly = true)
    public MenuResponseVO findMenu(String mnuId) {
            return menuRepository.selectMenu(mnuId);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int saveMenu(MenuRequestVO menuRequestVO) {

        if(MOVE_INNER.equals(menuRequestVO.getMenuLocation()) || DEFAULT.equals(menuRequestVO.getMenuLocation())){
            return saveMenuInnerOrDefault(menuRequestVO);
        }else{
            return saveMenuUpOrDown(menuRequestVO);
        }
    }

    private int saveMenuInnerOrDefault(MenuRequestVO menuRequestVO){
        if(MOVE_INNER.equals(menuRequestVO.getMenuLocation())){
            List<MenuResponseVO> childMenus = menuRepository.selectChildMenus(menuRequestVO.getTargetMenuId());
            menuRequestVO.setUpprMnuId(menuRequestVO.getTargetMenuId());
            menuRequestVO.setSortOrd(childMenus.size());
        }

        this.upsertMenu(menuRequestVO);
        return 1;
    }

    private void upsertMenu(MenuRequestVO menuRequestVO){
        UserSessionVO session = SessionScopeUtil.getContextSession();
        if(CrudConstants.CREATE.equals(menuRequestVO.getCrudKey()) || "".equals(menuRequestVO.getMnuId())){
            menuRepository.insertMenu(menuRequestVO, session);
        } else {
            menuRepository.updateMenu(menuRequestVO, session);
        }
    }

    private int saveMenuUpOrDown(MenuRequestVO menuRequestVO){

        List<MenuResponseVO> targetLevelMenus = this.findSameLevelMenus(menuRequestVO.getTargetMenuId());
        targetLevelMenus.removeIf(x -> x.getMnuId().equals(menuRequestVO.getMnuId()));

        OptionalInt optTargetIndex = IntStream.range(0, targetLevelMenus.size())
                .filter(i -> menuRequestVO.getTargetMenuId().equals(targetLevelMenus.get(i).getMnuId()))
                .findFirst();

        if(optTargetIndex.isPresent()){
            menuRequestVO.setUpprMnuId(targetLevelMenus.get(optTargetIndex.getAsInt()).getUpprMnuId());
        }

        int insertIndex = 0;
        if(MOVE_UP.equals(menuRequestVO.getMenuLocation())){
            insertIndex = optTargetIndex.orElse(0);
        }else if(MOVE_DOWN.equals(menuRequestVO.getMenuLocation())){
            insertIndex = optTargetIndex.orElse(targetLevelMenus.size()-1) + 1;
        }

        MenuResponseVO tempIndexMenu = MenuResponseVO.builder().mnuId(menuRequestVO.getMnuId()).build();
        targetLevelMenus.add(insertIndex, tempIndexMenu);

        for(int i = 0; i < targetLevelMenus.size(); i++){
            if(StringUtil.isEmpty(targetLevelMenus.get(i).getMnuId()) || targetLevelMenus.get(i).getMnuId().equals(menuRequestVO.getMnuId())){
                menuRequestVO.setSortOrd(i);
                this.upsertMenu(menuRequestVO);
            }
            else{
                menuRepository.updateMenuSortOrd(targetLevelMenus.get(i).getMnuId(), i, SessionScopeUtil.getContextSession());
            }
        }
        return 1;
    }

    private List<MenuResponseVO> findSameLevelMenus(String menuId){
        String upprMnuId = this.findMenu(menuId).getUpprMnuId();
        return this.findChildMenus(upprMnuId);
    }

    private List<MenuResponseVO> findChildMenus(String menuId){
        return menuRepository.selectChildMenus(menuId);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int removeMenus(String mnuId) {
        List<MenuResponseVO> siblingMenus = this.findSiblingMenus(mnuId);
        this.updateMenusSortOrder(siblingMenus);

       return menuRepository.deleteMenus(mnuId);
    }

    private List<MenuResponseVO> findSiblingMenus(String mnuId) {
        List<MenuResponseVO> siblingMenus = this.findSameLevelMenus(mnuId);
        siblingMenus.removeIf(x -> x.getMnuId().equals(mnuId));

        return siblingMenus;
    }

    private void updateMenusSortOrder(List<MenuResponseVO> menus){
        UserSessionVO session = SessionScopeUtil.getContextSession();
        for(int i = 0 ; i<menus.size(); i++){
            menuRepository.updateMenu(MenuRequestVO.builder().mnuId(menus.get(i).getMnuId()).sortOrd(i).build(), session);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleResponseVO> findRolesByMenuId(String mnuId) {
        return menuRepository.selectRolesByMenuId(mnuId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleEmployeeResponseVO> findEmployeesByMenu(String mnuId) {
        return menuRepository.selectEmployeesByMenuId(mnuId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentVO> findDepartmentsByMenu(String mnuId) {
        return menuRepository.selectDepartmentsByMenuId(mnuId);
    }
}