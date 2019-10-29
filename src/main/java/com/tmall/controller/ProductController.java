package com.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tmall.entity.Category;
import com.tmall.entity.CategoryExample;
import com.tmall.entity.Product;
import com.tmall.service.CategoryService;
import com.tmall.service.ProductService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    //controller不仅要考虑前台还要考虑后台，两者缺一不可
    @RequestMapping("admin_product_list")
    /*controller接受后台传递过来的 1.根据cid查询出来的product集合 2.
    在jsp里面放入 1.product集合 2.分页参数 3.cid用于面包屑导航栏的展示
    */
    public String list(Model model, Page page, int cid) {
        Category c = categoryService.getCategory(cid);

        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Product> ps = productService.listProduct(cid);

        int total = (int) new PageInfo<>(ps).getTotal();//通过pageinfo获取产品总数
        System.out.println("total为：" + total);
        page.setTotal(total);
        page.setParam("&cid=" + c.getId());//必须设置，不然无法正常分页

        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
        model.addAttribute("c", c);

        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String add(Product product, Model model) {
        product.setCreateDate(new Date());
        productService.addProduct(product);
        return "redirect:admin_product_list?cid=" + product.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String delete(int id) {
        Product product = productService.getProduct(id);
        productService.deleteProduct(id);
        return "redirect:admin_product_list?cid=" + product.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String edit(int id,Model model) {
        Product product = productService.getProduct(id);//取得的是产品的id不是分类的id即产品的cid
        //Category category = categoryService.getCategory(id);
        model.addAttribute("p", product);
        System.out.println("cid为："+product.getCid());
        return "admin/editProduct";
    }

    @RequestMapping("admin_product_update")
    public String update(Product product) {
        productService.updateProduct(product);
       // System.out.println("cid为"+product.getCid());
        return "redirect:admin_product_list?cid=" + product.getCid();
    }
}
