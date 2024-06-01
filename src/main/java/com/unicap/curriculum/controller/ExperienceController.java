package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Experience;
import com.unicap.curriculum.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService service;

    @PostMapping
    public Experience save(@RequestBody Experience experience) {
        return service.createExperience(experience);
    }

    @GetMapping
    public List<Experience> getAll() {
        return service.getAllExperiences();
    }

    @GetMapping("/{id}")
    public Optional<Experience> getById(@PathVariable Long id) {
        return service.getExperienceById(id);
    }

    @PutMapping("/{id}")
    public Optional<Experience> update(@PathVariable Long id, @RequestBody Experience experience) {
        return service.updateExperience(id, experience);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteExperience(id);
    }

}