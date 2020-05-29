package com.xzsd.pc.hotGoodsManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/12 12:06
 */
public class HotGoodsDo {
    /**
     * 热门商品Id
     */
    private String hotGoodsId;
    /**
     * 热门商品排序
     */
    private Integer goodsSort;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 删除标记
     */
    private int isdetele;
    /**
     * 创建时间
     */
    private Date buildTime;
    /**
     * 修改时间
     */
    private Date modifiyTime;
    /**
     * 创建者
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

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId;
    }

    public Integer getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(Integer goodsSort) {
        this.goodsSort = goodsSort;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getIsdetele() {
        return isdetele;
    }

    public void setIsdetele(int isdetele) {
        this.isdetele = isdetele;
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
