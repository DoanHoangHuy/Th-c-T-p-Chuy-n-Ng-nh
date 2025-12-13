package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.dao.CategoryDAOImp;
import com.example.DoAnThucTapTest.entity.Brand;
import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.service.BrandServiceImp;
import com.example.DoAnThucTapTest.service.CategoryService;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    private BrandServiceImp brandService;

    @GetMapping("/brand-list")
    public String list(Model model){
        List<Brand> brands = brandService.findAll();
        model.addAttribute("brands", brands);
        return "admin/brand/brand-list";
    }

    @GetMapping("/Brand-insert-form")
    public String insertForm(Model model){
        Brand brand = new Brand();
        model.addAttribute("brand",brand);
        return "admin/brand/Brand-insert-form";
    }

    @GetMapping("/Brand-edit-form")
    public String editForm(@RequestParam("id") int id, Model model){
        Brand brand = brandService.findById(id);
        model.addAttribute("brand",brand);
        return "admin/brand/Brand-edit-form";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("brand")  Brand brand){
        brandService.save(brand);
        return  "redirect:/admin/brand/brand-list";
    }

    @GetMapping("/delete")
    public String deltetCategory(@RequestParam("id") int id){
        brandService.deleteById(id);
        return "redirect:/admin/brand/brand-list";
    }
}
