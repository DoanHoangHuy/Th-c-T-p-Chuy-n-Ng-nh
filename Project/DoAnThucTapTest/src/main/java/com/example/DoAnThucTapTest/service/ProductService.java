package com.example.DoAnThucTapTest.service;

import com.example.DoAnThucTapTest.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
}
