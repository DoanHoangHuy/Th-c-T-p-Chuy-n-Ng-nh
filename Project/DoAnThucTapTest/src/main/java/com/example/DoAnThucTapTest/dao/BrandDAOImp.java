package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Brand;
import com.example.DoAnThucTapTest.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDAOImp implements BrandDAO {
    private EntityManager em;

    @Autowired
    public BrandDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Brand> findAll() {
        TypedQuery<Brand> query = em.createQuery( "FROM Brand ORDER BY id DESC",
                Brand.class);
        return query.getResultList();
    }

    @Override
    public Brand findById(int id) {
        Brand brand = em.find(Brand.class, id);
        return brand;
    }

    @Override
    @Transactional
    public Brand save(Brand brand) {
        if(brand.getId() ==0){
            em.persist(brand);
            return brand;
        }
        else {
            return em.merge(brand);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        em.remove(em.find(Brand.class, id));
    }
    @Override
    public Long count() {
        TypedQuery<Long> query = em.createQuery("SELECT count(b) FROM Brand b", Long.class);
        return query.getSingleResult();
    }
}
