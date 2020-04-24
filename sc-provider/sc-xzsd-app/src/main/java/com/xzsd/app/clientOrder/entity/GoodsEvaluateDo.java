package com.xzsd.app.clientOrder.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/22 8:33
 */
public class GoodsEvaluateDo {
    /**
     * 评价Id
     */
    private String evaluateId;
    /**
     * 客户评价人Id
     */
    private String customerId;
    /**
     * 商品Id
     */
    private String goodsId;
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

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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
