package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.model.AddGoalDTO;
import com.minidfull.backend.model.UpdateGoalDTO;
import com.minidfull.backend.model.WebResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface GoalControllerInterface {

    WebResponse<String> addGoal(@RequestBody AddGoalDTO request);
    WebResponse<String> updateGoal(@RequestBody UpdateGoalDTO request);
}
