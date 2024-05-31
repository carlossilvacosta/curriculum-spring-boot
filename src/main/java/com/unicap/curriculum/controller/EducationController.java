package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Education;
import com.unicap.curriculum.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationService service;

    @PostMapping
    public Education save(@RequestBody Education education) {
        return service.createEducation(education);
    }

    @GetMapping
    public List<Education> getAll() {
        return service.getAllEducations();
    }

    @GetMapping("/{id}")
    public Education getById(@PathVariable Long id) {
        return service.getEducationById(id);
    }

    @PutMapping("/{id}")
    public Education update(@RequestBody Education education) {
        return service.updateEducation(education);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEducation(id);
    }

}