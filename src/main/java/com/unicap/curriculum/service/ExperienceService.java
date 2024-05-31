package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Experience;
import com.unicap.curriculum.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository repository;

    public Experience createExperience(Experience experience) {
        return repository.save(experience);
    }

    public List<Experience> getAllExperiences() {
        return repository.findAll();
    }

    public Experience getExperienceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Experience updateExperience(Experience experience) {
        return repository.save(experience);
    }

    public String deleteExperience(Long id) {
        try {
            repository.deleteById(id);
            return "Deletado com Sucesso!";
        } catch (Exception e) {
            return "Erro";
        }
    }
}