package com.xzsd.app.clientSortPage.service;

import com.xzsd.app.clientSortPage.dao.SortDao;
import com.xzsd.app.clientSortPage.entity.SortCollection;
import com.xzsd.app.clientSortPage.entity.SortVo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/19 1:06
 */
@Service
public class SortService {
    @Resource
    private SortDao sortDao;

    /**
     * 查询一级分类
     * @return
     */
    public AppResponse findFirstClass(){
        List<SortVo> firstClass = sortDao.findFirstClass();
        if (firstClass != null){
            return AppResponse.success("一级分类查询成功",firstClass);
        }else {
            return AppResponse.bizError("一级分类查询失败");
        }
    }

    /**
     * 展示二级分类商品
     * @param sortId
     * @return
     */
    public AppResponse showSecondClass(String sortId){
        List<SortCollection> sortCollections = sortDao.showSecondClass(sortId);
        if (sortCollections != null){
            return AppResponse.success("二级商品查询成功",sortCollections);
        }else {
            return AppResponse.bizError("二级商品查询失败");
        }
    }
}
