package com.xzsd.pc.customerManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customerManagement.dao.CustomerDao;
import com.xzsd.pc.customerManagement.entity.CustomerDTO;
import com.xzsd.pc.customerManagement.entity.CustomerDo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/5 18:08
 */
@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;

    /**
     * 查询客户列表
     * @param customerDTO
     * @return
     */
    public AppResponse listCustomer(CustomerDTO customerDTO){
        List<CustomerDo> customerDos = null;
        PageHelper.startPage(customerDTO.getPageNum(),customerDTO.getPageSize());
        //店长角色登录获取其店下客户
        int role = customerDao.fingCurrentRole(SecurityUtils.getCurrentUserId()).get("role");
        if (role == 2){
            Map<String, String> invitationCode = customerDao.findInvitationCode(SecurityUtils.getCurrentUserId());
            //根据邀请码获取店长门店下的顾客
            customerDTO.setInvitationCode(invitationCode.get("invitationCode"));
            customerDos = customerDao.listCustomer(customerDTO);
        }
        //管理员角色获取全部客户
        else{
            customerDos = customerDao.listCustomer(customerDTO);
        }
        PageInfo<CustomerDo> customerDoPageInfo = new PageInfo<>(customerDos);
        if (customerDos != null){
            return AppResponse.success("客户列表查询成功",customerDoPageInfo);
        }else {
            return AppResponse.notFound("未查询到客户信息");
        }
    }

    /**
     * 查询客户详情
     * @param userId
     * @return
     */
    public AppResponse findCustomer(String userId){
        CustomerDo customer = customerDao.findCustomer(userId);
        if (customer != null){
            return AppResponse.success("客户信息查询成功",customer);
        }else {
            return AppResponse.notFound("未查询到客户信息");
        }
    }
}
