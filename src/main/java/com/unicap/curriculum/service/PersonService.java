package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Person;
import com.unicap.curriculum.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Person> getPersonById(Long id) {
        return repository.findById(id);
    }

    public Optional<Person> updatePerson(Long id, Person updatedPerson) {
        return repository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName() != null ? updatedPerson.getName() : person.getName());
                    person.setAge(updatedPerson.getAge() != 0 ? updatedPerson.getAge() : person.getAge());
                    person.setSummary(
                            updatedPerson.getSummary() != null ? updatedPerson.getSummary() : person.getSummary());
                    return repository.save(person);
                });
    }

    public String deletePerson(Long id) {
        try {
            repository.deleteById(id);
            return "Deletado com Sucesso!";
        } catch (Exception e) {
            return "Erro";
        }
    }
}
