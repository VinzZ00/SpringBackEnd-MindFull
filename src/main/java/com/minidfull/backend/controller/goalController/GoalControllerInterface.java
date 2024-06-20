package com.minidfull.backend.controller.goalController;

import com.minidfull.backend.dto.goalDtos.*;
import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.entity.Goals;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface GoalControllerInterface {

    WebResponse<Goals> addGoal(@RequestBody AddGoalDTO request);
    WebResponse<String> updateGoal(@RequestBody UpdateGoalDTO request);
    WebResponse<String> deleteGoal(@RequestBody DeleteGoalsDTO request);
    ResponseEntity<HashMap<Date, GoalResponseByDeadline[]>> getGoalsByTimeBound(@RequestParam("dateBefore") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateBefore);
    public GetAllGoalsResponse getAllGoals();
}
