package com.xzsd.pc.hotGoodsManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotGoodsManagement.dao.HotGoodsDao;
import com.xzsd.pc.hotGoodsManagement.entity.HotGoodsDTO;
import com.xzsd.pc.hotGoodsManagement.entity.HotGoodsDo;
import com.xzsd.pc.hotGoodsManagement.entity.HotGoodsNum;
import com.xzsd.pc.hotGoodsManagement.entity.HotGoodsVo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/12 14:21
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * 添加热门商品
     * @param hotGoodsDo
     * @return
     */
    public AppResponse addHotGoods(HotGoodsDo hotGoodsDo){
        hotGoodsDo.setHotGoodsId(UUIDUtils.getUUID());
        hotGoodsDo.setCreateBy(SecurityUtils.getCurrentUserId());
        hotGoodsDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
        if (hotGoodsDao.accoutGoodsSort(hotGoodsDo.getGoodsSort()) > 0){
            return AppResponse.bizError("热门商品排序已存在");
        }
        if (hotGoodsDao.accoutGoodsId(hotGoodsDo.getGoodsId()) > 0){
            return AppResponse.bizError("热门商品已存在");
        }

        int count = hotGoodsDao.addHotGoods(hotGoodsDo);
        if (count == 0){
            return AppResponse.bizError("热门商品未添加");
        }else {
            return AppResponse.success("热门商品添加成功");
        }
    }

    /**
     * 查询热门商品列表
     * @param hotGoodsDTO
     * @return
     */
    public AppResponse listHotGoods(HotGoodsDTO hotGoodsDTO){
        PageHelper.startPage(hotGoodsDTO.getPageNum(),hotGoodsDTO.getPageSize());
        List<HotGoodsVo> hotGoodsVos = hotGoodsDao.listHotGoods(hotGoodsDTO);
        PageInfo<HotGoodsVo> hotGoodsVoPageInfo = new PageInfo<>(hotGoodsVos);
        if (hotGoodsVos != null){
            return AppResponse.success("查询成功",hotGoodsVoPageInfo);
        }else {
            return AppResponse.bizError("未查询到数据");
        }
    }

    /**
     * 删除热门商品
     * @param hotGoodsId
     * @return
     */
    public AppResponse deteleHotGoods(String hotGoodsId){
        List<String> hotGoodsIds = Arrays.asList(hotGoodsId.split(","));
        int count = hotGoodsDao.deteleHotGoods(hotGoodsIds, SecurityUtils.getCurrentUserId());
        if (count != 0){
            return AppResponse.success("热门商品删除成功");
        }else {
            return AppResponse.bizError("热门商品删除未成功");
        }
    }

    /**
     * 查看热门商品展示数量
     * @return
     */
    public AppResponse findHotGoodsNum(){
        HotGoodsNum hotGoodsNum = hotGoodsDao.findHotGoodsNum();
        return AppResponse.success("查询成功",hotGoodsNum);
    }

    /**
     * 修改热门商品展示数量
     * @param num
     * @return
     */
    public AppResponse updateHotGoodsNum(int num){
        int count = hotGoodsDao.updateHotGoodsNum(num, SecurityUtils.getCurrentUserId());
        if (count != 0){
            return AppResponse.success("展示数量修改成功");
        }else {
            return AppResponse.bizError("展示数量未修改成功");
        }
    }

}
