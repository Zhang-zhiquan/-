package com.xzsd.app.clientDriver.dao;

import com.xzsd.app.clientDriver.entity.StoreVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
}
