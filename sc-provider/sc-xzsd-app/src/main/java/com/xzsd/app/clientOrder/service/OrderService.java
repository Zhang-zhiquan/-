package com.xzsd.app.clientOrder.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import com.xzsd.app.clientOrder.dao.OrderDao;
import com.xzsd.app.clientOrder.entity.*;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/21 15:57
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 展示订单列表
     * @param sign
     * @return
     */
    public AppResponse orderList(int sign){
        List<OrderListVo> orderListVos = orderDao.orderList(SecurityUtils.getCurrentUserId(), sign);
        //计算订单下的商品总数量
        for (OrderListVo order : orderListVos){
            int totall = 0;
            List<OrderMess> orderMess = order.getOrderList();
            for (OrderMess orderMess1 : orderMess){
                totall += orderMess1.getPurchaseNum();
            }
            order.setTotall(totall);
        }
        if (orderListVos == null){
            return AppResponse.bizError("未查找到订单");
        }else {
            return AppResponse.success("订单查找成功",orderListVos);
        }

    }

    /**
     * 展示订单详情
     * @param orderId
     * @return
     */
    public AppResponse showOrderDetails(String orderId){
        List<OrderVo> orderVos = orderDao.showOrderDetails(orderId);
        //计算订单下的商品总数量
        for (OrderVo order : orderVos){
            int totall = 0;
            List<OrderMess> orderList = order.getOrderList();
            for (OrderMess orderMess1 : orderList){
                totall += orderMess1.getPurchaseNum();
            }
            order.setTotall(totall);
        }
        if (orderVos == null){
            return AppResponse.bizError("未查找到订单");
        }else {
            return AppResponse.success("订单查找成功",orderVos);
        }
    }

    /**
     * 获取门店地址
     * @param
     * @return
     */
    public AppResponse getLocation(){
        Map<String, Integer> currentRole = orderDao.findCurrentRole(SecurityUtils.getCurrentUserId());
        Map<String, String> roleInvitationCode = new HashMap<>();
        //获取店长邀请码
        if (currentRole.get("role") == 2){
            roleInvitationCode = orderDao.getInvitationCodeForShopowner(SecurityUtils.getCurrentUserId());
        }
        //获取顾客邀请码
        else {
            roleInvitationCode = orderDao.getRoleInvitationCode(SecurityUtils.getCurrentUserId());
        }
        //根据邀请码获取地址
        Map<String, String> location = orderDao.getLocation(roleInvitationCode.get("invitationCode"));
        Map<String, String> locationMap = new HashMap<>();
        String storeName = location.get("storeName");
        String detailedAddress = null;
        //省市名一样，去掉省名
        if (location.get("province").equals(location.get("city"))){
            detailedAddress = location.get("city") + location.get("location") + location.get("storeAddress");
        }else {
            detailedAddress = location.get("province") + location.get("city") + location.get("location") + location.get("storeAddress");
        }
        locationMap.put("detailedAddress",detailedAddress);
        locationMap.put("storeName",storeName);
        return AppResponse.success("返回地址",locationMap);
    }

    /**
     * 添加商品评价
     * @param evaluate
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse evaluateGoods(Map<String,Object> evaluate){
        String orderId = (String)evaluate.get("orderId");
        List<List<Map<String,Object>>> evaluateList = (ArrayList)evaluate.get("evaluateList");
        for (List<Map<String,Object>> eva : evaluateList){
            for (Map<String,Object> evas : eva){
                GoodsEvaluateDo goodsEvaluateDo = new GoodsEvaluateDo();
                goodsEvaluateDo.setEvaluateId(StringUtil.getCommonCode(2));
                goodsEvaluateDo.setCustomerId(SecurityUtils.getCurrentUserId());
                goodsEvaluateDo.setAppraiseInfo((String)evas.get("appraiseInfo"));
                goodsEvaluateDo.setGoodsId((String)evas.get("goodsId"));
                goodsEvaluateDo.setOrderId(orderId);
                goodsEvaluateDo.setStarLevel((int)evas.get("starLevel"));
                //添加商品评价
                int count = orderDao.evaluateGoods(goodsEvaluateDo);
                if (count ==0){
                    return AppResponse.bizError("评价未成功");
                }
                //修改商品评价状态
                int i = orderDao.updateGoodsEvaluate(goodsEvaluateDo.getGoodsId(), goodsEvaluateDo.getOrderId());
            }

        }
        //修改订单状态为已完成已评价
        if (orderDao.accoutGoodsEvaluate(orderId) == 0){
            orderDao.updateGoodsOrderState(orderId);
        }
        return AppResponse.success("评价成功");


//        String currentUserId = SecurityUtils.getCurrentUserId();
//        String EvaluateId = StringUtil.getCommonCode(2);
//        goodsEvaluateDo.setEvaluateId(EvaluateId);
//        goodsEvaluateDo.setCustomerId(currentUserId);
//        //添加商品评价
//        int count = orderDao.evaluateGoods(goodsEvaluateDo);
//        //修改商品评价状态
//        int i = orderDao.updateGoodsEvaluate(goodsEvaluateDo.getGoodsId(), goodsEvaluateDo.getOrderId());
//        //修改订单状态为已完成已评价
//        if (orderDao.accoutGoodsEvaluate(goodsEvaluateDo.getOrderId()) == 0){
//            orderDao.updateGoodsOrderState(goodsEvaluateDo.getOrderId());
//        }
//        if (count == 0 || i == 0){
//            return AppResponse.bizError("评价未成功");
//        }else {
//            return AppResponse.success("评价成功");
//        }
    }

    /**
     * 展示商品评价
     * @param goodsId
     * @param sign
     * @return
     */
    public AppResponse showEvaluateGoods(String goodsId,int sign){
        List<GoodsEvaluateVo> goodsEvaluateVos = orderDao.showEvaluateGoods(goodsId,sign);
        if (goodsEvaluateVos == null){
            return AppResponse.bizError("未有评价");
        }else {
            return AppResponse.success("查询评价成功",goodsEvaluateVos);
        }
    }

    /**
     * 顾客修改邀请码
     * @param invitationCode
     * @return
     */
    public AppResponse alterInvitationCode(String invitationCode){
        int count = orderDao.findInvitationCode(invitationCode);
        if (count == 0){
            return AppResponse.bizError("邀请码不存在，重新输入");
        }
        int i = orderDao.updateUserInvitationCode(invitationCode, SecurityUtils.getCurrentUserId());
        if (i == 0) {

            return AppResponse.bizError("邀请码未修改成功");
        }else {
            return AppResponse.success("邀请码修改成功");
        }
    }

    /**
     * 修改密码
     * @param originalPassword
     * @param newPassword
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse alterPassword(String originalPassword,String newPassword){
        //校验密码是否正确
        Map<String, String> password = orderDao.findPassword(SecurityUtils.getCurrentUserId());
        String passw = password.get("password");
        if (!PasswordUtils.Password(originalPassword,passw)){
            return AppResponse.bizError("原密码错误，重新输入");
        }
        //密码加密
        String pw = PasswordUtils.generatePassword(newPassword);
        int i = orderDao.updatePassword(pw, SecurityUtils.getCurrentUserId());
        if (i == 0){
            return AppResponse.bizError("密码未修改成功");
        }else {
            return AppResponse.success("密码修改成功");
        }
    }

    /**
     * 获取用户详情
     * @return
     */
    public AppResponse customerDetails(){
        Map<String, String> userMap = orderDao.customerDetails(SecurityUtils.getCurrentUserId());
        if (userMap != null){
            return AppResponse.success("获取成功",userMap);
        }else {
            return AppResponse.bizError("获取失败");
        }
    }

    /**
     * 修改订单状态为已取消
     * @param orderId
     * @return
     */
    public AppResponse updateOrderState(String orderId){
        int i = orderDao.updateOrderState(orderId);
        if (i == 0){
            return AppResponse.bizError("订单未取消成功");
        } else {
            return AppResponse.success("订单取消成功");
        }
    }
}
