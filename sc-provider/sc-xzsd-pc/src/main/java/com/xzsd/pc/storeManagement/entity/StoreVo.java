package com.xzsd.pc.storeManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/14 0:02
 */
public class StoreVo {
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
     * 门店详细地址
     */
    private String storeAddress;
    /**
     * 店长姓名
     */
    private String shopownerName;
    /**
     * 邀请码
     */
    private String invitationCode;
    /**
     * 门店账号
     */

    private String storeAccountNumber;
    /**
     * 版本号
     */
    private int version;

    private int pageNum;

    private int pageSize;

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
