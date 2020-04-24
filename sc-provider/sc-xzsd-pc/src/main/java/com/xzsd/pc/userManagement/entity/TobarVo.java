package com.xzsd.pc.userManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/22 9:48
 */
public class TobarVo {
    private String userId;
    private String userName;
    private String imagesUrl;
    private Integer role;

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }
}
