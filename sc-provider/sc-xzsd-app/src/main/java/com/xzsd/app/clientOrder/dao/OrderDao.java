package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.GoodsEvaluateDo;
import com.xzsd.app.clientOrder.entity.GoodsEvaluateVo;
import com.xzsd.app.clientOrder.entity.OrderListVo;
import com.xzsd.app.clientOrder.entity.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/21 15:37
 */
@Mapper
public interface OrderDao {
    /**
     * 获取邀请码
     * @param userId
     * @return
     */
    public Map<String,String> getRoleInvitationCode(String userId);

    /**
     * 获取店长邀请码
     * @param userId
     * @return
     */
    public Map<String,String> getInvitationCodeForShopowner(String userId);

    /**
     * 展示订单列表
     * @param currentUserId
     * @param sign
     * @return
     */
    public List<OrderListVo> orderList(@Param("currentUserId") String currentUserId,@Param("sign") int sign);
    /**
     * 展示订单详情
     * @param
     * @return
     */
    public List<OrderVo> showOrderDetails(String orderId);

    /**
     * 获取门店地址
     * @param invitationCode
     * @return
     */
    public Map<String,String> getLocation(String invitationCode);

    /**
     *添加商品评价
     * @param goodsEvaluateDo
     * @return
     */
    public int evaluateGoods(GoodsEvaluateDo goodsEvaluateDo);

    /**
     * 修改商品评价状态
     * @param goodsId
     * @return
     */
    public int updateGoodsEvaluate(@Param("goodsId") String goodsId,@Param("orderId") String orderId);

    /**
     * 统计订单下的商品是否评价完
     * @param orderId
     * @return
     */
    public int accoutGoodsEvaluate(String orderId);

    /**
     * 修改订单状态为已完成已评价
     * @param orderId
     * @return
     */
    public int updateGoodsOrderState(String orderId);
    /**
     * 展示商品评价
     * @param goodsId
     * @param sign
     * @return
     */
    public List<GoodsEvaluateVo> showEvaluateGoods(@Param("goodsId") String goodsId,@Param("sign") int sign);

    /**
     * 查看邀请码是否存在
     * @param invitationCode
     * @return
     */
    public int findInvitationCode(String invitationCode);

    /**
     * 顾客修改邀请码
     * @param invitationCode
     * @param customerId
     * @return
     */
    public int updateUserInvitationCode(@Param("invitationCode") String invitationCode,@Param("customerId") String customerId);

    /**
     * 获取用户原密码
     * @param customerId
     * @return
     */
    public Map<String,String> findPassword(@Param("customerId") String customerId);

    /**
     * 修改密码
     * @param newPassword
     * @param customerId
     * @return
     */
    public int updatePassword(@Param("newPassword") String newPassword,@Param("customerId") String customerId);

    /**
     * 获取用户详情
     * @param customerId
     * @return
     */
    public Map<String,String> customerDetails(String customerId);

    /**
     * 查询当前登录人角色
     * @param userId
     * @return
     */
    public Map<String,Integer> findCurrentRole(String userId);

    /**
     * 修改订单状态为已取消
     * @param orderId
     * @return
     */
    public int updateOrderState(String orderId);
}
