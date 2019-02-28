package cn.wl.store.dao;

import cn.wl.store.domain.Order;
import cn.wl.store.domain.OrderItem;
import cn.wl.store.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
//    void saveOrder(Order order,  Connection con) throws Exception;
//
//    void saveOrderItem(OrderItem item, Connection con) throws Exception;

    void saveOrder(Order order) throws Exception;

    void saveOrderItem(OrderItem item) throws Exception;

    int getTotalRecord(User user) throws SQLException;

    List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception;

    Order findOrderByOid(String oid) throws SQLException;

    void updateOrder(Order order) throws SQLException;
}
