package com.xzsd.app.clientShoppingCart.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/21 9:17
 */
public class GoodsDetailDTO {
    private String customerId;
    private String goodsId;
    private int goodsAmount;
    private String goodsName;
    private double goodsSale;
    private double goodsCostprice;
    private double totalPrice;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
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

    public double getGoodsCostprice() {
        return goodsCostprice;
    }

    public void setGoodsCostprice(double goodsCostprice) {
        this.goodsCostprice = goodsCostprice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
