package com.minidfull.backend.services.goalService;

import com.minidfull.backend.dto.goalDtos.GetGoalBeforeDTO;
import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.repository.GoalRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GetGoalsByTimeBound {
    @Autowired private GoalRepository repo;

    @Autowired private Validator validator;

    public List<Goals> getByTimeBound(GetGoalBeforeDTO goal) {

        Set<ConstraintViolation<GetGoalBeforeDTO>> violations = validator.validate(goal);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
        return repo.findAllByTimeBoundBefore(goal.getDateBefore());
    }
}
