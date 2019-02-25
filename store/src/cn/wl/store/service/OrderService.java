package cn.wl.store.service;

import cn.wl.store.domain.Order;

import java.sql.SQLException;

public interface OrderService{
    void saveOrder(Order order) throws SQLException;
}
