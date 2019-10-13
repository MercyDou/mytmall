package com.tmall.mapper;

import com.tmall.entity.Category;
import com.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {

    public int total();

    public void delete(int id);

    public void add(Category category);

    public List<Category> list(Page page);
}
