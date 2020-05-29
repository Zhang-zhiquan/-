package com.xzsd.app.clientShoppingCart.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientShoppingCart.dao.CartDao;
import com.xzsd.app.clientShoppingCart.entity.*;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/20 9:37
 */
@Service
public class CartService {
    @Resource
    private CartDao cartDao;

    /**
     * 添加购物车
     * @param cartDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShoppingCart(CartDo cartDo){
        //校验库存是否还有
        if (cartDo.getGoodsAmount() > cartDao.findGoodsStock(cartDo.getGoodsId()).get("goodsStock")){
            return AppResponse.bizError("库存不足，请重新添加");
        }
        cartDo.setCartId(StringUtil.getCommonCode(2));
        cartDo.setCustomerId(SecurityUtils.getCurrentUserId());
        cartDo.setCreateBy(SecurityUtils.getCurrentUserId());
        cartDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
        int count = cartDao.addShoppingCart(cartDo);
        if (count != 0){
            return AppResponse.success("购物车添加成功");
        }else {
            return AppResponse.bizError("购物车添加失败");
        }
    }

    /**
     * 展示购物车
     * @return
     */
    public AppResponse showShoppingCart(){
        String currentUserId = SecurityUtils.getCurrentUserId();
        List<ShowCartVo> showCartVos = cartDao.showShoppingCart(currentUserId);
        if (showCartVos != null){
            return AppResponse.success("购物车查询成功",showCartVos);
        }else {
            return AppResponse.bizError("购物车查询失败");
        }
    }

    /**
     * 购物车商品数量修改
     * @param cartId
     * @param goodsAmount
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse alterGoodsNumber(String cartId,int goodsAmount){
        int count = cartDao.alterGoodsNumber(cartId, goodsAmount);
        if (count != 0){
            return AppResponse.success("商品数量修改成功");
        }else {
            return AppResponse.bizError("商品数量未修改");
        }
    }

    /**
     * 删除购物车
     * @param cartId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String cartId){
        List<String> cartIds = Arrays.asList(cartId.split(","));
        String customerId = SecurityUtils.getCurrentUserId();
        int count = cartDao.deleteShoppingCart(cartIds, customerId);
        if (count != 0){
            return AppResponse.success("购物车删除成功");
        }else {
            return AppResponse.bizError("购物车删除失败");
        }
    }

    /**
     * 从购物车下订单
     * @param cartDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse buyShoppingCart(CartDTO cartDTO){
        OrderDo orderDo = new OrderDo();
        //设置订单Id
        String orderId = StringUtil.getCommonCode(2);
        orderDo.setOrderId(orderId);
        //获取并设置门店Id
        Map<String, String> roleInvitationCode = cartDao.getRoleInvitationCode(SecurityUtils.getCurrentUserId());
        Map<String, String> storeId = cartDao.getStoreId(roleInvitationCode.get("invitationCode"));
        orderDo.setStoreId(storeId.get("storeId"));
        //设置订单总价
        orderDo.setOrderTotalPrice(cartDTO.getOrderTotalPrice());
        //获取并设置下单人基本信息
        String currentUserId = SecurityUtils.getCurrentUserId();
        Map<String, String> userMess = cartDao.getUserMess(currentUserId);
        orderDo.setCustomerId(currentUserId);
        orderDo.setShopingName(userMess.get("shoppingName"));
        orderDo.setShoppingPhone(userMess.get("shoppingPhone"));
        //创建订单
        int count = cartDao.addOrder(orderDo);
        if (count == 0){
            return AppResponse.bizError("下单失败");
        }
        //将订单下的商品详情加入订单详情表
        List<String> cartIdList = Arrays.asList(cartDTO.getCartId().split(","));
        List<GoodsDetailDTO> goods = cartDao.getGoods(cartIdList);
        for (int i = 0;i<goods.size();i++){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrdersId(StringUtil.getCommonCode(2));
            orderDTO.setOrderId(orderId);
            orderDTO.setUserId(goods.get(i).getCustomerId());
            orderDTO.setGoodsId(goods.get(i).getGoodsId());
            orderDTO.setGoodsName(goods.get(i).getGoodsName());
            orderDTO.setPurchaseNum(goods.get(i).getGoodsAmount());
            orderDTO.setTotalPrice(goods.get(i).getTotalPrice());
            orderDTO.setSale(goods.get(i).getGoodsSale());
            orderDTO.setPrice(goods.get(i).getGoodsCostprice());
            int cnnt = cartDao.addOrderDetails(orderDTO);
            if (cnnt == 0){
                return AppResponse.bizError("下单失败");
            }
        }
        //下单成功后删除购物车
        cartDao.deleteShoppingCart(cartIdList,SecurityUtils.getCurrentUserId());
        return AppResponse.success("下单成功",orderId);
    }

    /**
     * 直接购买下单
     * @param directOrderDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse directOrder(DirectOrderDTO directOrderDTO){
        //校验库存是否还有
        if (directOrderDTO.getPurchaseNum() > cartDao.findGoodsStock(directOrderDTO.getGoodsId()).get("goodsStock")){
            return AppResponse.bizError("库存不足，请重新添加");
        }
        OrderDo orderDo = new OrderDo();
        String orderId = StringUtil.getCommonCode(2);
        String currentUserId = SecurityUtils.getCurrentUserId();
        //设置订单编号
        orderDo.setOrderId(orderId);
        //设置购买总价
        BigDecimal sale = new BigDecimal((directOrderDTO.getPurchaseNum() * directOrderDTO.getGoodsSale()));
        double totalPrice = sale.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        orderDo.setOrderTotalPrice(totalPrice);
        //设置下单的门店
        Map<String, String> storeIdOfUserId = cartDao.getStoreIdOfUserId(currentUserId);
        orderDo.setStoreId(storeIdOfUserId.get("storeId"));
        //获取并设置下单人基本信息
        Map<String, String> userMess = cartDao.getUserMess(currentUserId);
        orderDo.setCustomerId(currentUserId);
        orderDo.setShopingName(userMess.get("shoppingName"));
        orderDo.setShoppingPhone(userMess.get("shoppingPhone"));
        //创建订单
        int count = cartDao.addOrder(orderDo);
        if (count == 0){
            return AppResponse.bizError("下单失败");
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrdersId(StringUtil.getCommonCode(2));
        orderDTO.setOrderId(orderId);
        orderDTO.setUserId(currentUserId);
        orderDTO.setPurchaseNum(directOrderDTO.getPurchaseNum());
        orderDTO.setTotalPrice(totalPrice);
        //设置订单详情商品信息
        GoodsDetailDTO goodsOfId = cartDao.getGoodsOfId(directOrderDTO.getGoodsId());
        orderDTO.setGoodsId(goodsOfId.getGoodsId());
        orderDTO.setGoodsName(goodsOfId.getGoodsName());
        orderDTO.setSale(goodsOfId.getGoodsSale());
        orderDTO.setPrice(goodsOfId.getGoodsCostprice());
        //添加到订单详细
        int i = cartDao.addOrderDetails(orderDTO);
        if (i == 0){
            return AppResponse.bizError("下单失败");
        }else {
            return AppResponse.success("下单成功");
        }
    }
}
