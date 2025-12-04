package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);

}
