package cn.wl.store.service.serviceImp;

import cn.wl.store.dao.CategoryDao;
import cn.wl.store.dao.daoImp.CategoryDaoImp;
import cn.wl.store.domain.Category;
import cn.wl.store.service.CategoryService;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    @Override
    public List<Category> getAllCats() throws Exception {
       CategoryDao categoryDao = new CategoryDaoImp();

        return categoryDao.getAllCats();
    }
}
