package com.example.DoAnThucTapTest.controllers;

import com.example.DoAnThucTapTest.entity.Contact;
import com.example.DoAnThucTapTest.service.ContactServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/contact")
public class ContactController {
    @Autowired
    ContactServiceImp contactServiceImp;

    @GetMapping("/contact-list")
    public String contactList(Model model) {
        List<Contact> contacts = contactServiceImp.findAll();
        model.addAttribute("contacts", contacts);
        model.addAttribute("activePage", "contact");
        return "admin/contact/contact-list";
    }

    @GetMapping("/edit-contact-form")
    public String editContactForm(@RequestParam("id") int id, Model model) {
        Contact contact = contactServiceImp.findById(id);
        model.addAttribute("contact", contact);
        return "admin/contact/edit-contact-form";
    }

    @PostMapping("/save-admin")
    public String saveAdmin(@ModelAttribute("contact")Contact contact) {
        contactServiceImp.save(contact);
        return "redirect:/admin/contact/contact-list";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("contact")Contact contact, RedirectAttributes redirectAttributes) {
        contactServiceImp.save(contact);
        redirectAttributes.addFlashAttribute("successMessage",
                "Chúng tôi đã nhận được phản hồi và sẽ sớm liên hệ với bạn thông qua Email cá nhân của bạn.");
        return "redirect:/contact";
    }
}
