package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.model.GoalsDTO;
import com.minidfull.backend.model.WebResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface GoalControllerInterface {

    public WebResponse<String> addGoal(@RequestBody GoalsDTO request);

}
