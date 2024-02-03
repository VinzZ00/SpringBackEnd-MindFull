package com.minidfull.backend.services.stepService;

import com.minidfull.backend.dto.BackEndException;
import com.minidfull.backend.dto.stepDtos.UpdateStepDTO;
import com.minidfull.backend.entity.Steps;
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
public class UpdateStepService {
    @Autowired private StepRepository stepRepo;

    @Autowired private Validator validator;

    @Autowired ModelMapper modelMapper;

    @Transactional
    public void updateStep(UpdateStepDTO step) {

        Set<ConstraintViolation<UpdateStepDTO>> violations = validator.validate(step);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }


        Steps s = stepRepo
                .findByStepId(step.getStepId())
                .orElseThrow(() -> BackEndException.notFoundException(Steps.class.getName()));

        s.setMotivation(step.getMotivation());
        s.setDailyTime(step.getDailyTime());

        stepRepo.save(s);
    }

}
