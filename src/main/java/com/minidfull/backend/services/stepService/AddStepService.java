package com.minidfull.backend.services.stepService;

import com.minidfull.backend.entity.Steps;
import com.minidfull.backend.dto.stepDtos.AddStepsDTO;
import com.minidfull.backend.repository.GoalRepository;
import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.dto.BackEndException;
import com.minidfull.backend.repository.StepRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AddStepService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StepRepository stepRepository;

    @Autowired
    GoalRepository goalRepository;

    @Autowired
    Validator validator;

    @Transactional
    public void addingStep(AddStepsDTO request) {
        Set<ConstraintViolation<AddStepsDTO>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        Steps step = modelMapper.map(request, Steps.class);

        Optional<Goals> associatedGoal = goalRepository.findByGoalId(request.getParent().getGoalId());
        step.setGoal(associatedGoal.orElseThrow(() -> BackEndException.notFoundException(Goals.class.getName())));

        stepRepository.save(step);
    }

}
