package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.dao.CategoryDAOImp;
import com.example.DoAnThucTapTest.entity.Brand;
import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Product;
import com.example.DoAnThucTapTest.service.BrandServiceImp;
import com.example.DoAnThucTapTest.service.CategoryService;
import com.example.DoAnThucTapTest.service.CategoryServiceImp;
import com.example.DoAnThucTapTest.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    private BrandServiceImp brandService;
    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping("/brand-list")
    public String list(Model model){
        List<Brand> brands = brandService.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("activePage", "brand");
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
    public String saveCategory(@ModelAttribute("brand")  Brand brand, Model model, RedirectAttributes redirectAttributes){
        try {
            if (brand.getStatus() ==0 && brand.getId() !=0){
                List<Product> products = productServiceImp.findById_brandandStatus(brand.getId(),1);
                if(products !=null && !products.isEmpty()){
                    model.addAttribute("error",
                            "Không thể tắt trạng thái! Thương hiệu '" + brand.getName() + "' đang chứa " + products.size() + " sản phẩm.");
                    return "/admin/brand/Brand-edit-form";
                }
            }
            brandService.save(brand);
            redirectAttributes.addFlashAttribute("success", "Lưu thương hiệu thành công!");
        }
        catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi hệ thống khi lưu thương hiệu.");
        }
        return  "redirect:/admin/brand/brand-list";
    }

    @GetMapping("/delete")
    public String deltetCategory(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        try {
            List<Product> products = productServiceImp.findById_brandandStatus(id,1);
            if(products !=null && !products.isEmpty()){
                redirectAttributes.addFlashAttribute("error",
                        "Không thể xóa! Thương hiệu này đang chứa "
                                + products.size() + " sản phẩm.");
            }
            else {
                brandService.deleteById(id);
                redirectAttributes.addFlashAttribute("success", "Đã xóa danh mục thành công!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi khi xóa Thương hiệu.");
            e.printStackTrace();
        }
        return "redirect:/admin/brand/brand-list";
    }
}
