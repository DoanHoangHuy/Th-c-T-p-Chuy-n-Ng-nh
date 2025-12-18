package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO {
    private EntityManager em;

    @Autowired
    public CategoryDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query = em.createQuery( "FROM Category",
                Category.class);
        return query.getResultList();
    }

    @Override
    public Category findById(int id) {
        Category category = em.find(Category.class, id);
        return category;
    }

    @Override
    @Transactional
    public Category save(Category category) {
        if(category.getId() ==0){
            em.persist(category);
            return category;
        }
        else {
            return em.merge(category);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        em.remove(em.find(Category.class, id));
    }
    @Override
    public Long count() {
        TypedQuery<Long> query = em.createQuery("SELECT count(c) FROM Category c", Long.class);
        return query.getSingleResult();
    }
}
