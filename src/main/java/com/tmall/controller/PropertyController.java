package com.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tmall.entity.Category;
import com.tmall.entity.Property;
import com.tmall.service.CategoryService;
import com.tmall.service.PropertyService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_property_list")
    public String listProperty(Model model, Page page, int cid) {
        Category c = categoryService.getCategory(cid);

        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Property> ps = propertyService.listProperty(cid);

        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + c.getId());// page.setParam("&cid=" + cid)

        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);
        return "admin/listProperty";
    }

    @RequestMapping("admin_property_add")
    public String addProperty(Property property, Model model) {
        propertyService.addProperty(property);
        //return "admin/listProperty";//如果直接跳转到jsp页面就会少了分页这部分，就会报错
        return "redirect:admin_property_list?cid=" + property.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String deleteProperty(int id) {
        Property property = propertyService.getProperty(id);
        propertyService.deleteProperty(id);
        return "redirect:admin_property_list?cid=" + property.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String editProperty(int id,Model model) {
        //这个id是listProperty.jsp传过来的id，也就是产品属性的id
        Property p = propertyService.getProperty(id);
        Category c = categoryService.getCategory(p.getCid());

        model.addAttribute("c", c);
        model.addAttribute("p", p);
        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String updateProperty(Property property) {
        propertyService.editProperty(property);
        return  "redirect:admin_property_list?cid="+property.getCid();
    }

}
