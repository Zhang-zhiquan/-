package com.xzsd.pc.orderManagement.controller;

import com.xzsd.pc.orderManagement.entity.OrderDTO;
import com.xzsd.pc.orderManagement.service.OrderService;
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
 * @Date 2020/4/16 14:55
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表
     * @param orderDTO
     * @return
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderDTO orderDTO){
        try{
            return orderService.listOrder(orderDTO);
        }catch (Exception e){
            logger.error("订单查询失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 修改订单状态
     * @param orderId
     * @param sgin
     * @return
     */
    @RequestMapping(value = "updateOrder")
    public AppResponse updateOrder(String orderId,String sgin){
        try{
            return orderService.updateOrder(orderId,sgin);
        }catch (Exception e){
            logger.error("订单修改状态失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    @RequestMapping(value = "findOrder")
    public AppResponse findOrder(String orderId){
        try{
            return orderService.findOrder(orderId);
        }catch (Exception e){
            logger.error("订单详情查询失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
}
