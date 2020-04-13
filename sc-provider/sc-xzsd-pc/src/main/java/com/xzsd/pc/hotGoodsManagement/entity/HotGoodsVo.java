package com.xzsd.pc.hotGoodsManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/12 14:27
 */
public class HotGoodsVo {
    /**
     * 每页显示条数
     */
    private int pageSize;
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 热门商品Id
     */
    private String hotGoodsId;
    /**
     * 热门商品排序
     */
    private int goodsSort;
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
    private double goodsSale;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId;
    }

    public int getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(int goodsSort) {
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

    public double getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(double goodsSale) {
        this.goodsSale = goodsSale;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
