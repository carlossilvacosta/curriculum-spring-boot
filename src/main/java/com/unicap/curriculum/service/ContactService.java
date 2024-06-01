package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Contact;
import com.unicap.curriculum.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return repository.findById(id);
    }

    public Optional<Contact> updateContact(Long id, Contact updateContact) {
        return repository.findById(id)
                .map(contact -> {
                    contact.setEmail(updateContact.getEmail() != null ? updateContact.getEmail() : contact.getEmail());
                    contact.setPhone(updateContact.getPhone() != null ? updateContact.getPhone() : contact.getPhone());
                    contact.setAddress(
                            updateContact.getAddress() != null ? updateContact.getAddress() : contact.getAddress());
                    return repository.save(contact);
                });
    }

    public String deleteContact(Long id) {
        try {
            repository.deleteById(id);
            return "Deletado com Sucesso!";
        } catch (Exception e) {
            return "Erro";
        }
    }
}
