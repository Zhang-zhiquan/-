package com.xzsd.app.clientStore.entity;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/23 15:30
 */
public class OrderMessVo {
    private String orderId;
    private Integer orderState;
    private String shopingName;
    private String shoppingPhone;
    private Double orderTotalPrice;
    private int totall;
    private List<OrderMessDetail> orderList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
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

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public List<OrderMessDetail> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderMessDetail> orderList) {
        this.orderList = orderList;
    }

    public int getTotall() {
        return totall;
    }

    public void setTotall(int totall) {
        this.totall = totall;
    }
}
