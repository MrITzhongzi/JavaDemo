package cn.wl.store.web.servlet;

import cn.wl.store.domain.Category;
import cn.wl.store.service.CategoryService;
import cn.wl.store.service.serviceImp.CategoryServiceImp;
import cn.wl.store.utils.UUIDUtils;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class AdminCategoryServlet extends BaseServlet {

    public String findAllCats(HttpServletRequest req, HttpServletResponse resp) {
        CategoryService categoryService = new CategoryServiceImp();
        try {
            List<Category> allCats = categoryService.getAllCats();
            req.setAttribute("allCats", allCats);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/category/list.jsp";
    }

    public String addCartgory(HttpServletRequest req, HttpServletResponse resp) {
        String cateName = req.getParameter("cname");
        String cid = UUIDUtils.getId();
        Category category = new Category(cid, cateName);
        CategoryService categoryService = new CategoryServiceImp();
        try {
            categoryService.addCartgory(category);
            List<Category> allCats = categoryService.getAllCats();
            req.setAttribute("allCats", allCats);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/category/list.jsp";
    }

    public String editCategory(HttpServletRequest req, HttpServletResponse resp) {
        String cid = req.getParameter("cid");
        CategoryService categoryService = new CategoryServiceImp();
        Category category = null;
        try {
            category = categoryService.getCategoryById(cid);
            req.setAttribute("category", category);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/admin/category/edit.jsp";
    }

    public String updateCategory(HttpServletRequest req, HttpServletResponse resp) {
       String cid = req.getParameter("cid");
       String cname = req.getParameter("cname");

       CategoryService categoryService = new CategoryServiceImp();
        try {
            Category category = categoryService.getCategoryById(cid);
            category.setCname(cname);
            categoryService.updateCategory(category);
            List<Category> allCats = categoryService.getAllCats();
            req.setAttribute("allCats", allCats);
            req.getRequestDispatcher("/admin/category/list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteCategory(HttpServletRequest req, HttpServletResponse resp) {
        String cid = req.getParameter("cid");
       CategoryService categoryService = new CategoryServiceImp();
        try {
            categoryService.deleteCategory(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAllCats(req, resp);
    }

}
