package com.xzsd.pc.goodsSortMansgement.dao;

import com.xzsd.pc.goodsSortMansgement.entity.SortDo;
import com.xzsd.pc.goodsSortMansgement.entity.SortVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/4 10:36
 */
@Mapper
public interface SortDao {
    /**
     * 统计分类数，查看商品分类是否已经存在
     * @param sortName
     * @return
     */
    int countNum(String sortName);
    /**
     * 新增商品分类
     * @param sortDo
     * @return
     */
    int addGoodsSort(SortDo sortDo);

    /**
     * 查询商品一级目录
     * @return
     */
    List<SortVo> findFirstClass();

    /**
     * 查询商品二级目录
     * @param parentId
     * @return
     */
    List<SortVo> findSecondClass(String parentId);

    /**
     * 修改商品分类信息
     * @param sortDo
     * @return
     */
    int updateGoodsSort(SortDo sortDo);

    /**
     * 删除商品分类
     * @param sortId
     * @return
     */
    int deteleGoodsSort(String sortId);

    /**
     * 查看商品分类详情
     * @param sortId
     * @return
     */
    SortVo findGoodsSort(String sortId);
}
