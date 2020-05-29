package com.xzsd.pc.driverManagement.entity;

/**
 * @ClassName DriverVo
 * @Description 前端展示
 * @Author quan
 * @Date 2020/4/15 6:39
 */
public class DriverVo {
    /**
     * 司机编号
     */
    private String driverId;
    /**
     * 司机姓名
     */
    private String driverName;
    /**
     * 司机手机号
     */
    private String driverPhone;
    /**
     * 身份证
     */
    private String driverIDCard;
    /**
     * 司机账号
     */
    private String driverAccounte;
    /**
     * 版本号
     */
    private int version;

    private String userId;

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

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverIDCard() {
        return driverIDCard;
    }

    public void setDriverIDCard(String driverIDCard) {
        this.driverIDCard = driverIDCard;
    }

    public String getDriverAccounte() {
        return driverAccounte;
    }

    public void setDriverAccounte(String driverAccounte) {
        this.driverAccounte = driverAccounte;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
