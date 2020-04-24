package com.xzsd.app.clientHomePage.controller;

import com.xzsd.app.clientHomePage.entity.RegisterDo;
import com.xzsd.app.clientHomePage.service.HomePageService;
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
 * @Date 2020/4/17 15:33
 */
@RestController
@RequestMapping(value = "/customer")
public class HomePageController {
    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);
    @Resource
    private HomePageService homePageService;

    /**
     * 获取登录用户角色
     * @param userId
     * @return
     */
    @RequestMapping(value = "getRoleInvitationCode")
    public AppResponse getRole(String userId){
        try{
            return homePageService.getRole(userId);
        }catch (Exception e){
            logger.error("查询客户角色和邀请码异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "registerCustomer")
    public AppResponse registerCustomer(RegisterDo registerDo){
        try{
            return homePageService.registerCustomer(registerDo);
        }catch (Exception e){
            logger.error("注册异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "showRotationChart")
    public AppResponse showRotationChart(){
        try{
            return homePageService.showRotationChart();
        }catch (Exception e){
            logger.error("查询轮播图异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "showHotGoods")
    public AppResponse showHotGoods(){
        try{
            return homePageService.showHotGoods();
        }catch (Exception e){
            logger.error("查询热门商品异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "showGoods")
    public AppResponse showGoods(String goodsId,String invitationCode){
        try{
            return homePageService.showGoods(goodsId,invitationCode);
        }catch (Exception e){
            logger.error("查询热门商品异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
