package cn.wl.store.web.servlet;

import cn.wl.store.domain.Category;
import cn.wl.store.service.CategoryService;
import cn.wl.store.service.serviceImp.CategoryServiceImp;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        CategoryService categoryService = new CategoryServiceImp();
        List<Category> list = categoryService.getAllCats();
        req.setAttribute("callCats", list);
        return "/jsp/index.jsp";
    }
}
