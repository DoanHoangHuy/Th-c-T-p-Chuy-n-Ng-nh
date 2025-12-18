package com.example.DoAnThucTapTest.service;

import com.example.DoAnThucTapTest.dao.ProductDAO;
import com.example.DoAnThucTapTest.dao.ProductDAOImp;
import com.example.DoAnThucTapTest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    public final ProductDAO productDAO;

    @Autowired
    public ProductServiceImp(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void deleteById(int id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> findByStatus(int status) {
        return productDAO.findByStatus(status);
    }

    @Override
    public List<Product> findByCategoryId(int cateId) {
        return productDAO.findById_cateAndStatus(cateId, 1);
    }

    @Override
    public List<Product> findByCategoryIdAndBrandId(int id_cate, int id_brand, int status) {
        return productDAO.findByCategoryIdAndBrandId(id_cate, id_brand, status);
    }

    @Override
    public Long count() {
        return productDAO.count();
    }

    @Override
    public List<Product> findById_brandandStatus(int id_brand, int status) {
        return productDAO.findById_brandandStatus(id_brand, status);
    }


}
