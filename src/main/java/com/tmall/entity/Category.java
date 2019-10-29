package com.tmall.entity;

import java.util.List;

public class Category {
    private Integer id;

    private String name;

    /*以下是用于前台数据展示*/
    private List<Product> products;//点击某个分类后进入到该分类下的产品页

    private List<List<Product>> productsByRow;//鼠标移动到某个分类后弹出的推荐产品项

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}