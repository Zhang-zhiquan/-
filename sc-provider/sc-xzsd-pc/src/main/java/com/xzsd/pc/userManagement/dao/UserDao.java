package com.xzsd.pc.userManagement.dao;

import com.xzsd.pc.userManagement.entity.TobarVo;
import com.xzsd.pc.userManagement.entity.UserDTO;
import com.xzsd.pc.userManagement.entity.UserInfo;
import com.xzsd.pc.userManagement.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/7 20:26
 */
@Mapper
public interface UserDao {
    /**
     * 查询账号是否存在
     * @param userInfo
     * @return
     */
    int countUserAcct(String userAccount);

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int saveUser(UserDTO userDTO);

    /**
     * 删除用户
     * @param listId
     * @param currentUserId
     * @return
     */
    int deleteUser(@Param("listId") List<String> listId, @Param("currentUserId") String currentUserId);

    /**
     * 查询用户列表
     * @param userInfo
     * @return
     */
    List<UserVo> listUsersByPage(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查看用户详情
     * @param userId
     * @return
     */
    UserInfo findUserById(@Param("userId") String userId);

    /**
     * 用户栏信息
     * @param userId
     * @return
     */
    TobarVo userTobar(String userId);

}
