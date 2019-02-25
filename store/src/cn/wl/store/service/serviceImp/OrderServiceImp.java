package cn.wl.store.service.serviceImp;

import cn.wl.store.dao.OrderDao;
import cn.wl.store.dao.daoImp.OrderDaoImp;
import cn.wl.store.domain.Order;
import cn.wl.store.domain.OrderItem;
import cn.wl.store.domain.PageModel;
import cn.wl.store.domain.User;
import cn.wl.store.service.OrderService;
import cn.wl.store.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImp implements OrderService {
    OrderDao orderDao = new OrderDaoImp();

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

            orderDao.saveOrder(order);
            for (OrderItem item: order.getList()) {
                orderDao.saveOrderItem(item);
            }
            JDBCUtils.commitAndClose();
        } catch (Exception e){
            JDBCUtils.rollbackAndClose();
        }
    }

    @Override
    public PageModel findMyOrdersWithPage(User user, int curNum) throws Exception {
        int totalRecord = orderDao.getTotalRecord(user);
        PageModel pm = new PageModel(curNum, totalRecord,3);
        List list = orderDao.findMyOrdersWithPage(user, pm.getStartIndex(), pm.getPageSize());
        pm.setList(list);
        pm.setUrl("OrderServlet?method=findMyOrdersWithPage");
        return pm;
    }
}
