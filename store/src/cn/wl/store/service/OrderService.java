package cn.wl.store.service;

import cn.wl.store.domain.Order;
import cn.wl.store.domain.PageModel;
import cn.wl.store.domain.User;

import java.sql.SQLException;

public interface OrderService{
    void saveOrder(Order order) throws SQLException;

    PageModel findMyOrdersWithPage(User user, int curNum) throws Exception;

    Order findOrderByOid(String oid) throws SQLException;
}
