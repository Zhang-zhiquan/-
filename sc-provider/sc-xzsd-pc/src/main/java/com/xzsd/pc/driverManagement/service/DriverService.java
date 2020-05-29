package com.xzsd.pc.driverManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driverManagement.dao.DriverDao;
import com.xzsd.pc.driverManagement.entity.DriverDo;
import com.xzsd.pc.driverManagement.entity.DriverVo;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/14 20:37
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 添加司机
     * @param driverDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverDo driverDo){
        //校验账号是否已经存在
        if(driverDao.accoutAcc(driverDo.getDriverAccounte()) > 0){
            return AppResponse.bizError("账号已存在，请重新输入");
        }
        //校验手机号是否已经存在
        if (driverDao.accoutPhone(driverDo.getDriverPhone()) > 0){
            return AppResponse.bizError("手机号已存在，请重新输入");
        }

        String userId = StringUtil.getCommonCode(2);
        driverDo.setUserId(userId);
        driverDo.setPassword(PasswordUtils.generatePassword(driverDo.getPassword()));
        //添加到用户表中
        if (driverDao.addDriverInUser(driverDo) > 0){
            driverDo.setDriverId(StringUtil.getCommonCode(2));
            driverDo.setCreateBy(SecurityUtils.getCurrentUserId());
            driverDo.setLastModifiyBy(SecurityUtils.getCurrentUserId());
            //添加到司机表
            int count = driverDao.addDriverIn(driverDo);
            if (count != 0){
                return AppResponse.success("添加司机成功");
            }
        }
        return AppResponse.bizError("司机添加未成功");
    }

    /**
     * 查询司机列表
     * @param driverDo
     * @return
     */
    public AppResponse listDriver(DriverDo driverDo){
        PageHelper.startPage(driverDo.getPageNum(),driverDo.getPageSize());
        int role = driverDao.findCurrentRole(SecurityUtils.getCurrentUserId()).get("role");
        //询司机列表，管理员权限
        if (role == 1){
            List<DriverVo> driverVos = driverDao.listDriverForManagement(driverDo);
            PageInfo<DriverVo> driverVoPageInfo = new PageInfo<>(driverVos);
            if (driverVos != null){
                return AppResponse.success("查询司机成功",driverVoPageInfo);
            }else {
                return AppResponse.bizError("查询司机失败");
            }
        }
        //询司机列表，店长权限
        else {
            //司机处于门店的所在地区时展示
            driverDo.setLocation(driverDao.findLocaltion(SecurityUtils.getCurrentUserId()).get("location"));
            List<DriverVo> driverVo = driverDao.listDriverForSelf(driverDo);
            PageInfo<DriverVo> driverVoPageInfo = new PageInfo<>(driverVo);
            if (driverVo != null){
                return AppResponse.success("查询司机成功",driverVoPageInfo);
            }else {
                return AppResponse.bizError("查询司机失败");
            }
        }
    }

    /**
     * 查询司机详情
     * @param driverId
     * @return
     */
    public AppResponse findDriver(String driverId){
        DriverVo driverVo = driverDao.findDriver(driverId);
        if (driverVo != null){
            return AppResponse.success("查询司机成功",driverVo);
        }else {
            return AppResponse.bizError("查询司机失败");
        }
    }

    /**
     * 修改司机信息
     * @param driverDo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverDo driverDo){
        if (driverDo.getDriverAccounte() != null && !"".equals(driverDo.getDriverAccounte())){
            if(driverDao.accoutAcc(driverDo.getDriverAccounte()) > 0){
                return AppResponse.bizError("账号已存在，请重新输入");
            }
        }
        //校验手机号是否已经存在
        if (driverDo.getDriverPhone() != null && !"".equals(driverDo.getDriverPhone())){
            if (driverDao.accoutPhone(driverDo.getDriverPhone()) > 0){
                return AppResponse.bizError("手机号已存在，请重新输入");
            }
        }
        if (driverDo.getPassword() != null && !"".equals(driverDo.getPassword())){
            //修改司机密码
            driverDo.setPassword(PasswordUtils.generatePassword(driverDo.getPassword()));
        }
        //分别修改司机表和用户表的信息
        int count = driverDao.updateDriverForUser(driverDo);
        int i = driverDao.updateDriverForSelf(driverDo);
        if (count != 0 && i != 0){
            return AppResponse.success("司机信息修改成功");
        }else {
            return AppResponse.bizError("司机信息修改失败");
        }
    }

    /**
     * 删除司机
     * @param driverId
     * @param userId
     * @param role
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deteleDriver(String driverId,String userId,int role){
        //权限控制，管理员入口
        if (role == 1){
            String currentUserId = SecurityUtils.getCurrentUserId();
            List<String> userIdList = Arrays.asList(userId.split(","));
            List<String> driverIdList = Arrays.asList(driverId.split(","));
            //分别删除司机表和用户表
            int count = driverDao.deleteDriverUser(userIdList, currentUserId);
            int i = driverDao.deleteDriver(driverIdList, currentUserId);
            if (count != 0 && i != 0){
                return AppResponse.success("删除成功");
            }else {
                return AppResponse.bizError("删除失败");
            }
        }
        //其他人员入口
        else {
            return AppResponse.bizError("您没有操作权限");
        }
    }

}
