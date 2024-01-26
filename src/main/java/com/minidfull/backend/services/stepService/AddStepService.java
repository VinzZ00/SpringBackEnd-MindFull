package com.minidfull.backend.services.stepService;

import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.entity.Steps;
import com.minidfull.backend.model.StepsDTO;
import com.minidfull.backend.repository.goalRepository.GoalRepository;
import com.minidfull.backend.repository.stepsRepository.StepRepository;
import com.minidfull.backend.services.goalService.interfaces.AddingStepInterface;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddStepService implements AddingStepInterface {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StepRepository stepRepository;

    @Autowired
    GoalRepository goalRepository;

    @Autowired
    Validator validator;

    @Transactional
    public void addingStep(StepsDTO request) {
        Set<ConstraintViolation<StepsDTO>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        Steps step = modelMapper.map(request, Steps.class);

        Goals associatedGoal = goalRepository.findByGoalId(request.getParent().getGoalId());
        step.setGoal(associatedGoal);


        stepRepository.save(step);
    }

}
