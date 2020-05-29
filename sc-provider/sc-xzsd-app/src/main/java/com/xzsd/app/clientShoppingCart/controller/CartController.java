package com.xzsd.app.clientShoppingCart.controller;

import com.xzsd.app.clientShoppingCart.entity.CartDTO;
import com.xzsd.app.clientShoppingCart.entity.CartDo;
import com.xzsd.app.clientShoppingCart.entity.DirectOrderDTO;
import com.xzsd.app.clientShoppingCart.service.CartService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/20 9:42
 */
@RestController
@RequestMapping(value = "/customer")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    @Resource
    private CartService cartService;

    /**
     * 添加购物车
     * @param cartDo
     * @return
     */
    @RequestMapping(value = "addShoppingCart")
    public AppResponse addShoppingCart(CartDo cartDo){
        try{
            return cartService.addShoppingCart(cartDo);
        }catch (Exception e){
            logger.error("添加购物车异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 展示购物车
     * @return
     */
    @RequestMapping(value = "showShoppingCart")
    public AppResponse showShoppingCart(){
        try{
            return cartService.showShoppingCart();
        }catch (Exception e){
            logger.error("查询购物车异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 购物车商品数量修改
     * @param cartId
     * @param goodsAmount
     * @return
     */
    @RequestMapping(value = "alterGoodsNumber")
    public AppResponse alterGoodsNumber(String cartId,int goodsAmount){
        try{
            return cartService.alterGoodsNumber(cartId,goodsAmount);
        }catch (Exception e){
            logger.error("修改购物车商品数量异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车
     * @param cartId
     * @return
     */
    @RequestMapping(value = "deleteShoppingCart")
    public AppResponse deleteShoppingCart(String cartId){
        try{
            return cartService.deleteShoppingCart(cartId);
        }catch (Exception e){
            logger.error("删除购物车异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 从购物车下订单
     * @param cartDTO
     * @return
     */
    @RequestMapping(value = "buyShoppingCart")
    public AppResponse buyShoppingCart(CartDTO cartDTO){
        try{
            return cartService.buyShoppingCart(cartDTO);
        }catch (Exception e){
            logger.error("购物车下单异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 直接购买下单
     * @param directOrderDTO
     * @return
     */
    @RequestMapping(value = "directOrder")
    public AppResponse directOrder(DirectOrderDTO directOrderDTO){
        try{
            return cartService.directOrder(directOrderDTO);
        }catch (Exception e){
            logger.error("直接下单异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
