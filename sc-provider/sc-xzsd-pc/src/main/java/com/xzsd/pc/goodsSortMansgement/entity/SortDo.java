package com.xzsd.pc.goodsSortMansgement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description 商品分类实体类
 * @Author quan
 * @Date 2020/4/4 10:14
 */
public class SortDo {
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
     * 是否父类
     */
    private int isParent;
    /**
     * 父类Id
     */
    private String parentId;
    /**
     * 删除标记
     */
    private int isDetele;
    /**
     * 创建时间
     */
    private Date buildTime;
    /**
     * 修改时间
     */
    private Date modifiyTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 最后修改人
     */
    private String lastModifiyBy;
    /**
     * 版本号
     */
    private int version;

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

    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getIsDetele() {
        return isDetele;
    }

    public void setIsDetele(int isDetele) {
        this.isDetele = isDetele;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public Date getModifiyTime() {
        return modifiyTime;
    }

    public void setModifiyTime(Date modifiyTime) {
        this.modifiyTime = modifiyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifiyBy() {
        return lastModifiyBy;
    }

    public void setLastModifiyBy(String lastModifiyBy) {
        this.lastModifiyBy = lastModifiyBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
