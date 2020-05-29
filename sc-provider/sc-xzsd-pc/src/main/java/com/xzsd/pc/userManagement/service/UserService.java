package com.xzsd.pc.userManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import com.xzsd.pc.userManagement.dao.UserDao;
import com.xzsd.pc.userManagement.entity.TobarVo;
import com.xzsd.pc.userManagement.entity.UserDTO;
import com.xzsd.pc.userManagement.entity.UserInfo;
import com.xzsd.pc.userManagement.entity.UserVo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import com.xzsd.pc.util.TencentCosUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/7 20:31
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     * @param
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveUser(UserDTO userDTO){
        //检验账号是否存在
        int countUserAcct = userDao.countUserAcct(userDTO.getUserAccount());
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账号已存在，请重新输入账号");
        }
        userDTO.setUserId(StringUtil.getCommonCode(2));
        userDTO.setPassword(PasswordUtils.generatePassword(userDTO.getPassword()));
        //新增用户
        int count = userDao.saveUser(userDTO);
        if(0 == count){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }


    /**
     * 删除用户
     * @param userId
     * @param currentUserId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId,String currentUserId){
        List<String> listId = Arrays.asList(userId.split(","));
        AppResponse appRespone = AppResponse.success("删除成功");
        int count = userDao.deleteUser(listId,currentUserId);
        if(0 == count){
            appRespone = AppResponse.bizError("删除失败");
        }
        return appRespone;
    }

    /**
     * 查询用户列表 （分页）
     * @param userInfo
     * @return
     */
    public AppResponse listUsers(UserInfo userInfo){
        PageHelper.startPage(userInfo.getPageNum(),userInfo.getPageSize());
        List<UserVo> userInfiList = userDao.listUsersByPage(userInfo);
        //包装Page对象
        PageInfo<UserVo> pageDate = new PageInfo<>(userInfiList);
        return AppResponse.success("查询成功",pageDate);
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo){
        //判断要修改的账号是否已经存在
        int countUserAcct = userDao.countUserAcct(userInfo.getUserAccount());
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账号已存在。请重新输入");
        }
        //修改密码
        if (userInfo.getPassword() != null && !"".equals(userInfo.getPassword())){
            userInfo.setPassword(PasswordUtils.generatePassword(userInfo.getPassword()));
        }
        if (userInfo.getUserId() != null && !" ".equals(userInfo.getUserId())){
            //修改用户信息
            int count = userDao.updateUser(userInfo);
            if(0 == count){
                return AppResponse.versionError("数据有变化，请刷新");
            }else {
                return AppResponse.success("修改成功");
            }
        }else{
            return AppResponse.notFound("请输入用户Id");
        }
    }

    /**
     * 查看用户详情
     * @param userId
     * @return
     */
    public AppResponse findUser(String userId){
        UserInfo userInfo = userDao.findUserById(userId);
        return AppResponse.success("查询成功",userInfo);
    }

    /**
     * 用户栏详情
     * @return
     */
    public AppResponse userTopbar(){
        String userId = SecurityUtils.getCurrentUserId();
        TobarVo userVo = userDao.userTobar(userId);
        if (userVo != null){
            return AppResponse.success("用户栏查询成功",userVo);
        }else {
            return AppResponse.notFound("未查询到用户");
        }
    }
}
