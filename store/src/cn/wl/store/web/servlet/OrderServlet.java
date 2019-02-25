package cn.wl.store.web.servlet;

import cn.wl.store.domain.*;
import cn.wl.store.service.OrderService;
import cn.wl.store.service.serviceImp.OrderServiceImp;
import cn.wl.store.utils.UUIDUtils;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Date;

public class OrderServlet extends BaseServlet {
    public String saveOrder(HttpServletRequest req, HttpServletResponse resp){
        //确认用户登录
        User user = (User)req.getSession().getAttribute("loginUser");
        if(null == user) {
            req.setAttribute("msg", "请登录之后再下单");
            return "/jsp/info.jsp";
        }
        //创建订单对象，为订单对象赋值。
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        Order order = new Order();
        order.setOid(UUIDUtils.getCode());
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setState(1);
        order.setUser(user);
        //创建订单项
        for (CartItem cartitem : cart.getList()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UUIDUtils.getCode());
            orderItem.setQuantity(cartitem.getNum());
            orderItem.setTotal(cartitem.getSubTotal());
            orderItem.setProduct(cartitem.getProduct());
            orderItem.setOrder(order);

           order.getList().add(orderItem);
        }
        OrderService orderService = new OrderServiceImp();
        try {
            orderService.saveOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //清空购物车
        cart.clearCart();
        // 将订单放入request
        req.setAttribute("order", order);
        //转发到下一个页面 jsp/order_info.jsp
        return "/jsp/order_info.jsp";
    }

    public String findMyOrdersWithPage(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        User user = (User)req.getSession().getAttribute("loginUser");
        int curNum = Integer.parseInt(req.getParameter("num"));
        OrderService orderService = new OrderServiceImp();
        PageModel pm = null;
        try {
            pm = orderService.findMyOrdersWithPage(user, curNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("page", pm);
        return "/jsp/order_list.jsp";
    }
}
