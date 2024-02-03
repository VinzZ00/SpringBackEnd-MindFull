package com.minidfull.backend.services.goalService;

import com.minidfull.backend.dto.goalDtos.GoalResponseByDeadline;
import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.repository.GoalRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class GetGoalsByTimeBoundService {
    @Autowired private GoalRepository repo;

    @Autowired private Validator validator;

    public List<Goals> getByTimeBound(Date date) {
        return repo.findAllByTimeBoundBefore(date);
    }
}
