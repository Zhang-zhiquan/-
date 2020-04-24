package com.xzsd.app.clientSortPage.entity;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 14:20
 */
public class SortCollection {
    /**
     * 分类编号
     */
    private String secondSortId;

    /**
     * 分类名称
     */
    private String secondSortName;

    /**
     * 商品集合
     */
    private List<Goods> goodsList;

    public String getSecondSortId() {
        return secondSortId;
    }

    public void setSecondSortId(String secondSortId) {
        this.secondSortId = secondSortId;
    }

    public String getSecondSortName() {
        return secondSortName;
    }

    public void setSecondSortName(String secondSortName) {
        this.secondSortName = secondSortName;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
