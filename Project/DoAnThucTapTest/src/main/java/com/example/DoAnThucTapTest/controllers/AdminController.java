package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.service.BrandServiceImp;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import com.example.DoAnThucTapTest.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    ProductServiceImp productServiceImp;
    @Autowired
    CategoryServiceImp categoryServiceImp;
    @Autowired
    BrandServiceImp brandServiceImp;

    @GetMapping({"/admin", "/admin/dashboard"})
    public String index(Model model) {
        long productCount = productServiceImp.count();
        long categoryCount = categoryServiceImp.count();
        long brandCount = brandServiceImp.count();

        model.addAttribute("productCount", productCount);
        model.addAttribute("categoryCount", categoryCount);
        model.addAttribute("brandCount", brandCount);
        model.addAttribute("activePage", "dashboard");
        return "admin/index";
    }
    @GetMapping("/admin/category")
    public String catergoryList(){
        return "admin/category/category-list";
    }
    @GetMapping("/admin/product")
    public String productList(){
        return "admin/products/product-list";
    }
}
