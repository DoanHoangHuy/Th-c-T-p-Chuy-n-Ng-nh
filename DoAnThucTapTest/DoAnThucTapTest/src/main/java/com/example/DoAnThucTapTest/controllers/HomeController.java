package com.example.DoAnThucTapTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
        @GetMapping("/")
        public String index(){
            return "index";
        }
    @GetMapping("/about")
    public String about(){
        return "home/about";
    }
    @GetMapping("/shop")
    public String shop(){
            return "home/shop";
    }
    @GetMapping("/service")
    public String service(){
        return "home/service";
    }
    @GetMapping("/blog")
    public String blog(){
        return "home/blog";
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
    @GetMapping("/admin")
    public String admin(){
            return "admin";
    }

}
