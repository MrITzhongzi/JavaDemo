package cn.wl.store.web.servlet;

import cn.wl.store.domain.Product;
import cn.wl.store.service.ProductService;
import cn.wl.store.service.serviceImp.ProductServiceImp;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ProductService productService = new ProductServiceImp();
        List<Product> newProducts =  productService.findAllNewProducts();
        List<Product> hotProducts = productService.findAllHotProducts();
        req.setAttribute("newProducts", newProducts);
        req.setAttribute("hotProducts", hotProducts);
        return "/jsp/index.jsp";
    }
}
