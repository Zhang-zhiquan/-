package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/28 9:48
 */
public class OrderListVo {
    private String orderId;
    private Integer orderState;
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
