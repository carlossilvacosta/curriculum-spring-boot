package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Contact;
import com.unicap.curriculum.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Contact> getById(@PathVariable Long id) {
        return service.getContactById(id);
    }

    @PutMapping("/{id}")
    public Optional<Contact> update(@PathVariable Long id, @RequestBody Contact contact) {
        return service.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteContact(id);
    }
}