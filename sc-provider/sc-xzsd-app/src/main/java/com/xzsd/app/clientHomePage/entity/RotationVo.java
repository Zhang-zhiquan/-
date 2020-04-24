package com.xzsd.app.clientHomePage.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/17 20:05
 */
public class RotationVo {
    /**
     * 图片排序
     */
    private Integer pictureSort;
    /**
     * 图片路径
     */
    private String pictureRounte;
    /**
     * 商品Id
     */
    private String goodsId;

    public Integer getPictureSort() {
        return pictureSort;
    }

    public void setPictureSort(Integer pictureSort) {
        this.pictureSort = pictureSort;
    }

    public String getPictureRounte() {
        return pictureRounte;
    }

    public void setPictureRounte(String pictureRounte) {
        this.pictureRounte = pictureRounte;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
