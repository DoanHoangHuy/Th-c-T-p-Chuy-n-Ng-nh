package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Category;

public interface AppDAO {
    void save(Category category);
    Category findCategoryById(int id);
    void deleteCategoryById(int id);

}
