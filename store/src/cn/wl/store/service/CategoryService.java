package cn.wl.store.service;

import cn.wl.store.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCats() throws Exception;
}
