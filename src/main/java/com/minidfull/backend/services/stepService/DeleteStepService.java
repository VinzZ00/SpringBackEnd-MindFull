package com.minidfull.backend.services.stepService;

import com.minidfull.backend.dto.stepDtos.DeleteStepsDTO;
import com.minidfull.backend.repository.StepRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DeleteStepService {

    @Autowired private StepRepository repo;
    @Autowired private Validator validator;

    @Transactional
    public void deleteSteps(DeleteStepsDTO steps) {
        if 
    }

}
