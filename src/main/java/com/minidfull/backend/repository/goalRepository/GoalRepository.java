package com.minidfull.backend.repository.goalRepository;

import com.minidfull.backend.entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GoalRepository extends JpaRepository<Goals, Long> {
    boolean existsByName(String name);
    Goals findByGoalId(Long goalId);
}
