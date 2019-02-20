package cn.wl.store.dao.daoImp;

import cn.wl.store.dao.CategoryDao;
import cn.wl.store.domain.Category;
import cn.wl.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDaoImp implements CategoryDao {
    @Override
    public List<Category> getAllCats() throws Exception {
        String sql = "select * from category";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> query = qr.query(sql, new BeanListHandler<>(Category.class));

        return query;
    }
}
