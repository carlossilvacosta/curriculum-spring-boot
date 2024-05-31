package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Skill;
import com.unicap.curriculum.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository repository;

    public Skill createSkill(Skill skill) {
        return repository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    public Skill getSkillById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Skill updateSkill(Skill skill) {
        return repository.save(skill);
    }

    public void deleteSkill(Long id) {
        repository.deleteById(id);
    }
}
