package com.tmall.service;

import com.tmall.entity.ProductImage;

import java.util.List;

public interface ProductImageService {
    void add(ProductImage productImage);

    void delete(int id);

    List<ProductImage> list(int pid);

    void get(int id);

    void update(ProductImage productImage);
}
