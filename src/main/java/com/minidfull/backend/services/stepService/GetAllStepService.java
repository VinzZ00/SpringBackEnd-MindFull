package com.minidfull.backend.services.stepService;

import com.minidfull.backend.entity.Steps;
import com.minidfull.backend.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllStepService {
    @Autowired private StepRepository repo;

    public List<Steps> getAllStepByGoals(Long goalId) {
        return repo.findAllByGoal_GoalId(goalId);
    }
}
