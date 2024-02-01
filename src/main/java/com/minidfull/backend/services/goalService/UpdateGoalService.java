package com.minidfull.backend.services.goalService;

import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.dto.BackEndException;
import com.minidfull.backend.dto.UpdateGoalDTO;
import com.minidfull.backend.repository.GoalRepository;
import com.minidfull.backend.services.interfaces.UpdateGoalInterface;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateGoalService implements UpdateGoalInterface {

    @Autowired private GoalRepository repository;
    @Autowired private Validator validator;

    @Transactional
    public void updateGoal(UpdateGoalDTO goal) {
        Goals retGoal = repository.findByGoalId(goal.getGoalId()).orElseThrow(() -> BackEndException.notFoundException(Goals.class.getName()));

        retGoal.setGoalIndicator(goal.getGoalIndicator());
        retGoal.setName(goal.getName());
        retGoal.setReason(goal.getReason());
        retGoal.setTimeBound(goal.getTimeBound());

        repository.save(retGoal);

    }

}
