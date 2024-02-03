package com.minidfull.backend.services.stepService;

import com.minidfull.backend.dto.BackEndException;
import com.minidfull.backend.dto.stepDtos.DeleteStepsDTO;
import com.minidfull.backend.entity.Steps;
import com.minidfull.backend.repository.GoalRepository;
import com.minidfull.backend.repository.StepRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class DeleteStepService {

    @Autowired private StepRepository stepRepo;
    @Autowired private GoalRepository goalRepo;
    @Autowired private Validator validator;

    @Transactional
    public void deleteSteps(DeleteStepsDTO steps) {
         Set<ConstraintViolation<DeleteStepsDTO>> violations = validator.validate(steps);

         if (!violations.isEmpty()) {
             throw new ConstraintViolationException(violations);
         }

         Set<Long> goalIds = Arrays
                 .stream(steps.getStepIds())
                 .collect(Collectors.toSet());

         for (Long s : steps.getStepIds()) {
             if(stepRepo.existsById(s)) {
                 if (!stepRepo.deleteByStepId(s)) {
                     throw BackEndException.SpringServerLogicalError(this.getClass().getName());
                 }
             } else {
                 throw BackEndException.notFoundException(Steps.class.getName());
             }
         }

        for (Long g : goalIds) {
            if(goalRepo.existsByGoalId(g)) {
                if (!stepRepo.existsByGoal_GoalId(g)) {
                    if (!goalRepo.deleteGoalsByGoalId(g)) {
                        throw BackEndException.SpringServerLogicalError(this.getClass().getName());
                    }
                }
            } else {
                throw BackEndException.SpringServerLogicalError(this.getClass().getName());
            }
        }
    }
}
