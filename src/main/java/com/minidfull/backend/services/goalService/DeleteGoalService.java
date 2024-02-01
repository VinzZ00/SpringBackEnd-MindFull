package com.minidfull.backend.services.goalService;

import com.minidfull.backend.dto.BackEndException;
import com.minidfull.backend.dto.DeleteGoalsDTO;
import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.repository.GoalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DeleteGoalService {

    @Autowired private GoalRepository repository;
    @Autowired private Validator validator;

    @Transactional
    public void deleteGoal(DeleteGoalsDTO goal) {

        Set<ConstraintViolation<DeleteGoalsDTO>> violations = validator.validate(goal);

        if (violations.size() > 0) {
            throw new ConstraintViolationException(violations);
        }

        for(Long g : goal.getGoalIds()) {
            if (repository.existsByGoalId(g))
                repository.deleteGoalsByGoalId(g);
            else
                // Note: This will make the past deletion discarded as well if have one, due to transactional annotated Method.
                throw BackEndException.notFoundException(Goals.class.getName());
        }
    }
}
