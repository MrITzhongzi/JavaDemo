package cn.wl.store.web.servlet;

import cn.wl.store.domain.Category;
import cn.wl.store.service.CategoryService;
import cn.wl.store.service.serviceImp.CategoryServiceImp;
import cn.wl.store.utils.JedisUtils;
import cn.wl.store.web.base.BaseServlet;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryServlet extends BaseServlet {
   public List<Category> findAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       //在redis中获取全部分类
       Jedis jedis = JedisUtils.getJedis();
       String allCats1 = jedis.get("allCats");
       if(null == allCats1 || "".equals(allCats1)){
           CategoryService categoryService = new CategoryServiceImp();
           List<Category> allCats = categoryService.getAllCats();

           String dataStr = JSON.toJSONString(allCats); //序列化
           jedis.set("allCats", dataStr);
           resp.setContentType("application/json;charset=utf-8");
           resp.getWriter().print(dataStr);
           System.out.println("没有缓存");
       } else {
           System.out.println("缓存");
           resp.setContentType("application/json;charset=utf-8");
           resp.getWriter().print(allCats1);
       }

       JedisUtils.closeJedis(jedis);
       return null;
   }
}
