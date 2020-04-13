package com.xzsd.pc.hotGoodsManagement.entity;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/12 15:40
 */
public class HotGoodsDTO {
    private String goodsName;
    private String goodsId;
    private int pageNum;
    private int pageSize;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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
}
