package cn.wl.store.dao;

import cn.wl.store.domain.Order;
import cn.wl.store.domain.OrderItem;

import java.sql.Connection;

public interface OrderDao {
//    void saveOrder(Order order,  Connection con) throws Exception;
//
//    void saveOrderItem(OrderItem item, Connection con) throws Exception;

    void saveOrder(Order order) throws Exception;

    void saveOrderItem(OrderItem item) throws Exception;
}
