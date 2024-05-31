package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Experience;
import com.unicap.curriculum.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Experience getById(@PathVariable Long id) {
        return service.getExperienceById(id);
    }

    @PutMapping("/{id}")
    public Experience update(@RequestBody Experience experience) {
        return service.updateExperience(experience);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteExperience(id);
    }

}