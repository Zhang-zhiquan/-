package com.xzsd.pc.customerManagement.dao;

import com.xzsd.pc.customerManagement.entity.CustomerDTO;
import com.xzsd.pc.customerManagement.entity.CustomerDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询当前用户角色
     * @param currentUserId
     * @return
     */
    Map<String,Integer> fingCurrentRole(String currentUserId);

    Map<String,String> findInvitationCode(String currentUserId);

}
