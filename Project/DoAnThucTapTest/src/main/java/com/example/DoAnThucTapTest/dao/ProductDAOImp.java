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
        TypedQuery<Product> query = em.createQuery("FROM Product ORDER BY id DESC", Product.class);
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

    @Override
    public List<Product> findByStatus(int status) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.status = :trangThai",
                            Product.class);
        query.setParameter("trangThai", status);
        return query.getResultList();
    }

    @Override
    public List<Product> findById_cateAndStatus(int id_cate, int status) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id_cate.id = :idcate AND status = :status ORDER BY id DESC" , Product.class);
        query.setParameter("idcate", id_cate);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List<Product> findByCategoryIdAndBrandId(int id_cate, int id_brand, int status) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id_cate.id = :idcate AND status = :status AND p.id_brand = :idbrand", Product.class);
        query.setParameter("idcate", id_cate);
        query.setParameter("status", status);
        query.setParameter("idbrand", id_brand);
        return query.getResultList();
    }
    @Override
    public Long count() {
        TypedQuery<Long> query = em.createQuery("SELECT count(p) FROM Product p", Long.class);
        return query.getSingleResult();
    }

    @Override
    public List<Product> findById_brandandStatus(int id_brand, int status) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id_brand.id = :idbrand AND status = :status", Product.class);
        query.setParameter("idbrand", id_brand);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List<Product> findLatestProducts(int limit) {
        String jpql = "SELECT p FROM Product p ORDER BY p.id DESC";

        TypedQuery<Product> query = em.createQuery(jpql, Product.class);

        query.setMaxResults(limit);

        return query.getResultList();
    }
}
