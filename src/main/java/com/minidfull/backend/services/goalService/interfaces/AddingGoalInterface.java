package com.minidfull.backend.services.goalService.interfaces;

import com.minidfull.backend.model.GoalsDTO;
import jakarta.validation.ConstraintViolationException;

public interface AddingGoalInterface {
    void addingGoal(GoalsDTO goal) throws ConstraintViolationException;


}
