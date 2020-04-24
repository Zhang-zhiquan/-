package com.xzsd.app.clientSortPage.dao;

import com.xzsd.app.clientSortPage.entity.SortCollection;
import com.xzsd.app.clientSortPage.entity.SortVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 1:00
 */
@Mapper
public interface SortDao {
    /**
     * 查询商品一级目录
     * @return
     */
    List<SortVo> findFirstClass();

    /**
     * 展示二级分类商品
     * @param sortId
     * @return
     */
    List<SortCollection> showSecondClass(String sortId);

}
