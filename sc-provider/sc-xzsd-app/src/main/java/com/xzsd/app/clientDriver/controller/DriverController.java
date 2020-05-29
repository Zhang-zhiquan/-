package com.xzsd.app.clientDriver.controller;

import com.xzsd.app.clientDriver.service.DriverService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/24 12:32
 */
@RestController
@RequestMapping(value = "/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;

    /**
     * 展示司机负责的门店信息
     * @return
     */
    @RequestMapping(value = "showStore")
    public AppResponse showStore(){
        try{
            return driverService.showStore();
        }catch (Exception e){
            logger.error("展示司机负责的门店信息异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机信息
     * @return
     */
    @RequestMapping(value = "showDriver")
    public AppResponse showDriver(){
        try{
            return driverService.showDriver();
        }catch (Exception e){
            logger.error("查询司机信息异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
