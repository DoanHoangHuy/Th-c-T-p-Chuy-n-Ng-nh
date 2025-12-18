package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.dao.CategoryDAOImp;
import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Product;
import com.example.DoAnThucTapTest.service.CategoryService;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import com.example.DoAnThucTapTest.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

        @Autowired
        private CategoryServiceImp categoryServiceImp;

        @Autowired
        private ProductServiceImp productServiceImp;
        @GetMapping("/category-list")
        public String list(Model model){
            List<Category> categories = categoryServiceImp.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("activePage", "category");
            return "admin/category/category-list";
        }

        @GetMapping("/Category-insert-form")
        public String insertForm(Model model){
            Category category = new Category();
            model.addAttribute("category",category);
            return "admin/category/Category-insert-form";
        }

        @GetMapping("/Category-edit-form")
        public String editForm(@RequestParam("id") int id, Model model){
            Category category = categoryServiceImp.findById(id);
            model.addAttribute("category",category);
            return "admin/category/category-edit-form";
        }

        @PostMapping("/save")
        public String saveCategory(@ModelAttribute("category")  Category category, Model model, RedirectAttributes redirectAttributes){
            try {
                if (category.getStatus() ==0 && category.getId() !=0){
                    List<Product> products = productServiceImp.findByCategoryId(category.getId());
                    if(products !=null && !products.isEmpty()){
                        model.addAttribute("error",
                                "Không thể tắt trạng thái! Danh mục '" + category.getName() + "' đang chứa " + products.size() + " sản phẩm.");
                        return "/admin/category/Category-edit-form";
                    }
                }
                categoryServiceImp.save(category);
                redirectAttributes.addFlashAttribute("success", "Lưu danh mục thành công!");
            }
            catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("error", "Lỗi hệ thống khi lưu danh mục.");
            }
            return  "redirect:/admin/category/category-list";
        }

        @GetMapping("/delete")
        public String deltetCategory(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
            try {
                List<Product> products = productServiceImp.findByCategoryId(id);
                if(products !=null && !products.isEmpty()){
                    redirectAttributes.addFlashAttribute("error",
                            "Không thể xóa! Danh mục này đang chứa "
                                    + products.size() + " sản phẩm.");
                }
                else {
                    categoryServiceImp.deleteById(id);
                    redirectAttributes.addFlashAttribute("success", "Đã xóa danh mục thành công!");
                }
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi khi xóa danh mục.");
                e.printStackTrace();
            }
            return "redirect:/admin/category/category-list";
        }

}
