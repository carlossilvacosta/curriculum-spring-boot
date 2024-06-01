package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Education;
import com.unicap.curriculum.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    private EducationRepository repository;

    public Education createEducation(Education education) {
        return repository.save(education);
    }

    public List<Education> getAllEducations() {
        return repository.findAll();
    }

    public Optional<Education> getEducationById(Long id) {
        return repository.findById(id);
    }

    public Optional<Education> updateEducation(Long id, Education updatedEducation) {
        return repository.findById(id)
                .map(education -> {
                    education.setInstitution(education.getInstitution() != null ? updatedEducation.getInstitution()
                            : education.getInstitution());
                    education.setDegree(
                            education.getDegree() != null ? updatedEducation.getDegree() : education.getDegree());
                    education.setFieldOfStudy(education.getFieldOfStudy() != null ? updatedEducation.getFieldOfStudy()
                            : education.getFieldOfStudy());
                    education.setStartDate(education.getStartDate() != null ? updatedEducation.getStartDate()
                            : education.getStartDate());
                    education.setEndDate(education.getEndDate() != null ? updatedEducation.getEndDate()
                            : education.getEndDate());
                    return repository.save(education);
                });
    }

    public String deleteEducation(Long id) {
        try {
            repository.deleteById(id);
            return "Deletado com Sucesso!";
        } catch (Exception e) {
            return "Erro";
        }
    }
}
