package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Experience;
import com.unicap.curriculum.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Experience> getExperienceById(Long id) {
        return repository.findById(id);
    }

    public Optional<Experience> updateExperience(Long id, Experience updatedExperience) {
        return repository.findById(id)
                .map(experience -> {
                    experience.setCompany(updatedExperience.getCompany() != null ? updatedExperience.getCompany()
                            : experience.getCompany());
                    experience.setPosition(updatedExperience.getPosition() != null ? updatedExperience.getPosition()
                            : experience.getPosition());
                    experience.setStartDate(updatedExperience.getStartDate() != null ? updatedExperience.getStartDate()
                            : experience.getStartDate());
                    experience.setEndDate(updatedExperience.getEndDate() != null ? updatedExperience.getEndDate()
                            : experience.getEndDate());
                    experience.setDescription(
                            updatedExperience.getDescription() != null ? updatedExperience.getDescription()
                                    : experience.getDescription());
                    return repository.save(experience);
                });
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