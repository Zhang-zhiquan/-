package com.xzsd.app.clientHomePage.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientHomePage.dao.HomePageDao;
import com.xzsd.app.clientHomePage.entity.HotGoodsVo;
import com.xzsd.app.clientHomePage.entity.RegisterDo;
import com.xzsd.app.clientHomePage.entity.RotationVo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/17 16:02
 */
@Service
public class HomePageService {
    @Resource
    private HomePageDao homePageDao;

    /**
     * 获取登录用户角色和邀请码
     * @param userId
     * @return
     */
    public AppResponse getRole(String userId){
        Map<String, Object> roleInvitationCode = homePageDao.getRoleInvitationCode(userId);
        return AppResponse.success("角色和邀请码获取成功",roleInvitationCode);
    }

    /**
     * 客户注册
     * @param registerDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse registerCustomer(RegisterDo registerDo){
        //密码加密
        registerDo.setPassword(PasswordUtils.generatePassword(registerDo.getPassword()));
        String userId = StringUtil.getCommonCode(2);
        registerDo.setUserId(userId);
        //校验账号是否已经存在
        if (homePageDao.countUserAcct(registerDo.getUserAccount()) > 0){
            return AppResponse.bizError("账号已存在，请重新输入");
        }
        //顾客信息存入用户表
        int count = homePageDao.registerForUser(registerDo);
        if (count == 0){
            return AppResponse.bizError("用户注册失败，请重新注册");
        }
        //顾客信息存入顾客表
        String customerId = StringUtil.getCommonCode(2);
        registerDo.setCustomerId(customerId);
        int i = homePageDao.registerForCustomer(registerDo);
        if (i ==0){
            return AppResponse.bizError("用户注册失败，请重新注册");
        }
        return AppResponse.success("注册成功");
    }

    /**
     * 查询轮播图
     * @return
     */
    public AppResponse showRotationChart(){
        List<RotationVo> rotationVos = homePageDao.showRotationChart();
        if (rotationVos != null){
            return AppResponse.success("轮播图查询成功",rotationVos);
        }else {
            return AppResponse.bizError("轮播图查询失败");
        }
    }

    /**
     * 展示热门商品
     * @return
     */
    public AppResponse showHotGoods(){
        //获取热门商品展示数量
        Map<String, Integer> hotGoods = homePageDao.findHotGoodsNum();
        List<HotGoodsVo> hotGoodsVos = homePageDao.showHotGoods(hotGoods.get("hotGoodsNum"));
        if (hotGoodsVos != null){
            return AppResponse.success("热门商品查询成功",hotGoodsVos);
        }else {
            return AppResponse.bizError("热门商品查询失败");
        }
    }

    /**
     * 获取商品详情信息
     * @param goodsId
     * @param invitationCode
     * @return
     */
    public AppResponse showGoods(String goodsId){
        //判断客户是否绑定了邀请码
        Map<String, Object> roleInvitationCode = homePageDao.getRoleInvitationCode(SecurityUtils.getCurrentUserId());
        String invitationCode = (String) roleInvitationCode.get("invitationCode");
        if (invitationCode ==null || "".equals(invitationCode)){
            return AppResponse.success("该用户未绑定邀请码","1");
        }
        //通过邀请码获取门店信息
        Map<String, String> store = homePageDao.findStore(invitationCode);
        Map<String, Object> goods = homePageDao.findGoods(goodsId);
        goods.putAll(store);
        if (goods != null){
            return AppResponse.success("查询成功",goods);
        }else {
            return AppResponse.bizError("查询失败");
        }
    }

}
