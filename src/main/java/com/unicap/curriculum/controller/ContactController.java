package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Contact;
import com.unicap.curriculum.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService service;

    @PostMapping
    public Contact save(@RequestBody Contact contact) {
        return service.createContact(contact);
    }

    @GetMapping
    public List<Contact> getAll() {
        return service.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getById(@PathVariable Long id) {
        return service.getContactById(id);
    }

    @PutMapping("/{id}")
    public Contact update(@RequestBody Contact contact) {
        return service.updateContact(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteContact(id);
    }
}