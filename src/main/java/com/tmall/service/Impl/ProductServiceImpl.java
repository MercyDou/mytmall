package com.tmall.service.Impl;

import com.tmall.entity.Category;
import com.tmall.entity.Product;
import com.tmall.entity.ProductExample;
import com.tmall.mapper.ProductMapper;
import com.tmall.service.CategoryService;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;

    @Override
    public List<Product> listProduct(int cid) {
        ProductExample productExample = new ProductExample();//productExample辅助查询类
        productExample.createCriteria().andCidEqualTo(cid);//表示查询cid字段
        productExample.setOrderByClause("id desc");
        List<Product> list = productMapper.selectByExample(productExample);
        System.out.println("list集合为：" + list);
        //setCategory(list);
        return list;
    }

   /*public void setCategory(List<Product> ps){
    for (Product p : ps)
        setCategory(p);
}
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.getCategory(cid);
        p.setCategory(c);
    }*/

    @Override
    public void addProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void deleteProduct(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Product getProduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override//为多个分类填充产品集合
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }

    @Override//为分类填充产品集合
    public void fill(Category c) {
        List<Product> ps = listProduct(c.getId());
        c.setProducts(ps);
    }

    //为多个分类填充产品集合，即把分类下的产品集合，按照8个为一行，拆成多行，利于后面数据展示
    @Override
    public void fillByRow(List<Category> cs) {
        //定义每行要列出的产品数为8个
        int productNumberEachRow = 8;
        //对该分类集合进行操作
        for (Category c : cs) {
            //获得该种类下的产品集合
            List<Product> products = c.getProducts();
            //新建集合的集合，即一个集合里面包含多个子集合，用于存放多个产品集合
            List<List<Product>> productsByRow = new ArrayList<>();
            //保证8个为一行
            for (int i = 0; i < products.size(); i += productNumberEachRow) {
                //获取每个产品集合（加起来）该显示的产品数量
                int size = i + productNumberEachRow;
                //如果size大于某个种类下的产品集合大小，显示数量就采用产品集合内产品的数量，否则采用size
                size = size > products.size() ? products.size() : size;
                //每个种类下的产品集合的显示数量为8个，通过截取子集合，每显示8个换行，每一行都是一个子集合
                //subList方法不会改变集合的原始结构，只是提供基于引用的视图
                List<Product> productsOfEachRow = products.subList(i, size);
                //将子集合放到存放集合的集合中
                productsByRow.add(productsOfEachRow);
            }
            //种类获取集合集
            c.setProductsByRow(productsByRow);
        }

    }
}
