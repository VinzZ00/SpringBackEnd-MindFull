package com.minidfull.backend.repository;

import com.minidfull.backend.entity.Steps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StepRepository extends JpaRepository<Steps, Long> {
    Optional<Steps> findByStepId(Long stepId);
    boolean deleteByStepId(Long stepId);
}
