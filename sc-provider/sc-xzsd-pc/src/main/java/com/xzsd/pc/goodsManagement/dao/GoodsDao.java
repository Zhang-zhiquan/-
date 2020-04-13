package com.xzsd.pc.goodsManagement.dao;

import com.xzsd.pc.goodsManagement.entity.GoodsDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/29 13:36
 */
@Mapper
public interface GoodsDao {
    /**
     * 查询商品列表
     * @param goodsDo
     * @return
     */
    List<GoodsDo> goodsList(GoodsDo goodsDo);

    /**
     * 添加商品
     * @param goodsDo
     * @return
     */
    int addGoods(GoodsDo goodsDo);

    /**
     * 查看商品详情
     * @param goodsDo
     * @return
     */
    GoodsDo findGoods(@Param("goodsId") String goodsId);

    /**
     * 修改商品信息
     * @param goodsDo
     * @return
     */
//    次方法实现mybatis有问题
//    int updateGoods(@Param("goodsDo") GoodsDo goodsDo, @Param("currentUserId") String currentUserId);

    /**
     * 修改商品信息
     * @param goodsDo
     * @return
     */
    int updateGoods(GoodsDo goodsDo);

    /**
     * 删除商品
     * @param goodsId
     * @param currentUserId
     * @return
     */
    int deleteGoods(@Param("goodsId") List<String> goodsId, @Param("currentUserId") String currentUserId);


}
