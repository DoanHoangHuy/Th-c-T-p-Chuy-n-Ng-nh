package com.example.DoAnThucTapTest.service;

import com.example.DoAnThucTapTest.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(int id);
    Contact save(Contact contact);
}
