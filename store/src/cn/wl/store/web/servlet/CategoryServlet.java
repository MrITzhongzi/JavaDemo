package cn.wl.store.web.servlet;

import cn.wl.store.domain.Category;
import cn.wl.store.service.CategoryService;
import cn.wl.store.service.serviceImp.CategoryServiceImp;
import cn.wl.store.web.base.BaseServlet;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryServlet extends BaseServlet {
   public List<Category> findAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       CategoryService categoryService = new CategoryServiceImp();
       List<Category> allCats = categoryService.getAllCats();

       String dataStr = JSON.toJSONString(allCats); //序列化
       resp.setContentType("application/json;charset=utf-8");
       resp.getWriter().print(dataStr);
       return null;
   }
}
