package com.xzsd.app.clientDriver.dao;

import com.xzsd.app.clientDriver.entity.StoreVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/24 12:22
 */
@Mapper
public interface DriverDao {
    /**
     * 展示司机负责的门店信息
     * @param currentUserId
     * @return
     */
    public List<StoreVo> showStore(String currentUserId);

    /**
     * 查询司机信息
     * @param currentUserId
     * @return
     */
    public Map<String,String> showDriver(String currentUserId);
}
