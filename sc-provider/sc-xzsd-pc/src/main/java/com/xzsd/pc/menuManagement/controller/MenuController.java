package com.xzsd.pc.menuManagement.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menuManagement.entity.MenuDo;
import com.xzsd.pc.menuManagement.service.MenuService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/27 19:34
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;

    /**
     * 菜单新增
     * @param menuDo
     * @return
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuDo menuDo){
        try{
            return menuService.addMenu(menuDo);
        }catch (Exception e){
            logger.error("菜单新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 跟新菜单信息
     * @param menuDo
     * @return
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuDo menuDo){
        try {
            menuDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = menuService.updateMenu(menuDo);
            return appResponse;
        }catch (Exception e){
            logger.error("菜单修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuId){
        try {
            String currentUserId = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = menuService.deleteMenu(menuId, currentUserId);
            return appResponse;
        }catch (Exception e){
            logger.error("菜单删除失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 菜单列表
     * @return
     */
    @RequestMapping(value = "listMenu")
    public AppResponse menuList(@RequestParam("role") int role){
        AppResponse appResponse = menuService.menuList(role);
        return appResponse;
    }

    /**
     * 菜单详情
     * @param menuId
     * @return
     */
    @RequestMapping(value = "findMenu")
    public AppResponse findMenu(String menuId){
        return menuService.findMenu(menuId);
    }


}
