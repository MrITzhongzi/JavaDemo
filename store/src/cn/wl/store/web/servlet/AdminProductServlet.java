package cn.wl.store.web.servlet;

import cn.wl.store.domain.PageModel;
import cn.wl.store.service.ProductService;
import cn.wl.store.service.serviceImp.ProductServiceImp;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AdminProductServlet extends BaseServlet {

    public String findAllProductsWithPage(HttpServletRequest req, HttpServletResponse resp){
        int curNum = Integer.parseInt(req.getParameter("num"));
        ProductService productService = new ProductServiceImp();
        try {
            PageModel pm = productService.findAllProductsWithPage(curNum);
            req.setAttribute("page", pm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/admin/product/list.jsp";
    }
    public String addProduct (HttpServletRequest req, HttpServletResponse resp){

        return "/admin/product/add.jsp";
    }

}
