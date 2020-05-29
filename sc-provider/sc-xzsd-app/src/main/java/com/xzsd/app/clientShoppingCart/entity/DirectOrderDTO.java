package com.xzsd.app.clientShoppingCart.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/24 20:39
 */
public class DirectOrderDTO {
    private String goodsId;
    private Integer purchaseNum;
    private Double orderTotalPrice;
    private Double goodsSale;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Double getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(Double goodsSale) {
        this.goodsSale = goodsSale;
    }
}
