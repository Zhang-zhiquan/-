package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/21 14:29
 */
public class OrderVo {
    private String orderId;
    private Integer orderState;
    private String buildTime;
    private double orderTotalPrice;
    private int totall;
    private List<OrderMess> orderList;

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

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public List<OrderMess> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderMess> orderList) {
        this.orderList = orderList;
    }

    public int getTotall() {
        return totall;
    }

    public void setTotall(int totall) {
        this.totall = totall;
    }
}
