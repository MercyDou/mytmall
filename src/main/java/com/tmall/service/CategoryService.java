package com.tmall.service;

import com.tmall.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> listCategory();

    public void deleteCategory(int id);

    public void addCategory(Category category);

    public Category getCategory(int id);

    public void editCategory(Category category);
}
