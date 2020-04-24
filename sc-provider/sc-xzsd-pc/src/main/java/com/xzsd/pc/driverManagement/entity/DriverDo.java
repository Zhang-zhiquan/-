package com.xzsd.pc.driverManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/14 19:53
 */
public class DriverDo {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页显示数
     */
    private int pageSize;
    /**
     * 司机Id
     */
    private String driverId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 司机姓名
     */
    private String driverName;
    /**
     * 司机账号
     */
    private String driverAccounte;
    /**
     * 手机号
     */
    private String driverPhone;
    /**
     * 司机身份证
     */
    private String driverIDCard;
    /**
     * 密码
     */
    private String password;
    /**
     * 省Id
     */
    private String province;
    /**
     * 市Id
     */
    private String city;
    /**
     * 区Id
     */
    private String location;
    /**
     * 角色
     */
    private int role;
    /**
     * 删除标记
     */
    private int isDetele;
    /**
     * 创建时间
     */
    private Date buildTime;
    /**
     * 修改时间
     */
    private Date modifiyTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 最后修改人
     */
    private String lastModifiyBy;
    /**
     * 版本号
     */
    private int version;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAccounte() {
        return driverAccounte;
    }

    public void setDriverAccounte(String driverAccounte) {
        this.driverAccounte = driverAccounte;
    }

    public String getDriverIDCard() {
        return driverIDCard;
    }

    public void setDriverIDCard(String driverIDCard) {
        this.driverIDCard = driverIDCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getIsDetele() {
        return isDetele;
    }

    public void setIsDetele(int isDetele) {
        this.isDetele = isDetele;
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

    public String getUserId() {
        return userId;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
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

    public void setUserId(String userId) {
        this.userId = userId;

    }
}
