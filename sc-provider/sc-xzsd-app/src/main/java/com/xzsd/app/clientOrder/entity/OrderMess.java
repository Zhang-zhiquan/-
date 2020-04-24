package com.xzsd.app.clientOrder.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/21 15:27
 */
public class OrderMess {
    private String goodsName;
    private String goodsId;
    private double sale;
    private int purchaseNum;
    private String goodsPicture;
    private String goodsAdvertising;
    private int isEvaluate;

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

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public int getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(int purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

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

    public int getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(int isEvaluate) {
        this.isEvaluate = isEvaluate;
    }
}
