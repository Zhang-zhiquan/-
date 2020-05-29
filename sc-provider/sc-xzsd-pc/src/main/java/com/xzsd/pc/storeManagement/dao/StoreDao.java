package com.xzsd.pc.storeManagement.dao;

import com.xzsd.pc.storeManagement.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/13 15:38
 */
@Mapper
public interface StoreDao {
    /**
     * 查询省
     * @return
     */
    public List<RegionDo> findProvince();

    /**
     * 查询市
     * @param regionId
     * @return
     */
    public List<RegionDo> findCity(@Param("regionId") String regionId);

    /**
     * 查询区
     * @param regionId
     * @return
     */
    public List<RegionDo> findLocaltion(@Param("regionId") String regionId);

    /**
     * 添加门店
     * @param storeDo
     * @return
     */
    public int addStore(StoreDo storeDo);

    /**
     * 校验店长账号是否在user表
     * @param userId
     * @return
     */
    public int accoutInUser(String userId);

    /**
     * 校验店长是否已经存在门店
     * @param userId
     * @return
     */
    public int accoutInStore(String userId);

    /**
     * 校验版本
     * @param version
     * @return
     */
    public int accoutVersion(@Param("storeId") String storeId,@Param("version") int version);

    /**
     * 查询门店列表 管理员权限
     * @param storeDTO
     * @return
     */
    public List<StoreVo> listStore(StoreDTO storeDTO);

    /**
     * 查询门店列表 店长权限
     * @param
     * @return
     */
    public List<StoreVo> listStoreForShopowner(@Param("currentUserId") String currentUserId);

    /**
     * 获取店长姓名
     * @param shopownerId
     * @return
     */
    public StoreGetName storeName(@Param("shopownerId") String shopownerId);

    /**
     * 查看门店详情
     * @param storeId
     * @return
     */
    public StoreVo findStore(@Param("storeId") String storeId);

    /**
     * 修改门店，管理员权限
     * @param storeDo
     * @return
     */
    public int updateStore(StoreDo storeDo);

    /**
     * 删除门店
     * @param storeId
     * @return
     */
    public int deleteStore(@Param("storeId") List<String> storeId,@Param("currentUserId") String currentUserId);

    public List<ShopnerVo> findShopwner(ShopnerDTO shopnerDTO);

    Map<String,Integer> findCurrentRole(String currentUserId);
}
