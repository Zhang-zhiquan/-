package com.xzsd.app.clientShoppingCart.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/20 11:32
 */
public class ShowCartVo {
    /**
     * 购物车Id
     */
    private String cartId;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片路径
     */
    private String goodsPicture;
    /**
     * 商品数量
     */
    private int goodsAmount;
    /**
     * 商品售价
     */
    private double goodsSale;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

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

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public double getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(double goodsSale) {
        this.goodsSale = goodsSale;
    }
}
