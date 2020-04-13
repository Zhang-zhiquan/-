package com.xzsd.pc.rotationPictureManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/2 18:53
 */
public class GoodsVo {
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品状态：为下架，1为在售
     */
    private int goodsStatus;
    /**
     * 商品一级分类
     */
    private String firstClass;
    /**
     * 商品二级分类
     */
    private String secondClass;

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

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }
}
