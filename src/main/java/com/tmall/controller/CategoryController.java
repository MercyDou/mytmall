package com.tmall.controller;

import com.tmall.entity.Category;
import com.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model) {
        List<Category> cs = categoryService.listCategory();
        model.addAttribute("cs", cs);
        return "admin/listCategory";
    }
}
