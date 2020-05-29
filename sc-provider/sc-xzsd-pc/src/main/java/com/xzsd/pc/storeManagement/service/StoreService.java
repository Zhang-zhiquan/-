package com.xzsd.pc.storeManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.storeManagement.dao.StoreDao;
import com.xzsd.pc.storeManagement.entity.*;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import com.xzsd.pc.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/13 15:55
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 查询省
     * @return
     */
    public AppResponse findProvince(){
        List<RegionDo> privinces = storeDao.findProvince();
        if (privinces != null){
            return AppResponse.success("查询成功",privinces);
        }else {
            return AppResponse.notFound("未查询到数据");
        }
    }

    /**
     * 查询市
     * @param regionId
     * @return
     */
    public AppResponse findCity(String regionId){
        List<RegionDo> citys = storeDao.findCity(regionId);
        if (citys != null){
            return AppResponse.success("查询成功",citys);
        }else {
            return AppResponse.notFound("未查询到数据");
        }
    }

    /**
     * 查询区
     * @param regionId
     * @return
     */
    public AppResponse findLocaltion(String regionId){
        List<RegionDo> localtions = storeDao.findLocaltion(regionId);
        if (localtions != null){
            return AppResponse.success("查询成功",localtions);
        }else {
            return AppResponse.notFound("未查询到数据");
        }
    }

    /**
     * 添加门店
     * @param storeDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreDo storeDo){
        //校验权限
        if (storeDo.getRole() != 1){
            return AppResponse.bizError("你没有此权限");
        }
        //校验店长账号是否在user表
        if (storeDao.accoutInUser(storeDo.getShopownerId()) <= 0){
            return AppResponse.bizError("用户账号不存在，请重新输入");
        }
        //校验店长是否已经存在门店
        if (storeDao.accoutInStore(storeDo.getShopownerId()) > 0){
            return AppResponse.bizError("该账号已存在店面，请重新输入");
        }
        //设置门店名称
        StoreGetName shopownerName = storeDao.storeName(storeDo.getShopownerId());
        storeDo.setShopownerName(shopownerName.getShopownerName());
        storeDo.setStoreId(StringUtil.getCommonCode(2));
        //设置邀请码，六位数字
        storeDo.setInvitationCode(Integer.toString((int)((Math.random()*9+1)*100000)));
        storeDo.setCreateBy(SecurityUtils.getCurrentUserId());
        storeDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
        //设置门店账号
        String storeAccountNumber = "XZS" + Integer.toString((int)((Math.random()*9+1)*100000));
        storeDo.setStoreAccountNumber(storeAccountNumber);
        int count = storeDao.addStore(storeDo);
        if (count != 0){
            return AppResponse.success("添加成功");
        }else {
            return AppResponse.bizError("未添加成功");
        }
    }

    /**
     * 查询门店列表
     * @param storeDTO
     * @return
     */
    public AppResponse listStore(StoreDTO storeDTO){
        int role = storeDao.findCurrentRole(SecurityUtils.getCurrentUserId()).get("role");
        //管理员权限，查看全部门店
        if (role == 1){
            PageHelper.startPage(storeDTO.getPageNum(),storeDTO.getPageSize());
            List<StoreVo> storeVos = storeDao.listStore(storeDTO);
            PageInfo<StoreVo> storeVoPageInfo = new PageInfo<>(storeVos);
            if (storeVos != null){
                return AppResponse.success("查询成功",storeVoPageInfo);
            }else {
                return AppResponse.notFound("未查询到信息");
            }
        }
        //店长权限，查看自己门店
        else {
            PageHelper.startPage(storeDTO.getPageNum(),storeDTO.getPageSize());
            List<StoreVo> storeVos = storeDao.listStoreForShopowner(SecurityUtils.getCurrentUserId());
            PageInfo<StoreVo> storeVoPageInfo = new PageInfo<>(storeVos);
            if (storeVos != null){
                return AppResponse.success("查询成功",storeVoPageInfo);
            }else {
                return AppResponse.notFound("未查询到信息");
            }
        }
    }

    /**
     * 查看门店详情
     * @param storeId
     * @return
     */
    public AppResponse findStore(String storeId){
        StoreVo store = storeDao.findStore(storeId);
        if (store != null){
            return AppResponse.success("查询成功",store);
        }else {
            return AppResponse.notFound("为查询到数据");
        }
    }

    /**
     * 修改门店信息
     * @param storeDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreDo storeDo){
        if (storeDo.getShopownerId() != null && !"".equals(storeDo.getShopownerId())){
            //校验店长账号是否在user表
            if (storeDao.accoutInUser(storeDo.getShopownerId()) <= 0){
                return AppResponse.bizError("用户账号不存在，请重新输入");
            }
            //校验店长是否已经存在门店
            if (storeDao.accoutInStore(storeDo.getShopownerId()) > 0){
                return AppResponse.bizError("该账号已存在店面，请重新输入");
            }
        }
        storeDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
        //修改店长Id同时修改姓名
        if (storeDo.getShopownerId() != null && !"".equals(storeDo.getShopownerId())){
            StoreGetName shopownerName = storeDao.storeName(storeDo.getShopownerId());
            storeDo.setShopownerName(shopownerName.getShopownerName());
        }
        int count = storeDao.updateStore(storeDo);
        if (count != 0){
            return AppResponse.success("修改成功");
        }else {
            return AppResponse.bizError("未修改成功");
        }
    }

    /**
     * 删除门店
     * @param storeId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId){
        List<String> storeIds = Arrays.asList(storeId.split(","));
        int count = storeDao.deleteStore(storeIds,SecurityUtils.getCurrentUserId());
        if (count != 0){
            return AppResponse.success("门店删除成功");
        }else {
            return AppResponse.bizError("门店删除未成功");
        }
    }

    /**
     * 查询店长
     * @param shopnerDTO
     * @return
     */
    public AppResponse findShopwner(ShopnerDTO shopnerDTO){
        PageHelper.startPage(shopnerDTO.getPageNum(),shopnerDTO.getPageSize());
        List<ShopnerVo> shopwner = storeDao.findShopwner(shopnerDTO);
        PageInfo<ShopnerVo> shopnerVoPageInfo = new PageInfo<>(shopwner);
        return AppResponse.success("查询店长成功",shopnerVoPageInfo);
    }

}
