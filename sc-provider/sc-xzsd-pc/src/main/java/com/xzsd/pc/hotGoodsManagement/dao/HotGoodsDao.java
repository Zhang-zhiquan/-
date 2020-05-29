package com.xzsd.pc.hotGoodsManagement.dao;

import com.xzsd.pc.hotGoodsManagement.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/12 12:06
 */
@Mapper
public interface HotGoodsDao {

    /**
     * 添加热门商品
     * @param goodsId
     * @param goodsSort
     * @return
     */
    public int addHotGoods(HotGoodsDo hotGoodsDo);

    /**
     * 查询热门排序是否已经存在
     * @param goodsSort
     * @return
     */
    public int accoutGoodsSort(int goodsSort);

    /**
     * 查询热门商品Id是否已经存在
     * @param goodsId
     * @return
     */
    public int accoutGoodsId(@Param("goodsId") String goodsId);

    /**
     * 校验版本号
     * @param version
     * @return
     */
    public int accoutVersion(@Param("hotGoodsId") String hotGoodsId,@Param("version") int version);

    /**
     * 查询商品列表
     * @param hotGoodsDTO
     * @return
     */
    public List<HotGoodsVo> listHotGoods(HotGoodsDTO hotGoodsDTO);

    /**
     * 删除热门商品
     * @param hotGoodsId
     * @param currentUserId
     * @return
     */
    public int deteleHotGoods(@Param("hotGoodsId") List<String> hotGoodsId,@Param("currentUserId") String currentUserId);

    /**
     * 查看热门商品展示数量
     * @return
     */
    public HotGoodsNum findHotGoodsNum();

    /**
     * 修改热门商品展示数量
     * @param num
     * @param currentUserId
     * @return
     */
    public int updateHotGoodsNum(@Param("num") int num,@Param("currentUserId") String currentUserId);

    /**
     * 修改热门商品信息
     * @param hotGoodsDTO
     * @return
     */
    public int updateHotGoods(HotGoodsDo hotGoodsDo);

    public HotGoodsDetail findGoods(String hotGoodsId);

}
