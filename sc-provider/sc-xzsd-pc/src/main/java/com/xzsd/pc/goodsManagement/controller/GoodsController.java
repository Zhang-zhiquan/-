package com.xzsd.pc.goodsManagement.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsManagement.entity.GoodsDo;
import com.xzsd.pc.goodsManagement.service.GoodsService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/29 14:48
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;

    /**
     * 查询商品列表（模糊查询）
     * @param goodsDo
     * @return
     */
    @RequestMapping(value = "goodslist")
    public AppResponse goodslist(GoodsDo goodsDo){
        try{
            return goodsService.goodsList(goodsDo);
        }catch (Exception e){
            logger.error("查询商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增商品
     * @param goodsDo
     * @return
     */
    @PostMapping("addgoods")
    public AppResponse addGoods(GoodsDo goodsDo){
        try{
            goodsDo.setCreateBy(SecurityUtils.getCurrentUserId());
            goodsDo.setGoodsId(UUIDUtils.getUUID());
            return goodsService.addList(goodsDo);
        }catch (Exception e){
            logger.error("商品添加失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查看商品详情
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "findGoods")
    public AppResponse findGoods(String goodsId){
        try{
            AppResponse appResponse = goodsService.findGoods(goodsId);
            return appResponse;
        }catch (Exception e){
            logger.error("商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

//    /**
//     *修改商品信息
//     * @param goodsDo
//     * @return
//     */
//    @PostMapping("updategoods")
//    public AppResponse updateGoods(GoodsDo goodsDo){
//        try {
//            String currentUserId = AuthUtils.getCurrentUserId();
//            AppResponse appResponse = goodsService.updateGoods(goodsDo, currentUserId);
//            return appResponse;
//        }catch (Exception e){
//            logger.error("商品修改失败",e);
//            System.out.println(e.toString());
//            throw e;
//        }
//    }

    /**
     * 修改商品信息
     * @param goodsDo
     * @return
     */
    @RequestMapping(value = "updategoods")
    public AppResponse updateGoods(GoodsDo goodsDo){
        try {
            goodsDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = goodsService.updateGoods(goodsDo);
            return appResponse;
        }catch (Exception e){
            logger.error("商品修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     * @param goodsId
     * @return
     */
    @PostMapping("detelegoods")
    public AppResponse updateGoods(String goodsId){
        List<String> goodsid = Arrays.asList(goodsId.split(","));
        String currentUserId = SecurityUtils.getCurrentUserId();
        AppResponse appResponse = goodsService.deteleGoods(goodsid, currentUserId);
        return appResponse;
    }

}
