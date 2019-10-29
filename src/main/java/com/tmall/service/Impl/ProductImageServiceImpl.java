package com.tmall.service.Impl;

import com.tmall.entity.ProductImage;
import com.tmall.entity.ProductImageExample;
import com.tmall.mapper.ProductImageMapper;
import com.tmall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    ProductImageMapper productImageMapper;
    @Override
    public void add(ProductImage productImage) {


    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ProductImage> list(int pid) {
        ProductImageExample productImageExample = new ProductImageExample();//使用example辅助查询
        productImageExample.createCriteria().andPidEqualTo(pid);//表示查询pid字段
        productImageExample.setOrderByClause("id desc");//按pid降序
        return productImageMapper.selectByExample(productImageExample);
    }

    @Override
    public void get(int id) {

    }

    @Override
    public void update(ProductImage productImage) {

    }
}
