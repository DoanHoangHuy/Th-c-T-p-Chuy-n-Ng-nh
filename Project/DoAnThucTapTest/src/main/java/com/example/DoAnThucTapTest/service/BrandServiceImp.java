package com.example.DoAnThucTapTest.service;

import com.example.DoAnThucTapTest.dao.BrandDAO;
import com.example.DoAnThucTapTest.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp implements BrandService {
    private BrandDAO brandDAO;

    @Autowired
    public BrandServiceImp(BrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    @Override
    public List<Brand> findAll() {
        return brandDAO.findAll();
    }

    @Override
    public Brand findById(int id) {
        return brandDAO.findById(id);
    }

    @Override
    public Brand save(Brand brand) {
        return brandDAO.save(brand);
    }

    @Override
    public void deleteById(int id) {
        brandDAO.deleteById(id);
    }

    @Override
    public Long count() {
        return brandDAO.count();
    }
}
