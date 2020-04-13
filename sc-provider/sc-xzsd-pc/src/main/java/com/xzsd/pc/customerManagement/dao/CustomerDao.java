package com.xzsd.pc.customerManagement.dao;

import com.xzsd.pc.customerManagement.entity.CustomerDTO;
import com.xzsd.pc.customerManagement.entity.CustomerDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/5 16:29
 */
@Mapper
public interface CustomerDao {
    /**
     * 查询客户列表
     * @param customerDTO
     * @return
     */
    List<CustomerDo> listCustomer(CustomerDTO customerDTO);

    /**
     * 查询客户详情
     * @param userId
     * @return
     */
    CustomerDo findCustomer(String userId);

}
