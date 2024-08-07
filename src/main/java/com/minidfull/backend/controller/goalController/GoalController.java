package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.dto.goalDtos.*;
import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.entity.Goals;
import com.minidfull.backend.services.goalService.*;
import org.apache.coyote.Response;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Note Using this we dont need to use ResponseEntity Class see Exception Handler to get more detail
@RestController
public class GoalController implements GoalControllerInterface {

    @Autowired private AddGoalService addGoalService;
    @Autowired private UpdateGoalService updateGoalService;
    @Autowired private DeleteGoalService deleteGoalService;
    @Autowired private GetGoalsByTimeBoundService getGoalsByTimeBoundService;
    @Autowired private GetAllGoalService getAllGoalService;

    @Override
    @PostMapping(
            path = "/api/addGoal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Goals> addGoal(@RequestBody AddGoalDTO request) {
        return WebResponse
                .<Goals>builder()
                .data(addGoalService.addingGoal(request))
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
    @Override
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

    @GetMapping(
            path = "/api/goals",
            params = {"dateBefore"}
    )
    @Override
    public ResponseEntity<HashMap<Date, GoalResponseByDeadline[]>> getGoalsByTimeBound(@RequestParam("dateBefore") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateBefore) {

        GoalResponseByDeadline[] goals = getGoalsByTimeBoundService
                .getByTimeBound(dateBefore)
                .stream()
                .map(g -> new GoalResponseByDeadline(
                        g.getGoalId(),
                        g.getName(),
                        g.getGoalIndicator(),
                        g.getDateCreatedAt(),
                        g.getPriority(),
                        g.getSteps())
                )
                .toArray(GoalResponseByDeadline[]::new);

        return new ResponseEntity<HashMap<Date, GoalResponseByDeadline[]>>(new HashMap<>(Map.of(dateBefore, goals)), HttpStatus.OK);
    }

    @GetMapping(
            path = "/api/AllGoals",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public GetAllGoalsResponse getAllGoals() {
        GetAllGoalsResponse resp = GetAllGoalsResponse
                .builder()
                .datas(getAllGoalService
                        .getAllGoals())
                .build();
        return resp;
    }

}
