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
        return "about";
    }
    @GetMapping("/shop")
    public String shop(){
            return "shop";
    }
    @GetMapping("/service")
    public String service(){
        return "service";
    }
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }
    @GetMapping("/checkout")
    public String checkout(){
        return "checkout";
    }
    @GetMapping("/thankyou")
    public String thankyou(){
        return "thankyou";
    }

}
