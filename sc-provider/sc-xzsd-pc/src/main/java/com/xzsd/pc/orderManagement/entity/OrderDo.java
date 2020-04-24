package com.xzsd.pc.orderManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/16 10:18
 */
public class OrderDo {
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
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 页展示数
     */
    private int pageSize;
    /**
     * 作废标记：0作废，1存在
     */
    private int isDelete;
    /**
     *创建时间
     */
    private Date buildTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 跟新时间
     */
    private Date modifiyTime;
    /**
     * 跟新者
     */
    private String lastModifiyBy;
    /**
     * 版本号
     */
    private int version;

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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getModifiyTime() {
        return modifiyTime;
    }

    public void setModifiyTime(Date modifiyTime) {
        this.modifiyTime = modifiyTime;
    }

    public String getLastModifiyBy() {
        return lastModifiyBy;
    }

    public void setLastModifiyBy(String lastModifiyBy) {
        this.lastModifiyBy = lastModifiyBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
