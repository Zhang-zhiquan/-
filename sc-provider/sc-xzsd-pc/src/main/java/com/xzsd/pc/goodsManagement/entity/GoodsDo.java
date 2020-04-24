package com.xzsd.pc.goodsManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/29 12:07
 */
public class GoodsDo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品成本价
     */
    private double goodsCostprice;
    /**
     * 商品售价
     */
    private double goodsSale;
    /**
     * 商品定价
     */
    private double goodsPrice;
    /**
     * 商品状态：为下架，1为在售
     */
    private Integer goodsStatus;
    /**
     * 出版社
     */
    private String publisher;
    /**
     * 作者
     */
    private String author;
    /**
     * 商品广告词
     */
    private String goodsAdvertising;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品图片路径
     */
    private String goodsPicture;
    /**
     * 商品一级分类
     */
    private String firstClass;
    /**
     * 商品二级分类
     */
    private String secondClass;
    /**
     * 商品上架时间
     */
    private Date goodsShelfTime;
    /**
     * 商品销售量
     */
    private int goodsSalesVolume;
    /**
     * 商品浏览量
     */
    private int goodsBrowse;
    /**
     * 商家编码
     */
    private String shopCode;
    /**
     * 商家名称
     */
    private String shopName;
    /**
     * 商品库存
     */
    private int goodsStock;
    /**
     * 书号
     */
    private String bookNumber;
    /**
     * 删除标记
     */
    private int isDetele;
    /**
     * 创建时间
     */
    private Date buildTime;
    /**
     * 修改时间
     */
    private Date modifiyTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 最后修改人
     */
    private String lastModifiyBy;
    /**
     * 版本号
     */
    private int version;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public double getGoodsCostprice() {
        return goodsCostprice;
    }

    public void setGoodsCostprice(double goodsCostprice) {
        this.goodsCostprice = goodsCostprice;
    }

    public double getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(double goodsSale) {
        this.goodsSale = goodsSale;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGoodsAdvertising() {
        return goodsAdvertising;
    }

    public void setGoodsAdvertising(String goodsAdvertising) {
        this.goodsAdvertising = goodsAdvertising;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public Date getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(Date goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime;
    }

    public int getGoodsSalesVolume() {
        return goodsSalesVolume;
    }

    public void setGoodsSalesVolume(int goodsSalesVolume) {
        this.goodsSalesVolume = goodsSalesVolume;
    }

    public int getGoodsBrowse() {
        return goodsBrowse;
    }

    public void setGoodsBrowse(int goodsBrowse) {
        this.goodsBrowse = goodsBrowse;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getIsDetele() {
        return isDetele;
    }

    public void setIsDetele(int isDetele) {
        this.isDetele = isDetele;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public Date getModifiyTime() {
        return modifiyTime;
    }

    public void setModifiyTime(Date modifiyTime) {
        this.modifiyTime = modifiyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifiyBy() {
        return lastModifiyBy;
    }

    public void setLastModifiyBy(String lastModifiyBy) {
        this.lastModifiyBy = lastModifiyBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "GoodsDo{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCostprice=" + goodsCostprice +
                ", goodsSale=" + goodsSale +
                ", goodsPrice=" + goodsPrice +
                ", goodsStatus=" + goodsStatus +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", goodsAdvertising='" + goodsAdvertising + '\'' +
                ", goodsIntroduce='" + goodsIntroduce + '\'' +
                ", goodsPicture='" + goodsPicture + '\'' +
                ", firstClass='" + firstClass + '\'' +
                ", secondClass='" + secondClass + '\'' +
                ", goodsShelfTime=" + goodsShelfTime +
                ", goodsSalesVolume=" + goodsSalesVolume +
                ", goodsBrowse=" + goodsBrowse +
                ", shopCode='" + shopCode + '\'' +
                ", shopName='" + shopName + '\'' +
                ", goodsStock=" + goodsStock +
                ", bookNumber='" + bookNumber + '\'' +
                ", isDetele=" + isDetele +
                ", buildTime=" + buildTime +
                ", modifiyTime=" + modifiyTime +
                ", createBy='" + createBy + '\'' +
                ", lastModifiyBy='" + lastModifiyBy + '\'' +
                ", version=" + version +
                '}';
    }
}
