package com.xzsd.app.clientHomePage.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/18 0:54
 */
public class HotGoodsVo {
    /**
     * 商品排序
     */
    private Integer goodsSort;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品售价
     */
    private Double goodsSale;

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(Double goodsSale) {
        this.goodsSale = goodsSale;
    }
}
