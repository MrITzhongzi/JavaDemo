package cn.wl.store.dao.daoImp;

import cn.wl.store.dao.ProductDao;
import cn.wl.store.domain.Product;
import cn.wl.store.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    @Override
    public List<Product> findAllNewProducts() throws SQLException {
        String sql = "select * from product where pflag = 0 order by pdate desc limit 0,9 ";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> findAllHotProducts() throws SQLException {
        String sql = "select * from product where pflag = 0 and is_hot = 0 order by pdate desc limit 0,9";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<>(Product.class));
    }

    @Override
    public Product findProductByPid(String pid) throws SQLException {
        String sql = "select * from product where pid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<>(Product.class), pid);
    }

    @Override
    public int findTotalRecords(String cid) throws SQLException {
        String sql = "select count(*) from product where cid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Long num = (Long)qr.query(sql, new ScalarHandler<>(), cid);
        return num.intValue();
    }

    @Override
    public List<Product> findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws SQLException{
        String sql = "select * from product where cid = ? limit ?,?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.query(sql, new BeanListHandler<>(Product.class), cid, startIndex, pageSize);
        return qr.query(sql, new BeanListHandler<>(Product.class), cid, startIndex, pageSize);
    }

    @Override
    public int findProductCount() throws SQLException {
        String sql = "select count(*) from product";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Long count = (Long)qr.query(sql, new ScalarHandler<>());
        return count.intValue();
    }

    @Override
    public List<Product> findAllProductsWithPage(int curNum) throws SQLException {
        String sql = "select * from product order by pdate desc limit ?,?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> query = qr.query(sql, new BeanListHandler<>(Product.class), (curNum - 1) * 5, 5);
        return query;
    }

    @Override
    public void saveProduct(Product product) throws SQLException {
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(),product.getPimage(),product.getPdate(),product.getIsHot(), product.getPdesc(),product.getPflag(),product.getCid()};
        queryRunner.update(sql, params);
    }
}
