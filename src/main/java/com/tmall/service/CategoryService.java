package com.tmall.service;

import com.tmall.entity.Category;
import com.tmall.util.Page;

import java.util.List;

public interface CategoryService {
    public int total();

    public List<Category> listCategory(Page page);

    public void deleteCategory(int id);

    public void addCategory(Category category);
}
