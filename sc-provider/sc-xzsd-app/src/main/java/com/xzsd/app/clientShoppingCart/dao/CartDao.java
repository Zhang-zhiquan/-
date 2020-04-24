package com.xzsd.app.clientShoppingCart.dao;

import com.xzsd.app.clientShoppingCart.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 19:56
 */
@Mapper
public interface CartDao {
    /**
     *添加购物车
     * @param cartDo
     * @return
     */
    public int addShoppingCart(CartDo cartDo);

    /**
     * 展示购物车
     * @param currentUserId
     * @return
     */
    public List<ShowCartVo> showShoppingCart(@Param("currentUserId") String currentUserId);

    /**
     * 修改购物车商品数量
     * @param cartId
     * @param goodsAmount
     * @return
     */
    public int alterGoodsNumber(@Param("cartId") String cartId,@Param("goodsAmount") int goodsAmount);

    /**
     * 删除购物车
     * @param cartId
     * @param customerId
     * @return
     */
    public int deleteShoppingCart(@Param("cartId") List<String> cartId,@Param("customerId") String customerId);

    /**
     * 获取门店Id
     * @param invitationCode
     * @return
     */
    public Map<String,String> getStoreId(@Param("invitationCode") String invitationCode);

    /**
     * 获取当前登录人信息
     * @param currentUserId
     * @return
     */
    public Map<String,String> getUserMess(@Param("currentUserId") String currentUserId);

    /**
     * 加入订单
     * @param orderDo
     * @return
     */
    public int addOrder(OrderDo orderDo);

    /**
     * 根据购物车Id获取商品详情
     * @param cartId
     * @return
     */
    public List<GoodsDetailDTO> getGoods(@Param("cartId") List<String> cartId);

    /**
     * 添加到订单详情表
     * @param orderDTO
     * @return
     */
    public int addOrderDetails(OrderDTO orderDTO);
}
