package cn.wl.store.dao.daoImp;

import cn.wl.store.dao.OrderDao;
import cn.wl.store.domain.Order;
import cn.wl.store.domain.OrderItem;
import cn.wl.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class OrderDaoImp implements OrderDao {
//    @Override
//    public void saveOrder(Order order, Connection con) throws Exception {
//        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
//        QueryRunner qr = new QueryRunner();
//        Object[] params = {order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(),order.getName(), order.getTelephone(), order.getUser().getUid()};
//        qr.update(con,sql, params);
//    }
//
//    @Override
//    public void saveOrderItem(OrderItem item, Connection con) throws Exception {
//        String sql = "insert into orderitem values(?,?,?,?,?)";
//        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
//        Object[] params = {item.getItemid(),item.getQuantity(), item.getTotal(), item.getProduct().getPid(), item.getOrder().getOid()};
//        qr.update(con, sql, params);
//    }

    @Override
    public void saveOrder(Order order) throws Exception {
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(), order.getName(), order.getTelephone(), order.getUser().getUid()};
        qr.update(sql, params);
    }

    @Override
    public void saveOrderItem(OrderItem item) throws Exception {
        String sql = "insert into orderitem values(?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {item.getItemid(),item.getQuantity(), item.getTotal(), item.getProduct().getPid(), item.getOrder().getOid()};
        qr.update(sql, params);
    }
}
