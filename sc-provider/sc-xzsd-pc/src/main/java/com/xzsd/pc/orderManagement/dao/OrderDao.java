package com.xzsd.pc.orderManagement.dao;

import com.xzsd.pc.orderManagement.entity.OrderDTO;
import com.xzsd.pc.orderManagement.entity.OrderDetailVo;
import com.xzsd.pc.orderManagement.entity.OrderDo;
import com.xzsd.pc.orderManagement.entity.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/16 10:26
 */
@Mapper
public interface OrderDao {
    /**
     *查询订单列表
     * @param orderDTO
     * @return
     */
    public List<OrderVo> listOrder(OrderDTO orderDTO);

    /**
     * 获取当前登陆人的门店Id
     * @param currentUserId
     * @return
     */
    public Map<String,String> findUserId(String currentUserId);

    /**
     * 修改订单状态
     * * @param orderId
     * @param sign
     * @return
     */
    public int updateOrder(@Param("orderId") List<String> orderId, @Param("sign") int sign);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    public List<OrderDetailVo> findOrder(String orderId);

    /**
     * 查询当前用户角色
     * @param currentUserId
     * @return
     */
    Map<String,Integer> findCurrentRole(String currentUserId);

}
