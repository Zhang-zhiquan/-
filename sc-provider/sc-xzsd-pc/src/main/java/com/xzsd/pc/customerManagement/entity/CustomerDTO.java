package com.xzsd.pc.customerManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/5 16:41
 */
public class CustomerDTO {
    /**
     *当前页是第几页
     */
    private int pageNum;
    /**
     * 每页显示多少条
     */
    private int pageSize;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 客户账号
     */
    private String customerAccount;

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
}
