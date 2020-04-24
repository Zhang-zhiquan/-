package com.xzsd.app.clientShoppingCart.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/20 20:25
 */
public class CartDTO {
    private String cartId;
    private double orderTotalPrice;
    private String invitationCode;
    private String goodsId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
