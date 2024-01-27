package com.minidfull.backend.services.interfaces;

import com.minidfull.backend.model.AddGoalDTO;
import jakarta.validation.ConstraintViolationException;

public interface AddingGoalInterface {
    void addingGoal(AddGoalDTO goal) throws ConstraintViolationException;


}
