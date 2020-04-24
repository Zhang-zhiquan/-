package com.xzsd.pc.orderManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/16 16:00
 */
public class OrderVo {
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 门店Id
     */
    private String storeId;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 支付状态
     */
    private int payState;
    /**
     * 支付时间
     */
    private String payTime;
    /**
     * 支付总价
     */
    private double orderTotalPrice;
    /**
     * 下单人姓名
     */
    private String shopingName;
    /**
     * 下单人手机号
     */
    private String shoppingPhone;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getShopingName() {
        return shopingName;
    }

    public void setShopingName(String shopingName) {
        this.shopingName = shopingName;
    }

    public String getShoppingPhone() {
        return shoppingPhone;
    }

    public void setShoppingPhone(String shoppingPhone) {
        this.shoppingPhone = shoppingPhone;
    }
}
