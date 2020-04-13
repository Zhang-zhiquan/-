package com.xzsd.pc.rotationPictureManagement.entity;

import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/31 21:20
 */
public class PictureDo {
    /**
     * 每页显示多少
     */
    private int pagaSize;
    /**
     * 当前页是几页
     */
    private int pageNum;
    /**
     * 图片Id
     */
    private String pictureId;
    /**
     * 图片排序
     */
    private int pictureSort;
    /**
     * 图片；路径
     */
    private String pictureRounte;
    /**
     * 图片状态
     */
    private int pictureStatus;
    /**
     * 图片有效期起
     */
    private String pictureStart;
    /**
     * 图片有效期止
     */
    private String pictureEnd;
    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 删除标记：0已删除，1存在
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
     * 创建者
     */
    private String createBy;
    /**
     * 最后修改者
     */
    private String lastModifiyBy;
    /**
     * 版本号
     */
    private int version;

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public int getPictureSort() {
        return pictureSort;
    }

    public void setPictureSort(int pictureSort) {
        this.pictureSort = pictureSort;
    }

    public String getPictureRounte() {
        return pictureRounte;
    }

    public void setPictureRounte(String pictureRounte) {
        this.pictureRounte = pictureRounte;
    }

    public int getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(int pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public String getPictureStart() {
        return pictureStart;
    }

    public void setPictureStart(String pictureStart) {
        this.pictureStart = pictureStart;
    }

    public String getPictureEnd() {
        return pictureEnd;
    }

    public void setPictureEnd(String pictureEnd) {
        this.pictureEnd = pictureEnd;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getPagaSize() {
        return pagaSize;
    }

    public void setPagaSize(int pagaSize) {
        this.pagaSize = pagaSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "PictureDo{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureSort=" + pictureSort +
                ", pictureRounte='" + pictureRounte + '\'' +
                ", pictureStatus=" + pictureStatus +
                ", pictureStart=" + pictureStart +
                ", pictureEnd=" + pictureEnd +
                ", goodsId='" + goodsId + '\'' +
                ", isDetele=" + isDetele +
                ", buildTime=" + buildTime +
                ", modifiyTime=" + modifiyTime +
                ", createBy='" + createBy + '\'' +
                ", lastModifiyBy='" + lastModifiyBy + '\'' +
                ", version=" + version +
                '}';
    }
}
