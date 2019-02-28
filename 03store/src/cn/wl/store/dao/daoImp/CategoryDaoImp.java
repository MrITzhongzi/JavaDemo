package cn.wl.store.dao.daoImp;

import cn.wl.store.dao.CategoryDao;
import cn.wl.store.domain.Category;
import cn.wl.store.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImp implements CategoryDao {
    @Override
    public List<Category> getAllCats() throws Exception {
        String sql = "select * from category";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> query = qr.query(sql, new BeanListHandler<>(Category.class));

        return query;
    }

    @Override
    public void addCartgory(Category category) throws SQLException {
        String sql = "insert into category values(?,?)";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql, category.getCid(), category.getCname());
    }

    @Override
    public Category getCategoryById(String cid) throws SQLException {
        String sql = "select * from category where cid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

        return qr.query(sql, new BeanHandler<>(Category.class),cid);
    }

    @Override
    public void updateCategory(Category category) throws SQLException {
        String sql = "update category set cname=? where cid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,category.getCname(), category.getCid());
    }

    @Override
    public void deleteCategory(String cid) throws SQLException {
        String sql = "delete from category where cid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql, cid);
    }
}
