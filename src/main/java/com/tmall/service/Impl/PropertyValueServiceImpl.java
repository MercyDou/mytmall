package com.tmall.service.Impl;

import com.tmall.entity.Product;
import com.tmall.entity.Property;
import com.tmall.entity.PropertyValue;
import com.tmall.entity.PropertyValueExample;
import com.tmall.mapper.PropertyValueMapper;
import com.tmall.service.PropertyService;
import com.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    PropertyValueMapper propertyValueMapper;
    @Autowired
    PropertyService propertyService;


    @Override
    public void init(Product product) {
        //需要获得property和propertyValue,每个Category下有多个Product，每个Product里面有多个property，每个property对应着唯一的propertyValue
        List<Property> pts = propertyService.listProperty(product.getCid());
        for (Property pt : pts) {
            PropertyValue pv = get(pt.getId(), product.getId());
            if (null == pv) {
                pv = new PropertyValue();
                pv.setPid(product.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }


    }

    @Override
    public void update(PropertyValue propertyValue) {
        propertyValueMapper.updateByPrimaryKeySelective(propertyValue);
    }

    @Override
    public PropertyValue get(int pid, int ptid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid).andPtidEqualTo(ptid);
        List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
        if(pvs.isEmpty())
             return null;
        return pvs.get(0);
    }

    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> result = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv : result) {
            Property property = propertyService.getProperty(pv.getPtid());
            pv.setProperty(property);
        }
        return result;
    }
}
