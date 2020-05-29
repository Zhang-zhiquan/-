package com.xzsd.app.clientStore.dao;

import com.xzsd.app.clientOrder.entity.OrderMess;
import com.xzsd.app.clientStore.entity.OrderDetails;
import com.xzsd.app.clientStore.entity.OrderMessVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/23 11:25
 */
@Mapper
public interface StoreDao {
    /**
     * 获取店长信息
     * @param currentUserId
     * @return
     */
    public Map<String,String> showShopowner(@Param("currentUserId") String currentUserId);

    /**
     * 获取门店的司机
     * @param currentUserId
     * @return
     */
    public List<Map<String,String>> showDriver(String currentUserId);

    /**
     * 店长查看订单列表
     * @param storeId
     * @return
     */
    public List<OrderMessVo> showOrder(@Param("storeId") String storeId,@Param("sign") int sign);

    /**
     * 获取登录人门店Id
     * @param currentUserId
     * @return
     */
    public Map<String,String> getStoreId(String currentUserId);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    public List<OrderDetails> showOrderDetails(String orderId);

    /**
     * 更改订单状态
     * @param orderId
     * @param sign
     * @return
     */
    public int alterOrderState(@Param("orderId") String orderId,@Param("sign") int sign);

    /**
     * 获取订单状态
     * @param orderId
     * @return
     */
    public Map<String,String> getOrderState(String orderId);
}
