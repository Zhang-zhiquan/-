package com.xzsd.pc.goodsManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsManagement.dao.GoodsDao;
import com.xzsd.pc.goodsManagement.entity.GoodsDo;
import com.xzsd.pc.goodsManagement.entity.GoodsVo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import com.xzsd.pc.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/3/29 14:34
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 商品列表
     * @param goodsDo
     * @return
     */
    public AppResponse goodsList(GoodsDo goodsDo){
        PageHelper.startPage(goodsDo.getPageNum(),goodsDo.getPageSize());
        List<GoodsVo> goodsDos = goodsDao.goodsList(goodsDo);
        PageInfo<GoodsVo> pageDate = new PageInfo<>(goodsDos);
        return AppResponse.success("查询成功",pageDate);
    }

    /**
     * 新增商品
     * @param goodsDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addList(GoodsDo goodsDo){
        goodsDo.setCreateBy(SecurityUtils.getCurrentUserId());
        goodsDo.setGoodsId(StringUtil.getCommonCode(2));
        int count = goodsDao.addGoods(goodsDo);
        if(0 == count){
            return AppResponse.bizError("商品添加失败");
        }
        return AppResponse.success("商品添加成功");
    }

    /**
     * 查看商品详情
     * @param goodsId
     * @return
     */
    public AppResponse findGoods(String goodsId) {
        GoodsVo goods = goodsDao.findGoods(goodsId);
        return AppResponse.success("查询成功",goods);
    }

    /**
     * 修改商品信息
     * @param goodsDo
     * @return
     */
    public AppResponse updateGoods(GoodsDo goodsDo){
            int count = goodsDao.updateGoods(goodsDo);
            if (count == 0){
                return AppResponse.bizError("未查询到此商品,商品修改失败");
            }else {
                return AppResponse.success("商品修改成功");
            }
    }

    /**
     * 删除商品操作
     * @param goodsId
     * @param currentUserId
     * @return
     */
    public AppResponse deteleGoods(List<String> goodsId,String currentUserId){
        int count = goodsDao.deleteGoods(goodsId, currentUserId);
        if (count == 0){
            return AppResponse.success("商品未删除");
        }else {
            return AppResponse.success("商品删除成功");
        }
    }

    /**
     * 商品上架下架
     * @param goodsId
     * @param sign
     * @return
     */
    public AppResponse updateGoodsState(String goodsId,String sign){
        List<String> goodsIds = Arrays.asList(goodsId.split(","));
        int i = goodsDao.updateGoodsState(goodsIds, Integer.parseInt(sign));
        if (i == 0){
            return AppResponse.success("商品上下架失败");
        }else {
            return AppResponse.success("商品上下架成功");
        }
    }
}
