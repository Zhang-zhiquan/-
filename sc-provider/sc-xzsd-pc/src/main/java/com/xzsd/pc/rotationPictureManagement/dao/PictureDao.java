package com.xzsd.pc.rotationPictureManagement.dao;

import com.xzsd.pc.rotationPictureManagement.entity.GoodsVo;
import com.xzsd.pc.rotationPictureManagement.entity.PictureDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/31 21:29
 */
@Mapper
public interface PictureDao {

    /**
     * 查询轮播图列表
     * @param pictureStatus
     * @return
     */
     List<PictureDo> pictureList(@Param("pictureStatus") int pictureStatus);

    /**
     *添加轮播图
     * @param pictureDo
     * @return
     */
    public int addPicture(PictureDo pictureDo);

    /**
     * 判断排序是否已经存在
     * @param pictureSort
     * @return
     */
    public int accountSort(@Param("pictureSort") int pictureSort);

    /**
     * 判断商品是否已经存在
     * @param goodsId
     * @return
     */
    public int accountGoodsId(@Param("goodsId") String goodsId);

    /**
     * 删除轮播图
     * @param pictureId
     * @param currentUserId
     * @return
     */
    public int deletePicture(@Param("pictureId") List<String> pictureId, @Param("currentUserId") String currentUserId);

    /**
     * 修改轮播图状态：0为禁用,1为启用
     * @param pictureIdList
     * @param pictureStatus
     * @param currentUserId
     * @return
     */
    public int updatePicture(@Param("pictureIdList") List<String> pictureIdList, @Param("pictureStatus") int pictureStatus, @Param("currentUserId") String currentUserId);

    /**
     * 查找商品
     * @param goodsId 商品Id
     * @param goodsName 商品名称
     * @return
     */
    public List<GoodsVo> findGoods(@Param("goodsId") String goodsId,@Param("goodsName") String goodsName);
}
