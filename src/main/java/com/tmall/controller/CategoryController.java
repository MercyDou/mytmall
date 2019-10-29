    package com.tmall.controller;

    import com.github.pagehelper.PageHelper;
    import com.github.pagehelper.PageInfo;
    import com.tmall.entity.Category;
    import com.tmall.service.CategoryService;
    import com.tmall.util.ImageUtil;
    import com.tmall.util.Page;
    import com.tmall.util.UploadedImgFile;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.multipart.MultipartFile;

    import javax.imageio.ImageIO;
    import javax.servlet.http.HttpSession;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import java.util.List;

    @Controller
    @RequestMapping("")
    public class CategoryController {
        @Autowired
        CategoryService categoryService;

        @RequestMapping("admin_category_list")
        public String list(Model model, Page page) {
            PageHelper.offsetPage(page.getStart(), page.getCount());
            List<Category> cs = categoryService.listCategory();
            int total = (int) new PageInfo<>(cs).getTotal();
            System.out.println("分类total为：" + total);
            page.setTotal(total);
            model.addAttribute("page", page);
            model.addAttribute("cs", cs);
            return "admin/listCategory";
        }

        @RequestMapping("admin_category_delete")
        public String delete(int id) throws IOException {
            System.out.println("id为" + id);
            categoryService.deleteCategory(id);
            return "redirect:/admin_category_list";
        }

        @RequestMapping("admin_category_add")
        public String add(Category category, HttpSession session, UploadedImgFile uploadedImgFile) throws IOException {
            categoryService.addCategory(category);
            File imageFloder = new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFloder, category.getId() + ".jpg");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            uploadedImgFile.getImage().transferTo(file);
            BufferedImage image = ImageUtil.chang2jpg(file);
            ImageIO.write(image, "img", file);
            return "redirect:/admin_category_list";
        }

        @RequestMapping("admin_category_get")
        public String get(int id, Model model) throws IOException {
            Category category = categoryService.getCategory(id);
            model.addAttribute("c", category);
            return "admin/editCategory";
        }

        @RequestMapping("admin_category_edit")
        public String edit(HttpSession session, Category category,UploadedImgFile uploadedImgFile)throws IOException {
            categoryService.editCategory(category);
            MultipartFile image = uploadedImgFile.getImage();
            if (null != image &&!image.isEmpty()) {
                File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
                File file = new File(imageFolder, category.getId() + ".jpg");
                image.transferTo(file);
                BufferedImage img = ImageUtil.chang2jpg(file);
                ImageIO.write(img, "jpg", file);
            }
            return "redirect:/admin_category_list";
        }
    }
