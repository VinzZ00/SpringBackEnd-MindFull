package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.dto.AddGoalDTO;
import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.dto.UpdateGoalDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface GoalControllerInterface {

    WebResponse<String> addGoal(@RequestBody AddGoalDTO request);
    WebResponse<String> updateGoal(@RequestBody UpdateGoalDTO request);
}
