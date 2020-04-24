package com.xzsd.pc.storeManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/13 18:06
 */
public class StoreDo {
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店电话
     */
    private String storePhone;
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
     * 营业执照编码
     */
    private String shoppingCode;
    /**
     * 门店详细地址
     */
    private String storeAddress;
    /**
     * 店长姓名
     */
    private String shopownerName;
    /**
     * 店长编号,具体在用户表里
     */
    private String shopownerId;
    /**
     * 邀请码
     */
    private String invitationCode;
    /**
     * 门店账号
     */
    private String storeAccountNumber;
    /**
     * 用户角色：管理员'1',店长'2',司机'3',客户'4'
     */
    private int role;
    /**
     * 作废标记
     */
    private int isdetele;
    /**
     * 创建时间
     */
    private Date buildTime;
    /**
     * 更新时间
     */
    private Date modifiyTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新者
     */
    private String lastModifiyBy;
    /**
     * 版本号
     */
    private int version;

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

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
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

    public String getShoppingCode() {
        return shoppingCode;
    }

    public void setShoppingCode(String shoppingCode) {
        this.shoppingCode = shoppingCode;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getShopownerName() {
        return shopownerName;
    }

    public void setShopownerName(String shopownerName) {
        this.shopownerName = shopownerName;
    }

    public String getShopownerId() {
        return shopownerId;
    }

    public void setShopownerId(String shopownerId) {
        this.shopownerId = shopownerId;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getStoreAccountNumber() {
        return storeAccountNumber;
    }

    public void setStoreAccountNumber(String storeAccountNumber) {
        this.storeAccountNumber = storeAccountNumber;
    }

    public int getIsdetele() {
        return isdetele;
    }

    public void setIsdetele(int isdetele) {
        this.isdetele = isdetele;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public Date getModifiyTime() {
        return modifiyTime;
    }

    public void setModifiyTime(Date modifiyTime) {
        this.modifiyTime = modifiyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
