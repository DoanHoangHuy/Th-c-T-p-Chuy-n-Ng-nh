package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDAOImp implements ContactDAO {
    private EntityManager em;
    public ContactDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Contact> findAll() {
        TypedQuery<Contact> query = em.createQuery( "FROM Contact ORDER BY id DESC",
                Contact.class);
        return query.getResultList();
    }

    @Override
    public Contact findById(int id) {
        Contact contact = em.find(Contact.class, id);
        return contact;
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        if(contact.getId() ==0){
            em.persist(contact);
            return contact;
        }
        else {
            return em.merge(contact);
        }
    }
}
