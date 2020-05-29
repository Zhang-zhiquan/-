package com.xzsd.pc.menuManagement.dao;

import com.xzsd.pc.menuManagement.entity.MenuDo;
import com.xzsd.pc.menuManagement.entity.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/27 17:30
 */
@Mapper
public interface MenuDao {
    /**
     * 查看是否有相同的菜单名
     * @param menuName
     * @return
     */
    public int accoutMenu(String menuName);
    /**
     * 新增菜单
     * @param menudo
     * @return
     */
    int addMenu(MenuDo menudo);

    /**
     * 修改菜单
     * @param menuDo
     * @return
     */
    int updateMenu(MenuDo menuDo);

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    int deleteMenu(@Param("menuId") List menuId, @Param("currentUserId") String currentUserId);

    /**
     * 查询管理员菜单列表
     * @return
     */
    List<MenuVo> MenuManagementList();

    /**
     * 查询店长菜单列表
     * @return
     */
    List<MenuVo> MenuShopperList();

    /**
     * 查看菜单详情
     * @param menuId
     * @return
     */
    MenuDo findMenu(@Param("menuId") String menuId);

}
