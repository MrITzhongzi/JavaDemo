package cn.wl.store.service.serviceImp;

import cn.wl.store.dao.ProductDao;
import cn.wl.store.dao.daoImp.ProductDaoImp;
import cn.wl.store.domain.PageModel;
import cn.wl.store.domain.Product;
import cn.wl.store.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImp implements ProductService {
    ProductDao productDao = new ProductDaoImp();
    @Override
    public List<Product> findAllNewProducts() throws SQLException {

        return productDao.findAllNewProducts();
    }

    @Override
    public List<Product> findAllHotProducts() throws SQLException {

        return productDao.findAllHotProducts();
    }

    @Override
    public Product findProductByPid(String pid) throws SQLException {
        return productDao.findProductByPid(pid);
    }

    @Override
    public PageModel findProductsByCidWithPage(String cid, int curNum) throws SQLException {
        int totalRecords = productDao.findTotalRecords(cid);
        PageModel pm = new PageModel(curNum, totalRecords, 12);
        List<Product> products = productDao.findProductsByCidWithPage(cid, pm.getStartIndex(), pm.getPageSize());
        pm.setList(products);
        pm.setUrl("ProductServlet?method=findProductsByCidWithPage&cid=" + cid);
        return pm;
    }
}
