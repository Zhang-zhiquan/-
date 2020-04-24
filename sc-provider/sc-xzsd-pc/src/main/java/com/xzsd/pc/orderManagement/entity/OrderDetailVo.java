package com.xzsd.pc.orderManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/16 23:25
 */
public class OrderDetailVo {
    /**
     * 订单详情Id
     */
    private String ordersId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 购买数量
     */
    private Integer purchaseNum;
    /**
     * 购买总价
     */
    private Double totalPrice;
    /**
     * 售价
     */
    private Double sale;
    /**
     * 定价
     */
    private Double price;

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
