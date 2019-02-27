package cn.wl.store.service.serviceImp;

import cn.wl.store.dao.CategoryDao;
import cn.wl.store.dao.daoImp.CategoryDaoImp;
import cn.wl.store.domain.Category;
import cn.wl.store.service.CategoryService;
import cn.wl.store.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImp implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImp();
    @Override
    public List<Category> getAllCats() throws Exception {


        return categoryDao.getAllCats();
    }

    @Override
    public void addCartgory(Category category) throws SQLException {
        categoryDao.addCartgory(category);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }

    @Override
    public Category getCategoryById(String cid) throws SQLException {

        return categoryDao.getCategoryById(cid);
    }

    @Override
    public void updateCategory(Category category) throws SQLException {
        categoryDao.updateCategory(category);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }

    @Override
    public void deleteCategory(String cid) throws SQLException {
        categoryDao.deleteCategory(cid);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }

}
