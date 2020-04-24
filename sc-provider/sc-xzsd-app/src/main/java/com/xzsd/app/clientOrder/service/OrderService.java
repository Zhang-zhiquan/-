package com.xzsd.app.clientOrder.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import com.xzsd.app.clientOrder.dao.OrderDao;
import com.xzsd.app.clientOrder.entity.GoodsEvaluateDo;
import com.xzsd.app.clientOrder.entity.GoodsEvaluateVo;
import com.xzsd.app.clientOrder.entity.OrderVo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 展示订单详情
     * @param sign
     * @return
     */
    public AppResponse showOrder(String sign){
        String currentUserId = SecurityUtils.getCurrentUserId();
        List<OrderVo> orderVos = orderDao.showOrder(currentUserId,Integer.valueOf(sign));
        if (orderVos == null){
            return AppResponse.bizError("未查找到订单");
        }else {
            return AppResponse.success("订单查找成功",orderVos);
        }
    }

    /**
     * 获取门店地址
     * @param invitationCode
     * @return
     */
    public AppResponse getLocation(String invitationCode){
        Map<String, String> location = orderDao.getLocation(invitationCode);
        Map<String, String> locationMap = new HashMap<>();
        String storeName = location.get("storeName");
        String detailedAddress = null;
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
     * @param goodsEvaluateDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse evaluateGoods(GoodsEvaluateDo goodsEvaluateDo){
        String currentUserId = SecurityUtils.getCurrentUserId();
        String EvaluateId = StringUtil.getCommonCode(2);
        goodsEvaluateDo.setEvaluateId(EvaluateId);
        goodsEvaluateDo.setCustomerId(currentUserId);
        int count = orderDao.evaluateGoods(goodsEvaluateDo);
        int i = orderDao.updateGoodsEvaluate(goodsEvaluateDo.getGoodsId(), currentUserId);
        if (count == 0 || i == 0){
            return AppResponse.bizError("评价未成功");
        }else {
            return AppResponse.success("评价成功");
        }
    }

    /**
     * 展示商品评价
     * @param goodsId
     * @param sign
     * @return
     */
    public AppResponse showEvaluateGoods(String goodsId,String sign){
        List<GoodsEvaluateVo> goodsEvaluateVos = orderDao.showEvaluateGoods(goodsId, Integer.parseInt(sign));
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
}
