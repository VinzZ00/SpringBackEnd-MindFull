package com.minidfull.backend.controller.stepController;

import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.dto.stepDtos.AddStepsDTO;
import com.minidfull.backend.dto.stepDtos.DeleteStepsDTO;
import com.minidfull.backend.dto.stepDtos.UpdateStepDTO;
import com.minidfull.backend.services.stepService.AddStepService;
import com.minidfull.backend.services.stepService.DeleteStepService;
import com.minidfull.backend.services.stepService.UpdateStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
public class StepController implements StepControllerInterface{

    @Autowired private AddStepService addStepService;
    @Autowired private UpdateStepService updateStepService;
    @Autowired private DeleteStepService deleteStepService;

    @PostMapping(
            path = "/api/addStep",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public WebResponse<String> addStep(@RequestBody AddStepsDTO request) {
        addStepService.addingStep(request);
        return WebResponse.<String>builder().data("Step Successfully added").build();
    }

    @PostMapping(
            path = "/api/updateStep",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> updateStep(UpdateStepDTO request) {
        updateStepService.updateStep(request);
        return WebResponse.<String>builder().data("Step ".concat(request.getStepId().toString()).concat(" Successfully added")).build();
    }

    @PostMapping(
            path = "/api/deleteStep",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteStep(DeleteStepsDTO request) {
        deleteStepService.deleteSteps(request);

        String deletedStep = Arrays
                .stream(request.getStepIds())
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return WebResponse
                .<String>builder()
                .data("Step "
                        .concat(deletedStep)
                        .concat(" has been successfully deleted"))
                .build();
    }



}
