package com.minidfull.backend.services.goalService;

import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.repository.GoalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllGoalService {
    @Autowired GoalRepository repo;

    public List<Goals> getAllGoals() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "timeBound"));
    }
}
