package cn.wl.store.web.base;

import cn.wl.store.domain.Cart;
import cn.wl.store.domain.Category;
import cn.wl.store.web.servlet.CartServlet;
import cn.wl.store.web.servlet.CategoryServlet;
import cn.wl.store.web.servlet.OrderServlet;
import cn.wl.store.web.servlet.ProductServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class BaseServlet extends javax.servlet.http.HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // localhost:8080/store/productServlet?method=addProduct
        String method = req.getParameter("method");

        if (null == method || "".equals(method) || method.trim().equals("")) {
            method = "execute";
        }

//        if(method.equals("findOrderByOid")){
//            try {
//                String oid = req.getParameter("oid");
//                OrderServlet orderServlet = new OrderServlet();
//                orderServlet.findOrderByOid(req, resp);
//                System.out.println(111);
//                return;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        // 注意:此处的this代表的是子类的对象
        // System.out.println(this);
        // 子类对象字节码对象
        Class clazz = this.getClass();

        try {
            // 查找子类对象对应的字节码中的名称为method的方法.这个方法的参数类型是:HttpServletRequest.class,HttpServletResponse.class
            Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);

            if(null!=md){
                String jspPath = (String) md.invoke(this, req, resp);
                if (null != jspPath) {
                    req.getRequestDispatcher(jspPath).forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 默认方法
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        return null;
    }
}

