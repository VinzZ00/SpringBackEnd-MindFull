package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.dto.AddGoalDTO;
import com.minidfull.backend.dto.DeleteGoalsDTO;
import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.services.goalService.AddGoalService;
import com.minidfull.backend.dto.UpdateGoalDTO;
import com.minidfull.backend.services.goalService.DeleteGoalService;
import com.minidfull.backend.services.goalService.UpdateGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

// Note Using this we dont need to use ResponseEntity Class see Exception Handler to get more detail
@RestController
public class GoalController implements GoalControllerInterface {

    @Autowired private AddGoalService addGoalService;
    @Autowired private UpdateGoalService updateGoalService;
    @Autowired private DeleteGoalService deleteGoalService;



    @Override
    @PostMapping(
            path = "/api/addGoal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> addGoal(@RequestBody AddGoalDTO request) {
        System.out.println("Sebelum error");
        addGoalService.addingGoal(request);
        System.out.println("Setelah error");
        return WebResponse
                .<String>builder()
                .data("Goal Successfully added")
                .build();
    }

    @Override
    @PostMapping(
            path = "/api/updateGoal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> updateGoal(@RequestBody UpdateGoalDTO request) {
        updateGoalService.updateGoal(request);
        return WebResponse
                .<String>builder()
                .data("Update Goal Done")
                .build();
    }

    @PostMapping(
            path = "/api/deleteGoal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteGoal(@RequestBody DeleteGoalsDTO request) {
        deleteGoalService.deleteGoal(request);

        String ids = "";

        for(Long x : request.getGoalIds()) {
            ids = ids.concat(x.toString());
        }

        return WebResponse
                .<String>builder()
                .data("Data with ids"
                        .concat(ids)
                        .concat("has been deleted Successfully"))
                .build();
    }

}
