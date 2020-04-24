package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.GoodsEvaluateDo;
import com.xzsd.app.clientOrder.entity.GoodsEvaluateVo;
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
     * 展示订单详情
     * @param currentUserId
     * @return
     */
    public List<OrderVo> showOrder(@Param("currentUserId") String currentUserId,@Param("sign") int sign);

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
    public int updateGoodsEvaluate(@Param("goodsId") String goodsId,@Param("currentUserId") String currentUserId);

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
}
