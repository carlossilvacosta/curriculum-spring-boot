package com.unicap.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unicap.curriculum.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
