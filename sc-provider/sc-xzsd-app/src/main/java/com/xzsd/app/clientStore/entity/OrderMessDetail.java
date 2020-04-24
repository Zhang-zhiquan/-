package com.xzsd.app.clientStore.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/23 15:31
 */
public class OrderMessDetail {
    private String goodsPicture;
    private String goodsAdvertising;
    private String goodsName;
    private String goodsId;
    private Double sale;
    private Integer purchaseNum;

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsAdvertising() {
        return goodsAdvertising;
    }

    public void setGoodsAdvertising(String goodsAdvertising) {
        this.goodsAdvertising = goodsAdvertising;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }
}
