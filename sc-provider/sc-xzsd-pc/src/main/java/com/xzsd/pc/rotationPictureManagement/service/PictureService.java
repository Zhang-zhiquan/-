package com.xzsd.pc.rotationPictureManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.rotationPictureManagement.dao.PictureDao;
import com.xzsd.pc.rotationPictureManagement.entity.GoodsVo;
import com.xzsd.pc.rotationPictureManagement.entity.PictureDo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName
 * @Description 轮播图service
 * @Author quan
 * @Date 2020/4/1 15:31
 */
@Service
public class PictureService {
    @Resource
    private PictureDao pictureDao;

    /**
     * 查询轮播图列表
     * @param pictureStatus
     * @param pageNum
     * @param pageSize
     * @return
     */
    public AppResponse picturelist(int pictureStatus, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<PictureDo> picturelists = pictureDao.pictureList(pictureStatus);
        PageInfo<PictureDo> pictureDoPageInfo = new PageInfo<>(picturelists);
        if (picturelists == null){
            return AppResponse.success("未查询到轮播图数据");
        }else {
            return AppResponse.success("轮播图查询成功",pictureDoPageInfo);
        }
    }

    /**
     * 添加轮播图
     * @param pictureDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addPicture(PictureDo pictureDo){
        if (pictureDao.accountSort(pictureDo.getPictureSort()) > 0){
            return AppResponse.bizError("轮播图排序已存在，请重新输入");
        }
        //判断轮播图商品是否已经存在
        if (pictureDao.accountGoodsId(pictureDo.getGoodsId()) > 0){
            return AppResponse.bizError("轮播图商品已存在，请重新输入");
        }

        int count = pictureDao.addPicture(pictureDo);
        if (count != 0){
            return AppResponse.success("轮播图添加成功");
        }else {
            return AppResponse.versionError("轮播图添加失败");
        }
    }

    /**
     * 删除轮播图
     * @param pictureId
     * @param currentUserId
     * @return
     */
    public AppResponse detelePicture(String pictureId,String currentUserId){
        List<String> pictureIdList = Arrays.asList(pictureId.split(","));
        int count = pictureDao.deletePicture(pictureIdList,currentUserId);
        if (count == 0){
            return AppResponse.notFound("未删除轮播图");
        }else {
            return AppResponse.success("删除成功");
        }
    }

    /**
     * 修改轮播图状态：0为禁用,1为启用
     * @param pictureId
     * @param status
     * @param currentUserId
     * @return
     */
    public AppResponse updatePictureStatus(String pictureId,String status,String currentUserId){
        List<String> pictureIdList = Arrays.asList(pictureId.split(","));
        int pictureStatus = Integer.valueOf(status);
        int count = pictureDao.updatePicture(pictureIdList, pictureStatus, currentUserId);
        if (count == 0){
            return AppResponse.notFound("轮播图状态未修改");
        }else {
            return AppResponse.success("轮播图状态修改成功");
        }
    }

    /**
     * 轮播图查询商品，
     * @param goodsId
     * @param goodsName
     * @return
     */
    public AppResponse findGoods(String goodsId,String goodsName){
        List<GoodsVo> goods = pictureDao.findGoods(goodsId, goodsName);
        if (goods != null){
            return AppResponse.success("查询成功",goods);
        }else{
            return AppResponse.bizError("未查询到数据");
        }
    }

}
