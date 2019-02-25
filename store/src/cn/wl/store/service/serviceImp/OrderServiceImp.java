package cn.wl.store.service.serviceImp;

import cn.wl.store.dao.OrderDao;
import cn.wl.store.dao.daoImp.OrderDaoImp;
import cn.wl.store.domain.Order;
import cn.wl.store.domain.OrderItem;
import cn.wl.store.service.OrderService;
import cn.wl.store.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderServiceImp implements OrderService {

    @Override
    public void saveOrder(Order order) throws SQLException {
//        Connection con = JDBCUtils.getConnection();
//       try{
//           con.setAutoCommit(false);
//           OrderDao orderDao = new OrderDaoImp();
//           orderDao.saveOrder(order, con);
//           for (OrderItem item: order.getList()) {
//               orderDao.saveOrderItem(item, con);
//           }
//           con.commit();
//       } catch (Exception e){
//           con.rollback();
//       }finally {
//           con.close();
//       }
        try{
            JDBCUtils.startTransaction();
            OrderDao orderDao = new OrderDaoImp();
            orderDao.saveOrder(order);
            for (OrderItem item: order.getList()) {
                orderDao.saveOrderItem(item);
            }
            JDBCUtils.commitAndClose();
        } catch (Exception e){
            JDBCUtils.rollbackAndClose();
        }
    }
}
