package cn.cs.service.Impl;

import cn.cs.mapper.OrderItemMapper;
import cn.cs.mapper.OrderMapper;
import cn.cs.mapper.ProductMapper;
import cn.cs.mapper.ShopcarMapper;
import cn.cs.pojo.Order;
import cn.cs.pojo.OrderItem;
import cn.cs.pojo.Product;
import cn.cs.pojo.Shopcar;
import cn.cs.service.OrderService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.annotation.XmlAccessorOrder;
import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ShopcarMapper shopcarMapper;

    @Override
    public CSResult addOrder(Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        order.setId(UUID.randomUUID().toString());
        orderMapper.addOrder(order);
        //System.out.println(id);
        for(OrderItem item:orderItems){
            item.setoId(order.getId());
            orderItemMapper.addOrderItem(item);
            //System.out.println(item.getpId());
            shopcarMapper.deleteShopcar(item.getpId(),order.getuId());
        }
        return CSResult.ok(order.getId());
    }

    @Override
    public CSResult commitOrder(String id) {
        //首先修改该订单的状态
        orderMapper.updateOrder(id,new Date());
        //然后修改订单项中商品的数量
        List<OrderItem> list = orderItemMapper.getOrderItemList(id);
        for(OrderItem orderItem : list){
            Product product = new Product();
            product.setId(orderItem.getpId());
            product.setNumber(orderItem.getNumbers());
            product.setPaynum(orderItem.getNumbers());
            productMapper.updateProduct(product);
        }
        return CSResult.ok();
    }

    @Override
    public CSResult deleteOrder(String id) {
        //取消订单应先删除订单项
        orderItemMapper.deleteOrderItem(id);
        orderMapper.deleteOrder(id);
        return CSResult.ok() ;
    }

    @Override
    public CSResult getOrderList(Integer id) {
        List<Order> list = orderMapper.getOrderList(id);

        Map<String,List<Order>> map = new HashMap<>();
        List<Order> list1 = new ArrayList<>();
        List<Order> list2 = new ArrayList<>();
        for(Order order : list){
            List<OrderItem> orderItemList = orderItemMapper.getOrderItemList(order.getId());
            order.setOrderItems(orderItemList);
            if(order.getStatus()){
                list1.add(order);
            }else {
                list2.add(order);
            }
        }
        map.put("yes",list1);
        map.put("no",list2);
        List<Map<String,List<Order>>> mapList = new ArrayList<>();
        mapList.add(map);
        return CSResult.ok(mapList);
    }
}
