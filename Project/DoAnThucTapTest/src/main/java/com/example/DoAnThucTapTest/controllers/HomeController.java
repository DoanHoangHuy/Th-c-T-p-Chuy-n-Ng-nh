package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Product;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import com.example.DoAnThucTapTest.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductServiceImp productServiceImp;
    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping("/")
    public String index(Model model){
        List<Product> products = productServiceImp.findLatestProducts(6);
        List<Category> cateList = categoryServiceImp.findAll();
        model.addAttribute("cateList", cateList);
        model.addAttribute("productList", products);
        return "index";
    }
    @GetMapping("/service")
    public String service(){
        return "home/service";
    }
    @GetMapping("/contact")
    public String contact(){
        return "home/contact";
    }
    @GetMapping("/cart")
    public String cart(){
        return "home/cart";
    }
    @GetMapping("/checkout")
    public String checkout(){
        return "home/checkout";
    }
    @GetMapping("/thankyou")
    public String thankyou(){
        return "home/thankyou";
    }

}
