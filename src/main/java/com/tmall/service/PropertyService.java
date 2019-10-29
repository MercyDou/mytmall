package com.tmall.service;

import com.tmall.entity.Property;

import java.util.List;

public interface PropertyService {
    public List<Property> listProperty(int cid);

    public void addProperty(Property property);

    public void deleteProperty(int id);

    public Property getProperty(int id);

    public void editProperty(Property property);

}
