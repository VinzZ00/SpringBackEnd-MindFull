package com.minidfull.backend.services.goalService;

import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.model.AddGoalDTO;
import com.minidfull.backend.repository.goalRepository.GoalRepository;
import com.minidfull.backend.services.interfaces.AddingGoalInterface;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class AddGoalService implements AddingGoalInterface {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private Validator validator;

    @Override
    @Transactional
    public void addingGoal(AddGoalDTO goal) throws ConstraintViolationException {
        Set<ConstraintViolation<AddGoalDTO>> violations = validator.validate(goal);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if (goalRepository.existsByNameIgnoreCase(goal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Goal already exist, remove the last one before you can add it again");
        }

        Goals g = new Goals();
        g.setName(goal.getName());
        g.setGoalIndicator(goal.getGoalIndicator());
        g.setTimeBound(goal.getTimeBound());
        g.setDateCreatedAt(goal.getDateCreatedAt());
        g.setReason(goal.getReason());

        goalRepository.save(g);
    }
}

