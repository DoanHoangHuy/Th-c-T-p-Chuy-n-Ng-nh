package com.example.DoAnThucTapTest.service;

import com.example.DoAnThucTapTest.entity.Brand;
import com.example.DoAnThucTapTest.entity.Category;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand findById(int id);
    Brand save(Brand brand);
    void deleteById(int id);
}
