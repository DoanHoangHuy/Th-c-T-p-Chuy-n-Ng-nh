package com.example.DoAnThucTapTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/category")
    public String catergoryList(){
        return "admin/category/category-list";
    }
    @GetMapping("/admin/product")
    public String productList(){
        return "admin/products/product-list";
    }
    @GetMapping("/admin/cart")
    public String cartList(){
        return "admin/cart/cart-list";
    }
}
