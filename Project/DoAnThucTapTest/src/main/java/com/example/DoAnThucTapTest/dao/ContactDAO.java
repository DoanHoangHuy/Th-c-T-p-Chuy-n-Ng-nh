package com.example.DoAnThucTapTest.dao;

import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();
    Contact findById(int id);
    Contact save(Contact contact);
}
