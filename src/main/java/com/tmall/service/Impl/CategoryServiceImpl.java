package com.tmall.service.Impl;

import com.tmall.entity.Category;
import com.tmall.mapper.CategoryMapper;
import com.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public List<Category> listCategory() {
        return categoryMapper.list();
    }
}
