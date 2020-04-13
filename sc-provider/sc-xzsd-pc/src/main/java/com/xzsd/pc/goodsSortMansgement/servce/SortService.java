package com.xzsd.pc.goodsSortMansgement.servce;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsSortMansgement.dao.SortDao;
import com.xzsd.pc.goodsSortMansgement.entity.SortDo;
import com.xzsd.pc.goodsSortMansgement.entity.SortVo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/4 11:02
 */
@Service
public class SortService {
    @Resource
    private SortDao sortDao;

    /**
     * 新增商品分类
     * @param sortDo
     * @return
     */
    public AppResponse addSort(SortDo sortDo){
        int count = 0;
        //判断商品分类是否存在
        if (sortDao.countNum(sortDo.getSortName()) > 0){
            return AppResponse.bizError("分类名称已存在，请重新输入");
        }
        //判断是否父类，是的话parent为1
        if (sortDo.getParentId() == null || "".equals(sortDo.getParentId())){
            sortDo.setIsParent(1);
            count = sortDao.addGoodsSort(sortDo);
        }else {
            count = sortDao.addGoodsSort(sortDo);
        }
        if (count == 0){
            return AppResponse.versionError("商品分类新增失败");
        }else {
            return AppResponse.success("新增商品分类成功");
        }
    }

    /**
     * 查询商品一级目录
     * @return
     */
    public AppResponse findFirstClass(){
        List<SortVo> firstClass = sortDao.findFirstClass();
        if (firstClass != null){
            return AppResponse.success("查询一级商品分类成功",firstClass);
        }else {
            return AppResponse.notFound("未查询到一级商品分类");
        }
    }

    /**
     * 查询二级商品分类
     * @param parentId
     * @return
     */
    public AppResponse findSecondClass(String parentId){
        if (parentId != null || !" ".equals(parentId)){
            List<SortVo> secondClass = sortDao.findSecondClass(parentId);
            return AppResponse.success("查询二级商品分类成功",secondClass);
        }else {
            return AppResponse.versionError("查询二级商品分类失败");
        }
    }

    /**
     * 修改商品分类目录
     * @param sortDo
     * @return
     */
    public AppResponse updateSort(SortDo sortDo){
        sortDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
        //判断商品分类是否存在
        if (sortDao.countNum(sortDo.getSortName()) > 0){
            return AppResponse.bizError("分类名称已存在，请重新输入");
        }

        int count = sortDao.updateGoodsSort(sortDo);
        if (count != 0){
            return AppResponse.success("商品分类修改成功");
        }else {
            return AppResponse.notFound("商品分类未修改");
        }
    }

    /**
     * 删除商品分类
     * @param sortId
     * @return
     */
    public AppResponse deteleSort(String sortId){
        int count = sortDao.deteleGoodsSort(sortId);
        if(count != 0){
            return AppResponse.success("商品分类删除成功");
        }else {
            return AppResponse.notFound("商品分类未删除成功");
        }
    }

    /**
     * 查看商品分类详情
     * @param sortId
     * @return
     */
    public AppResponse findSort(String sortId){
        SortVo goodsSort = sortDao.findGoodsSort(sortId);
        if (goodsSort != null){
            return AppResponse.success("查询成功",goodsSort);
        }else {
            return AppResponse.notFound("未查询到数据");
        }
    }
}
