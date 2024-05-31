package com.unicap.curriculum.service;

import com.unicap.curriculum.model.Education;
import com.unicap.curriculum.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Education getEducationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Education updateEducation(Education education) {
        return repository.save(education);
    }

    public void deleteEducation(Long id) {
        repository.deleteById(id);
    }

}
