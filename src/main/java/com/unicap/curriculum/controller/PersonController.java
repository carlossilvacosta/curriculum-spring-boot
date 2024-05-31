package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Person;
import com.unicap.curriculum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Person getById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return service.creatPerson(person);
    }

    @PutMapping("/{id}")
    public Person update(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePerson(id);
    }
}
