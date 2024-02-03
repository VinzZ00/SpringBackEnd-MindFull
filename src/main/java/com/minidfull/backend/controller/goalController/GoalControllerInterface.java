package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.dto.goalDtos.AddGoalDTO;
import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.dto.goalDtos.UpdateGoalDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface GoalControllerInterface {

    WebResponse<String> addGoal(@RequestBody AddGoalDTO request);
    WebResponse<String> updateGoal(@RequestBody UpdateGoalDTO request);
}
