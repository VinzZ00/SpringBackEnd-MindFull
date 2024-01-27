package com.minidfull.backend.controller.stepController;

import com.minidfull.backend.model.StepsDTO;
import com.minidfull.backend.model.WebResponse;
import com.minidfull.backend.services.stepService.AddStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StepController implements StepControllerInterface{

    @Autowired
    private AddStepService addStepService;

    @PostMapping(
            path = "/api/addStep",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public WebResponse<String> addStep(@RequestBody StepsDTO request) {
        addStepService.addingStep(request);
        return WebResponse.<String>builder().data("Step Successfully added").build();
    }
}
