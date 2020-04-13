package com.xzsd.pc.customerManagement.controller;

import com.xzsd.pc.customerManagement.entity.CustomerDTO;
import com.xzsd.pc.customerManagement.service.CustomerService;
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
 * @Date 2020/4/5 18:16
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;

    /**
     * 查询客户列表
     * @param customerDTO
     * @return
     */
    @RequestMapping(value = "listCustomer")
    public AppResponse listCustomer(CustomerDTO customerDTO){
        try{
            return customerService.listCustomer(customerDTO);
        }catch (Exception e){
            logger.error("查询客户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询客户详情
     * @param userId
     * @return
     */
    @RequestMapping(value = "findCustomer")
    public AppResponse findCustomer(String userId){
        try{
            return customerService.findCustomer(userId);
        }catch (Exception e){
            logger.error("查询客户信息异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
