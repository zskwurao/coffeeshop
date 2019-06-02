package cn.cs.mapper;

import cn.cs.pojo.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper {
    void addOrderItem(OrderItem item);

    List<OrderItem> getOrderItemList(String id);

    void deleteOrderItem(String id);
}
