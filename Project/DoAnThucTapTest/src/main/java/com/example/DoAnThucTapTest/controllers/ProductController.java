package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.dao.ProductDAO;
import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Product;
import com.example.DoAnThucTapTest.service.CategoryService;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import com.example.DoAnThucTapTest.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("/product-list")
    public String list(Model model){
        List<Product> products = productServiceImp.findAll();
        model.addAttribute("products", products);
        return "admin/products/product-list";
    }

    @GetMapping("/Product-insert-form")
    public String insertForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);

        List<Category> cateList = categoryServiceImp.findAll();
        model.addAttribute("cateList", cateList);
        return "admin/products/Product-insert-form";
    }

    @GetMapping("/Product-edit-form")
    public String editForm(@RequestParam("id") int id, Model model){
        Product product = productServiceImp.findById(id);
        model.addAttribute("product", product);

        List<Category> cateList = categoryServiceImp.findAll();
        model.addAttribute("cateList", cateList);
        return "admin/products/Product-edit-form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        productServiceImp.save(product);
        return "redirect:/admin/products/product-list";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id){
        productServiceImp.deleteById(id);
        return "redirect:/admin/products/product-list";
    }

}
