package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Skill;
import com.unicap.curriculum.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Skill> getSkillById(Long id) {
        return repository.findById(id);
    }

    public Optional<Skill> updateSkill(Long id, Skill updateSkill) {
        return repository.findById(id)
                .map(skill -> {
                    skill.setName(updateSkill.getName() != null ? updateSkill.getName() : skill.getName());
                    skill.setLevel(updateSkill.getLevel() != null ? updateSkill.getLevel() : skill.getLevel());
                    return repository.save(skill);
                });
    }

    public String deleteSkill(Long id) {
        try {
            repository.deleteById(id);
            return "Deletado com Sucesso!";
        } catch (Exception e) {
            return "Erro";
        }
    }
}
