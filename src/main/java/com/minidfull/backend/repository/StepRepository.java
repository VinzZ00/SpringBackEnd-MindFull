package com.minidfull.backend.repository;

import com.minidfull.backend.entity.Steps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StepRepository extends JpaRepository<Steps, Long> {
    Optional<Steps> findByStepId(Long stepId);
    boolean deleteByStepId(Long stepId);
    boolean existsByGoal_GoalId(Long goalId);
}
