package com.xzsd.pc.orderManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/16 11:11
 */
public class OrderDTO {
    /**
     * 下单人姓名
     */
    private String shopingName;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 支付时间起
     */
    private String payTimeStart;
    /**
     * 支付时间止
     */
    private String payTimeEnd;
    /**
     * 下单人手机号
     */
    private String shoppingPhone;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 角色
     */
    private int role;
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 页大小
     */
    private int pageSize;

    private String storeId;

    public String getShopingName() {
        return shopingName;
    }

    public void setShopingName(String shopingName) {
        this.shopingName = shopingName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public String getShoppingPhone() {
        return shoppingPhone;
    }

    public void setShoppingPhone(String shoppingPhone) {
        this.shoppingPhone = shoppingPhone;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
