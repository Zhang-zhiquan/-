package com.xzsd.pc.userManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/10 14:01
 */
public class UserVo {
    private String userId;
    private String userName;
    private String imagesUrl;
    private int role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
