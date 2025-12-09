package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.entity.Product;
import com.example.DoAnThucTapTest.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    ProductServiceImp productServiceImp;

    @GetMapping("/shop-list")
    public String PorudctList(Model model){
        List<Product> products = productServiceImp.findAll();
        model.addAttribute("products",products);
        return "/home/shop";
    }
}
