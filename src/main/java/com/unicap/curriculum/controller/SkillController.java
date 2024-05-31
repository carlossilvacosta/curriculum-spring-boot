package com.unicap.curriculum.controller;

import com.unicap.curriculum.model.Skill;
import com.unicap.curriculum.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService service;

    @PostMapping
    public Skill save(@RequestBody Skill skill) {
        return service.createSkill(skill);
    }

    @GetMapping
    public List<Skill> getAll() {
        return service.getAllSkills();
    }

    @GetMapping("/{id}")
    public Skill getById(@PathVariable Long id) {
        return service.getSkillById(id);
    }

    @PutMapping("/{id}")
    public Skill update(@RequestBody Skill skill) {
        return service.updateSkill(skill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSkill(id);
    }
}