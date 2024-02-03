package com.minidfull.backend.services.goalService;

import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.dto.BackEndException;
import com.minidfull.backend.dto.goalDtos.UpdateGoalDTO;
import com.minidfull.backend.repository.GoalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UpdateGoalService{

    @Autowired private GoalRepository repository;
    @Autowired private Validator validator;

    @Transactional
    public void updateGoal(UpdateGoalDTO goal) {

        Set<ConstraintViolation<UpdateGoalDTO>> violations = validator.validate(goal);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        Goals retGoal = repository
                .findByGoalId(goal.getGoalId())
                .orElseThrow(() -> BackEndException.notFoundException(Goals.class.getName()));

        retGoal.setGoalIndicator(goal.getGoalIndicator());
        retGoal.setName(goal.getName());
        retGoal.setPriority(goal.getPriority());
        retGoal.setTimeBound(goal.getTimeBound());

        repository.save(retGoal);

    }

}
