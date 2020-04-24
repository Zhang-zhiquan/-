package com.xzsd.app.clientSortPage.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 14:22
 */
public class Goods {
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品售价
     */
    private String goodsSale;
    /**
     * 商品图片路径
     */
    private String goodsPicture;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(String goodsSale) {
        this.goodsSale = goodsSale;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }
}
