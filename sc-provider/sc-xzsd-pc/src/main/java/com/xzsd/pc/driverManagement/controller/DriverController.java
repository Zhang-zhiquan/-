package com.xzsd.pc.driverManagement.controller;

import com.xzsd.pc.driverManagement.entity.DriverDo;
import com.xzsd.pc.driverManagement.service.DriverService;
import com.xzsd.pc.userManagement.controller.UserController;
import com.xzsd.pc.userManagement.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Driver;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/14 23:48
 */
@RestController
@RequestMapping(value = "/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private DriverService driverService;

    /**
     * 添加司机
     * @param driverDo
     * @return
     */
    @RequestMapping(value = "addDriver")
    public AppResponse addDriver(DriverDo driverDo){
        try{
            return driverService.addDriver(driverDo);
        }catch (Exception e){
            logger.error("添加司机失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "listDriver")
    public AppResponse listDriver(DriverDo driverDo){
        try{
            return driverService.listDriver(driverDo);
        }catch (Exception e){
            logger.error("查询司机列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "findDriver")
    public AppResponse findDriver(String driverId){
        try{
            return driverService.findDriver(driverId);
        }catch (Exception e){
            logger.error("查询司机详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "updateDriver")
    public AppResponse updateDriver(DriverDo driverDo){
        try{
            return driverService.updateDriver(driverDo);
        }catch (Exception e){
            logger.error("修改司机信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "deleteDriver")
    public AppResponse deleteDriver(String driverId,String userId,int role){
        try{
            return driverService.deteleDriver(driverId,userId,role);
        }catch (Exception e){
            logger.error("删除司机失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
