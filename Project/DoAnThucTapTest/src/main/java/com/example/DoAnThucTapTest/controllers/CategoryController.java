package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.dao.CategoryDAOImp;
import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.service.CategoryService;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

        @Autowired
        private CategoryServiceImp categoryServiceImp;

        @GetMapping("/category-list")
        public String list(Model model){
            List<Category> categories = categoryServiceImp.findAll();
            model.addAttribute("categories", categories);
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
        public String saveCategory(@ModelAttribute("category")  Category category){
            categoryServiceImp.save(category);
            return  "redirect:/admin/category/category-list";
        }

        @GetMapping("/delete")
        public String deltetCategory(@RequestParam("id") int id){
            categoryServiceImp.deleteById(id);
            return "redirect:/admin/category/category-list";
        }
}
