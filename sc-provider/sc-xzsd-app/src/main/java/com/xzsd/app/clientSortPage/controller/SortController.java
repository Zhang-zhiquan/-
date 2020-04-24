package com.xzsd.app.clientSortPage.controller;

import com.xzsd.app.clientHomePage.controller.HomePageController;
import com.xzsd.app.clientSortPage.service.SortService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 1:10
 */
@RestController
@RequestMapping(value = "/customer")
public class SortController {
    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);
    @Resource
    private SortService sortService;

    /**
     * 查找一级分类
     * @return
     */
    @RequestMapping(value = "showFirstClass")
    public AppResponse showFirstClass(){
        try{
            return sortService.findFirstClass();
        }catch (Exception e){
            logger.error("查询一级分类异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 展示二级分类商品
     * @param sortId
     * @return
     */
    @RequestMapping(value = "showSecondClass")
    public AppResponse showSecondClass(String sortId){
        try{
            return sortService.showSecondClass(sortId);
        }catch (Exception e){
            logger.error("查询二级分类异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
