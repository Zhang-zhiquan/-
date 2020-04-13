package com.xzsd.pc.customerManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/5 16:12
 */
public class CustomerDo {
    /**
     *当前页是第几页
     */
    private int pageNum;
    /**
     * 每页显示多少条
     */
    private int pageSize;
    /**
     * 客户Id
     */
    private String customerId;
    /**
     * 用户表Id
     */
    private String userId;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 客户账号
     */
    private String customerAccount;
    /**
     * 性别
     */
    private int sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 身份证
     */
    private String idCard;

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
