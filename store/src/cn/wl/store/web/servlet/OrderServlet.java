package cn.wl.store.web.servlet;

import cn.wl.store.domain.*;
import cn.wl.store.service.OrderService;
import cn.wl.store.service.serviceImp.OrderServiceImp;
import cn.wl.store.utils.PaymentUtil;
import cn.wl.store.utils.UUIDUtils;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

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

    public String findOrderByOid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String oid = req.getParameter("oid");
        OrderService orderService = new OrderServiceImp();
        Order order = orderService.findOrderByOid(oid);
        req.setAttribute("order", order);
        return "/jsp/order_info.jsp";
    }

    public String payOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, NoSuchAlgorithmException {
        String oid = req.getParameter("oid");
        String address = req.getParameter("address");
        String name = req.getParameter("name");
        String telephone = req.getParameter("telephone");
        String pd_FrpId = req.getParameter("pd_FrpId");

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        OrderService orderService = new OrderServiceImp();
        Order order = orderService.findOrderByOid(oid);
        order.setName(name);
        order.setTelephone(telephone);
        order.setAddress(address);

        orderService.updateOrder(order);

        String dataStr = oid  + order.getTotal() +  order.getState() + order.getAddress() + order.getName()  + order.getTelephone();
        md5.update( dataStr.getBytes());
        String mdStr = new BigInteger(1, md5.digest()).toString(16);

        StringBuffer mySb = new StringBuffer("/OrderServlet?method=callBack&oid=" + oid + "&total=" + order.getTotal() + "&state=" + order.getState() + "&address=" + order.getAddress() + "&name=" + order.getName() + "&telephone=" + order.getTelephone());
        mySb.append("&mdStr=").append(mdStr);

        System.out.println(mySb.toString());
        // 使用重定向：
        resp.sendRedirect(mySb.toString());
        return null;
    }

    public String callBack(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String oid = req.getParameter("oid");
        String total = req.getParameter("total");
        String state = req.getParameter("state");
        String address = req.getParameter("address");
        String name = req.getParameter("name");
        String telephone = req.getParameter("telephone");
        String mdStr = req.getParameter("mdStr");
        StringBuffer sb = new StringBuffer();
        sb.append(oid).append(total).append(state).append(address).append(name).append(telephone);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(sb.toString().getBytes());
        String callBackMdStr = new BigInteger(1, md5.digest()).toString(16);
        if(callBackMdStr.equals(mdStr)){
            OrderService orderService = new OrderServiceImp();
            Order orderByOid = orderService.findOrderByOid(oid);
            orderByOid.setState(2);
            orderService.updateOrder(orderByOid);
            System.out.println("支付成功");
            req.setAttribute("msg", "支付成功");
            return "/jsp/info.jsp";
        } else {
            System.out.println("数据被篡改过，支付失败");
            req.setAttribute("msg", "数据被篡改过，支付失败");
            return "/jsp/info.jsp";
        }
    }

}
