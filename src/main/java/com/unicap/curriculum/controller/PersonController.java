package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Person;
import com.unicap.curriculum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> getAll() {
        return service.getAllPersons();
    }

    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return service.creatPerson(person);
    }

    @PutMapping("/{id}")
    public Optional<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return service.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deletePerson(id);
    }
}
