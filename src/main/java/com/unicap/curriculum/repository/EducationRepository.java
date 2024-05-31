package com.unicap.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unicap.curriculum.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
