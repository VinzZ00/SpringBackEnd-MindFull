package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.model.GoalsDTO;
import com.minidfull.backend.model.WebResponse;
import com.minidfull.backend.services.goalService.AddGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalController implements GoalControllerInterface {

    @Autowired
    private AddGoalService addGoalService;
    @Override
    @PostMapping(
            path = "/api/addGoal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> addGoal(@RequestBody GoalsDTO request) {
        addGoalService.addingGoal(request);
        return WebResponse.<String>builder().data("Goal Successfully added").build();
    }
}
