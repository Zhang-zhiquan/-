package com.xzsd.app.clientSortPage.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 1:03
 */
public class SortVo {
    /**
     * 分类Id
     */
    private String sortId;
    /**
     *分类名称
     */
    private String sortName;

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
