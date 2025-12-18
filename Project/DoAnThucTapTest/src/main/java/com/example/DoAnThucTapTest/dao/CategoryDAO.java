package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    Category findById(int id);
    Category save(Category category);
    void deleteById(int id);
    Long count();
}
