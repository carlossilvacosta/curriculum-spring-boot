package com.unicap.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unicap.curriculum.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
