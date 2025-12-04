package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImp implements ProductDAO {
    private EntityManager em;

    @Autowired
    public ProductDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        if(product.getId() ==0){
            em.persist(product);
            return product;
        }
        else {
            return em.merge(product);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        em.remove(em.find(Product.class, id));
    }

}
