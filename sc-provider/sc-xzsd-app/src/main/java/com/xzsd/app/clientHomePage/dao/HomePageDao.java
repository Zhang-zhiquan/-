package com.xzsd.app.clientHomePage.dao;

import com.xzsd.app.clientHomePage.entity.HotGoodsVo;
import com.xzsd.app.clientHomePage.entity.RegisterDo;
import com.xzsd.app.clientHomePage.entity.RotationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/17 15:52
 */
@Mapper
public interface HomePageDao {
    /**
     * 获取登录用户角色
     * @param userId
     * @return
     */
    public Map<String,Object> getRoleInvitationCode(String userId);

    /**
     * 统计用户账号数量
     * @param userAccount
     * @return
     */
    public int countUserAcct(String userAccount);

    /**
     * 注册客户信息存入顾客表
     * @param registerDo
     * @return
     */
    public int registerForCustomer(RegisterDo registerDo);

    /**
     * 注册客户信息存入用户表
     * @param registerDo
     * @return
     */
    public int registerForUser(RegisterDo registerDo);

    /**
     * 查询轮播图
     * @return
     */
    public List<RotationVo> showRotationChart();

    /**
     * 查看热门商品展示数量
     * @return
     */
    public Map<String,Integer> findHotGoodsNum();

    /**
     * 展示热门商品
     * @param hotGoodsNum
     * @return
     */
    public List<HotGoodsVo> showHotGoods(int hotGoodsNum);

    /**
     * 查看商品详情
     * @param goodsId
     * @return
     */
    public Map<String,Object> findGoods(String goodsId);

    /**
     * 通过邀请码获取门店信息
     * @param invitationCode
     * @return
     */
    public Map<String,String> findStore(String invitationCode);
}
