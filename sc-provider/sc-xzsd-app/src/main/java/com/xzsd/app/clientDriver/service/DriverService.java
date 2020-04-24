package com.xzsd.app.clientDriver.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientDriver.dao.DriverDao;
import com.xzsd.app.clientDriver.entity.StoreVo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/24 12:28
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 展示司机负责的门店信息
     * @return
     */
    public AppResponse showStore(){
        List<StoreVo> storeVos = driverDao.showStore(SecurityUtils.getCurrentUserId());
        if (storeVos != null){
            return AppResponse.success("门店信息查询成功",storeVos);
        }else {
            return AppResponse.bizError("门店信息查询失败");
        }
    }
}
