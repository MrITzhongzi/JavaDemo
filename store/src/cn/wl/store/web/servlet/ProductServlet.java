package cn.wl.store.web.servlet;

import cn.wl.store.domain.PageModel;
import cn.wl.store.domain.Product;
import cn.wl.store.service.ProductService;
import cn.wl.store.service.serviceImp.ProductServiceImp;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends BaseServlet {

    public String findProductByPid(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pid = req.getParameter("pid");
        ProductService productService = new ProductServiceImp();
        Product pro = productService.findProductByPid(pid);
        req.setAttribute("product", pro);
        return "/jsp/product_info.jsp";
    }
    public String findProductsByCidWithPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String cid = req.getParameter("cid");
        int curNum = Integer.parseInt(req.getParameter("num"));
        ProductService productService = new ProductServiceImp();
        PageModel pm = productService.findProductsByCidWithPage(cid, curNum);
        req.setAttribute("page", pm);
        return "/jsp/product_list.jsp";
    }

}
