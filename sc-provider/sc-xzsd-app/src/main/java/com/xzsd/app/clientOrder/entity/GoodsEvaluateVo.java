package com.xzsd.app.clientOrder.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/22 10:08
 */
public class GoodsEvaluateVo {
    /**
     * 客户评价人姓名
     */
    private String customerName;
    /**
     * 评价星级
     */
    private Integer starLevel;
    /**
     * 评价内容
     */
    private String appraiseInfo;
    /**
     * 图片路径
     */
    private String imagesUrl;
    /**
     * 创建时间
     */
    private String buildTime;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    public String getAppraiseInfo() {
        return appraiseInfo;
    }

    public void setAppraiseInfo(String appraiseInfo) {
        this.appraiseInfo = appraiseInfo;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }
}
