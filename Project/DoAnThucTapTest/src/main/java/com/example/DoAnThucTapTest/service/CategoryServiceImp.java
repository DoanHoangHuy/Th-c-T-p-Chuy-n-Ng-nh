package com.example.DoAnThucTapTest.service;

import com.example.DoAnThucTapTest.dao.CategoryDAO;
import com.example.DoAnThucTapTest.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImp(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> findAll(){
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(int id){
        return categoryDAO.findById(id);
    }

    @Override
    public Category save(Category category){
        return categoryDAO.save(category);
    }

    @Override
    public void deleteById(int id){
        categoryDAO.deleteById(id);
    }
}
