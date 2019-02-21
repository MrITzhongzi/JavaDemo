package cn.wl.store.dao;

import cn.wl.store.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findAllNewProducts() throws SQLException;

    List<Product> findAllHotProducts() throws SQLException;

    Product findProductByPid(String pid) throws SQLException;

    int findTotalRecords(String cid) throws SQLException;

    List<Product> findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws SQLException;

}
