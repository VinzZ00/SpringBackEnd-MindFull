package com.minidfull.backend.repository.goalRepository;

import com.minidfull.backend.entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GoalRepository extends JpaRepository<Goals, Long> {
    boolean existsByNameIgnoreCase(String name);
    Optional<Goals> findByGoalId(Long goalId);
}
