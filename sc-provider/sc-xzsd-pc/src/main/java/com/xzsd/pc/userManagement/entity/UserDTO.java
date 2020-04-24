package com.xzsd.pc.userManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/18 16:43
 */
public class UserDTO {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户登录账号
     */
    private String userAccount;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户登录密码
     */
    private String password;
    /**
     * 用户性别
     */
    private Integer sex;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户头像url
     */
    private String imagesUrl;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 用户角色：管理员'1',店长'2',司机'3',客户'4'
     */
    private Integer role;
    /**
     * 作废标记：0作废，1存在
     */
    private Integer isDelete;
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
    private Integer version;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
