package com.xzsd.pc.storeManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/30 11:39
 */
public class ShopnerDTO {
    private String userAccount;
    private String userName;
    private int pageNum;
    private int pageSize;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
