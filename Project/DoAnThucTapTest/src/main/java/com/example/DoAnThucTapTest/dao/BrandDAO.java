package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Brand;
import com.example.DoAnThucTapTest.entity.Category;

import java.util.List;

public interface BrandDAO {
    List<Brand> findAll();
    Brand findById(int id);
    Brand save(Brand brand);
    void deleteById(int id);
    Long count();
}
