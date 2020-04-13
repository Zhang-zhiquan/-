package com.xzsd.pc.customerManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.customerManagement.dao.CustomerDao;
import com.xzsd.pc.customerManagement.entity.CustomerDTO;
import com.xzsd.pc.customerManagement.entity.CustomerDo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        PageHelper.startPage(customerDTO.getPageNum(),customerDTO.getPageSize());
        List<CustomerDo> customerDos = customerDao.listCustomer(customerDTO);
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
