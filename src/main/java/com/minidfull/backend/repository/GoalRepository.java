package com.minidfull.backend.repository;

import com.minidfull.backend.entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface GoalRepository extends JpaRepository<Goals, Long> {
    boolean existsByNameIgnoreCase(String name);
    boolean existsByGoalId(Long goalId);
    Optional<Goals> findByGoalId(Long goalId);
    boolean deleteGoalsByGoalId(long goalId);
    List<Goals> findAll();

    List<Goals> findAllByTimeBoundBefore(Date date);
}
