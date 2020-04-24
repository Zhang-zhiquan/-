package com.xzsd.pc.storeManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/13 23:55
 */
public class StoreDTO {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 显示条数
     */
    private int pageSize;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 所在省份
     */
    private String province;
    /**
     * 所在城市
     */
    private String city;
    /**
     * 所在区
     */
    private String location;
    /**
     * 店长姓名
     */
    private String shopownerName;
    /**
     * 用户角色
     */
    private int role;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShopownerName() {
        return shopownerName;
    }

    public void setShopownerName(String shopownerName) {
        this.shopownerName = shopownerName;
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
}
