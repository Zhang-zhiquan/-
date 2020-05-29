package com.xzsd.pc.driverManagement.dao;

import com.xzsd.pc.driverManagement.entity.DriverDo;
import com.xzsd.pc.driverManagement.entity.DriverVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/14 19:59
 */
@Mapper
public interface DriverDao {
    /**
     * 校验用户表和司机表是否有相同账号
     * @param driverAccounte
     * @return
     */
    public int accoutAcc(@Param("driverAccounte") String driverAccounte);

    /**
     * 校验用户表版本
     * @param version
     * @return
     */
    public int accoutVersion(@Param("version") int version,@Param("userId") String userId);

    /**
     * 校验司机表版本
     * @param version
     * @return
     */
    public int accoutVersionDriver(@Param("driverId") String driverId,@Param("version") int version);


    /**
     * 校验电话号码是否重复
     * @param driverPhone
     * @return
     */
    public int accoutPhone(@Param("driverPhone") String driverPhone);
    /**
     * 新增司机到用户表
     * @param driverDo
     * @return
     */
    public int addDriverInUser(DriverDo driverDo);

    /**
     * 新增司机到司机表
     * @param driverDo
     * @return
     */
    public int addDriverIn(DriverDo driverDo);

    /**
     * 查询司机列表，管理员权限
     * @param driverDo
     * @return
     */
    public List<DriverVo> listDriverForManagement(DriverDo driverDo);

    /**
     * 查询司机列表，店长权限
     * @param driverDo
     * @return
     */
    public List<DriverVo> listDriverForSelf(DriverDo driverDo);

    /**
     * 查看司机详情
     * @param driverId
     * @return
     */
    public DriverVo findDriver(String driverId);

    /**
     * 修改用户表
     * @param driverDo
     * @return
     */
    public int updateDriverForUser(DriverDo driverDo);

    /**
     * 修改司机表
     * @param driverDo
     * @return
     */
    public int updateDriverForSelf(DriverDo driverDo);

    public int deleteDriverUser(@Param("userId") List<String> userId,@Param("currentUserId") String currentUserId);

    public int deleteDriver(@Param("driverId") List<String> driverId,@Param("currentUserId") String currentUserId);

    Map<String,Integer> findCurrentRole(String currentUserId);

    /**
     * 获取门店地区
     * @param currentUserId
     * @return
     */
    Map<String,String> findLocaltion(String currentUserId);
}
