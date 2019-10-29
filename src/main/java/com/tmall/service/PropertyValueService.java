package com.tmall.service;

import com.tmall.entity.Product;
import com.tmall.entity.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    void init(Product product);

    void update(PropertyValue propertyValue);

    PropertyValue get(int pid,int ptid);

    List<PropertyValue> list(int pid);
}
