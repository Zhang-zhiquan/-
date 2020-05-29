package com.xzsd.pc.storeManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/30 11:38
 */
public class ShopnerVo {
    private String userId;
    private String userAccount;
    private String userName;
    private int role;
    private int sex;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
