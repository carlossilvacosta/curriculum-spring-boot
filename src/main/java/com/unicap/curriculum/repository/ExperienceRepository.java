package com.unicap.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unicap.curriculum.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
