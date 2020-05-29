package com.xzsd.app.clientOrder.controller;

import com.xzsd.app.clientHomePage.controller.HomePageController;
import com.xzsd.app.clientOrder.entity.GoodsEvaluateDo;
import com.xzsd.app.clientOrder.service.OrderService;
import com.xzsd.app.clientSortPage.service.SortService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/21 16:19
 */
@RestController
@RequestMapping(value = "/customer")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;

    /**
     * 展示订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "showOrderDetails")
    public AppResponse showOrderDetails(String orderId){
        try{
            return orderService.showOrderDetails(orderId);
        }catch (Exception e){
            logger.error("订单查询异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *展示订单列表
     * @param sign
     * @return
     */
    @RequestMapping(value = "showList")
    public AppResponse orderList(int sign){
        try{
            return orderService.orderList(sign);
        }catch (Exception e){
            logger.error("订单列表查询异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 获取门店地址
     * @param
     * @return
     */
    @RequestMapping(value = "orderAdress")
    public AppResponse showOrderDetails(){
        try{
            return orderService.getLocation();
        }catch (Exception e){
            logger.error("查询门店地址异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 添加商品评价
     * @param evaluate
     * @return
     */
    @RequestMapping(value = "evaluateGoods")
    @ResponseBody
    public AppResponse evaluateGoods(@RequestBody Map<String,Object> evaluate){
        try{
            return orderService.evaluateGoods(evaluate);
        }catch (Exception e){
            logger.error("添加评价异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 展示商品评价
     * @param goodsId
     * @param sign
     * @return
     */
    @RequestMapping(value = "showEvaluateGoods")
    public AppResponse showEvaluateGoods(String goodsId,int sign){
        try{
            return orderService.showEvaluateGoods(goodsId,sign);
        }catch (Exception e){
            logger.error("查询评价异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 顾客修改邀请码
     * @param invitationCode
     * @return
     */
    @RequestMapping(value = "alterInvitationCode")
    public AppResponse alterInvitationCode(String invitationCode){
        try{
            return orderService.alterInvitationCode(invitationCode);
        }catch (Exception e){
            logger.error("修改邀请码异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改密码
     * @param originalPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "alterPassword")
    public AppResponse alterPassword(String originalPassword,String newPassword){
        try{
            return orderService.alterPassword(originalPassword,newPassword);
        }catch (Exception e){
            logger.error("修改密码异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 获取用户详情
     * @return
     */
    @RequestMapping(value = "customerDetails")
    public AppResponse customerDetails(){
        try{
            return orderService.customerDetails();
        }catch (Exception e){
            logger.error("获取用户信息异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "updateOrderState")
    public AppResponse updateOrderState(String orderId){
        try{
            return orderService.updateOrderState(orderId);
        }catch (Exception e){
            logger.error("取消订单异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
