package cn.wl.store.dao.daoImp;

import cn.wl.store.dao.OrderDao;
import cn.wl.store.domain.Order;
import cn.wl.store.domain.OrderItem;
import cn.wl.store.domain.Product;
import cn.wl.store.domain.User;
import cn.wl.store.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    @Override
    public int getTotalRecord(User user) throws SQLException {
        String sql = "select count(*) from orders where uid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Long num = (Long)qr.query(sql,new ScalarHandler<>(), user.getUid());
        return num.intValue();
    }

    @Override
    public List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception {
        String sql = "select * from orders where uid = ? limit ?, ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> list = qr.query(sql, new BeanListHandler<>(Order.class),user.getUid(), startIndex, pageSize);

        for (Order order : list) {
//            order
            String oid = order.getOid();
            sql = "select * from orderitem o, product p where o.pid = p.pid and oid = ?";
            List<Map<String, Object>> list02 = qr.query(sql, new MapListHandler(), oid);
            for (Map<String, Object> map :
                    list02) {
                OrderItem orderItem = new OrderItem();
                Product product = new Product();
                // 1_创建时间类型的转换器
                DateConverter dt = new DateConverter();
                // 2_设置转换的格式
                dt.setPattern("yyyy-MM-dd");
                // 3_注册转换器
                ConvertUtils.register(dt, java.util.Date.class);
                BeanUtils.populate(orderItem, map);
                BeanUtils.populate(product, map);
                orderItem.setProduct(product);
                order.getList().add(orderItem);
            }
        }

        return list;
    }

    @Override
    public Order findOrderByOid(String oid) throws SQLException {
        String sql = "select * from orders where oid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Order order = qr.query(sql, new BeanHandler<>(Order.class), oid);
        sql = "select * from orderitem where oid = ?";
        List<OrderItem> list  = qr.query(sql, new BeanListHandler<>(OrderItem.class),oid);
        for (OrderItem orderItem:
             list) {
            sql = "select pid from orderitem where itemid = ?";
            String pid = qr.query(sql, new ScalarHandler<>(), orderItem.getItemid());
            sql = "select * from product where pid = ?";
            Product pro = qr.query(sql, new BeanHandler<>(Product.class), pid);
            orderItem.setProduct(pro);
            orderItem.setOrder(order);
        }
        order.setList(list);
        return order;
    }
}
