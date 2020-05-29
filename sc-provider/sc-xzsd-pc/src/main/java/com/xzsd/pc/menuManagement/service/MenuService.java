package com.xzsd.pc.menuManagement.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menuManagement.dao.MenuDao;
import com.xzsd.pc.menuManagement.entity.MenuDo;
import com.xzsd.pc.menuManagement.entity.MenuVo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import com.xzsd.pc.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/27 19:13
 */
@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 新增菜单
     * @param menuDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuDo menuDo){
        menuDo.setMenuId(StringUtil.getCommonCode(2));
        menuDo.setCreateBy(SecurityUtils.getCurrentUserId());
        //校验菜单名是否已经存在
        int i = menuDao.accoutMenu(menuDo.getMenuName());
        if( i > 0 ){
            return AppResponse.bizError("菜单名称已存在，请重新输入：");
        }
        //添加菜单名
        int count = menuDao.addMenu(menuDo);
        if(count ==0){
            return AppResponse.bizError("新增菜单失败");
        }
        return AppResponse.success("新增菜单成功！");
    }

    /**
     * 修改菜单
     * @param menuDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuDo menuDo){
        AppResponse appResponse = AppResponse.success("菜单修改成功");
        menuDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
        int count = menuDao.updateMenu(menuDo);
        if(0 == count){
            appResponse = AppResponse.versionError("菜单修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除菜单
     * @param menuId
     * @param currentUserId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuId,String currentUserId){
        AppResponse appResponse = AppResponse.success("删除菜单成功");
        List<String> menuIdList = Arrays.asList(menuId.split(","));
        int count = menuDao.deleteMenu(menuIdList, currentUserId);
        if(0 == count){
            appResponse = AppResponse.notFound("未删除菜单");
        }
        return appResponse;
    }

    /**
     * 查询菜单列表,根据不同角色显示不同菜单，角色有管理员和店长
     * @return 菜单列表
     */
    public AppResponse menuList(int role){
        List<MenuVo> menuVos = null;
        //角色为1则是管理员，2为店长
        if (role == 1){
            menuVos = menuDao.MenuManagementList();
        }else{
            menuVos = menuDao.MenuShopperList();
        }
        return AppResponse.success("查询成功",menuVos);
    }

    /**
     * 查看菜单详情
     * @param menuId
     * @return
     */
    public AppResponse findMenu(String menuId){
        MenuDo menu = menuDao.findMenu(menuId);
        return AppResponse.success("查询成功",menu);
    }

}
