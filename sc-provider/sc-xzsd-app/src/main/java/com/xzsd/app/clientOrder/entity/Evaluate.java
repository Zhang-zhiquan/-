package com.xzsd.app.clientOrder.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/5/3 23:26
 */
public class Evaluate {
    private String goodsId;
    private String appraiseInfo;
    private Integer starLevel;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAppraiseInfo() {
        return appraiseInfo;
    }

    public void setAppraiseInfo(String appraiseInfo) {
        this.appraiseInfo = appraiseInfo;
    }

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }
}
