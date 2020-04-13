package com.xzsd.pc.goodsSortMansgement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/4 15:58
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
    /**
     * 备注
     */
    private String remarks;
    /**
     * 父类Id
     */
    private String parentId;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
