package cn.cs.service;

import cn.cs.pojo.Order;
import cn.cs.utils.CSResult;

public interface OrderService {
    CSResult addOrder(Order order);

    CSResult commitOrder(String id);

    CSResult deleteOrder(String id);

    CSResult getOrderList(Integer id);
}
