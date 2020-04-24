package com.xzsd.pc.hotGoodsManagement.controller;

import com.xzsd.pc.hotGoodsManagement.entity.HotGoodsDTO;
import com.xzsd.pc.hotGoodsManagement.entity.HotGoodsDo;
import com.xzsd.pc.hotGoodsManagement.service.HotGoodsService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/12 14:19
 */
@RestController
@RequestMapping(value = "/hotGoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);
    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * 添加热门商品
     * @param hotGoodsDo
     * @return
     */
    @RequestMapping(value = "addHotGoods")
    public AppResponse addHotGoods(HotGoodsDo hotGoodsDo){
        try{
            return hotGoodsService.addHotGoods(hotGoodsDo);
        }catch (Exception e){
            logger.error("热门商品添加失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品列表查询
     * @param hotGoodsDTO
     * @return
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsDTO hotGoodsDTO){
        try{
            return hotGoodsService.listHotGoods(hotGoodsDTO);
        }catch (Exception e){
            logger.error("热门商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门商品
     * @param hotGoodsId
     * @return
     */
    @RequestMapping("deleteHotGoods")
    public AppResponse deteleHotGoods(String hotGoodsId){
        try{
            return hotGoodsService.deteleHotGoods(hotGoodsId);
        }catch (Exception e){
            logger.error("热门商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查找热门商品展示数量
     * @return
     */
    @RequestMapping(value = "findHotGoodsNum")
    public AppResponse findHotGoodsNum(){
        try{
            return hotGoodsService.findHotGoodsNum();
        }catch (Exception e){
            logger.error("查看热门数量展示失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门展示数量
     * @param num
     * @return
     */
    @RequestMapping(value = "updateHotGoodsNum")
    public AppResponse updateHotGoodsNum(String num){
        try{
            return hotGoodsService.updateHotGoodsNum(num);
        }catch (Exception e){
            logger.error("修改热门数量展示失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "updateHotGoods")
    public AppResponse updateGoods(HotGoodsDo hotGoodsDo){
        try{
            return hotGoodsService.updateGoods(hotGoodsDo);
        }catch (Exception e){
            logger.error("修改热门失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
