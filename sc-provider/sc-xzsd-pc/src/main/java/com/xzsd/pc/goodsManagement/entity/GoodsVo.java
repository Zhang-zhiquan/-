package com.xzsd.pc.goodsManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 18:04
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
     * 商品成本价
     */
    private double goodsCostprice;
    /**
     * 商品售价
     */
    private double goodsSale;
    /**
     * 商品状态：0为下架，1为在售
     */
    private int goodsStatus;
    /**
     * 商品广告词
     */
    private String goodsAdvertising;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品一级分类
     */
    private String firstClass;
    /**
     * 商品二级分类
     */
    private String secondClass;
    /**
     * 商品上架时间
     */
    private String goodsShelfTime;
    /**
     * 商品销售量
     */
    private int goodsSalesVolume;
    /**
     * 商品浏览量
     */
    private int goodsBrowse;
    /**
     * 商家编码
     */
    private String shopCode;
    /**
     * 商家名称
     */
    private String shopName;
    /**
     * 商品库存
     */
    private int goodsStock;
    /**
     * 书号
     */
    private String bookNumber;

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

    public double getGoodsCostprice() {
        return goodsCostprice;
    }

    public void setGoodsCostprice(double goodsCostprice) {
        this.goodsCostprice = goodsCostprice;
    }

    public double getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(double goodsSale) {
        this.goodsSale = goodsSale;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsAdvertising() {
        return goodsAdvertising;
    }

    public void setGoodsAdvertising(String goodsAdvertising) {
        this.goodsAdvertising = goodsAdvertising;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
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

    public String getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(String goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime;
    }

    public int getGoodsSalesVolume() {
        return goodsSalesVolume;
    }

    public void setGoodsSalesVolume(int goodsSalesVolume) {
        this.goodsSalesVolume = goodsSalesVolume;
    }

    public int getGoodsBrowse() {
        return goodsBrowse;
    }

    public void setGoodsBrowse(int goodsBrowse) {
        this.goodsBrowse = goodsBrowse;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }
}
