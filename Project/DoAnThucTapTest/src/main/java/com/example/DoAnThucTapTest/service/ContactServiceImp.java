package com.example.DoAnThucTapTest.service;

import com.example.DoAnThucTapTest.dao.ContactDAO;
import com.example.DoAnThucTapTest.entity.Contact;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService {
    private final ContactDAO contactDAO;

    @Autowired
    public ContactServiceImp(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Override
    public Contact findById(int id) {
        return contactDAO.findById(id);
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactDAO.save(contact);
    }
}
