package com.minidfull.backend.services.stepService;

import com.minidfull.backend.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllStepService {
    @Autowired private StepRepository repo;

}
