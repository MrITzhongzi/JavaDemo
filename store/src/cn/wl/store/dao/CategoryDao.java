package cn.wl.store.dao;

import cn.wl.store.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCats() throws Exception;
}
