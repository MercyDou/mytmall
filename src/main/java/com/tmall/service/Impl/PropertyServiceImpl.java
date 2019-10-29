package com.tmall.service.Impl;

import com.tmall.entity.Property;
import com.tmall.entity.PropertyExample;
import com.tmall.mapper.PropertyMapper;
import com.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyMapper propertyMapper;
    @Override
    public List<Property> listProperty(int cid) {
        PropertyExample example = new PropertyExample();//propertyExample辅助查询类
        example.createCriteria().andCidEqualTo(cid);//表示查询cid字段
        example.setOrderByClause("id desc");
        return propertyMapper.selectByExample(example);
    }

    @Override
    public void addProperty(Property property) {
        propertyMapper.insert(property);
    }

    @Override
    public void deleteProperty(int id) {
        propertyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Property getProperty(int id) {
        return propertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public void editProperty(Property property) {
         propertyMapper.updateByPrimaryKeySelective(property);
    }

}
