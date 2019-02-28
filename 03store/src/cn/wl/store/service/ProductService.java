package cn.wl.store.service;

import cn.wl.store.domain.PageModel;
import cn.wl.store.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAllNewProducts() throws SQLException;

    List<Product> findAllHotProducts() throws SQLException;

    Product findProductByPid(String pid) throws SQLException;

    PageModel findProductsByCidWithPage(String cid, int curNum) throws SQLException;

    PageModel findAllProductsWithPage(int curNum) throws SQLException;

    void saveProduct(Product product) throws SQLException;
}
