package cn.cs.mapper;


import cn.cs.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    long addOrder(Order order);

    void updateOrder(@Param("id") String id, @Param("time") Date date);

    void deleteOrder(String id);

    List<Order> getOrderList(Integer id);
}
