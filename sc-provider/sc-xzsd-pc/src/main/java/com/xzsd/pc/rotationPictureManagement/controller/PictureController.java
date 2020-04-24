package com.xzsd.pc.rotationPictureManagement.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.rotationPictureManagement.entity.PictureDo;
import com.xzsd.pc.rotationPictureManagement.service.PictureService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/1 15:46
 */
@RestController
@RequestMapping("/rotation")
public class PictureController {
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Resource
    private PictureService pictureService;

    /**
     * 查询轮播图列表
     * @param pictureStatus
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "listPicture")
    public AppResponse pictureController(@RequestParam("pictureStatus") int pictureStatus,
                                         @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        try{
            AppResponse picturelist = pictureService.picturelist(pictureStatus, pageNum, pageSize);
            return picturelist;
        }catch (Exception e){
            logger.error("查询轮播图失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 添加轮播图
     * @param pictureDo
     * @return
     */
    @RequestMapping(value = "addPicture")
    public AppResponse addPicture(PictureDo pictureDo){
        try{
            pictureDo.setPictureId(UUIDUtils.getUUID());
            pictureDo.setCreateBy(SecurityUtils.getCurrentUserId());
            return pictureService.addPicture(pictureDo);
        }catch (Exception e){
            logger.error("添加轮播图失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 删除轮播图
     * @param pictureId
     * @return
     */
    @RequestMapping(value = "detelePicture")
    public AppResponse detelePicture(String pictureId){
        try {
            String currentUserId = SecurityUtils.getCurrentUserId();
            return pictureService.detelePicture(pictureId, currentUserId);
        }catch (Exception e){
            logger.error("删除轮播图失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 修改轮播图状态：0为禁用,1为启用
     * @param pictureId
     * @param status
     * @return
     */
    @RequestMapping(value = "updatePictureStatus")
    public AppResponse updatePictureStatus(String pictureId,String status){
        try{
            String currentUserId = SecurityUtils.getCurrentUserId();
            return pictureService.updatePictureStatus(pictureId,status,currentUserId);
        }catch (Exception e){
            logger.error("轮播图状态修改失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    @RequestMapping(value = "findGoods")
    public AppResponse findGoods(String goodsId,String goodsName){
        try{
            return pictureService.findGoods(goodsId,goodsName);
        }catch (Exception e){
            logger.error("查找商品失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
}
