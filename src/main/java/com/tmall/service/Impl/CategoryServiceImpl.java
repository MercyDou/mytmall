package com.tmall.service.Impl;

import com.tmall.entity.Category;
import com.tmall.entity.CategoryExample;
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
    public List<Category> listCategory() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void deleteCategory(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public Category getCategory(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void editCategory(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);//只修改变化了的字段，未变化的字段就不修改了
    }


}
