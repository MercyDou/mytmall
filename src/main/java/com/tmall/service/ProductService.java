package com.tmall.service;

import com.tmall.entity.Category;
import com.tmall.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listProduct(int cid);

    public void addProduct(Product product);

    public void deleteProduct(int id);

    public Product getProduct(int id);

    public void updateProduct(Product product);

    public void fill(List<Category> cs);

    public void fill(Category c);

    public void fillByRow(List<Category> cs);
}
