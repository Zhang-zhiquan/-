package com.xzsd.pc.storeManagement.controller;

import com.xzsd.pc.rotationPictureManagement.controller.PictureController;
import com.xzsd.pc.rotationPictureManagement.service.PictureService;
import com.xzsd.pc.storeManagement.entity.StoreDTO;
import com.xzsd.pc.storeManagement.entity.StoreDo;
import com.xzsd.pc.storeManagement.service.StoreService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/13 16:05
 */
@RestController
@RequestMapping(value = "/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * 查询省
     * @return
     */
    @RequestMapping(value = "findProvince")
    public AppResponse findProvince(){
        try{
            return storeService.findProvince();
        }catch (Exception e){
            logger.error("查找省失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 查询市
     * @param regionId
     * @return
     */
    @RequestMapping(value = "findCity")
    public AppResponse findCity(String regionId){
        try{
            return storeService.findCity(regionId);
        }catch (Exception e){
            logger.error("查找市失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 查询区
     * @param regionId
     * @return
     */
    @RequestMapping(value = "findLocaltion")
    public AppResponse findLocaltion(String regionId){
        try{
            return storeService.findLocaltion(regionId);
        }catch (Exception e){
            logger.error("查找区失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 添加门店
     * @param storeDo
     * @return
     */
    @RequestMapping(value = "addStore")
    public AppResponse addStore(StoreDo storeDo){
        try{
            return storeService.addStore(storeDo);
        }catch (Exception e){
            logger.error("门店添加失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 查询门店列表
     * @param storeDTO
     * @return
     */
    @RequestMapping(value = "listStore")
    public AppResponse listStore(StoreDTO storeDTO){
        try{
            return storeService.listStore(storeDTO);
        }catch (Exception e){
            logger.error("查询门店列表失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    @RequestMapping(value = "findStore")
    public AppResponse findStore(String storeId){
        try{
            return storeService.findStore(storeId);
        }catch (Exception e){
            logger.error("查询门店详情失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    @RequestMapping(value = "updateStore")
    public AppResponse updateStore(StoreDo storeDo){
        try{
            return storeService.updateStore(storeDo);
        }catch (Exception e){
            logger.error("修改门店失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    @RequestMapping(value = "deleteStore")
    public AppResponse deteleStore(String storeId){
        try{
            return storeService.deleteStore(storeId);
        }catch (Exception e){
            logger.error("删除门店失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

}
