package com.tmall.service.Impl;

import com.tmall.entity.Category;
import com.tmall.mapper.CategoryMapper;
import com.tmall.service.CategoryService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public int total() {
        return categoryMapper.total();
    }

    @Override
    public List<Category> listCategory(Page page) {
        return categoryMapper.list(page);
    }

    @Override
    public void deleteCategory(int id) {
         categoryMapper.delete(id);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.add(category);
    }
}
