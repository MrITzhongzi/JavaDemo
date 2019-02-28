package cn.wl.store.dao;

import cn.wl.store.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> getAllCats() throws Exception;

    void addCartgory(Category category) throws SQLException;

    Category getCategoryById(String cid) throws SQLException;

    void updateCategory(Category category) throws SQLException;

    void deleteCategory(String cid) throws SQLException;
}
