package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.model.AddGoalDTO;
import com.minidfull.backend.model.UpdateGoalDTO;
import com.minidfull.backend.model.WebResponse;
import com.minidfull.backend.services.goalService.AddGoalService;
import com.minidfull.backend.services.goalService.UpdateGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
public class GoalController implements GoalControllerInterface {

    @Autowired
    private AddGoalService addGoalService;

    @Autowired
    private UpdateGoalService updateGoalService;

    @Override
    @PostMapping(
            path = "/api/addGoal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> addGoal(@RequestBody AddGoalDTO request) {
        addGoalService.addingGoal(request);
        return WebResponse.<String>builder().data("Goal Successfully added").build();
    }

    @Override
    @PostMapping(
            path = "/api/updateGoal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> updateGoal(@RequestBody UpdateGoalDTO request) {
        updateGoalService.updateGoal(request);
        return WebResponse.<String>builder().data("Update Goal Done").build();
    }
}
