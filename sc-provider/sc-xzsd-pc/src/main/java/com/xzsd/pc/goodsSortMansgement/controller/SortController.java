package com.xzsd.pc.goodsSortMansgement.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsSortMansgement.entity.SortDo;
import com.xzsd.pc.goodsSortMansgement.servce.SortService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/4 11:05
 */
@RestController
@RequestMapping("/goodsSort")
public class SortController {
    private static final Logger logger = LoggerFactory.getLogger(SortController.class);
    @Resource
    private SortService sortService;

    /**
     * 新增商品分类
     * @param sortDo
     * @return
     */
    @RequestMapping(value = "addGoodsSort")
    public AppResponse addSort(SortDo sortDo){
        try{
            sortDo.setSortId(UUIDUtils.getUUID());
            sortDo.setCreateBy(SecurityUtils.getCurrentUserId());
            return sortService.addSort(sortDo);
        }catch (Exception e){
            logger.error("新增商品分类失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品一级目录
     * @return
     */
    @RequestMapping(value = "findFirstClass")
    public AppResponse findFirstClass(){
        try{
            return sortService.findFirstClass();
        }catch (Exception e){
            logger.error("查询一级商品失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品二级目录
     * @param parentId
     * @return
     */
    @RequestMapping(value = "findSecondClass")
    public AppResponse findSecondClass(String parentId){
        try{
            return sortService.findSecondClass(parentId);
        }catch (Exception e){
            logger.error("查询二级商品失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品分类
     * @param sortDo
     * @return
     */
    @RequestMapping(value = "updateGoodsSort")
    public AppResponse updateGoodsSort(SortDo sortDo){
        try{
            return sortService.updateSort(sortDo);
        }catch (Exception e){
            logger.error("修改商品分类失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     * @param sortId
     * @return
     */
    @RequestMapping(value = "deleteGoodsSort")
    public AppResponse deleteGoodsSort(String sortId){
        try{
            return sortService.deteleSort(sortId);
        }catch (Exception e){
            logger.error("删除商品分类失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查看商品分类详情
     * @param sortId
     * @return
     */
    @RequestMapping(value = "findGoodsSort")
    public AppResponse findGoodsSort(String sortId){
        try{
            return sortService.findSort(sortId);
        }catch (Exception e){
            logger.error("查询商品分类失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
