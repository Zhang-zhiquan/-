package com.xzsd.pc.orderManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.orderManagement.dao.OrderDao;
import com.xzsd.pc.orderManagement.entity.OrderDTO;
import com.xzsd.pc.orderManagement.entity.OrderDetailVo;
import com.xzsd.pc.orderManagement.entity.OrderVo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/16 14:03
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 查询订单列表
     * @param orderDTO
     * @return
     */
    public AppResponse listOrder(OrderDTO orderDTO){
        //管理员权限查询
        if (orderDTO.getRole() == 1){
            PageHelper.startPage(orderDTO.getPageNum(),orderDTO.getPageSize());
            List<OrderVo> orderDos = orderDao.listOrder(orderDTO);
            PageInfo<OrderVo> orderDoPageInfo = new PageInfo<>(orderDos);
            if (orderDos != null){
                return AppResponse.success("查询成功",orderDoPageInfo);
            }else {
                return AppResponse.bizError("查询失败");
            }
        }
        //店长权限
        else {
            //获取当前登陆人Id
            String currentUserId = SecurityUtils.getCurrentUserId();
            //获取当前登陆人的门店Id
            Map<String, String> storeId = orderDao.findUserId(currentUserId);
            //设置登录店长的订单
            orderDTO.setStoreId(storeId.get(storeId));
            PageHelper.startPage(orderDTO.getPageNum(),orderDTO.getPageSize());
            //查找当前登陆店长的订单
            List<OrderVo> orderDov = orderDao.listOrder(orderDTO);
            PageInfo<OrderVo> orderDoPageInfos = new PageInfo<>(orderDov);
            if (orderDov != null){
                return AppResponse.success("查询成功",orderDoPageInfos);
            }else {
                return AppResponse.bizError("查询失败");
            }
        }
    }

    /**
     *删除订单
     * @param orderId
     * @param sign
     * @return
     */
    public AppResponse updateOrder(String orderId,String sign){
        List<String> orderIdList = Arrays.asList(orderId.split(","));
        int count = orderDao.updateOrder(orderIdList, Integer.valueOf(sign));
        if (count != 0){
            return AppResponse.success("订单修改成功");
        }else {
            return AppResponse.success("订单修改失败");
        }
    }

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    public AppResponse findOrder(String orderId){
        List<OrderDetailVo> orders = orderDao.findOrder(orderId);
        if (orders != null){
            return AppResponse.success("订单详情查询成功",orders);
        }else {
            return AppResponse.success("订单详情查询失败");
        }
    }

}
