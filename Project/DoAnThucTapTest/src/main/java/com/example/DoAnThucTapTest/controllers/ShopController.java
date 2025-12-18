package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Product;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import com.example.DoAnThucTapTest.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    ProductServiceImp productServiceImp;
    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping("/categories")
    public String showCategoryList(Model model) {
        List<Category> cateList = categoryServiceImp.findAll();
        model.addAttribute("cateList", cateList);

        return "home/shop-category";
    }

    @GetMapping("/shop-list")
    public String PorudctList(Model model, @RequestParam(name="cateid", required = false) Integer cateid) {
        List<Product> products;
        if(cateid == null){
            products = productServiceImp.findByStatus(1);
        }
        else {
            products = productServiceImp.findByCategoryId(cateid);
        }
        List<Category> cateList =  categoryServiceImp.findAll();
        model.addAttribute("products", products);
        model.addAttribute("cateList", cateList);
        model.addAttribute("currentId",cateid);

        return "home/shop";
    }
    @GetMapping("/product-detail")
    public String ProductDetail(@RequestParam(name = "id") Integer id, Model model) {
        Product product = productServiceImp.findById(id);
        model.addAttribute("product", product);
        return "home/productdetail";
    }

}
