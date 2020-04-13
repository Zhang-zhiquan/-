package com.xzsd.pc.userManagement.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.userManagement.entity.UserInfo;
import com.xzsd.pc.userManagement.service.UserService;
import com.xzsd.pc.util.AppResponse;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/7 20:37
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 新增用户
     */
    @PostMapping("addUser")
    public AppResponse saveUser(UserInfo userInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = userService.saveUser(userInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "deleteUser")
    public AppResponse deleteUser(String userId){
        try{
            String currentUserId = SecurityUtils.getCurrentUserId();
            return userService.deleteUser(userId,currentUserId);
        }catch (Exception e){
            logger.error("用户删除错误");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 用户列表 （分页）
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo){
        try{
            return userService.listUsers(userInfo);
        }catch (Exception e){
            logger.error("查询用户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  修改用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "updateUser")
    public AppResponse updateUser(UserInfo userInfo){
        try{
            String currentUserId = SecurityUtils.getCurrentUserId();
            userInfo.setLastModifiyBy(currentUserId);
            return userService.updateUser(userInfo);
        }catch (Exception e){
            logger.error("修改用户信息错误");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查看用户详情
     * @param userId
     * @return
     */
    @RequestMapping(value = "findUserById")
    public AppResponse findUser(String userId){
        try{
            return userService.findUser(userId);
        }catch (Exception e){
            logger.error("用户查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "userTopbar")
    public AppResponse userToBar(){
        try {
            return userService.userTopbar();
        }catch (Exception e){
            logger.error("用户栏查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
