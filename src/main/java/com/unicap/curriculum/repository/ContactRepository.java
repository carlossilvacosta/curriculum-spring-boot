package com.unicap.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unicap.curriculum.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
