package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImp implements AppDAO {
    private EntityManager entityManager;

    public AppDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category findCategoryById(int id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        Category tempCategory = entityManager.find(Category.class, id);
        entityManager.remove(tempCategory);
    }

}
