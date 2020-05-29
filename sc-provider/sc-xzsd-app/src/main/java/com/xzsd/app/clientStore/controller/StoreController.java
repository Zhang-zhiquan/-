package com.xzsd.app.clientStore.controller;

import com.xzsd.app.clientHomePage.controller.HomePageController;
import com.xzsd.app.clientSortPage.service.SortService;
import com.xzsd.app.clientStore.dao.StoreDao;
import com.xzsd.app.clientStore.service.StoreService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/23 11:52
 */
@RestController
@RequestMapping(value = "/shopowner")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Resource
    private StoreService storeService;

    /**
     * 获取店长信息
     * @return
     */
    @RequestMapping(value = "showShopowner")
    public AppResponse showShopowner(){
        try{
            return storeService.showShopowner();
        }catch (Exception e){
            logger.error("获取店长信息异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 获取门店的司机
     * @return
     */
    @RequestMapping(value = "showDriver")
    public AppResponse showDriver(){
        try{
            return storeService.showDriver();
        }catch (Exception e){
            logger.error("获取门店的司机异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 店长查看订单列表
     * @return
     */
    @RequestMapping(value = "showOrder")
    public AppResponse showOrder(int sign){
        try{
            return storeService.showOrder(sign);
        }catch (Exception e){
            logger.error("店长查看订单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "showOrderDetails")
    public AppResponse showOrderDetails(String orderId){
        try{
            return storeService.showOrderDetails(orderId);
        }catch (Exception e){
            logger.error("店长查看订单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "showAdrees")
    public AppResponse showAdrees(){
        try{
            AppResponse appResponse = storeService.showShopowner();
            Map<String,String> data = (Map<String,String>)appResponse.getData();
            data.remove("imagesUrl");
            data.remove("storeId");
            data.remove("invitationCode");
            data.remove("userName");
            return AppResponse.success("获取地址成功",data);
        }catch (Exception e){
            logger.error("店长查看订单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 更改订单状态
     * @param orderId
     * @param sign
     * @return
     */
    @RequestMapping(value = "alterOrderState")
    public AppResponse alterOrderState(String orderId,int sign){
        try{
            return storeService.alterOrderState(orderId,sign);
        }catch (Exception e){
            logger.error("店长更改订单状态异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
