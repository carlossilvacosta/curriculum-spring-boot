package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Person;
import com.unicap.curriculum.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person creatPerson(Person person) {
        return repository.save(person);
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public Person getPersonById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Person updatePerson(Person person) {
        return repository.save(person);
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }
}
