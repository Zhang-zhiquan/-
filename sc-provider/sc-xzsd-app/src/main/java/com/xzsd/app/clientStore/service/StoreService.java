package com.xzsd.app.clientStore.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientOrder.entity.OrderMess;
import com.xzsd.app.clientOrder.entity.OrderVo;
import com.xzsd.app.clientStore.dao.StoreDao;
import com.xzsd.app.clientStore.entity.OrderDetails;
import com.xzsd.app.clientStore.entity.OrderInfo;
import com.xzsd.app.clientStore.entity.OrderMessDetail;
import com.xzsd.app.clientStore.entity.OrderMessVo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author quan
 * @Date 2020/4/23 11:36
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 获取店长信息
     * @return
     */
    public AppResponse showShopowner(){
        String currentUserId = SecurityUtils.getCurrentUserId();
        Map<String, String> storeMess = storeDao.showShopowner(currentUserId);
        String detailedAddress = null;
        //拼接省市区，返回完整地址
        if (storeMess.get("province").equals(storeMess.get("city"))){
            detailedAddress = storeMess.get("city") + storeMess.get("location") + storeMess.get("storeAddress");
        }else {
            detailedAddress = storeMess.get("province") + storeMess.get("city") + storeMess.get("location") + storeMess.get("storeAddress");
        }
        //删除map中的省市区，添加完整地址
        storeMess.remove("province");
        storeMess.remove("city");
        storeMess.remove("location");
        storeMess.remove("storeAddress");
        storeMess.put("detailedAddress",detailedAddress);
        return AppResponse.success("店长信息查询成功",storeMess);
    }

    /**
     * 获取门店的司机
     * @return
     */
    public AppResponse showDriver(){
        List<Map<String, String>> maps = storeDao.showDriver(SecurityUtils.getCurrentUserId());
        if (maps != null){
            return AppResponse.success("司机查询成功",maps);
        }else {
            return AppResponse.bizError("司机查询异常");
        }
    }

    /**
     * 店长查看订单列表
     * @return
     */
    public AppResponse showOrder(int sign){
        Map<String, String> storeId = storeDao.getStoreId(SecurityUtils.getCurrentUserId());
        if (storeId.get("storeId").equals("")){
            return AppResponse.bizError("未查询到订单");
        }
        List<OrderMessVo> orderlists = storeDao.showOrder(storeId.get("storeId"),sign);
        //计算订单下的商品总数量
        for (OrderMessVo order : orderlists){
            int totall = 0;
            List<OrderMessDetail> orderList = order.getOrderList();
            for (OrderMessDetail orderMess : orderList){
                totall += orderMess.getPurchaseNum();
            }
            order.setTotall(totall);
        }

        if (orderlists != null){
            return AppResponse.success("订单查询成功",orderlists);
        }else {
            return AppResponse.bizError("未查询到订单");
        }
    }

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    public AppResponse showOrderDetails(String orderId){
        List<OrderDetails> orderDetails = storeDao.showOrderDetails(orderId);
        //计算订单下的商品总数量
        for (OrderDetails order : orderDetails){
            int totall = 0;
            List<OrderInfo> orderList = order.getOrderList();
            for (OrderInfo orderMess : orderList){
                totall += orderMess.getPurchaseNum();
            }
            order.setTotall(totall);
        }

        return AppResponse.success("查看订单详情成功",orderDetails);
    }

    /**
     * 更改订单状态
     * @param orderId
     * @param sign
     * @return
     */
    public AppResponse alterOrderState(String orderId,int sign){
        int i = storeDao.alterOrderState(orderId,sign);
        if (i == 0){
            return AppResponse.bizError("订单状态未修改");
        }
        Map<String, String> orderState = storeDao.getOrderState(orderId);
        return AppResponse.success("订单状态修改成功",orderState);
    }

}
