package com.xzsd.pc.menuManagement.entity;

/**
 * @ClassName
 * @Description 展示菜单列表
 * @Author quan
 * @Date 2020/3/28 15:31
 */
public class MenuVo {
    /**
     * 菜单id
     */
    private String menuId;
    /**
     * 菜单名称
     */
    private String menuName;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
